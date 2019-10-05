package com.example.a123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView An_1, An_2, An_3, result, qu;
    ArrayList<String> listQu = new ArrayList<>();
    ArrayList<String> listAn = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    int an, rn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qu = (TextView) findViewById(R.id.textView2);
        result = (TextView) findViewById(R.id.textView);
        An_1 = (TextView) findViewById(R.id.textView3);
        An_2 = (TextView) findViewById(R.id.textView4);
        An_3 = (TextView) findViewById(R.id.textView5);

        try {
            InputStream inputStream = getAssets().open("qu.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine())!=null ) ;
            {
                listQu.add(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            InputStream inputStream = getAssets().open("result.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) ;
            {
                listAn.add(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
            arrayList.add("");
            showTxT();
        }


    }

    private void showTxT() {
        if (arrayList.size() < listQu.size()) {
            Random r1 = new Random();
            int Run_qu = r1.nextInt(listQu.size());
            String qus = listQu.get(Run_qu);
            Boolean a = true;
            for (int i = 0; i < listQu.size(); i++) {
                if (qus.equals(listQu.get(i))) {
                    showTxT();
                    a = false;
                    listQu.add(listQu.get(Run_qu));
                    break;
                }
            }

            if (a) {
                qu.setText(qus);
                String[] Aan = listAn.get(Run_qu).split(",");
                An_1.setText(Aan[0]);
                An_2.setText(Aan[1]);
                An_3.setText(Aan[2]);
                an = Integer.parseInt(Aan[3]);
                arrayList.add(listQu.get(Run_qu));

            } else {
                Toast.makeText(this, "انتهت الاسئله", Toast.LENGTH_SHORT);
                qu.setText("");
                An_1.setText("");
                An_2.setText("");
                An_3.setText("");
            }

        }
    }

    public void txt1(View view) {
        if (an == 1) {
            Toast.makeText(this, "good", Toast.LENGTH_SHORT).show();
            rn++;
            result.setText("الاجابات الصحيحه:  " + rn);
            showTxT();
        } else
            Toast.makeText(this, "bad", Toast.LENGTH_SHORT).show();
        rn--;
    }

    public void txt2(View view) {
        if (an == 2) {
            Toast.makeText(this, "good", Toast.LENGTH_SHORT).show();
            rn++;
            result.setText("الاجابات الصحيحه:  " + rn);
            showTxT();
        } else
            Toast.makeText(this, "bad", Toast.LENGTH_SHORT).show();
        rn--;
    }

    public void txt3(View view) {
        if (an == 3) {
            Toast.makeText(this, "good", Toast.LENGTH_SHORT).show();
            rn++;
            result.setText("الاجابات الصحيحه:  " + rn);
            showTxT();
        } else
            Toast.makeText(this, "bad", Toast.LENGTH_SHORT).show();
        rn--;
    }


}

