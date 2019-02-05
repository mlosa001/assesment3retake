package org.pursuit.unit_03_assessment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZodiacRetrofit {

    private static Retrofit retroInstace;

    private ZodiacRetrofit() {
    }

    public static Retrofit getInstance() {
        if (retroInstace != null) {
            return retroInstace;
        }
        retroInstace = new Retrofit
                .Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())//parsing
                .build();
        return retroInstace;
    }


}
