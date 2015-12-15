package com.example.valentin.veracalculator3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    // создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// TODO Auto-generated method stub
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    // обработка нажатий на пункты меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
        switch (item.getItemId()) {
            case MENU_RESET_ID:
// очищаем поля
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                tvResultSQRT.setText("");
                break;
            case MENU_QUIT_ID:
// выход из приложения
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    Button btnSQRTAdd;
    Button btnSQRTSub;
    Button btnSQRTMult;
    Button btnSQRTDiv;

    TextView tvResult;
    TextView tvResultSQRT;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // находим элементы
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnSQRTAdd = (Button) findViewById(R.id.btnSQRTAdd);
        btnSQRTSub = (Button) findViewById(R.id.btnSQRTSub);
        btnSQRTMult = (Button) findViewById(R.id.btnSQRTMult);
        btnSQRTDiv = (Button) findViewById(R.id.btnSQRTDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResultSQRT = (TextView) findViewById(R.id.tvResultSQRT);

        // прописываем обработчик
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btnSQRTAdd.setOnClickListener(this);
        btnSQRTSub.setOnClickListener(this);
        btnSQRTMult.setOnClickListener(this);
        btnSQRTDiv.setOnClickListener(this);
    }
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;
        float resultSQRT = 0;
        int sort=0;

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        // читаем EditText и заполняем переменные числами
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;

            case R.id.btnSQRTAdd:
                oper = "+";
                sort=1;
                resultSQRT = (float) Math.sqrt(num1 + num2);
                break;
            case R.id.btnSQRTSub:
                oper = "-";
                sort=1;
                resultSQRT = (float) Math.sqrt(num1 - num2);
                break;
            case R.id.btnSQRTMult:
                oper = "*";
                sort=1;
                resultSQRT = (float) Math.sqrt(num1 * num2);
                break;
            case R.id.btnSQRTDiv:
                oper = "/";
                sort=1;
                resultSQRT = (float) Math.sqrt(num1 / num2);
                break;

            default:
                break;
        }

        // формируем строку вывода
        if (sort==1)
        {
            tvResultSQRT.setText("SQRT("+num1 + " " + oper + " " + num2 +")"+ " = " + resultSQRT);
        }
        else
        {
            tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
        }


    }

}
