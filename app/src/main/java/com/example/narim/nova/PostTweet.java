package com.example.narim.nova;


import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.RelativeLayout.TRUE;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostTweet extends DialogFragment {
View view;
Context context;
Button tweet;
TextView cancel;
EditText tweettext;

    public PostTweet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.posttweet, container, false);
        tweet=view.findViewById(R.id.textview_posttweet_tweet);
        tweettext=view.findViewById(R.id.EditText_Posttweet);
        cancel=view.findViewById(R.id.textview_posttweet_cancel);
        context=getActivity();
        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tweettext.getText().toString().isEmpty())
                    Toast.makeText(context,"Your tweet is empty!", Toast.LENGTH_LONG).show();
                else
                    dismiss();


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }

    public static PostTweet newInstance(String title) {
        PostTweet frag = new PostTweet();
        return frag;
    }


}
