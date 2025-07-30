import 'package:flutter/material.dart';
import 'package:mobile_front/Screens/Home/HomeScreen.dart';
import 'package:mobile_front/Screens/ProfileScreen/ProfileScreen.dart';
import 'package:mobile_front/Screens/TasksScreen/TasksScreen.dart';
import 'package:mobile_front/theme/app_colors.dart';

class BottomNavScreen extends StatefulWidget {

  @override
  _bottomNavScreenState createState() => _bottomNavScreenState();



}


  
  class _bottomNavScreenState extends State<BottomNavScreen>{
    int _currentIndex = 0;
    final List<Widget> _screens =[
      Homescreen(),
      TasksScreen(),
      Profilescreen(),
      
    ];

    @override
    Widget build(BuildContext context){
      return Scaffold(
        backgroundColor: AppColors.base100,
        body: _screens[_currentIndex],
        bottomNavigationBar: BottomNavigationBar(
          backgroundColor: AppColors.primary,
          
          currentIndex: _currentIndex,
          onTap: (index){
            print('tapped index $index');
            setState(() {
              _currentIndex=index;
            });
          },
          selectedItemColor: AppColors.info,
          unselectedItemColor: AppColors.base100,
          items: [
            BottomNavigationBarItem(icon: Icon(Icons.home),label: 'Home'),
            BottomNavigationBarItem(icon: Icon(Icons.task), label: 'Tasks'),
            BottomNavigationBarItem(icon: Icon(Icons.person), label: 'Profile')
          ],),
      );
    }


  }