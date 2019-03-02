package com.example.schoterspersonal.presentation.mapper;

import com.example.schoterspersonal.data.model.PersonalCategory;
import com.example.schoterspersonal.presentation.viewmodel.PersonalCategoryVM;

import java.util.ArrayList;
import java.util.List;

public class PersonalCategoryMapper {

     public static List<PersonalCategoryVM> transform(List<PersonalCategory> response) {
         List<PersonalCategoryVM> personalCategoryVMList = new ArrayList<>();
         List<PersonalCategory> personalCategoryList = response;
         PersonalCategoryVM personalCategoryVM;
         for (PersonalCategory personalCategory : personalCategoryList) {
             personalCategoryVM = new PersonalCategoryVM();
             personalCategoryVM.setId(personalCategory.getId());
             personalCategoryVM.setName(personalCategory.getName());
             personalCategoryVM.setDescription(personalCategory.getDescriptionEng());
             personalCategoryVM.setPublishedAt(personalCategory.getPublishedAt());
             personalCategoryVM.setImageUrl(personalCategory.getImageUrl());
             personalCategoryVM.setChecked(false);
             personalCategoryVMList.add(personalCategoryVM);
         }
         return personalCategoryVMList;
     }

     public static List<PersonalCategoryVM> selecteChoosenCategory(List<PersonalCategoryVM> input) {
         List<PersonalCategoryVM> personalCategoryVMList = new ArrayList<>();
         PersonalCategoryVM personalCategoryVM;
         for (PersonalCategoryVM item : input) {
             if (item.isChecked()) {
                 personalCategoryVM = new PersonalCategoryVM();
                 personalCategoryVM.setId(item.getId());
                 personalCategoryVM.setName(item.getName());
                 personalCategoryVM.setDescription(item.getDescription());
                 personalCategoryVM.setPublishedAt(item.getPublishedAt());
                 personalCategoryVM.setImageUrl(item.getImageUrl());
                 personalCategoryVM.setChecked(item.isChecked());
                 personalCategoryVMList.add(personalCategoryVM);
             }
         }
         return personalCategoryVMList;
     }

}
