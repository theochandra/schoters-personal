package com.example.schoterspersonal.data.source.factory;

import com.example.schoterspersonal.data.LocalApi;
import com.example.schoterspersonal.data.RestApi;
import com.example.schoterspersonal.data.network.retrofit.RetrofitRestApiImpl;
import com.example.schoterspersonal.data.source.CategoryDataSource;
import com.example.schoterspersonal.data.source.cloud.CloudCategoryDataSource;

public class CategoryDataSourceFactory {

    // create local and cloud data source

    public CategoryDataSource createCloudDataSource() {
        RestApi restApi = new RetrofitRestApiImpl();
        return new CloudCategoryDataSource(restApi);
    }

//    public CategoryDataSource createLocalDataSource() {
//        return null;
//    }

}
