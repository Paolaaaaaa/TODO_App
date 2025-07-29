import 'package:flutter/material.dart';
import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:mobile_front/Screens/WellcomeScreen/WellcomeScreen.dart';
import 'package:mobile_front/providers/Auth/AuthViewModel.dart';
import 'package:mobile_front/theme/app_colors.dart';
import 'package:provider/provider.dart';
import 'flavor.dart';

Future<void> mainApp() async {

  final envFile = F.isProd ? 'assets/config/.env.production' : 'assets/config/.env.development';

  await dotenv.load(fileName: envFile);

  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => AuthViewModel()),
      ],
      child: MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget{
  const MyApp({super.key});

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