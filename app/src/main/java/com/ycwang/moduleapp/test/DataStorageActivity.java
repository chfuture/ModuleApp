package com.ycwang.moduleapp.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ycwang.moduleapp.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ycwang.
 * @date 2018-9-21.
 */
public class DataStorageActivity extends Activity {


    EditText edx;

    Button save_data;
    Button get_data_sh;
    TextView data_sh;

    public static void launch(Context context) {
        Intent intent = new Intent(context, DataStorageActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        edx = findViewById(R.id.edx);
        save_data = findViewById(R.id.save_data);
        data_sh = findViewById(R.id.data_sh);
        get_data_sh = findViewById(R.id.get_data_sh);
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataInter();
            }
        });

        get_data_sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_sh.setText(getDataInter());
            }
        });
    }

    public String getData() {
        return edx.getText().toString();
    }

    public void saveDataSh() {
        SharedPreferences sharedPreferences = getSharedPreferences("sh_name", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key", getData());
        editor.apply();
    }

    public String getDataSh() {
        SharedPreferences sharedPreferences = getSharedPreferences("sh_name", MODE_PRIVATE);
        return sharedPreferences.getString("key", "");
    }


    public void saveDataInter() {
        try {
            FileOutputStream fileOutputStream = openFileOutput("inter_name", MODE_PRIVATE);
            fileOutputStream.write(getData().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDataInter() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("inter_name");
            InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader br = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            reader.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
