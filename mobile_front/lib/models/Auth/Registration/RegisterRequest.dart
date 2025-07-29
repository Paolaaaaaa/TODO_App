class Registerrequest {

  final String name;
  final String email;
  final String cellphone;
  final String password;
  final String description;

  Registerrequest({
    required this.name,
    required this.email,
    required this.cellphone,
    required this.password,
    required this.description
  });


 Map<String, dynamic> toJson() => {
        'name': name,
        'email': email,
        'cellphone': cellphone,
        'password': password,
        'description': description
      };




  
}