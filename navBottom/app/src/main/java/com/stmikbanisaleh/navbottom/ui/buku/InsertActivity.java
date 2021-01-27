package com.stmikbanisaleh.navbottom.ui.buku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stmikbanisaleh.navbottom.R;
import com.stmikbanisaleh.navbottom.adapter.bukuAdapter;
import com.stmikbanisaleh.navbottom.api.retrofitClient;
import com.stmikbanisaleh.navbottom.model.buku_m;
import com.stmikbanisaleh.navbottom.model.responseModel;
import com.stmikbanisaleh.navbottom.model.responseModelsingle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    private Button buttonsimpan, buttoncancel, buttondelete;
    private EditText editjudul, editpenulis, editjenis, edittahun;
    private String judul, penulis, jenis, tahun;
    com.stmikbanisaleh.navbottom.api.api api;
    private bukuAdapter adapter = null;
    private buku_m buku;
//    private retrofitClient retro;
    private AlertDialog dialog = null;
    private final InsertActivity activity = this;
    private boolean isNew = false;
    private int id;

    private String TAG = "InsertActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        id = getIntent().getIntExtra("ID", 0);
        Log.d(TAG, "onCreate: id buku "+id);
        if(id == 0){
            isNew = true;
        }


        editjudul = (EditText) findViewById(R.id.editjudulinsert);
        editpenulis = (EditText) findViewById(R.id.editpenulisinsert);
        editjenis = (EditText) findViewById(R.id.editjenisinsert);
        edittahun = (EditText) findViewById(R.id.edittahuninsert);


        buttonsimpan = (Button) findViewById(R.id.buttonsimpan);
        buttoncancel = (Button) findViewById(R.id.buttoncancel);
        buku = new buku_m();

        api = retrofitClient.getInstance().getApi();

        buttonsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editjudul.getText().toString().trim().equals("")) {
                    editjudul.setError("judul harus diisi");
                } else if (editpenulis.getText().toString().trim().equals("")) {
                    editpenulis.setError("Penulis harus diisi");
                } else {
                    prosesSave();
                }

            }
        });

        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

    private Callback<responseModel> callback = new Callback<responseModel>() {
        @Override
        public void onResponse(Call<responseModel> call, Response<responseModel> response) {
            if(response.isSuccessful()){
                if(response.body().isStatus()){
                    Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(activity, "response failde", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<responseModel> call, Throwable t) {
            Toast.makeText(activity, "Data failed", Toast.LENGTH_SHORT).show();
        }
    };

    private void prosesSave() {
        buku.setJudul(editjudul.getText().toString());
        buku.setPenulis(editpenulis.getText().toString());
        buku.setJenis(editjenis.getText().toString());
        buku.setTahun(edittahun.getText().toString());
        try {
            if (isNew) {
                Log.d(TAG, "prosesSave: ini true save buku");

                Call<responseModelsingle> postbuku = api.post(buku);
                postbuku.enqueue(new Callback<responseModelsingle>() {
                    @Override
                    public void onResponse(Call<responseModelsingle> call, Response<responseModelsingle> response) {
                        Log.d(TAG, "onResponse: ini success");
                        if(response.isSuccessful()){
                            if(response.body().isStatus()){
                                Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(activity, "response failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<responseModelsingle> call, Throwable t) {
                        Log.d(TAG, "onFailure: ini faidel");
                        Toast.makeText(activity, "Data failed", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
            } else {
//                api.put(buku.getId(), buku).enqueue(callback);
            }

        } catch (Exception ex) {
            Toast.makeText(activity, "Data failed", Toast.LENGTH_SHORT).show();
        }

    }


}