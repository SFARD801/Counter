package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //تعریف متغیر های برنامه و کنترل های اکتیویتی اصلی
    Button buttonCount, buttonReset;
    EditText editTextInput;
    TextView textViewOutput;
    int valueInput = 0, valueOutput = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ارتباط کنترل های تعریف شده در اکتیویتی و ایجاد شده در قاب layout اصلی
        buttonCount = (Button) findViewById(R.id.buttonCount);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        editTextInput = (EditText) findViewById(R.id.editTextInput);
        textViewOutput = (TextView) findViewById(R.id.textViewOutput);

        //بررسی وضعیت کلیک دکمه ریست برای اعمال کد های مربوطه به وضعیت ریست
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewOutput.setText("0");
                valueOutput=0;

                //اگر بخواهیم مقدار ورودی را هم صفر کنیم، نیاز به تایپ دوباره خواهیم داشت
                /*editTextInput.setText("0");
                valueInput=0;*/

                Toast.makeText(MainActivity.this, "شمارنده ریست شد!", Toast.LENGTH_SHORT).show();
            }
        });

        //بررسی وضعیت کلیک شمارش تا کدهای مربوط به شمارش را پیاده کنیم
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //بررسی مقدار موجودی در کنترل textViewOutput که ایا مقداری دارد یا تهی است
                //یا باید مقدار textViewOutput را به عدد صحیح تبدیل کنیم یا بعنوان رشته Test تعریف کنیم و از متود Test.isEmpty برای صحت کامنت بالایی، بکار ببریم
                String Test=editTextInput.getText().toString();
                //درصورت خالی بودن ""، مانع از ادامه یافن برنامه شده و خطا را در قالب یک Toast حاوی پیغام هشدار، نشان میدهیم
                if (Test.isEmpty()) {
                    Toast.makeText(MainActivity.this, "درج مقدار ورودی الزامیست!", Toast.LENGTH_SHORT).show();
                }
                //اگر هم مقداری بود با استفاده از ()getText. آنرا گرفته و توسط parseInt. به مقدار صحیح تبدیل میکنیم
                else {
                    valueInput= Integer.parseInt(editTextInput.getText().toString());
                    //مقدار دریافتی valueInput را به آخرین مقدار خروجی valueOutput اضافه میکنیم
                    valueOutput=valueOutput+valueInput;
                    //سپس حاصل جمع را در در قالب رشته با استفاده از setText. در داخل textViewOutput قرار میدهیم
                    textViewOutput.setText(valueOutput + "");
                }
            }
        });
    }
}