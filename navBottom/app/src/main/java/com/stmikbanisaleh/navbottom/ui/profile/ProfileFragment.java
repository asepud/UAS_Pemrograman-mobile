package com.stmikbanisaleh.navbottom.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.stmikbanisaleh.navbottom.R;
import com.stmikbanisaleh.navbottom.adapter.bukuAdapter;
import com.stmikbanisaleh.navbottom.adapter.userAdapter;
import com.stmikbanisaleh.navbottom.api.retrofitClient;
import com.stmikbanisaleh.navbottom.model.buku_m;
import com.stmikbanisaleh.navbottom.model.responseModel;
import com.stmikbanisaleh.navbottom.model.user.responseUser;
import com.stmikbanisaleh.navbottom.model.user.user_m;
import com.stmikbanisaleh.navbottom.ui.buku.InsertActivity;
import com.stmikbanisaleh.navbottom.ui.buku.SettingFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        return view;
    }


}
