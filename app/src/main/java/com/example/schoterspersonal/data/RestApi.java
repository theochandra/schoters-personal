package com.example.schoterspersonal.data;

import com.example.schoterspersonal.BuildConfig;
import com.example.schoterspersonal.data.model.PersonalCategory;

import java.util.List;

import io.reactivex.Observable;

public interface RestApi {

    String SCHOTERS_SERVER_URL = BuildConfig.SCHOTERS_SERVER_URL;

    int CONNECTION_TIMEOUT = 60;

    int READ_TIMEOUT = 60;

    Observable<List<PersonalCategory>> retrievePersonalCategory(String fullUrl);

}
