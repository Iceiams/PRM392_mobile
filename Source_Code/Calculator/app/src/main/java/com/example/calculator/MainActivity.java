package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextView manHinhPhu;
    private TextView manHinh;
    private String input = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean isResultShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manHinhPhu = findViewById(R.id.man_hinh_phu);
        manHinh = findViewById(R.id.man_hinh);

        setNumberButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        int[] numberButtonIds = {
                R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5,
                R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9, R.id.btdot
        };

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (isResultShown) {
                    input = "";
                    isResultShown = false;
                }
                input += button.getText().toString();
                manHinh.setText(input);
            }
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(numberClickListener);
        }
    }

    private void setOperatorButtonListeners() {
        int[] operatorButtonIds = {
                R.id.btplus, R.id.btsub, R.id.btmul, R.id.btdiv
        };

        View.OnClickListener operatorClickListener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (!input.isEmpty()) {
                    if (!operator.isEmpty()) {
                        double secondNumber = Double.parseDouble(input);
                        firstNumber = calculateResult(firstNumber, secondNumber, operator);
                    } else {
                        firstNumber = Double.parseDouble(input);
                    }
                    operator = button.getText().toString();
                    input = "";
                    manHinhPhu.setText(firstNumber + " " + operator);
                    manHinh.setText("");
                }
            }
        };

        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(operatorClickListener);
        }

        findViewById(R.id.btequal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    double secondNumber = Double.parseDouble(input);
                    double result = calculateResult(firstNumber, secondNumber, operator);
                    manHinh.setText(String.valueOf(result));
                    manHinhPhu.setText("");
                    input = String.valueOf(result);
                    operator = "";
                    isResultShown = true;
                }
            }
        });

        findViewById(R.id.btc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = "";
                firstNumber = 0;
                operator = "";
                manHinh.setText("");
                manHinhPhu.setText("");
            }
        });

        findViewById(R.id.btce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = "";
                manHinh.setText("");
            }
        });
    }

    private double calculateResult(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    // Xử lý chia cho 0
                    return 0;
                }
            default:
                return 0;
        }
    }
}
