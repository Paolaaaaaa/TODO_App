import 'package:flutter/material.dart';
import 'package:mobile_front/Screens/Home/HomeScreen.dart';
import 'package:mobile_front/Screens/SignIn/SignInValidators.dart';
import 'package:mobile_front/Widgets/Custom_TextField.dart';
import 'package:mobile_front/Widgets/Custom_button.dart';
import 'package:mobile_front/Widgets/UpbarCustomized.dart';
import 'package:mobile_front/models/Auth/AuthResponse.dart';
import 'package:mobile_front/models/Auth/LogIn/LoginRequest.dart';
import 'package:mobile_front/providers/Auth/AuthViewModel.dart';
import 'package:mobile_front/theme/app_colors.dart';
import 'package:provider/provider.dart';

class LogInScreen extends StatelessWidget {
  final _formLogIn = GlobalKey<FormState>();

  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,

      backgroundColor: AppColors.primary,
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: Column(
            spacing: 10,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Form(
                key: _formLogIn,
                autovalidateMode: AutovalidateMode.onUserInteraction,

                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    UpbarCustomized(
                      backgroundColor: AppColors.primary,
                      textIconsColor: AppColors.base100,
                      title: "Log In",
                    ),

                    _buildEmail(),
                    _buildPassword(),
                    _BuildButtonLogIn(context),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildEmail() {
    return (Container(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: CustomTextfield(
        validator: Signinvalidators.validateEmail,
        lable: 'Email',
        backgroundColor: AppColors.primary,
        textColor: AppColors.base100,
        controller: emailController,
        keyboardType: TextInputType.emailAddress,
        hintText: 'Email',
      ),
    ));
  }

  Widget _buildPassword() {
    return (Container(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: CustomTextfield(
        validator: Signinvalidators.validatePasswordLogIn,
        lable: 'Password',
        backgroundColor: AppColors.primary,
        textColor: AppColors.base100,
        controller: passwordController,
        keyboardType: TextInputType.visiblePassword,
        hintText: 'Password',
        obscureText: true,
      ),
    ));
  }

  Widget _BuildButtonLogIn(BuildContext context) {
    return (Container(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 16),
      child: CustomButton(
        text: 'Log In',
        backgroundColor: AppColors.base100,
        textColor: AppColors.primary,

        onPressed: () async {
          if (_formLogIn.currentState!.validate()) {
            final authViewModel = Provider.of<AuthViewModel>(
              context,
              listen: false,
            );

            final request = LoginRequest(
              email: emailController.text,
              password: passwordController.text,
            );

            AuthResponse? response = await authViewModel.login(request);

            if (response?.error.toString() == 'null') {
              Navigator.pushReplacement(
                context,
                MaterialPageRoute(
                  builder: (context) => Homescreen(
                    email: response?.email,
                    id: response!.id,
                    token: response.token,
                    error: response.error,
                  ),
                ),
              );
            } else {
              showDialog(
                context: context,
                builder: (_) => AlertDialog(
                  title: Text('Login Failed'),
                  content: Text(response!.error.toString()),
                  actions: [
                    TextButton(
                      onPressed: () => Navigator.pop(context),
                      child: Text('ok'),
                    ),
                  ],
                ),
              );
            }
          }
        },
      ),
    ));
  }
}
