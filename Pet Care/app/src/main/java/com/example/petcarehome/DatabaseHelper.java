package com.example.petcarehome;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PetCareDB";
    public static final int DATABASE_VERSION = 1;

    // USERS Table - column names
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_REG_NO = "register_no";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_FULL_NAME = "full_name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EXPERIENCE = "experience";
    public static final String COLUMN_USER_TYPE = "user_type"; // Added for user type

    // Pet_Owner Table - column names
    public static final String TABLE_PET_OWNER = "Pet_Owner";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE_NO = "phoneNo";
    public static final String COLUMN_ADDRESS = "Address";

    // Create table SQL statements
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_REG_NO + " TEXT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_FULL_NAME + " TEXT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASSWORD + " TEXT,"
            + COLUMN_EXPERIENCE + " TEXT,"
            + COLUMN_USER_TYPE + " TEXT" // Added for user type
            + ")";

    private static final String CREATE_TABLE_PET_OWNER = "CREATE TABLE " + TABLE_PET_OWNER + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PHONE_NO + " TEXT,"
            + COLUMN_ADDRESS + " TEXT,"
            + COLUMN_PASSWORD + " TEXT"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating required tables
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_PET_OWNER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // On upgrade, drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PET_OWNER);

        // Create new tables
        onCreate(db);
    }

    public void CareGiverSignUp(String registerNo, String username, String fullName, String email, String password, String experience) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_REG_NO, registerNo);
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_FULL_NAME, fullName);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_EXPERIENCE, experience);
        values.put(COLUMN_USER_TYPE, "Care giver"); // Set user type for Care giver

        // Insert the new row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }

    public void CustomerSignUp(String name, String username, String email, String phoneNo, String address, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE_NO, phoneNo);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_USER_TYPE, "Pet Owner"); // Set user type for Pet Owner

        // Insert the new row
        db.insert(TABLE_PET_OWNER, null, values);
        db.close(); // Closing database connection
    }

    public int Signin(String username, String password,String usertye) {
        int result = 0;
        String str[] = new String[3];
        str[0] = username;
        str[1] = password;
        str[2] =usertye;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=? AND " + COLUMN_USER_TYPE + "=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        c.close();
        db.close();
        return result;
    }

    @SuppressLint("Range")
    public String getUserType(String username) {
        String userType = "";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT " + COLUMN_USER_TYPE + " FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=?", new String[]{username});

        if (c.moveToFirst()) {
            userType = c.getString(c.getColumnIndex(COLUMN_USER_TYPE));
        }

        c.close();
        db.close();
        return userType;
    }

    public boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            return f1 == 1 && f2 == 1 && f3 == 1;
        }
    }
}
