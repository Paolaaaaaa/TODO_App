import 'package:flutter/material.dart';
import 'package:mobile_front/Services/auth_Service.dart';
import 'package:mobile_front/models/Auth/AuthResponse.dart';
import 'package:mobile_front/models/Auth/Registration/RegisterRequest.dart';

class AuthViewModel with ChangeNotifier {

  final AuthService  _authService = AuthService();

  bool _isLoading = false;
  bool get isLoading => _isLoading;


  Future<AuthResponse?> register(Registerrequest request) async {
    _isLoading =true;
    notifyListeners();
    final response = await _authService.register(request);
    _isLoading =false;
    notifyListeners();
    return response;


  }
  
}