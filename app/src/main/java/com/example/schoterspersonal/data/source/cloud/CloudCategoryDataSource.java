package com.example.schoterspersonal.data.source.cloud;

import com.example.schoterspersonal.data.RestApi;
import com.example.schoterspersonal.data.model.PersonalCategory;
import com.example.schoterspersonal.data.network.EndPointAddress;
import com.example.schoterspersonal.data.source.CategoryDataSource;

import java.util.List;

import io.reactivex.Observable;

public class CloudCategoryDataSource implements CategoryDataSource {

    private final RestApi mRestApi;

    public CloudCategoryDataSource(RestApi restApi) {
        mRestApi = restApi;
    }

    @Override
    public Observable<List<PersonalCategory>> retrievePersonalCategory() {
        String fullUrl = EndPointAddress
            .getSchotersEndpoint(EndPointAddress.RETRIEVE_PERSONAL_CATEGORY);
        return mRestApi.retrievePersonalCategory(fullUrl);
    }

}
