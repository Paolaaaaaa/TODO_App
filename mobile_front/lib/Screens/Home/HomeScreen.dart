import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:mobile_front/Enum/PrivacyLevel.dart';
import 'package:mobile_front/Widgets/CustomHighlight.dart';
import 'package:mobile_front/Widgets/Custom_card.dart';
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

      backgroundColor: AppColors.base100,
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: ListView(
            children: [

              CustomHighlight(
                imageURL: 'https://github.com/Paolaaaaaa/silver-umbrella/blob/42c322e5d6c45789ec3f9a2b913c7a17e2e3bf91/AdobeStock_375415241.jpeg'
              , title: 'Start Today Create your proyect', onTap: (){}),

        CustomCard(
                title: 'Project 1',
                description: 'Description 1',
                
              ),
              CustomCard(
                title: 'Project 2',
                description: 'Description 2',
                imageURL:
                    'https://github.com/Paolaaaaaa/silver-umbrella/blob/42c322e5d6c45789ec3f9a2b913c7a17e2e3bf91/AdobeStock_375415241.jpeg?raw=true',
              ),
              CustomCard(
                title: 'Project 3',
                description: 'Description 3',
                imageURL:
                    'https://github.com/Paolaaaaaa/silver-umbrella/blob/42c322e5d6c45789ec3f9a2b913c7a17e2e3bf91/AdobeStock_375415241.jpeg?raw=true',
              ),
     
            ]))));
  }
}