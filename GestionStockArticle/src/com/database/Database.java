package com.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
///import java.sql.Statement;
public class Database {

    public static  void connect(){
        Connection con = null;
        String dbpath="gestion.db";
        try{
            Class.forName("org.sqlite.JDBC");
            String path="jdbc:sqlite:"+dbpath;
            con = DriverManager.getConnection(path);
            System.out.println("Connection to sqlite has been established ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(con!=null)
                {
                    System.out.println("Connexion fermée");
                    con.close();
                }
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args){
        connect();
    }
}
