package com.example.schoterspersonal.data.source.local;

import com.example.schoterspersonal.data.LocalApi;
import com.example.schoterspersonal.data.model.PersonalCategory;
import com.example.schoterspersonal.data.source.CategoryDataSource;

import java.util.List;

import io.reactivex.Observable;

public class LocalCategoryDataSource implements CategoryDataSource {

    private LocalApi mContentResolveDataSource;

    private LocalApi mLocalApi;

    public LocalCategoryDataSource(LocalApi localApi, LocalApi contentResolveDataSource) {
        mLocalApi = localApi;
        mContentResolveDataSource = contentResolveDataSource;
    }

    @Override
    public Observable<List<PersonalCategory>> retrievePersonalCategory() {
        return null;
    }

}
