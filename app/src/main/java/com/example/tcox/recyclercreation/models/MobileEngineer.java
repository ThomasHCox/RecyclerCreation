package com.example.tcox.recyclercreation.models;

/**
 * Created by tcox on 11/28/17.
 */

public class MobileEngineer {
    private String mName;
    private String mPosition;
    private String mBirthdate;
    private String mStartDate;
    private String mAvatar;
    private String mHobbies;
    private String mProject;
    private String mBio;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String mPosition) {
        this.mPosition = mPosition;
    }

    public String getBirthdate() {
        return mBirthdate;
    }

    public void setBirthdate(String mBirthdate) {
        this.mBirthdate = mBirthdate;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public void setStartDate(String mStartDate) {
        this.mStartDate = mStartDate;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getHobbies() {
        return mHobbies;
    }

    public void setHobbies(String hobbies) {
        mHobbies = hobbies;
    }

    public String getProject() {
        return mProject;
    }

    public void setProject(String project) {
        mProject = project;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio (String bio) {
        mBio = bio;
    }
}
