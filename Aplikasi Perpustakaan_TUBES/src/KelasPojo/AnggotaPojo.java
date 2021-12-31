/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KelasPojo;

/**
 *
 * @author asus
 */
public class AnggotaPojo {
    private String id_anggota, nama, kelas, Jenis_Kelamin, Alamat, ttl;

    public AnggotaPojo(String id_anggota, String nama, String kelas, String Jenis_Kelamin, String Alamat, String ttl) {
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.kelas = kelas;
        this.Jenis_Kelamin = Jenis_Kelamin;
        this.Alamat = Alamat;
        this.ttl = ttl;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getJenis_Kelamin() {
        return Jenis_Kelamin;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getTtl() {
        return ttl;
    }
    
    
    
}
