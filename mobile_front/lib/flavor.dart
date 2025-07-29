enum Flavor {
  dev,
  prod,
}

class F {

  
  static Flavor appFlavor = Flavor.dev;

  static bool get isProd => appFlavor == Flavor.prod;
}