package com.inducesmile.androidmultiquiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.inducesmile.androidmultiquiz.entities.Client;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Sandman on 12/05/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USER = "user";
    private static final String TABLE_CATEGORY = "category";
    private static final String TABLE_QUIZ = "quiz";
  //  private static final String TABLE_QUIZ_SCORE = "categoryScore";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_CATEGORY_ID = "category_id";
    private static final String COLUMN_CATEGORY_NAME = "category_name";
    private static final String COLUMN_CATEGORY_IMAGE = "category_image";
    private static final String COLUMN_QUIZ_ID = "quiz_id";
    private static final String COLUMN_QUIZ_QUESTION = "quiz_question";
    private static final String COLUMN_QUIZ_OPTIONS = "quiz_options";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT)";

    private String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + " ("
            + COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CATEGORY_NAME + " TEXT, "
            + COLUMN_CATEGORY_IMAGE + " TEXT)";

    private String CREATE_QUIZ_TABLE = "CREATE TABLE " + TABLE_QUIZ + " ("
            + COLUMN_QUIZ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CATEGORY_ID + "REFERENCES category(category_id), "
            + COLUMN_QUIZ_QUESTION + " TEXT, "
            + COLUMN_QUIZ_OPTIONS + " TEXT)";

    // insert into tables
    private String INSERT_USERS = "INSERT INTO user (user_id, user_email, user_password) VALUES " + "('1', 'Jeremy', 'jj@pp.com'), ('2', 'James', 'james@gmail.com',)";
    private String INSERT_CATEGORIES = "INSERT INTO category (category_id, category_name, category_image) VALUES " + "('1', 'Health and Personal Growth', 'health'), ('2', 'Money/Career', 'money'), ('3', 'Physical Environment', 'physical'), ('4', 'Relationships/Family', 'family') "
    private String INSERT_QUIZ = "INSERT INTO quiz (quiz_id, quiz_question, quiz_options) VALUES ('1', '1', 'I feel excited about my life most of the time.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree')," +
            "('2', '1', 'I feel disengaged and fearful most of the time.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree'), ('3', '1', 'I feel content and appreciate with what life has taught me.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree')," +
            "('4', '1', 'I feel stressed and overwhelmed with my daily activities.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree'), ('5', '1', 'I am in full control of my health and wellness.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree')," +
            "('6', '2', 'I have a plan for my business/career and l am on track.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree'), ('7', '2', 'I am frustrated with my work/life balance.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree')," +
            "('8', '2', 'I organise my budget well and know exactly where my money is spent.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree'), ('9', '2', 'I live week to week with no idea where my money goes.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree')," +
            "('10', '2', 'I have a vision and mission for my life.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree'), ('11', '3', 'I feel at peace in my surroundings.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree')," +
            "('12', '3', 'My environment is busy and cluttered.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree'), ('13', '3', 'I have a special space where l am able to sit and reflect.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree')," +
            "('14', '3', 'I do not have a place l use for reflection and creativity.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree'), ('15', '3', 'I feel anxious and frustrated with my surroundings.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree')," +
            "('16', '4', 'I am energised with the connection l have with my partner/ special person.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree'), ('17', '4', 'I feel that everyone around me drains my energy.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree')," +
            "('18', '4', 'I love to plan special activities with my partner/special person.', 'Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree'), ('19', '4', 'I prefer to spend my free time alone.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree')," +
            "('20', '4', 'I would like to spend more time with my family/friends.', 'Strongly Agree, Agree, Neutral, Disagree, Strongly Disgree') ";



    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    private String DROP_CATEGORY_TABLE = "DROP TABLE IF EXISTS " + TABLE_CATEGORY;
    private String DROP_QUIZ_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUIZ;

    public DBHandler (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_QUIZ_TABLE);
        db.execSQL(CREATE_CATEGORY_TABLE);
        onCreate(db);
}

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_CATEGORY_TABLE);
        db.execSQL(DROP_QUIZ_TABLE);
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public void addClient(Client client) {
        //Create ContentValues Object to hold data
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, client.getId());
        //Assign client name to object taken from passed Client object
        values.put(COLUMN_USER_NAME, client.getName());
        //Assign email to object taken from passed Client object
        values.put(COLUMN_USER_EMAIL, client.getEmail());
        //Create DB object and assign current object to it
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public void addCategory(Category category) {
        //Create ContentValues Object to hold data
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORY_ID, category.getId());
        //Assign client name to object taken from passed Client object
        values.put(COLUMN_CATEGORY_NAME, category.getName());
        //Assign email to object taken from passed Client object
        values.put(COLUMN_CATEGORY_IMAGE, category.getImage());
        //Create DB object and assign current object to it
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CATEGORY, null, values);
        db.close();
    }

    public void addQuiz(Quiz quiz) {
        //Create ContentValues Object to hold data
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUIZ_ID, quiz.getId());
        //Assign client name to object taken from passed Client object
        values.put(COLUMN_QUIZ_OPTIONS, quiz.getName());
        //Assign email to object taken from passed Client object
        values.put(COLUMN_QUIZ_QUESTION, quiz.getImage());
        //Create DB object and assign current object to it
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_QUIZ, null, values);
        db.close();
    }

    public Client findAllClients() {
        String query = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Client client = new Client();
        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            client.setName(cursor.getString(1));
            client.setEmail(cursor.getString(2));
            cursor.close();
        } else {
            client = null;
        }
        db.close();
        return client;
    }
}
