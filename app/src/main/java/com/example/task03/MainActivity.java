package com.example.task03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.FragmentAListener , SecondFragment.FragmentBListener{
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.F_Fragment_Layout, firstFragment)
                .replace(R.id.S_Fragment_Layout, secondFragment)
                .commit();
    }

    @Override
    public void onInputFFSent(CharSequence input) {
        secondFragment.updateEditText(input);
    }

    @Override
    public void onInputSFSent(CharSequence input) {
        firstFragment.updateEditText(input);
    }
}