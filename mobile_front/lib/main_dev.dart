import 'package:mobile_front/main.dart';

import 'flavor.dart';

void main() {
  F.appFlavor = Flavor.dev;
  mainApp(); // call main defined in main.dart
}
