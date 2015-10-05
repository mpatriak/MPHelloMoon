package com.example.michal.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Michal on 10/3/2015.
 */
public class HelloMoonFragment extends Fragment
{
    private AudioPlayer mPlayer = new AudioPlayer();
    private Button mPlayButton;
    private Button mStopButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Fragment property set to preserve the instance of a fragment upon device rotation.
        setRetainInstance(true);
    }

    // Override onCreateView() to inflate the layout and get references to the buttons.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener()
        {
           public void onClick(View v)
           {
               mPlayer.play(getActivity());
           }
        });

        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener()
        {
           public void onClick(View v)
           {
               mPlayer.stop();
           }
        });

        return v;
    }

    // Prevents the MediaPlayer from continuing playback after the fragment has been destroyed.
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mPlayer.stop();
    }
} // End class HelloMoonFragment
