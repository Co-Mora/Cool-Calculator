package com.omardev.coolcal;

import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    public enum Operation {

        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL

    }


    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;



    TextView viewText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oneBtn   = findViewById(R.id.oneBtn);
        Button twoBtn   = findViewById(R.id.twoBtn);
        Button threeBtn = findViewById(R.id.threeBtn);
        Button fourBtn  = findViewById(R.id.fourBtn);
        Button fiveBtn  = findViewById(R.id.fiveBtn);
        Button sixBtn   = findViewById(R.id.sixBtn);
        Button sevenBtn = findViewById(R.id.sevenBtn);
        Button eightBtn = findViewById(R.id.eightBtn);
        Button nineBtn  = findViewById(R.id.nineBtn);
        Button zeroBtn  = findViewById(R.id.zeroBtn);
        Button clearBtn = findViewById(R.id.clearBtn);


        ImageButton addBtn      = findViewById(R.id.addBtn);
        ImageButton subtractBtn = findViewById(R.id.subtractBtn);
        ImageButton divideBtn   = findViewById(R.id.divideBtn);
        ImageButton multiBtn    = findViewById(R.id.multyBtn);
        ImageButton resultsBtn  = findViewById(R.id.resultBtn);
        viewText = (TextView) findViewById(R.id.viewText);
        viewText.setText("");

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(2);

            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(4);

            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });

         clearBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 runningNumber = "";
                 leftValueStr = "";
                 rightValueStr = "";
                 result = 0;
                 currentOperation = null;
                 viewText.setText("0");
             }
         });

         addBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 processOperation(Operation.ADD);
             }
         });
         subtractBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 processOperation(Operation.SUBTRACT);
             }
         });

         divideBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 processOperation(Operation.DIVIDE);
             }
         });

         multiBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 processOperation(Operation.MULTIPLY);
             }
         });

         resultsBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 processOperation(Operation.EQUAL);
             }
         });
    }

    void processOperation(Operation operation) {

        if(currentOperation != null) {

            if(runningNumber != "") {

                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation) {

                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }

                leftValueStr = String.valueOf(result);
                viewText.setText(leftValueStr);

            }
        } else {

            leftValueStr = runningNumber;
            runningNumber = "";
        }

        currentOperation = operation;
    }

    void numberPressed(int number) {

        runningNumber += String.valueOf(number);
        viewText.setText(runningNumber);
    }
}
