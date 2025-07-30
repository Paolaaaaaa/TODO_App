

import 'dart:math';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:mobile_front/theme/app_colors.dart';

class CustomCard extends StatelessWidget{

  final String title;
  final String description;
  final String? imageURL;

  const CustomCard ({super.key, 
    required this.title,
    required this.description,
     this.imageURL,

  });

  @override
  Widget build(BuildContext context) {

    return Center(
      child: Card(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: <Widget>[
          
            ListTile(
           
              title: Text(title),
              subtitle: Text(description.substring(0,min(description.length, 30))),

            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                IconButton(onPressed: (){}, icon: Icon(Icons.arrow_forward,
                color: AppColors.primary))
              ],
            )
          ],
        ),
      ),

    );



  }

  
}