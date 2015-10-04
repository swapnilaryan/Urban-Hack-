package com.example.chandanmattikalli.rakshak;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private NotificationManager mManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        final Button sendAlertButton = (Button) findViewById(R.id.sendAlertButton);
        sendAlertButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent;
                intent = new Intent(getApplicationContext(), SendAlert.class);
                startActivity(intent);
            }
        });

        final Button receiveAlertButton = (Button) findViewById(R.id.receiveAlertButton);
        receiveAlertButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent;
                intent = new Intent(getApplicationContext(), ListAlerts.class);
                startActivity(intent);
            }
        });



        mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(),MainActivity.class);
        Notification notification = new Notification(R.mipmap.ic_launcher,"Hey", System.currentTimeMillis());
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this.getApplicationContext(),0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.setLatestEventInfo(this.getApplicationContext(), "Type: Vehicle Robbery","Location: BTM, Bangalore", pendingNotificationIntent);
        mManager.notify(0, notification);






        return true;
    }
}
