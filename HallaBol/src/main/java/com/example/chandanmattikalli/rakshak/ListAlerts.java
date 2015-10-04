package com.example.chandanmattikalli.rakshak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAlerts extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_list_alerts);
        final ListView listView = (ListView) findViewById(R.id.background);
        ArrayList str = new ArrayList();
        str.add("Victim: Sachin\n"+"Type: Vehicle Robbery \n" +"Location: BTM, Bangalore" );
        str.add("Victim: Smithi\n"+"Type: Assault \n" +"Location: BEML layout, basaveswara nagar, Bangalore" );
        str.add("Victim: Soumya\n"+"Type: Snatching \n" +"Location: Devappa garden, Nagahashettihalli, Sanjay nagar, Bangalore" );


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, str);

        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
                String str = Integer.toString(position + 1);
                Object o = listView.getItemAtPosition(position);
                String strName = (String) o;
                Intent inte = new Intent();
                inte.setClass(getApplicationContext(), DetailsPage.class);
                Bundle b = new Bundle();
                b.putString("name", strName);
                b.putString("row", str);
                inte.putExtras(b);
                startActivity(inte);
            }
        });
    }
}
