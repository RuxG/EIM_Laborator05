package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 9 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 7 - get the action and the extra information from the intent
        // and set the text on the messageTextView
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

        // TODO: exercise 9 - restart the activity through an intent
        // if the messageTextView is not available
    }
}
