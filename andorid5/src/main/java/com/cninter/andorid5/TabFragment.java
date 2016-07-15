package com.cninter.andorid5;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ${jacksen-hss} on 2016/7/15 0015.
 */
public class TabFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acitivity_table_layout_fragment,null);
        Bundle bundle = getArguments();
        String values = bundle.getString("CONTENT");
        TextView textView = (TextView) view.findViewById(R.id.tab_lay_textview);
        textView.setText(values);


        return view;
    }
}
