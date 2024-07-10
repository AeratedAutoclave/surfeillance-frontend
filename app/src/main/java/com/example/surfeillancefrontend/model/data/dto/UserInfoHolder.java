package com.example.surfeillancefrontend.model.data.dto;

public class UserInfoHolder {
    private static UserInfoHolder instance;
    private String token;
    private String userID;


    private UserInfoHolder() {
    }

    public static synchronized UserInfoHolder getInstance() {
        if (instance == null) {
            instance = new UserInfoHolder();

        }
          return instance;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        System.out.println("this is the token on setting" + token);
        this.token = token;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
