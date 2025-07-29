class Registerrequest {

  final String name;
  final String email;
  final String cellphone;
  final String password;

  Registerrequest({
    required this.name,
    required this.email,
    required this.cellphone,
    required this.password,
  });


 Map<String, dynamic> toJson() => {
        'name': name,
        'email': email,
        'cellphone': cellphone,
        'password': password,
      };




  
}