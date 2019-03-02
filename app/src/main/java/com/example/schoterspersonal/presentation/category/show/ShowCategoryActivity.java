package com.example.schoterspersonal.presentation.category.show;

import com.example.schoterspersonal.R;
import com.example.schoterspersonal.base.BaseActivity;
import com.example.schoterspersonal.presentation.viewmodel.PersonalCategoryVM;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class ShowCategoryActivity extends BaseActivity {

    public static final String EXTRA_CATEGORY = "extra_category";

    @BindView(R.id.rv_category_list)
    RecyclerView mRvCategoryList;

    private List<PersonalCategoryVM> mPersonalCategoryVMList = new ArrayList<>();

    private ShowCategoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntentData();
        initRecyclerView();
        populateRecyclerView();
    }

    private void getIntentData() {
        mPersonalCategoryVMList = getIntent().getParcelableArrayListExtra(EXTRA_CATEGORY);
    }

    private void initRecyclerView() {
        mAdapter = new ShowCategoryAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvCategoryList.setLayoutManager(layoutManager);
        mRvCategoryList.setAdapter(mAdapter);
    }

    private void populateRecyclerView() {
        mAdapter.setPersonalCategoryVMList(mPersonalCategoryVMList);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_show_category;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.show_cat_title);
    }

    @OnClick({R.id.iv_toolbar_back, R.id.btn_done})
    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back:
                onBackPressed();
                break;
            case R.id.btn_done:
                finish();
                break;
            default:
        }
    }

}
