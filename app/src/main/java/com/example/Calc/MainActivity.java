package com.example.Calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView workingsTextView;
    private TextView resultsTextView;
    private int buffer;
    private char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews() {
        workingsTextView = (TextView) findViewById(R.id.workingsTextView);
        resultsTextView = (TextView) findViewById(R.id.resultTextView);
    }

    public void opOnClick(View view) {
        buffer = Integer.parseInt(workingsTextView.getText().toString());
        Button b = (Button) view;
        op = b.getText().charAt(0);
        resultsTextView.setText(workingsTextView.getText().toString() + b.getText().toString());
        workingsTextView.setText("");
    }

    public void numOnClick(View view) {
        Button b = (Button) view;
        workingsTextView.setText(workingsTextView.getText().toString() + b.getText().toString());
    }

    public void clearOnClick(View view) {
        workingsTextView.setText("");
        resultsTextView.setText("");
    }

    public void equalsOnClick(View view) {
        switch (op) {
            case '+':
                buffer += Integer.parseInt((String) workingsTextView.getText());
                break;
            case '-':
                buffer -= Integer.parseInt((String) workingsTextView.getText());
                break;
            case '*':
                buffer *= Integer.parseInt((String) workingsTextView.getText());
                break;
            case '/':
                buffer /= Integer.parseInt((String) workingsTextView.getText());
                break;
        }
        resultsTextView.setText(String.valueOf(buffer));
        workingsTextView.setText("");
    }
}

