import 'package:flutter/material.dart';
import 'package:mobile_front/Screens/WellcomeScreen/WellcomeScreen.dart';
import 'package:mobile_front/theme/app_colors.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget{
  const MyApp();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(

      debugShowCheckedModeBanner: false,
      title: 'TODO App',
      theme: ThemeData(

    
        colorScheme: ColorScheme(
          brightness: Brightness.light,
          primary: AppColors.primary,
          onPrimary: AppColors.onPrimary,
          secondary: AppColors.secondary,
          onSecondary: AppColors.onSecondary,
          error: AppColors.error,
          onError: AppColors.onError,
          background: AppColors.base100,
          onBackground: AppColors.baseContent,
          surface: AppColors.base200,
          onSurface: AppColors.baseContent,
      
      ),


      appBarTheme: AppBarTheme(
        backgroundColor: AppColors.primary,
        foregroundColor: AppColors.onPrimary
      ),
    ),
    home: Wellcomescreen(),
    );
  
}}