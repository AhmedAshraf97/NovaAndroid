package com.example.narim.nova;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    ImageView Home;
    ImageView Search;
    ImageView Profile;
    ImageView Notifications;
    ImageView PostTweet;
    RecyclerView TweetRecView;
    List<Tweets> tweets= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Home= findViewById(R.id.Icon_Home_Home);
        Search= findViewById(R.id.Icon_Home_Search);
        Profile=findViewById(R.id.Icon_Home_Profile);
        Notifications= findViewById(R.id.Icon_Home_Notifs);
        PostTweet= findViewById(R.id.Icon_Home_PostTweet);
        TweetRecView=findViewById(R.id.RecyclerView_Home_Tweets);
        String Name[]={"Dina Walid","Menna Walid", "Arwa Walid","Ziad Walid"};
        String ScreenName[]={"dinawalid","mennawalid","arwawalid","ziadwalid"};
        String TweetText[]={"Hi, I'm dina","Hi, I'm menna","Hi, I'm arwa","Hi, I'm ziad"};
        String RetweetNumber[]={"1","2","3","4"};
        String RepliesNumber[]={"1","2","3","4"};
        String LikesNumber[]={"1","2","3","4"};
        for(int i=0; i<Name.length; i++)
        {
            Tweets tweet =new Tweets(Name[i],ScreenName[i],TweetText[i],RetweetNumber[i],RepliesNumber[i],LikesNumber[i]);
            tweets.add(tweet);
        }
        TweetRecView.setLayoutManager(new LinearLayoutManager(HomePage.this));
        TweetsAdapter tweetsAdapter=new TweetsAdapter(tweets);
        TweetRecView.setAdapter(tweetsAdapter);

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,ProfilePage.class);
                startActivity(intent);
                finish();

            }
        });
        Notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,NotificationsPage.class);
                startActivity(intent);
                finish();
            }
        });
        PostTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostTweet alertDialog= new PostTweet();
                FragmentManager f=getSupportFragmentManager();
                alertDialog.show(f, "fragment_alert");
            }
        });

    }
}
