package com.example.android.quizproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton question1Button3;
    RadioButton question2Button2;
    RadioButton question3Button3;
    EditText question4FruitName;
    RadioButton question5Button1;
    CheckBox question6Check1;
    CheckBox question6Check2;
    CheckBox question6Check3;
    CheckBox question6Check4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question1Button3 = findViewById(R.id.q1r3);
        question2Button2 = findViewById(R.id.q2r2);
        question3Button3 = findViewById(R.id.q3r3);
        question4FruitName = findViewById(R.id.input_fruit_name);
        question5Button1 = findViewById(R.id.q5r1);
        question6Check1 = findViewById(R.id.q6cb1);
        question6Check2 = findViewById(R.id.q6cb2);
        question6Check3 = findViewById(R.id.q6cb3);
        question6Check4 = findViewById(R.id.q6cb4);
    }

    /*
    /  This method verifies each possible correct answer and increments the score
    /  integer if the answer is correct. Returns the score counter.
    */
    public int calculateScore() {
        int score = 0;
        Editable name = question4FruitName.getText();
        String fruitName = name.toString();
        if (question1Button3.isChecked()) {
            score++;
        }
        if (question2Button2.isChecked()) {
            score++;
        }
        if (question3Button3.isChecked()) {
            score++;
        }
        if (fruitName.equalsIgnoreCase(getString(R.string.peach))) {
            score++;
        }
        if (question5Button1.isChecked()) {
            score++;
        }
        if (!question6Check1.isChecked()) {
            if (question6Check2.isChecked()) {
                if (!question6Check3.isChecked()) {
                    if (question6Check4.isChecked()) {
                        score++;
                    }
                }
            }
        }
        return score;
    }

    /*
    /  This method displays the results toast when Results button is pressed
    */
    public void submitResults(View view) {
        Context context = getApplicationContext();

        String text = getString(R.string.answerCorrect) + " " + calculateScore();
        if (calculateScore() == 1) {
            text += getString(R.string.question) + getString(R.string.ofMaxQuestions);
        } else text += getString(R.string.questions) + getString(R.string.ofMaxQuestions);

        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /*
    /This method resets results by restarting the activity
     */
    public void resetResults(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);

    }
}
