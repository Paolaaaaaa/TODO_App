import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:mobile_front/Widgets/UpbarCustomized.dart';
import 'package:mobile_front/theme/app_colors.dart';

class Homescreen  extends StatelessWidget{
  final String? id;
   final String? email;
   final String? token;
   final String? error;

  const Homescreen({
    super.key, 
     this.id, 
     this.email, 
     this.token,
     this.error});



  @override
  Widget build(BuildContext context){

    return      Scaffold(
      resizeToAvoidBottomInset: false,

      backgroundColor: AppColors.primary,
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: Column(
            spacing: 10,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
     
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    UpbarCustomized(
                      backgroundColor: AppColors.primary,
                      textIconsColor: AppColors.base100,
                      title: " $id" ,
                    ),]),
                    
                    Text('$email')]))));
  }
}