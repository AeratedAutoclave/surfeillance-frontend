package com.example.surfeillancefrontend.model.data.dto;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;

public class AppUser extends BaseObservable implements Parcelable  {
        private long id;
        private String userName;
        private String profileText;
        private String location;
        private String skillLevel;
        private String imageUrl;
        private String email;
        private String token;

    public AppUser(long id) {
        this.id = id;
    }

    public AppUser(Parcel in) {
        id = in.readLong();
        userName = in.readString();
        profileText = in.readString();
        location = in.readString();
        skillLevel = in.readString();
        imageUrl = in.readString();
        email = in.readString();
        token = in.readString();
    }

    public static final Creator<AppUser> CREATOR = new Creator<AppUser>() {
        @Override
        public AppUser createFromParcel(Parcel in) {
            return new AppUser(in);
        }

        @Override
        public AppUser[] newArray(int size) {
            return new AppUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(userName);
        dest.writeString(profileText);
        dest.writeString(location);
        dest.writeString(skillLevel);
        dest.writeString(imageUrl);
        dest.writeString(email);
        dest.writeString(token);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileText() {
        return profileText;
    }

    public void setProfileText(String profileText) {
        this.profileText = profileText;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
