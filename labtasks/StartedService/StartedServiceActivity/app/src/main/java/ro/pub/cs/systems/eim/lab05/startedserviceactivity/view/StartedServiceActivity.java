package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.R;
import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceActivity extends AppCompatActivity {

    private TextView messageTextView;
    private StartedServiceBroadcastReceiver startedServiceBroadcastReceiver;
    private IntentFilter startedServiceIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_service);

        messageTextView = (TextView)findViewById(R.id.message_text_view);

        // TODO: exercise 6 - start the service
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("ro.pub.cs.systems.eim.lab05.startedservice",
                                "ro.pub.cs.systems.eim.lab05.startedservice.service.StartedService");
        intent.setComponent(componentName);
        startService(intent);

        // TODO: exercise 8a - create an instance of the StartedServiceBroadcastReceiver broadcast receiver
        startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver(messageTextView);

        // TODO: exercise 8b - crea te an instance of an IntentFilter
        // with all available actions contained within the broadcast intents sent by the service
        startedServiceIntentFilter = new IntentFilter();
        startedServiceIntentFilter.addAction(Constants.ACTION_ARRAY_LIST);
        startedServiceIntentFilter.addAction(Constants.ACTION_INTEGER);
        startedServiceIntentFilter.addAction(Constants.ACTION_STRING);


    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO: exercise 8c - register the broadcast receiver with the corresponding intent filter
        registerReceiver(startedServiceBroadcastReceiver, startedServiceIntentFilter);
    }

    @Override
    protected void onPause() {
        // TODO: exercise 8c - unregister the broadcast receiver
        super.onPause();
        unregisterReceiver(startedServiceBroadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        // TODO: exercise 8d - stop the service
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("ro.pub.cs.systems.eim.lab05.startedservice",
                "ro.pub.cs.systems.eim.lab05.startedservice.service.StartedService");
        intent.setComponent(componentName);
        stopService(intent);
        super.onDestroy();
    }

    // TODO: exercise 9 - implement the onNewIntent callback method
    // get the message from the extra field of the intent
    // and display it in the messageTextView
   /* @Override
    protected void onNewIntent(Intent intent) {
        String action = intent.getAction();
        if (action.compareTo("ro.pub.cs.systems.eim.lab05.startedservice.string") == 0) {
            String extra = intent.getStringExtra("ro.pub.cs.systems.eim.lab05.startedservice.data");
            messageTextView.setText(messageTextView.getText().toString() + "\n" + extra);
        } else if (action.compareTo("ro.pub.cs.systems.eim.lab05.startedservice.integer") == 0) {
            int extra = intent.getIntExtra("ro.pub.cs.systems.eim.lab05.startedservice.data", 0);
            messageTextView.setText(messageTextView.getText().toString() + "\n" + Integer.toString(extra));
        } else if (action.compareTo("ro.pub.cs.systems.eim.lab05.startedservice.arraylist") == 0) {
            ArrayList<String> data = intent.getStringArrayListExtra("ro.pub.cs.systems.eim.lab05.startedservice.data");
            messageTextView.setText(messageTextView.getText().toString() + "\n" + data.toString());
        }
    }*/


}
