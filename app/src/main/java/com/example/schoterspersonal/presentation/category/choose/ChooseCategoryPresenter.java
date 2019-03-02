package com.example.schoterspersonal.presentation.category.choose;

import com.example.schoterspersonal.data.model.PersonalCategory;
import com.example.schoterspersonal.domain.usecase.RetrievePersonalCategoryUseCase;
import com.example.schoterspersonal.presentation.mapper.PersonalCategoryMapper;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class ChooseCategoryPresenter implements ChooseCategoryContract.Presenter {

    private RetrievePersonalCategoryUseCase mRetrievePersonalCategoryUseCase;

    private ChooseCategoryContract.View mView;

    public ChooseCategoryPresenter(
        RetrievePersonalCategoryUseCase retrievePersonalCategoryUseCase,
        ChooseCategoryContract.View view
    ) {
        mRetrievePersonalCategoryUseCase = retrievePersonalCategoryUseCase;
        mView = view;
    }

    @Override
    public void retrievePersonalCategory() {
        mView.hideDisplayLayout();
        mView.hideErrorLayout();
        mView.showLoadingBar();
        mRetrievePersonalCategoryUseCase.execute(
            new DisposableObserver<List<PersonalCategory>>() {
            @Override
            public void onNext(List<PersonalCategory> response) {
                mView.hideLoadingBar();
                if (!response.isEmpty()) {
                    // show layout
                    mView.showDisplayLayout();
                    mView.populateChipCategory(PersonalCategoryMapper.transform(response));
                } else {
                    // show empty layout
                    mView.showErrorLayout();
                }
            }

            @Override
            public void onError(Throwable e) {
                // show error layout
                mView.hideLoadingBar();
                mView.showErrorLayout();
            }

            @Override
            public void onComplete() {
                // default implementation ignored
            }
        });
    }

    @Override
    public void destroy() {
        mRetrievePersonalCategoryUseCase.unsubscribe();
    }

}
