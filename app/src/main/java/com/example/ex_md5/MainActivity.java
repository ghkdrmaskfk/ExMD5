package com.example.ex_md5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button encryptBtn, okBtn, removeBtn;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();

        encryptBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
        removeBtn.setOnClickListener(this);

    }

    private void findViewById() {

        textView = findViewById(R.id.text_view);

        editText = findViewById(R.id.edit_text);

        encryptBtn = findViewById(R.id.encrypt_btn);
        okBtn = findViewById(R.id.ok_btn);
        removeBtn = findViewById(R.id.remove_btn);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.encrypt_btn:

                try {

                    MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
                    digest.update(textView.getText().toString().getBytes());
                    byte messageDigest[] = digest.digest();

                    StringBuffer hexString = new StringBuffer();

                    for (int i = 0; i < messageDigest.length; i ++) {
                        hexString.append(Integer.toHexString(0xff & messageDigest[i]));
                    }

                    textView.setText(hexString);

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ok_btn:

                textView.setText(editText.getText().toString());

                break;
            case R.id.remove_btn:

                textView.setText("");

                break;

        }
    }
}
