package com.kelompok16.tugasppbkelompok16;

public class Absen {

    private String id;
    private String nim;
    private String nama;
    private String tanggal;
    private String jam;
    private String status;

    public Absen(String id, String nim, String nama, String tanggal, String jam, String status) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.tanggal = tanggal;
        this.jam = jam;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
