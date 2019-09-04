package com.example.saavanclone;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.example.saavanclone.adapters.HomeRecyclerViewAdapter;
import com.example.saavanclone.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.saavanclone.App.CHANNEL_HIGH;

public class MainActivity extends AppCompatActivity implements HomeRecyclerViewAdapter.IListener {
private NotificationManagerCompat notificationManagerCompat ;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    startFragment(homeFragment);
                    Toast.makeText(getApplicationContext(),"home", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_dashboard:
                    Toast.makeText(getApplicationContext(),"dashboard", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_notifications:
                    Toast.makeText(getApplicationContext(),"notification", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };
     public void startFragment(Fragment fragment){
         getSupportFragmentManager()
                 .beginTransaction()
                 .replace(R.id.default_frame,fragment)
                 .commit();
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        HomeFragment homeFragment = new HomeFragment();
        startFragment(homeFragment);
        notificationManagerCompat= NotificationManagerCompat.from(this);
    }

    @Override
    public void onClick(View view ) {
        Snackbar.make(view, "You have clicked no the screen", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
//     public void sendNotificationChannelHigh(){
//         Intent intent = new Intent();
//         PendingIntent pendingIntent =new PendingIntent();
//         Notification notification = new NotificationCompat.Builder(this,CHANNEL_HIGH)
//                 .setSmallIcon(R.drawable.service_icon)
//                 .setContentTitle("hi notification in channel 1")
//                 .setContentText("hello guys")
//                 .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                 .setContentIntent(new )
//                 .build();
//     }
}
