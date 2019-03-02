package com.example.schoterspersonal.presentation.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonalCategoryVM implements Parcelable {

    public static final Creator<PersonalCategoryVM> CREATOR = new Creator<PersonalCategoryVM>() {
        @Override
        public PersonalCategoryVM createFromParcel(Parcel source) {
            return new PersonalCategoryVM(source);
        }

        @Override
        public PersonalCategoryVM[] newArray(int size) {
            return new PersonalCategoryVM[size];
        }
    };

    private String mId;

    private String mName;

    private String mDescription;

    private String mPublishedAt;

    private String mImageUrl;

    private boolean mIsChecked;

    public PersonalCategoryVM() { }

    protected PersonalCategoryVM(Parcel source) {
        mId             = source.readString();
        mName           = source.readString();
        mDescription    = source.readString();
        mPublishedAt    = source.readString();
        mImageUrl       = source.readString();
        mIsChecked      = source.readByte() != 0;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        mPublishedAt = publishedAt;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public boolean isChecked() {
        return mIsChecked;
    }

    public void setChecked(boolean checked) {
        mIsChecked = checked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeString(mPublishedAt);
        dest.writeString(mImageUrl);
        dest.writeByte((byte) (mIsChecked ? 1 : 0));
    }

}
