package com.example.Task_android2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task_android2.R;

public class MainActivity extends AppCompatActivity {


    private String[] words = {"welcome", "play", "ahmed", "book", "computer","hello","android","work","phone","programming","task","nice","word","next","show"};

    private int currentIndex = 0;
    private String currentWord;

    private TextView wordTextView;
    private TextView correctWord;
    private EditText userInputEditText;
    private Button showButton;
    private Button checkButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Start from here

        wordTextView = findViewById(R.id.correct_textview2);
        correctWord = findViewById(R.id.correct_textview4);
        userInputEditText = findViewById(R.id.correct_edittext);
        showButton = findViewById(R.id.correct_btn1);
        checkButton = findViewById(R.id.correct_btn2);
        nextButton = findViewById(R.id.correct_btn3);

        showNextWord();

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordTextView.setText(words[currentIndex]);
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEnteredWord = userInputEditText.getText().toString();
                if (userEnteredWord.equals(words[currentIndex])) {
                    correctWord.setText("Correct Congratulations");
                } else {
                    correctWord.setText("Wrong Try again!");
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextWord();
            }
        });


    }
    private void nextWord () {
        currentIndex++;
        showNextWord();


    }


    private void showNextWord() {
        if (currentIndex < words.length) {
            currentWord = scrambleWord(words[currentIndex]);
            wordTextView.setText(currentWord);
            userInputEditText.setText("");
        } else {
            wordTextView.setText("No more words.");

        }
    }

    private String scrambleWord(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int randomIndex = (int) (Math.random() * chars.length);
            char temp = chars[i];
            chars[i] = chars[randomIndex];
            chars[randomIndex] = temp;
        }
        return new String(chars);
    }

}