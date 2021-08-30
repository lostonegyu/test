package com.example.capstone_design;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrScanner extends AppCompatActivity {
    Button btnScan, btnPrint;
    TextView tvTest;
    ImageView ivTest;
    static String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTest = (TextView)findViewById(R.id.textview_test);
        ivTest = (ImageView)findViewById(R.id.imageview_test);
        btnScan = (Button)findViewById(R.id.button_scan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(QrScanner.this).initiateScan();
            }
        });
        btnPrint = (Button)findViewById(R.id.button_print);
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTest.setText(string);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = null;

                try {
                    // 지정한 번호,포맷,사이즈로 바코드 만들기
                    bitmap = barcodeEncoder.encodeBitmap(string, BarcodeFormat.UPC_A,200,20);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                ivTest.setImageBitmap(bitmap);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == IntentIntegrator.REQUEST_CODE){
                IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                if (result != null) {
                    if (result.getContents() != null) {
                        Toast.makeText(this, "Scanned: " + result.getContents() + "\nFormat:" + result.getFormatName(), Toast.LENGTH_LONG).show();
                        string = result.getContents();

                    }
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}