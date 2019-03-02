package com.example.schoterspersonal;

import com.example.schoterspersonal.data.source.factory.CategoryDataSourceFactory;
import com.example.schoterspersonal.domain.repository.CategoryDataRepository;
import com.example.schoterspersonal.domain.repository.CategoryRepository;
import com.example.schoterspersonal.domain.usecase.RetrievePersonalCategoryUseCase;

@SuppressWarnings("ALL")
public class ApplicationComponent {

    private ApplicationComponent() { }

    private static CategoryRepository provideCategoryRepository() {
        CategoryDataSourceFactory categoryDataSourceFactory = new CategoryDataSourceFactory();
        return new CategoryDataRepository(categoryDataSourceFactory.createCloudDataSource());
    }

    // provide retrieve personal category
    public static RetrievePersonalCategoryUseCase providePersonalCategory() {
        return new RetrievePersonalCategoryUseCase(provideCategoryRepository());
    }

}
