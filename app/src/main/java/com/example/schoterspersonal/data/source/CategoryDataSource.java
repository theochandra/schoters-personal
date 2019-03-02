package com.example.schoterspersonal.data.source;

import com.example.schoterspersonal.data.model.PersonalCategory;

import java.util.List;

import io.reactivex.Observable;

public interface CategoryDataSource {

    Observable<List<PersonalCategory>> retrievePersonalCategory();

}
