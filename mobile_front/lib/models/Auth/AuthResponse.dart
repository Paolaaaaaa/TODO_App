


class AuthResponse {
  final String? token;
  final String? email;
  final String? id;
  final AuthResponse? data;
  final String? error;
  

  AuthResponse({
     required this.token,
     required this.email,
     required this.id,
     this.data,
     this.error
  });


  factory AuthResponse.fromJson(Map<String, dynamic> json) {
    return AuthResponse(
      token: json['token'] ?? '',
      email: json['email'] ?? '',
      id: json['uuid'] ?? '',
    );}



}
