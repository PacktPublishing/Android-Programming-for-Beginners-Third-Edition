package com.gamecodeschool.agedatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_search,container,false);

        Button btnSearch = v.findViewById(R.id.btnSearch);
        final EditText editSearch = v.findViewById(R.id.editSearch);
        final TextView textResult = v.findViewById(R.id.textResult);

        // This is our DataManager instance
        final DataManager dm = new DataManager(getActivity());

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor c = dm.searchName(editSearch.getText().toString());

                // Make sure a result was found before using the Cursor
                if(c.getCount() > 0) {
                    c.moveToNext();
                    textResult.setText("Result = " + c.getString(1) + " - " + c.getString(2));
                }

            }
        });

        return v;
    }



}
