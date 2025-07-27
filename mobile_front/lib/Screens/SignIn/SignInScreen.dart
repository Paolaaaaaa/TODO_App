
import 'package:flutter/material.dart';
import 'package:mobile_front/Screens/SignIn/SignInValidators.dart';
import 'package:mobile_front/Widgets/Custom_TextField.dart';
import 'package:mobile_front/Widgets/Custom_button.dart';
import 'package:mobile_front/Widgets/UpbarCustomized.dart';
import 'package:mobile_front/theme/app_colors.dart';

class SignInScreen extends StatelessWidget {
final _formKey = GlobalKey<FormState>();


  final TextEditingController nameController = TextEditingController();
    final TextEditingController emailController = TextEditingController();

  final TextEditingController cellphonController = TextEditingController();
    final TextEditingController passwordController = TextEditingController();
        final TextEditingController passwordVerificationController = TextEditingController();


  @override
  Widget build(BuildContext context) {

    return Scaffold(
      backgroundColor: AppColors.primary,
      body: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          spacing: 10,
        crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Form(
              key: _formKey,
              child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  
              
                     UpbarCustomized(
                backgroundColor: AppColors.primary,
              textIconsColor: AppColors.base100,
              title: "Log In",),
          
                 
                  _buildName(),
                  _buildEmail(),
                  _buildCellphone(),
                  _buildPassword(),
                  _buildVerificationPassword(),
                  _BuildcreateUser()
              
              
              
              
              
              
              
                ],
              ),
            )
          ],
        ),),
    );


  }





Widget _buildTitle(){

  return(

                   Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Text(
                                  'To Do',
                                  style: TextStyle(
                    color: AppColors.base100,
                    fontSize: 45,
                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                    
                    Text(
                                  'Registration',
                                  style: TextStyle(
                    color: AppColors.base100,
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                  ],
                )
  );
}




Widget _buildName(){
  return(

       Container(

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
            )

  );
}

Widget _buildEmail(){
  return(

            Container(

              margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
              child: CustomTextfield(
                validator: Signinvalidators.validateEmail,
                lable: 'Email', 
                backgroundColor: AppColors.primary,
                textColor: AppColors.base100,
                controller: emailController, 
                keyboardType: TextInputType.emailAddress,
                hintText: 'Email'),
            )

  );
}
Widget _buildPassword(){
  return(

       Container(

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
            )

  );
}


Widget _buildVerificationPassword(){
  return(

       Container(

              margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
              child: CustomTextfield(

                validator: (value) =>

                  Signinvalidators.validatePasswordConfirmation(value, 
                  passwordController.text)
                  
                ,
                lable: 'Verify your Password', 
                   backgroundColor: AppColors.primary,
                textColor: AppColors.base100,
                controller: passwordVerificationController, 
                keyboardType: TextInputType.visiblePassword,
                hintText: 'Verify your Password',
                obscureText: true,
                ),
            )

  );
}


Widget _buildCellphone(){
  return(

       Container(

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
            )

  );
}


Widget _BuildcreateUser(){
  return(

       
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 16),
              child: CustomButton(text: 'Register', 
              backgroundColor: AppColors.base100,
              textColor: AppColors.primary,
              
              onPressed: (){}),
            )

  );
}


}