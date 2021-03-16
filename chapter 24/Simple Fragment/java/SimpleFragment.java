package com.gamecodeschool.simplefragment;


import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class SimpleFragment extends Fragment {

    // member variables accessible from anywhere in this fragment
    String myString;
    Button myButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        myString = "Hello from SimpleFragment";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout,
                container, false);

        myButton = view.findViewById(R.id.button);

        myButton.setOnClickListener(
            new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Toast.makeText(getActivity(),
                            myString ,
                            Toast.LENGTH_SHORT).
                            show();
                }
            });



        return view;
    }

}
