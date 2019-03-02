package com.example.schoterspersonal.presentation.category.choose;

import com.example.schoterspersonal.base.BasePresenter;
import com.example.schoterspersonal.base.BaseView;
import com.example.schoterspersonal.presentation.viewmodel.PersonalCategoryVM;

import java.util.List;

public interface ChooseCategoryContract {

    interface View extends BaseView {

        void populateChipCategory(List<PersonalCategoryVM> personalCategoryVMList);

        void hideDisplayLayout();

        void showDisplayLayout();

        void hideErrorLayout();

        void showErrorLayout();

    }

    interface Presenter extends BasePresenter {

        void retrievePersonalCategory();

    }

}
