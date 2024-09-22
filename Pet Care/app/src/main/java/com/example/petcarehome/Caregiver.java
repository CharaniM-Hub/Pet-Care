package com.example.petcarehome;

import android.os.Parcel;
import android.os.Parcelable;

public class Caregiver implements Parcelable {

    String RegNo, UName, FName, Email, Pno, Password, Experience, Price;

    public Caregiver(String regNo, String UName, String FName, String email, String pno, String password, String experience, String price) {
        this.RegNo = regNo;
        this.UName = UName;
        this.FName = FName;
        this.Email = email;
        this.Pno = pno;
        this.Password = password;
        this.Experience = experience;
        this.Price = price;
    }

    protected Caregiver(Parcel in) {
        RegNo = in.readString();
        UName = in.readString();
        FName = in.readString();
        Email = in.readString();
        Pno = in.readString();
        Password = in.readString();
        Experience = in.readString();
        Price = in.readString();
    }

    public static final Creator<Caregiver> CREATOR = new Creator<Caregiver>() {
        @Override
        public Caregiver createFromParcel(Parcel in) {
            return new Caregiver(in);
        }

        @Override
        public Caregiver[] newArray(int size) {
            return new Caregiver[size];
        }
    };

    public String getRegNo() {
        return RegNo;
    }

    public String getUName() {
        return UName;
    }

    public String getFName() {
        return FName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPno() {
        return Pno;
    }

    public String getPassword() {
        return Password;
    }

    public String getExperience() {
        return Experience;
    }

    public String getPrice() {
        return Price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(RegNo);
        dest.writeString(UName);
        dest.writeString(FName);
        dest.writeString(Email);
        dest.writeString(Pno);
        dest.writeString(Password);
        dest.writeString(Experience);
        dest.writeString(Price);
    }
}
