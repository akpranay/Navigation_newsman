package com.example.pranay.navigation;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pranay on 3/25/2018.
 */

public class ThirdFragment extends Fragment {

    TextView tv_a;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.third_layout,container,false);
        tv_a=(TextView)myView.findViewById(R.id.tv_ab);
        tv_a.setText("Hello this is group 16(M) we had developed an app for news.\n This app will give you the most unbiased news");
        return myView;
    }
}
