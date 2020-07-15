package com.liuwang.mutaotravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.liuwang.mutaotravel.fragment.MeFragment;

public class LoginActivity extends AppCompatActivity {
    protected Button mBtnRegister;
    protected ImageView loginClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBtnRegister= (Button) this.findViewById(R.id.btn_register);
        loginClose= (ImageView) this.findViewById(R.id.login_close);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}
