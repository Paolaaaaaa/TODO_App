import 'package:flutter_regex/flutter_regex.dart';


class Signinvalidators {

static String? validateEmail(String? value) {
    if (!value!.isEmail()){
      return 'Ivalid email format';

    }
    return null;
  }


    static String? validatePassword(String? value){ 
      
   
    if (!value!.isPasswordHard()) {
      return 'Please enter a valid 10-digit phone number';
    }
    return null; // Input is valid
    }

  static String? validateName(String? value){
    if (value == null || value.isEmpty) {
      return 'Please enter your first name.';
    }
    return null;
  }

    static String? validateCellphone(String? value){
   
    if (!value!.isPhone()) {
      return 'Please enter a valid 10-digit phone number';
    }
    return null; // Input is valid
  }


  
static String? validatePasswordConfirmation(String? value, String originalPassword) {
  if (value == null || value.isEmpty) return 'La confirmación es obligatoria';
  if (value != originalPassword) return 'Las contraseñas no coinciden';
  if (validatePassword(value) != null) return 'La contraseña no es fuerte';


  return null;
}




}