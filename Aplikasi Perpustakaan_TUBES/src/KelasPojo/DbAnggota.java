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

public class DbAnggota {
    private Connection conn;
    private final Koneksi k = new Koneksi();
    
    //SELECT
    public ArrayList<AnggotaPojo> getAnggotaPojo() throws SQLException{
        ArrayList<AnggotaPojo> daftar = new ArrayList<>();      
        
        //langkah 1
        conn = k.panggilKoneksi();
        
        //langkah 2
        String kueri = "SELECT * FROM anggota";
        PreparedStatement ps = conn.prepareStatement(kueri);
        
        //langkah 3
        ResultSet rs = ps.executeQuery();
        
        //langkah 4
        while(rs.next()){
            String id = rs.getString("id_anggota");
            String nama = rs.getString("nama");
            String kelas = rs.getString("kelas");
            String jenis = rs.getString("Jenis_Kelamin");
            String alamat = rs.getString("Alamat");
            String ttl = rs.getString("ttl");
            
            AnggotaPojo p = new AnggotaPojo(id, nama, kelas, jenis, alamat, ttl);
            daftar.add(p);
        }
        //langkah 5
        rs.close(); ps.close();conn.close();
        return daftar;
    }
    
    //INSERT
     public boolean insertAnggota(AnggotaPojo p) throws SQLException{
        
        //langkah 1
        conn = k.panggilKoneksi();
        
        //langkah 2
        String kueri = "INSERT INTO anggota(id_anggota,nama,kelas,Jenis_Kelamin,Alamat,ttl) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, p.getId_anggota()); 
        ps.setString(2, p.getNama());
        ps.setString(3, p.getKelas()); 
        ps.setString(4, p.getJenis_Kelamin()); 
        ps.setString(5, p.getAlamat()); 
        ps.setString(6, p.getTtl()); 
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
        
    }
    
     
    //UPDATE
    public boolean updateAnggota(AnggotaPojo p) throws SQLException{
        //langkah 1
        conn = k.panggilKoneksi();
        
        //langkah 2
        String kueri = "UPDATE anggota SET nama=?, kelas=?, Jenis_Kelamin=?, Alamat=?, ttl=? WHERE id_anggota=?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, p.getNama()); 
        ps.setString(2, p.getKelas());
        ps.setString(3, p.getJenis_Kelamin());
        ps.setString(4, p.getAlamat());
        ps.setString(5, p.getTtl());
        ps.setString(6, p.getId_anggota());
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
    }
    
    //DELETE
    public boolean deleteAnggota(String id_anggota) throws SQLException{
        
        //langkah 1
        conn = k.panggilKoneksi();
        
        //langkah 2
        String kueri = "DELETE FROM anggota WHERE id_anggota = ?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, id_anggota); 
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
    }
}
