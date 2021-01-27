package com.stmikbanisaleh.navbottom.ui.buku;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.stmikbanisaleh.navbottom.R;
import com.stmikbanisaleh.navbottom.adapter.bukuAdapter;
import com.stmikbanisaleh.navbottom.api.retrofitClient;
import com.stmikbanisaleh.navbottom.model.buku_m;
import com.stmikbanisaleh.navbottom.model.responseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SettingFragment extends Fragment {
    private RecyclerView recyclerView = null;
    private List<buku_m> list= null;
    private bukuAdapter adapter = null;
    private buku_m buku = null;
    private com.stmikbanisaleh.navbottom.api.api api;
    private boolean isNew = false;
    private int position = -1;
    public static SettingFragment setting;
    private AlertDialog dialog = null;
    private ImageButton button;
    private View viewDialog;
    private Button buttonsave, buttoncancel, buttondelete;
    private EditText editjudul, editpenulis, editjenis, edittahun;
    private String judul, penulis, jenis, tahun;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        api = retrofitClient.getInstance().getApi();
        loadData();

        button = view.findViewById(R.id.buttonAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InsertActivity.class);
                intent.putExtra("ID", 0);

                startActivity(intent);
            }
        });

        return view;

    }

    public void loadData() {
        Call<responseModel> getbuku = api.getlist();
        getbuku.enqueue(new Callback<responseModel>() {
            @Override
            public void onResponse(Call<responseModel> call, Response<responseModel> response) {
                List<buku_m> list = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data buku: " +
                        String.valueOf(list.size()));
                adapter = new bukuAdapter(setting,list,setting);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<responseModel> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

}
