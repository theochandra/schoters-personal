package com.example.schoterspersonal.domain.repository;

import com.example.schoterspersonal.data.model.PersonalCategory;
import com.example.schoterspersonal.data.source.CategoryDataSource;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CategoryDataRepository implements CategoryRepository {

    private CategoryDataSource mCategoryCloudDataSource;

    public CategoryDataRepository(CategoryDataSource categoryCloudDataSource) {
        mCategoryCloudDataSource = categoryCloudDataSource;
    }

    @Override
    public Observable<List<PersonalCategory>> retrievePersonalCategory() {
        return mCategoryCloudDataSource.retrievePersonalCategory()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

}
