package com.example.Calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView workingsTextView;
    private TextView resultsTextView;
    private String input = "";
    private boolean clearResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void initTextViews() {
        workingsTextView = (TextView) findViewById(R.id.workingsTextView);
        resultsTextView = (TextView) findViewById(R.id.resultTextView);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("save", input);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        input = savedInstanceState.getString("save");
    }

    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = "";
                break;
            case "*":
                clearResult = false;
                Solve();
                input += "*";
                break;
            case "^":
                clearResult = false;
                Solve();
                input += "^";
                break;
            case "=":
                clearResult = true;
                Solve();
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    clearResult = false;
                    Solve();
                } else if (clearResult) {
                    input = "";
                    clearResult = false;
                }
                input += data;
        }
        workingsTextView.setText(input);
    }

    public void Solve() {
        if (input.split("\\*").length == 2) {
            String[] numbers = input.split("\\*");
            try {
                double multiple = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                input = multiple + "";
            } catch (Exception ignored) {
            }
        } else if (input.split("/").length == 2) {
            String[] numbers = input.split("/");
            double div = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
            input = div + "";
        } else if (input.split("\\^").length == 2) {
            String[] numbers = input.split("\\^");
            double pow = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
            input = pow + "";
        } else if (input.split("\\+").length == 2) {
            String[] numbers = input.split("\\+");
            double sum = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
            input = sum + "";
        } else if (input.split("\\-").length > 1) {
            String[] numbers = input.split("\\-");
            if (numbers[0].equals("") && numbers.length == 2) {
                numbers[0] = 0 + "";
            }
                double sub = 0;
                if (numbers.length == 2) {
                    sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                } else if (numbers.length == 3) {
                    sub = -Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[2]);
                }
                input = sub + "";

        }
        String[] n = input.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                input = n[0];
            }
        }
        resultsTextView.setText(input);
    }
}

