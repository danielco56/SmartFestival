package com.example.daniel.smartfestival;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.w3c.dom.Text;

import static android.R.attr.data;

public class FirstPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        TextView clickAici = (TextView) findViewById(R.id.click);
        TextView festivale = (TextView) findViewById(R.id.Festivale);
        TextView balanta = (TextView) findViewById(R.id.Balanta);


        festivale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent festivale = new Intent(FirstPage.this, Festivals.class);
                startActivity(festivale);
            }
        });

        balanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent balanta = new Intent(FirstPage.this, Balance.class);
                startActivity(balanta);
            }
        });

        final Activity activity = this;

        clickAici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();


            }
        });
    }
    @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null){
                if(result.getContents()==null){
                    Toast.makeText(this,"Ai anulat scanarea", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();
                }
            }
            else {
                super.onActivityResult(requestCode , resultCode, data);
            }
        }

    }

