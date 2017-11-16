package com.mzdhr.quizapppython;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Objects
    private int mCorrectAnswers;

    // Views
    private CheckBox mCheckBoxAnswer01Question01;
    private CheckBox mCheckBoxAnswer02Question01;
    private CheckBox mCheckBoxAnswer03Question01;
    private CheckBox mCheckBoxAnswer04Question01;
    private CheckBox mCheckBoxAnswer01Question02;
    private CheckBox mCheckBoxAnswer02Question02;
    private CheckBox mCheckBoxAnswer03Question02;
    private CheckBox mCheckBoxAnswer04Question02;
    private RadioButton mRadioButtonAnswer02Question03;
    private RadioButton mRadioButtonAnswer01Question04;
    private RadioButton mRadioButtonAnswer03Question05;
    private EditText mEditTextAnswer01Question06;
    private Button mButtonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    /**
     * Calculating Results
     * Full result is 10
     * Question 1 give +4 points
     * Question 2 give +2 points
     * others give +1 point each
     *
     * Then showing the result in toast
     * After that reset the global variable: mCorrectAnswers to 0.
     */
    private void calculateResult() {
        if (mCheckBoxAnswer01Question01.isChecked() && mCheckBoxAnswer02Question01.isChecked() &&
                mCheckBoxAnswer03Question01.isChecked() && mCheckBoxAnswer04Question01.isChecked() == true){mCorrectAnswers +=4;}
        if (mCheckBoxAnswer01Question02.isChecked() && mCheckBoxAnswer03Question02.isChecked() == true &&
                mCheckBoxAnswer02Question02.isChecked() == false && mCheckBoxAnswer04Question02.isChecked() == false){mCorrectAnswers += 2;}
        if (mRadioButtonAnswer02Question03.isChecked() == true){mCorrectAnswers += 1;}
        if (mRadioButtonAnswer01Question04.isChecked() == true){mCorrectAnswers += 1;}
        if (mRadioButtonAnswer03Question05.isChecked() == true){mCorrectAnswers += 1;}
        if (mEditTextAnswer01Question06.getText().toString().equals(getString(R.string.question06answer01))){mCorrectAnswers += 1;}

        if(mCorrectAnswers == 10){
            Toast.makeText(this, R.string.result_message_full_score, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,
                    getString(R.string.result_message_part01)
                            + mCorrectAnswers
                            + getString(R.string.result_message_part02)
                    , Toast.LENGTH_SHORT).show();
        }

        mCorrectAnswers = 0;
    }

    private void findViews() {
        mCheckBoxAnswer01Question01 = (CheckBox) findViewById(R.id.answer01_question01);
        mCheckBoxAnswer02Question01 = (CheckBox) findViewById(R.id.answer02_question01);
        mCheckBoxAnswer03Question01 = (CheckBox) findViewById(R.id.answer03_question01);
        mCheckBoxAnswer04Question01 = (CheckBox) findViewById(R.id.answer04_question01);
        mCheckBoxAnswer01Question02 = (CheckBox) findViewById(R.id.answer01_question02);
        mCheckBoxAnswer02Question02 = (CheckBox) findViewById(R.id.answer02_question02);
        mCheckBoxAnswer03Question02 = (CheckBox) findViewById(R.id.answer03_question02);
        mCheckBoxAnswer04Question02 = (CheckBox) findViewById(R.id.answer04_question02);
        mRadioButtonAnswer02Question03 = (RadioButton) findViewById(R.id.answer02_question03);
        mRadioButtonAnswer01Question04 = (RadioButton) findViewById(R.id.answer01_question04);
        mRadioButtonAnswer03Question05 = (RadioButton) findViewById(R.id.answer03_question05);
        mEditTextAnswer01Question06 = (EditText) findViewById(R.id.answer01_question06);
        mButtonSubmit = (Button) findViewById(R.id.button_submit);
    }
}
