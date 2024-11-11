package com.example.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btntinhBMI, btnThoat, btnClear;
    EditText editten, editchieucao, editcannang, editBMI, editchandoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btntinhBMI = (Button) findViewById(R.id.button);
        btnThoat = (Button) findViewById(R.id.button2);
        btnClear = (Button) findViewById(R.id.button3);

        editten = (EditText) findViewById(R.id.editTextText);
        editchieucao = (EditText) findViewById(R.id.editTextText2);
        editcannang = (EditText) findViewById(R.id.editTextText3);
        editBMI = (EditText) findViewById(R.id.editTextText4);
        editchandoan = (EditText) findViewById(R.id.editTextText5);


        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder Dialog = new AlertDialog.Builder(MainActivity.this);
                Dialog.setTitle("Thông báo!");
                Dialog.setMessage("Bạn có muốn thoát chương trình không?");
                Dialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface DialogInterface, int i) {
                        finish();
                    }
                });
                Dialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface DialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Bạn đã chọn No", Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface DialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Bạn đã chọn Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.create();
                Dialog.show();
            }
        });

    btnClear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editten.setText("");
            editchieucao.setText("");
            editcannang.setText("");
            editBMI.setText("");
            editchandoan.setText("");


        }
    });

        btntinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double H = Double.parseDouble(editchieucao.getText() + "");
                double W = Double.parseDouble(editcannang.getText() + "");
                double BMI = W / Math.pow(H, 2);
                String chandoan = null;
                if (BMI < 18) {
                    chandoan = "Bạn gầy";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI <= 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI <= 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editchandoan.setText(chandoan);
            }
        });
    }
}
//Pullll