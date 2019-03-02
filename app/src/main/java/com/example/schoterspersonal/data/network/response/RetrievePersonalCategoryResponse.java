package com.example.schoterspersonal.data.network.response;

import com.example.schoterspersonal.data.model.PersonalCategory;

import java.util.ArrayList;
import java.util.List;

public class RetrievePersonalCategoryResponse {

    private List<PersonalCategory> mPersonalCategoryList = new ArrayList<>();

    public List<PersonalCategory> getPersonalCategoryList() {
        return mPersonalCategoryList;
    }

    public void setPersonalCategoryList(List<PersonalCategory> personalCategoryList) {
        mPersonalCategoryList = personalCategoryList;
    }

}
