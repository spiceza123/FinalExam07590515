package com.pannathorn.finalexam07590515;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pannathorn.finalexam07590515.Database.LedgerDao;
import com.pannathorn.finalexam07590515.Database.LedgerItem;
import com.pannathorn.finalexam07590515.Database.LedgerRepository;

import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button regis = findViewById(R.id.register_button);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        reloadData(); // กรณีเก็บข้อมูลในฐานข้อมูล SQLite บนมือถือ
    }

    private void reloadData() {
        LedgerRepository repo = new LedgerRepository(MainActivity.this);

        repo.getLedger(new LedgerRepository.Callback() {
            @Override
            public void onGetLedger(final List<LedgerItem> itemList) {
                final String check;

                EditText uname = findViewById(R.id.username_edit_text);
                final String username = uname.getText().toString();

                EditText pw = findViewById(R.id.password_edit_text);
                final String password = pw.getText().toString();

                Button lg = findViewById(R.id.login_button);
                lg.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(username.isEmpty() || password.isEmpty()){
                        NO();
                        }
                    }
                });

                for (LedgerItem item : itemList) {
                    if (item.UName==username){
                        NoWelcome();
                        break;
                    }else{
                        welcome(username);
                    }
                }

            }

        });

    }

    void NO(){
        Toast t = Toast.makeText(this,"All fields are required",Toast.LENGTH_LONG);
        t.show();
    }
    void welcome(String s){
        Toast t = Toast.makeText(this,s,Toast.LENGTH_LONG);
        t.show();
    }
    void NoWelcome(){
        Toast t = Toast.makeText(this,"Invalid username or password",Toast.LENGTH_LONG);
        t.show();
    }
}
