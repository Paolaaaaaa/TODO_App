import 'package:flutter/material.dart';
import 'package:mobile_front/theme/app_colors.dart';

class CustomTextfield extends StatelessWidget{

  final String lable;
  final TextEditingController controller;

  final Color backgroundColor;
  final Color textColor;
  final bool obscureText;

  final TextInputType keyboardType;
  final String hintText;

  final String? Function(String?)? validator;



  const CustomTextfield({super.key, 
    required this.lable,
    required this.controller,
    required this.backgroundColor,
    required this.textColor,
    this.obscureText =false,
    this.keyboardType = TextInputType.text,
    required this.hintText,
    required this.validator
  });


  @override
  Widget build (BuildContext context){

    return Column(

      crossAxisAlignment: CrossAxisAlignment.start,
      children: [

        TextFormField(
          


          controller: controller,
          obscureText: obscureText,
          keyboardType: keyboardType,
          style: TextStyle(color: textColor),
          validator:validator,
          
          
     decoration: InputDecoration(
            hintText: hintText ,
            hintStyle: TextStyle(color: textColor?.withOpacity(0.5)),
            labelStyle: TextStyle(color: textColor),
            filled: true,
            fillColor: backgroundColor, // light background
            contentPadding: const EdgeInsets.symmetric(vertical: 16, horizontal: 12),
            
            
            
          
            
            errorBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(30),
              borderSide: const BorderSide(color: AppColors.onError,width: 2),
            ),
              focusedErrorBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(30),
              borderSide: const BorderSide(color: AppColors.error,width: 2),
            ),

          ),
        
        )
      ],
    );
  }
  
}