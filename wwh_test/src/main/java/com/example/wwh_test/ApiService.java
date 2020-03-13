package com.example.wwh_test;


import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiService {
    String BaseUrl="https://cdwan.cn/api/";

    @GET("topic/list")
    Observable<Bean> initData();
}
