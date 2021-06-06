package com.example.Calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;
    int buffer;
    char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews() {
        workingsTV = (TextView) findViewById(R.id.workingsTextView);
        resultsTV = (TextView) findViewById(R.id.resultTextView);
    }

    public void opOnClick(View view) {
        buffer = Integer.parseInt(workingsTV.getText().toString());
        Button b = (Button) view;
        op = b.getText().charAt(0);
        resultsTV.setText(workingsTV.getText().toString() + b.getText().toString());
        workingsTV.setText("");
    }

    public void numOnClick(View view) {
        Button b = (Button) view;
        workingsTV.setText(workingsTV.getText().toString() + b.getText().toString());
    }

    public void clearOnClick(View view) {
        workingsTV.setText("");
        resultsTV.setText("");
    }

    public void equalsOnClick(View view) {
        switch (op) {
            case '+':
                buffer += Integer.parseInt((String) workingsTV.getText());
                break;
            case '-':
                buffer -= Integer.parseInt((String) workingsTV.getText());
                break;
            case '*':
                buffer *= Integer.parseInt((String) workingsTV.getText());
                break;
            case '/':
                buffer /= Integer.parseInt((String) workingsTV.getText());
                break;
        }
        resultsTV.setText(String.valueOf(buffer));
        workingsTV.setText("");
    }
}

