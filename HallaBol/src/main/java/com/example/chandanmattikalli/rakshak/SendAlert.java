package com.example.chandanmattikalli.rakshak;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SendAlert extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_alert);

        Spinner dropdown = (Spinner)findViewById(R.id.typeSpinner);
        String[] items = new String[]{"Vehicle Robbery", "Snatching", "Assault"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        final Button sendAlertButton = (Button) findViewById(R.id.sendButton);
        sendAlertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SendAlert.this);
                builder.setMessage("Send Alert?")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                Toast.makeText(SendAlert.this, "Alert Sent", Toast.LENGTH_SHORT).show();
                                Intent intent;
                                intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        //do things
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

}
