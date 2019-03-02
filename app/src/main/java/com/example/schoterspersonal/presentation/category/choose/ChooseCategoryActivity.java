package com.example.schoterspersonal.presentation.category.choose;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.schoterspersonal.ApplicationComponent;
import com.example.schoterspersonal.R;
import com.example.schoterspersonal.base.BaseActivity;
import com.example.schoterspersonal.presentation.category.show.ShowCategoryActivity;
import com.example.schoterspersonal.presentation.mapper.PersonalCategoryMapper;
import com.example.schoterspersonal.presentation.viewmodel.PersonalCategoryVM;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.Group;
import butterknife.BindView;
import butterknife.OnClick;

public class ChooseCategoryActivity extends BaseActivity implements ChooseCategoryContract.View {

    @BindView(R.id.chip_group)
    ChipGroup mChipGroup;

    @BindView(R.id.group_data_displayed)
    Group mGroupDataDisplayed;

    @BindView(R.id.group_error_displayed)
    Group mGroupErrorDisplayed;

    private List<PersonalCategoryVM> mPersonalCategoryVMList = new ArrayList<>();

    private ChooseCategoryContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideLeftMenu();
        initView();
        initPresenter();
        retrievePersonalCategory();
    }

    private void initView() {
        mGroupErrorDisplayed.setVisibility(View.GONE);
    }

    private void initPresenter() {
        mPresenter = new ChooseCategoryPresenter(
            ApplicationComponent.providePersonalCategory(),
            this
        );
    }

    private void retrievePersonalCategory() {
        mPresenter.retrievePersonalCategory();
    }

    @Override
    public void populateChipCategory(List<PersonalCategoryVM> personalCategoryVMList) {
        mPersonalCategoryVMList = personalCategoryVMList;
        for (PersonalCategoryVM personalCategoryVM : mPersonalCategoryVMList) {
            addChipCategory(personalCategoryVM.getName());
        }
    }

    private void addChipCategory(String category) {
        Chip chip = new Chip(this);
        setChipAtribute(chip);
        chip.setText(category);
        chip.setOnCheckedChangeListener((view, isChecked) -> {
            int index = mChipGroup.indexOfChild(chip);
            mPersonalCategoryVMList.get(index).setChecked(isChecked);
        });
        mChipGroup.addView(chip);
    }

    private void setChipAtribute(Chip chip) {
        chip.setLayoutParams(new ChipGroup.LayoutParams(
            ChipGroup.LayoutParams.WRAP_CONTENT, ChipGroup.LayoutParams.WRAP_CONTENT));
        chip.setTextSize(TypedValue.COMPLEX_UNIT_PX,
            getResources().getDimension(R.dimen.font_size_m));
        chip.setChipCornerRadius(getResources().getDimension(R.dimen.chip_radius));
        chip.setChipStrokeWidth(getResources().getDimension(R.dimen.chip_stroke));
        chip.setChipStrokeColor(getResources().getColorStateList(R.color.selector_chip_stroke));
        chip.setChipBackgroundColor(getResources().getColorStateList(R.color.selector_chip));
        chip.setTextColor(getResources().getColorStateList(R.color.selector_chip_text));
        chip.setCheckedIconEnabled(false);
        chip.setCheckedIcon(null);
        chip.setCheckable(true);
        chip.setClickable(true);
        chip.setFocusable(true);
    }

    @Override
    public void hideDisplayLayout() {
        mGroupDataDisplayed.setVisibility(View.GONE);
    }

    @Override
    public void showDisplayLayout() {
        mGroupDataDisplayed.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorLayout() {
        mGroupErrorDisplayed.setVisibility(View.GONE);
    }

    @Override
    public void showErrorLayout() {
        mGroupErrorDisplayed.setVisibility(View.VISIBLE);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_choose_category;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.choose_cat_title);
    }

    @OnClick({R.id.btn_done, R.id.btn_try_again})
    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_done:
                if (isAssertButton()) {
                    startNextScreen();
                } else {
                    showToastMessage();
                }
                break;
            case R.id.btn_try_again:
                mPresenter.retrievePersonalCategory();
                break;
            default:
        }
    }

    private boolean isAssertButton() {
        int size = mPersonalCategoryVMList.size();
        for (int i = 0; i < size; i++) {
            if (mPersonalCategoryVMList.get(i).isChecked()) {
                return true;
            }
        }
        return false;
    }

    private void startNextScreen() {
        List<PersonalCategoryVM> choosenCategory = PersonalCategoryMapper
            .selecteChoosenCategory(mPersonalCategoryVMList);
        Intent intent = new Intent(this, ShowCategoryActivity.class);
        intent.putParcelableArrayListExtra(ShowCategoryActivity.EXTRA_CATEGORY,
            (ArrayList<? extends Parcelable>) choosenCategory);
        startActivity(intent);
    }

    private void showToastMessage() {
        Toast toast = Toast.makeText(this,
            getString(R.string.choose_cat_at_least_one), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

}
