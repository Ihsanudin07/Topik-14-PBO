/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KelasPojo;

/**
 *
 * @author asus
 */
public class Buku {
    private String id_buku, judul, nama_pengarang, nama_penerbit;
    private int stok;

    public Buku(String id_buku, String judul, String nama_pengarang, String nama_penerbit, int stok) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.nama_pengarang = nama_pengarang;
        this.nama_penerbit = nama_penerbit;
        this.stok = stok;
    }

    public String getId_buku() {
        return id_buku;
    }

    public String getJudul() {
        return judul;
    }

    public String getNama_pengarang() {
        return nama_pengarang;
    }

    
    public String getNama_penerbit() {
        return nama_penerbit;
    }

    public int getStok() {
        return stok;
    }
    
    
}
