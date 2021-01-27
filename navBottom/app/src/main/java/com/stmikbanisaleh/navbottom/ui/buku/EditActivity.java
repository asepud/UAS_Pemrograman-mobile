package com.stmikbanisaleh.navbottom.ui.buku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stmikbanisaleh.navbottom.R;
import com.stmikbanisaleh.navbottom.api.api;
import com.stmikbanisaleh.navbottom.api.retrofitClient;
import com.stmikbanisaleh.navbottom.model.buku_m;
import com.stmikbanisaleh.navbottom.model.responseModel;
import com.stmikbanisaleh.navbottom.model.responseModelsingle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    int id;
    String judul, jenis, penulis, tahun;
    EditText editjudul, editpenulis, editjenis, edittahun;
    Button buttonsave, buttoncancel, buttondelete;
    private buku_m buku;
    private com.stmikbanisaleh.navbottom.api.api api;
    private final EditActivity activity = this;
    private boolean isNew = false;
    private String TAG = "InsertActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        id = getIntent().getIntExtra("id", 0);

        judul = getIntent().getStringExtra("judul");
        jenis = getIntent().getStringExtra("jenis");
        penulis = getIntent().getStringExtra("penulis");
        tahun = getIntent().getStringExtra("tahun");

        editjudul = findViewById(R.id.editjudul);
        editjudul.setText(judul);
        editpenulis = findViewById(R.id.editpenulis);
        editpenulis.setText(penulis);
        editjenis = findViewById(R.id.editjenis);
        editjenis.setText(jenis);
        edittahun = findViewById(R.id.edittahun);
        edittahun.setText(tahun);

        buttonsave = findViewById(R.id.btnsave);
        buttoncancel = findViewById(R.id.btncancel);
        buttondelete = findViewById(R.id.btndelete);
        buku = new buku_m();
        api = retrofitClient.getInstance().getApi();

        buttonsave.setOnClickListener(new View.OnClickListener() {
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

        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDelete();
            }
        });

    }

    private Callback<responseModelsingle> callback = new Callback<responseModelsingle>() {
        @Override
        public void onResponse(Call<responseModelsingle> call, Response<responseModelsingle> response) {
            if(response.isSuccessful()){
                if(response.body().isStatus()){
                    Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(activity, "response data failde", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<responseModelsingle> call, Throwable t) {
            Toast.makeText(activity, "Data failed", Toast.LENGTH_SHORT).show();
        }
    };
    private void prosesSave() {
        buku.setJudul(editjudul.getText().toString());
        buku.setPenulis(editpenulis.getText().toString());
        buku.setJenis(editjenis.getText().toString());
        buku.setTahun(edittahun.getText().toString());

        try {
            if(!isNew){
                Call<responseModelsingle> putbuku = api.put(buku.getId(), buku);
                putbuku.enqueue(new Callback<responseModelsingle>() {
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
                            Toast.makeText(activity, "response gagal", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<responseModelsingle> call, Throwable t) {
                        Log.d(TAG, "onFailure: ini faidel");
                        Toast.makeText(activity, "Data failed", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
            }else {
                Toast.makeText(activity, "response failed", Toast.LENGTH_SHORT).show();
            }
//            adapter.notifyDataSetChanged();
//            dialog.dismiss();
//            Toast.makeText(this, "Data dosen berhasil disimpan", Toast.LENGTH_SHORT).show();

        }catch (Exception ex){
            Toast.makeText(this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
        }
    }

    private void processDelete(){
        try {
            Log.d(TAG, "onResponse: ini success");
            api.delete(buku.getId()).enqueue(new Callback<responseModelsingle>() {
                @Override
                public void onResponse(Call<responseModelsingle> call, Response<responseModelsingle> response) {
                    Toast.makeText(activity , "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                    finish();

                }

                @Override
                public void onFailure(Call<responseModelsingle> call, Throwable t) {

                }
            });
        }catch (Exception ex){
            Toast.makeText(this, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
        }
    }


}