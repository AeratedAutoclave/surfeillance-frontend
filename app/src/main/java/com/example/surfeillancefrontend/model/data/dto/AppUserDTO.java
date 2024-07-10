package com.example.surfeillancefrontend.model.data.dto;


import android.os.Parcel;
import android.os.Parcelable;

public class AppUserDTO implements Parcelable {
    private String googleId;
    private String userName;
    private String profileText;
    private String location;
    private String skillLevel;
    private String imageUrl;
    private String email;
    private String token;

    public String getGoogle_id() {
        return googleId;
    }

    public void setGoogle_id(String googleId) {
        this.googleId = googleId;
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

    public AppUserDTO(String googleId,String userName, String profileText, String location, String skillLevel, String imageUrl, String email, String token) {
        this.googleId = googleId;
        this.userName = userName;
        this.profileText = profileText;
        this.location = location;
        this.skillLevel = skillLevel;
        this.imageUrl = imageUrl;
        this.email = email;
        this.token = token;
    }

    public AppUserDTO(String googleId) {
        this.googleId = googleId;
    }

    protected AppUserDTO(Parcel in) {
       googleId = in.readString();
        userName = in.readString();
        profileText = in.readString();
        location = in.readString();
        skillLevel = in.readString();
        imageUrl = in.readString();
        email = in.readString();
        token = in.readString();
    }

    public static final Creator<AppUserDTO> CREATOR = new Creator<AppUserDTO>() {
        @Override
        public AppUserDTO createFromParcel(Parcel in) {
            return new AppUserDTO(in);
        }

        @Override
        public AppUserDTO[] newArray(int size) {
            return new AppUserDTO[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(googleId);
        dest.writeString(userName);
        dest.writeString(profileText);
        dest.writeString(location);
        dest.writeString(skillLevel);
        dest.writeString(imageUrl);
        dest.writeString(email);
        dest.writeString(token);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}


