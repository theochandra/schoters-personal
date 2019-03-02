package com.example.schoterspersonal.data.network.retrofit;

import com.example.schoterspersonal.data.model.PersonalCategory;
import com.example.schoterspersonal.presentation.Constants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface RetrofitRestApi {

    @Headers({Constants.REUQEST_HEADER_CONTENT_TYPE})
    @GET
    Observable<List<PersonalCategory>> retrievePersonalCategory(@Url String fullUrl);

}
