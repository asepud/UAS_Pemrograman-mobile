package com.stmikbanisaleh.navbottom.ui.notifications;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stmikbanisaleh.navbottom.R;

public class NotificationsFragment extends Fragment {
    ListView Is;
    private ImageButton button;
    Context context;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

//        button = view.findViewById(R.id.buttonAdd);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(v.getContext(), AddActivity.class));
//            }
//        });


        return view;

    }

}
