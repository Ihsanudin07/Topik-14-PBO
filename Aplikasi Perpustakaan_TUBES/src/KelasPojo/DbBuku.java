/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KelasPojo;

/**
 *
 * @author asus
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import perpustakaan.Koneksi;

public class DbBuku {
    private Connection conn;
    private final Koneksi k = new Koneksi();
    
    //SELECT
    public ArrayList<Buku> getBuku() throws SQLException{
        ArrayList<Buku> daftar = new ArrayList<>();      
        
        //langkah 1
        conn = k.panggilKoneksi();
        
        //langkah 2
        String sql = "SELECT * FROM buku";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        //langkah 3
        ResultSet rs = ps.executeQuery();
        
        //langkah 4
        while(rs.next()){
            String id = rs.getString("id_buku");
            String judul = rs.getString("judul");
            String namaPengarang = rs.getString("nama_pengarang");
            String namaPenerbit = rs.getString("nama_penerbit");
            String stok = rs.getString("stok");
            
            Buku p = new Buku(id, judul, namaPengarang, namaPenerbit, Integer.parseInt(stok));
            daftar.add(p);
        }
        //langkah 5
        rs.close(); ps.close();conn.close();
        return daftar;
    }
    
    //INSERT
     public boolean insertBuku(Buku p) throws SQLException{
        
        //langkah 1
        conn = k.panggilKoneksi();
        
        //langkah 2
        String sql = "INSERT INTO buku(id_buku,judul,nama_pengarang,nama_penerbit,stok) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getId_buku()); 
        ps.setString(2, p.getJudul());
        ps.setString(3, p.getNama_pengarang()); 
        ps.setString(4, p.getNama_penerbit()); 
        ps.setInt(5, p.getStok());
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
        
    }
    
     
    //UPDATE
    public boolean updateBuku(Buku p) throws SQLException{
        //langkah 1
        conn = k.panggilKoneksi();
        
        //langkah 2
        String sql = "UPDATE buku SET judul=?, nama_pengarang=?, nama_penerbit=?, stok=? WHERE id_buku=?";
        PreparedStatement ps = conn.prepareStatement(sql); 
        ps.setString(1, p.getJudul());
        ps.setString(2, p.getNama_pengarang()); 
        ps.setString(3, p.getNama_penerbit()); 
        ps.setInt(4, p.getStok());
        ps.setString(5, p.getId_buku());
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
    }
    
    //DELETE
    public boolean deleteBuku(String id_buku) throws SQLException{
        
        //langkah 1
        conn = k.panggilKoneksi();
        
        //langkah 2
        String sql = "DELETE FROM buku WHERE id_buku = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id_buku); 
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
    }
}
