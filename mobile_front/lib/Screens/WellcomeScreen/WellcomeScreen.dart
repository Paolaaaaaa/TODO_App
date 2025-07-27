import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:mobile_front/Screens/LogIn/LogInScreen.dart';
import 'package:mobile_front/Screens/SignIn/SignInScreen.dart';
import 'package:mobile_front/Widgets/Custom_button.dart';
import 'package:mobile_front/theme/app_colors.dart';

class Wellcomescreen extends StatelessWidget {
  const Wellcomescreen({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.base100,
      body: Center(
        child: Column(
          spacing: 10,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SvgPicture.asset(
              'assets/Icons/logo.svg',
              width: 100,
              height: 200,
              fit: BoxFit.contain,
            ),
            Text(
              'To Do',
              style: TextStyle(
                color: AppColors.baseContent,
                fontSize: 45,
                fontWeight: FontWeight.bold,
              ),
            ),
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
              child: CustomButton(
                text: 'Register',
                backgroundColor: AppColors.primary,
                textColor: AppColors.onPrimary,
                onPressed: () {
 Navigator.push(
                    context,
                    MaterialPageRoute(builder: (e) => SignInScreen(),
                    ),
                  );                },
              ),
            ),

            Container(
              margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
              child: CustomButton(
                text: 'Log In',
                backgroundColor: AppColors.primary,
                textColor: AppColors.onPrimary,
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (e) => LogInScreen(),
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
