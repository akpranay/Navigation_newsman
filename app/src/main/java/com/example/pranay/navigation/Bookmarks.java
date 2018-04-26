package com.example.pranay.navigation;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bookmarks extends Fragment {

    TextView tv_b;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.bookmark,container,false);
        tv_b=(TextView)myView.findViewById(R.id.tv_b);
        tv_b.setText("bookmarks tab");
        return myView;
    }
}
