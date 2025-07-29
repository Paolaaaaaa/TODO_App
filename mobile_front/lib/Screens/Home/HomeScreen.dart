import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:mobile_front/theme/app_colors.dart';

class Homescreen  extends StatelessWidget{
  final String? id;
   final String? email;
   final String? token;

  const Homescreen({
    super.key, 
     this.id, 
     this.email, 
     this.token});



  @override
  Widget build(BuildContext context){

    return Scaffold(
      backgroundColor: AppColors.base100,
      resizeToAvoidBottomInset: false,
      body: Title(color: AppColors.primary, child: Text(id!)),
    );
  }
}