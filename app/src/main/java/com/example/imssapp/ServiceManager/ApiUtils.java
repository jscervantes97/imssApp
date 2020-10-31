package com.example.imssapp.ServiceManager;

public class ApiUtils {

    private ApiUtils() {}

    // Desarrollo
    //public static final String BASE_URL = "http://192.168.0.103:80/";
    // Produccion
      public static final String BASE_URL = "https://imsswebapplication.000webhostapp.com//";
    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}