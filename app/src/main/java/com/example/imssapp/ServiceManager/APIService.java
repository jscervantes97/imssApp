package com.example.imssapp.ServiceManager;

import com.example.imssapp.Entity.User;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @POST("/apiimsss/controllers/UserController.php?opc=1")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<User> iniciarSesion(@Body User user);
}