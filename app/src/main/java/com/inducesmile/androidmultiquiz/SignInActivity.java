package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;

import com.inducesmile.androidmultiquiz.database.DBHandler;
import com.inducesmile.androidmultiquiz.entities.QuestionObject;

public class SignInActivity extends AppCompatActivity {

    private DBHandler dbHandler = new DBHandler(SignInActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#e1c8d6'>My Life Balance | Sign In</font>"));

        QuestionObject q = new QuestionObject(1, "I feel excited about my life most of the time.", "Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree");
        dbHandler.addQuiz(q);

        Button register = (Button)findViewById(R.id.register_button);
        assert register != null;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizCategoryIntent = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivity(quizCategoryIntent);
            }
        });
    }
}
