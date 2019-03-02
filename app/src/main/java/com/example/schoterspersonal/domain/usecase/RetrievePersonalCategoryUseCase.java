package com.example.schoterspersonal.domain.usecase;

import com.example.schoterspersonal.domain.repository.CategoryRepository;

import io.reactivex.Observable;

public class RetrievePersonalCategoryUseCase extends UseCase {

    private CategoryRepository mCategoryRepository;

    public RetrievePersonalCategoryUseCase(CategoryRepository categoryRepository) {
        mCategoryRepository = categoryRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mCategoryRepository.retrievePersonalCategory();
    }

}
