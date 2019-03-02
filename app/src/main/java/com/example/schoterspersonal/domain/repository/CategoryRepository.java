package com.example.schoterspersonal.domain.repository;

import com.example.schoterspersonal.data.model.PersonalCategory;

import java.util.List;

import io.reactivex.Observable;

public interface CategoryRepository {

    Observable<List<PersonalCategory>> retrievePersonalCategory();

}
