package com.example.pranay.navigation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.pranay.navigation.CustomAdapter;
import java.util.ArrayList;

/**
 * Created by Pranay on 3/25/2018.
 */

public class SecondFragment extends Fragment {
    View myView;

    CustomAdapter adapter;
    GridView gv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout,container,false);

        gv= (GridView) myView.findViewById(R.id.gv);
        adapter=new CustomAdapter(getContext(),getData());
        gv.setAdapter(adapter);


        return myView;
    }

    private ArrayList getData()
    {
        ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

        Spacecraft s=new Spacecraft();
        s.setImage(R.drawable.automobile);
        spacecrafts.add(s);

        s=new Spacecraft();
        s.setImage(R.drawable.business);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.entertainment);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.fashion);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.hatke);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.india);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.international);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.miscelleneous);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.politics);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.science);
        spacecrafts.add(s);

        s=new Spacecraft();
        s.setImage(R.drawable.sports);
        spacecrafts.add(s);

        s=new Spacecraft();
        s.setImage(R.drawable.startups);
        spacecrafts.add(s);

        s=new Spacecraft();
        s.setImage(R.drawable.technology);
        spacecrafts.add(s);


        s=new Spacecraft();
        s.setImage(R.drawable.travel);
        spacecrafts.add(s);


        return spacecrafts;
    }




}
