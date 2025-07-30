import 'package:flutter_dotenv/flutter_dotenv.dart';

class ProyectService {

    final String _baseUrl = dotenv.env['API_URL'] ?? 'http://10.0.2.2:8080/api';


    // Future<ProyectsResponse> getProyects(ProyectsRequest request){

    // }



  
}