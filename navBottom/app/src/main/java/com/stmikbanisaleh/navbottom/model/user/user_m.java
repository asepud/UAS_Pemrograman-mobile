package com.stmikbanisaleh.navbottom.model.user;

public class user_m {
    private int id;
    private String npm;
    private String nama;
    private String kelas;
    private String jurusan;
    private String email;
    private String telp;

    public user_m() {

    }

    public user_m(int id, String npm, String nama, String kelas, String jurusan, String email, String telp) {
        this.id = id;
        this.npm = npm;
        this.nama = nama;
        this.kelas = kelas;
        this.jurusan = jurusan;
        this.email = email;
        this.telp = telp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
}
