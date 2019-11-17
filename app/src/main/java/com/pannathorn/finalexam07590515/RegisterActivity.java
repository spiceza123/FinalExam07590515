package com.pannathorn.finalexam07590515;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pannathorn.finalexam07590515.Database.LedgerItem;
import com.pannathorn.finalexam07590515.Database.LedgerRepository;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button rg = findViewById(R.id.register_button);
        rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText FNameEdittext = findViewById(R.id.full_name_edit_text);
                String FName =FNameEdittext.getText().toString();

                EditText UNameEdittext = findViewById(R.id.username_edit_text);
                String UName = UNameEdittext.getText().toString();

                EditText PWEdittext = findViewById(R.id.password_edit_text);
                String PW = PWEdittext.getText().toString();

                            if(FName.isEmpty() || UName.isEmpty() || PW.isEmpty()){
                                No();
                            }else{
                                LedgerItem item = new LedgerItem(0,FName,UName,PW);
                                insertLedger(item);
                            }


            }
        });
    }

    private void insertLedger(LedgerItem item) {
        LedgerRepository repo = new LedgerRepository(RegisterActivity.this);
        Toast t = Toast.makeText(this,"Register successfully",Toast.LENGTH_LONG);
        t.show();
        repo.insertLedger(item, new LedgerRepository.InsertCallback() {
            @Override
            public void onInsertSuccess() {
                finish();
            }

        });
    }

    private void No(){
        Toast t = Toast.makeText(this,"All fields are required",Toast.LENGTH_LONG);
        t.show();
    }
}
