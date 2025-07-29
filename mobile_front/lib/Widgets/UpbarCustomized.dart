import 'package:flutter/material.dart';
import 'package:mobile_front/theme/app_colors.dart';

class UpbarCustomized extends StatelessWidget{


  final String title;
  final Color textIconsColor;
  final Color backgroundColor;

  const UpbarCustomized({super.key, 
    required this.title,
    required this.textIconsColor,
    required this.backgroundColor
  });


@override
Widget build (BuildContext context){
  return AppBar(

    leading: IconButton(onPressed: () {
        Navigator.pop(context); 
      }, icon: Icon(Icons.arrow_back, color: textIconsColor,)),

centerTitle: true,
title: _buildTitle(),
  );
}


Widget _buildTitle(){

  return(

                   Row(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Text(
                                  'To Do:  ',
                                  style: TextStyle(
                    color: AppColors.base100,
                    fontSize: 45,
                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                    
                    Text(
                                  title,
                                  style: TextStyle(
                    color: AppColors.base100,
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                  ],
                )
  );
}





  
}