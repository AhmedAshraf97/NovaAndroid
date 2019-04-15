package com.example.narim.nova;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        TabLayout ProfilePage_TabLayout = findViewById(R.id.TabLayout_Profile);
        ViewPager ProfilePage_ViewPage = findViewById(R.id.ViewPager_Profile);

        ProfilePage_Adapter adapter = new ProfilePage_Adapter(getSupportFragmentManager());

        adapter.AddFragment("one", new profile_page_tweets());
        adapter.AddFragment("two", new profile_page_retweets());
        adapter.AddFragment("three", new profile_page_likes());
        adapter.AddFragment("four", new profile_page_media());

        ProfilePage_TabLayout.setupWithViewPager(ProfilePage_ViewPage);
        ProfilePage_ViewPage.setAdapter(adapter);
        ProfilePage_TabLayout.getTabAt(0).setCustomView(R.layout.tablayout_profile_page_tweets);
        ProfilePage_TabLayout.getTabAt(1).setCustomView(R.layout.tablayout_profile_page_retweets);
        ProfilePage_TabLayout.getTabAt(2).setCustomView(R.layout.tablayout_profile_page_likes);
        ProfilePage_TabLayout.getTabAt(3).setCustomView(R.layout.tablayout_profile_page_media);

        Button EditProfile = findViewById(R.id.Button_Profile_EditProfile);
        Button Following = findViewById(R.id.Button_Profile_Following);
        Button Followers = findViewById(R.id.Button_Profile_Followers);

        EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this,EditProfile.class);
                startActivity(intent);
                finish();
            }
        });

        Followers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this,Followers.class);
                startActivity(intent);
                finish();
            }
        });

        Following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this,Following.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
