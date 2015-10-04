package com.example.chandanmattikalli.rakshak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);

        //Bundle bundle = getIntent().getExtras();

        TextView Victim = (TextView) findViewById(R.id.victimTextView);
        Victim.setText("Victim: Sachin ");

        TextView Type = (TextView) findViewById(R.id.typeTextView);
        Type.setText("Type: Vehicle Robbery");

        TextView Desctiption = (TextView) findViewById(R.id.descriptionTextView);
        Desctiption.setText("Vehicle Type: Two Wheeler \n" +"Color: Black \n" + "Vehicle number: KA-25 EP-3476");

        final ImageButton mapButton = (ImageButton) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent;
                intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

    }

}
