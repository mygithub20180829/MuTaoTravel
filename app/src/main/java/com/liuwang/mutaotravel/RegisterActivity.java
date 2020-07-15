package com.liuwang.mutaotravel;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    String username,password;//用户名和密码
    String registfile="registfile.txt";
    String pswfile="pswfile.txt";
    String pass="~`!@#$%^&*(){}''?|《》<>?,.，。-=_+[]\"/、\\";
    EditText number;
    EditText psw,repsw;
    Button regist;
    DBhelper dbHelper=new DBhelper(this,"UserLogin",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        number= (EditText) findViewById(R.id.regist_username);
        psw= (EditText) findViewById(R.id.regist_setpassword);
        repsw= (EditText) findViewById(R.id.regist_resetpassword);
        regist= (Button) findViewById(R.id.btn_submit);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    saveUsersInfo();
            }
        });
    }

    private void saveUsersInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserLogin", Context.MODE_APPEND);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", number.getText().toString());
        //判断注册时的两次密码是否相同
        if (psw.getText().toString().equals(repsw.getText().toString())) {
            editor.putString("password", psw.getText().toString());
        }
        editor.commit();
    }

    private void registerUserInfo(String username, String userpassword) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", userpassword);
        db.insert("usertable", null, values);
        db.close();
    }

    public boolean CheckIsDataAlreadyInDBorNot(String value) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String Query = "Select * from usertable where username =?";
        Cursor cursor = db.rawQuery(Query, new String[]{value});
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
}
