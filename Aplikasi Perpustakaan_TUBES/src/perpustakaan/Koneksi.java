/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

/**
 *
 * @author asus
 */
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;
    public static Connection panggilKoneksi(){
        MysqlDataSource dataSource = new MysqlDataSource();
        String DB_URL= "jdbc:mysql://localhost:3306/aplikasiperpustakaan";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";
                
        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
                
        try{
            koneksi = dataSource.getConnection();
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex){
            System.out.println("Eksepsi akses data : " + ex.getMessage());
        }
        return koneksi;
    }

   
}
