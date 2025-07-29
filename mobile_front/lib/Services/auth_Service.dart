import 'dart:convert';

import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:http/http.dart' as http;
import 'package:mobile_front/models/Auth/AuthResponse.dart';
import 'package:mobile_front/models/Auth/LogIn/LoginRequest.dart';
import 'package:mobile_front/models/Auth/Registration/RegisterRequest.dart';

class AuthService {
  final String _baseUrl = dotenv.env['API_URL'] ?? 'http://10.0.2.2:8080/api';

  Future<AuthResponse?> login(LoginRequest request) async {
    final url = Uri.parse('$_baseUrl/v1/auth/login');

    final response = await http.post(
      url,
      headers: <String, String>{'Content-Type': 'application/json'},
      body: jsonEncode(request),
    );

    if (response.statusCode == 200) {
      final data = jsonDecode(response.body);
      final token = data['token'];
      return AuthResponse(
        token: data['token'],
        email: data['email'],
        id: data['id'],
        error: null,
      );
    } else {
      return null;
    }
  }

  Future<AuthResponse?> register(Registerrequest person) async {
    try {
      final url = Uri.parse('$_baseUrl/v1/auth/signup');
      final response = await http.post(
        url,
        headers: <String, String>{'Content-Type': 'application/json'},
        body: jsonEncode(person),
      );

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        return AuthResponse(
          token: data['token'],
          email: data['email'],
          id: data['id'],
          error: null,
        );
      } else {
        final errorMsg =
            jsonDecode(response.body)['message'] ?? 'Unknown error';
        return AuthResponse(error: errorMsg, token: '', email: '', id: '');
      }
    } catch (e) {
      return AuthResponse(
        error:
            'Failed to complete the registration, please try another time $e',
        token: '',
        email: '',
        id: '',
      );
    }
  }
}
