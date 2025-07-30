import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:mobile_front/theme/app_colors.dart';

class CustomHighlight extends StatelessWidget {
  final String imageURL;
  final String title;
  final VoidCallback onTap;

  const CustomHighlight({
    required this.imageURL,
    required this.title,
    required this.onTap,
  });
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap,
      child: Stack(
        alignment: Alignment.bottomLeft,
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(12),
            child: Image.network(
              imageURL,
              height: 200,
              width: double.infinity,
              fit: BoxFit.cover,
            ),
          ),

          Container(
            height: 200,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(12),
              gradient: LinearGradient(
                colors: [Colors.transparent, Colors.black.withOpacity(0.6)],
                begin: Alignment.topCenter,
                end: Alignment.bottomCenter,
              ),
            ),
          ),
          Padding(
            padding: EdgeInsets.all(12.0),
            child: Text(
              title,
              style: TextStyle(
                color: AppColors.base100,
                fontSize: 28,
                fontWeight: FontWeight.bold,
                shadows: [
                  Shadow(
                    blurRadius: 6,
                    color: AppColors.primary,
                    offset: Offset(0, 2),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
