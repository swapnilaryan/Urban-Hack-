package com.example.chandanmattikalli.rakshak;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class AppWidget extends AppWidgetProvider {
    private static final String MyOnClick1 = "myOnClickTag1";

   // public static String WIDGET_BUTTON = "com.example.chandanmattikalli.rakshak.WIDGET_BUTTON";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them


        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            //updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.app_widget);

           // remoteViews.setOnClickPendingIntent(R.id.widgetButton, getPendingSelfIntent(context, MyOnClick1));


            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);


        }

    }
    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        // super.onReceive(context, intent);
        if (MyOnClick1.equals(intent.getAction())) {
            Toast.makeText(context, "Button1", Toast.LENGTH_SHORT).show();
            Log.w("Widget", "Clicked button1");

        }
    }
    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


       // Log.d("widget","clicked");
       // CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        //RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.app_widget);
        //views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
       // appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}

