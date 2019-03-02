package com.example.schoterspersonal.base;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.schoterspersonal.R;
import com.example.schoterspersonal.component.views.HelveticaTextView;
import com.example.schoterspersonal.utils.StatusBarUtils;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected static final String TAG = BaseActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar mToolbar;

    @BindView(R.id.iv_toolbar_back)
    @Nullable
    ImageView mIvToolbarBack;

    @BindView(R.id.tv_toolbar_title)
    @Nullable
    HelveticaTextView mTvToolbarTitle;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getContentView());
        ButterKnife.bind(this);
        setToolbar();
        setStatusBar();
    }

    public abstract int getContentView();

    public abstract String getScreenTitle();

    public void hideLeftMenu() {
        if (mIvToolbarBack != null) {
            mIvToolbarBack.setVisibility(View.GONE);
        }
    }

    private void setToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle("");
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setBackgroundDrawable(
                new ColorDrawable(getResources().getColor(R.color.colorTurquoise)));
        }

        if (mTvToolbarTitle != null) {
            mTvToolbarTitle.setText(getScreenTitle());
        }
    }

    private void setStatusBar() {
        StatusBarUtils.setStatusBarColor(this, R.color.colorDarkTurquoise);
    }

    public void showLoadingBar() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.style.ProgressDialogTheme);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        mProgressDialog.show();
    }

    public void hideLoadingBar() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
