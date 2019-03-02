package com.example.schoterspersonal.presentation.category.show;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoterspersonal.R;
import com.example.schoterspersonal.component.views.HelveticaTextView;
import com.example.schoterspersonal.component.views.OpenSansTextView;
import com.example.schoterspersonal.presentation.viewmodel.PersonalCategoryVM;
import com.example.schoterspersonal.utils.DateUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<PersonalCategoryVM> mPersonalCategoryVMList;

    public ShowCategoryAdapter(List<PersonalCategoryVM> personalCategoryVMList) {
        mPersonalCategoryVMList = personalCategoryVMList;
    }

    public void setPersonalCategoryVMList(List<PersonalCategoryVM> personalCategoryVMList) {
        mPersonalCategoryVMList = personalCategoryVMList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_show_category, parent, false);
        return new ShowCategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ShowCategoryViewHolder) holder).bind(mPersonalCategoryVMList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPersonalCategoryVMList.size();
    }

    public class ShowCategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_category_name)
        HelveticaTextView mTvCategotyName;

        @BindView(R.id.tv_category_description)
        OpenSansTextView mTvCategoryDescription;

        @BindView(R.id.tv_published_at)
        OpenSansTextView mTvPublishedAt;

        public ShowCategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(PersonalCategoryVM personalCategoryVM) {
            mTvCategotyName.setText(personalCategoryVM.getName());
            mTvCategoryDescription.setText(personalCategoryVM.getDescription());
            String publishedAt = String.format(
                mTvPublishedAt.getContext().getString(R.string.show_cat_published_at),
                DateUtils.formatDateTime(personalCategoryVM.getPublishedAt()));
            mTvPublishedAt.setText(publishedAt);
        }

    }

}
