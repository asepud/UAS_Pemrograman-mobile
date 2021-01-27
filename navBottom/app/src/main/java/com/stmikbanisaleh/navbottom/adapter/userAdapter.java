package com.stmikbanisaleh.navbottom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stmikbanisaleh.navbottom.R;
import com.stmikbanisaleh.navbottom.model.buku_m;
import com.stmikbanisaleh.navbottom.model.user.user_m;
import com.stmikbanisaleh.navbottom.ui.buku.SettingFragment;
import com.stmikbanisaleh.navbottom.ui.profile.ProfileFragment;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder> {
    private ProfileFragment contex;
    private List<user_m> list = new ArrayList<>();
    private View.OnClickListener listener;
    private EditText editjudul, editpenulis, editjenis, edittahun;
    private String judul, penulis, jenis, tahun;

    public userAdapter(ProfileFragment contex, List<user_m> list) {
        this.contex = contex;
        this.list = list;
    }

    public userAdapter(ProfileFragment profil, List<user_m> list, ProfileFragment profil1) {
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        view.setOnClickListener(listener);
       userAdapter.userViewHolder holder = new userAdapter.userViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        user_m user = list.get(position);
        holder.Npm.setText(user.getNpm());
        holder.Nama.setText(user.getNama());
        holder.Kelas.setText(user.getKelas());
        holder.jurusan.setText(user.getJurusan());
        holder.email.setText(user.getEmail());
        holder.telp.setText(user.getTelp());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class userViewHolder extends RecyclerView.ViewHolder {
        TextView Npm, Nama, Kelas, jurusan, email, telp ;
        public userViewHolder(@NonNull View view) {
            super(view);
            Npm = view.findViewById(R.id.tv_npm);
            Nama = view.findViewById(R.id.tv_nama);
            Kelas = view.findViewById(R.id.tv_kelas);
            jurusan = view.findViewById(R.id.tv_jurusan);

        }
    }
}
