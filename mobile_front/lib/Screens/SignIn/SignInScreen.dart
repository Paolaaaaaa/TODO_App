import 'package:flutter/material.dart';
import 'package:mobile_front/Screens/Home/HomeScreen.dart';
import 'package:mobile_front/Screens/SignIn/SignInValidators.dart';
import 'package:mobile_front/Widgets/Custom_TextField.dart';
import 'package:mobile_front/Widgets/Custom_button.dart';
import 'package:mobile_front/Widgets/UpbarCustomized.dart';
import 'package:mobile_front/models/Auth/AuthResponse.dart';
import 'package:mobile_front/models/Auth/Registration/RegisterRequest.dart';
import 'package:mobile_front/providers/Auth/AuthViewModel.dart';
import 'package:mobile_front/theme/app_colors.dart';
import 'package:provider/provider.dart';

class SignInScreen extends StatelessWidget {
  final _formSignIn = GlobalKey<FormState>();

  final TextEditingController nameController = TextEditingController();
  final TextEditingController emailController = TextEditingController();
  final TextEditingController descriptionController = TextEditingController();

  final TextEditingController cellphonController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();
  final TextEditingController passwordVerificationController =
      TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,

      backgroundColor: AppColors.primary,
      body: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          spacing: 10,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Form(
              key: _formSignIn,
              autovalidateMode: AutovalidateMode.onUserInteraction,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  UpbarCustomized(
                    backgroundColor: AppColors.primary,
                    textIconsColor: AppColors.base100,
                    title: "Sign In",
                  ),

                  _buildName(),
                  _buildDescription(),
                  _buildEmail(),
                  _buildCellphone(),
                  _buildPassword(),
                  _buildVerificationPassword(),
                  _BuildcreateUser(context),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildName() {
    return (Container(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: CustomTextfield(
        validator: Signinvalidators.validateName,

        lable: 'Full Name',
        backgroundColor: AppColors.primary,
        textColor: AppColors.base100,
        controller: nameController,
        keyboardType: TextInputType.name,
        hintText: 'Full Name',
        obscureText: false,
      ),
    ));
  }



  Widget _buildDescription() {
    return (Container(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: CustomTextfield(
        validator: Signinvalidators.validateDescription,

        lable: 'Description',
        backgroundColor: AppColors.primary,
        textColor: AppColors.base100,
        controller: descriptionController,
        keyboardType: TextInputType.name,
        hintText: 'Describe yourself',
        obscureText: false,
      ),
    ));
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
        validator: Signinvalidators.validatePassword,
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

  Widget _buildVerificationPassword() {
    return (Container(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: CustomTextfield(
        validator: (value) => Signinvalidators.validatePasswordConfirmation(
          value,
          passwordController.text,
        ),
        lable: 'Verify your Password',
        backgroundColor: AppColors.primary,
        textColor: AppColors.base100,
        controller: passwordVerificationController,
        keyboardType: TextInputType.visiblePassword,
        hintText: 'Verify your Password',
        obscureText: true,
      ),
    ));
  }

  Widget _buildCellphone() {
    return (Container(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: CustomTextfield(
        validator: Signinvalidators.validateCellphone,
        lable: 'Cellphone',
        backgroundColor: AppColors.primary,
        textColor: AppColors.base100,
        controller: cellphonController,
        keyboardType: TextInputType.visiblePassword,
        hintText: 'Cellphone : e.g +57 1020250265',
      ),
    ));
  }

  Widget _BuildcreateUser(BuildContext context) {
    return (Container(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 16),
      child: CustomButton(
        text: 'Register',
        backgroundColor: AppColors.base100,
        textColor: AppColors.primary,

        onPressed: () async {
          if (_formSignIn.currentState!.validate()) {
            final authViewModel = Provider.of<AuthViewModel>(
              context,
              listen: false,
            );

            final request = Registerrequest(
              name: nameController.text,
              email: emailController.text,
              cellphone: cellphonController.text,
              password: passwordController.text,
              description: descriptionController.text
            );

            AuthResponse? response = await authViewModel.register(request);

            if ( response?.error.toString() =='null') {

              print('$response.error');
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
                  title: Text('Registration Failed'),
                  content: Text(response!.error.toString() ),
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
