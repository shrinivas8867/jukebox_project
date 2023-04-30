package Model;

import Bean.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class Recommended {// here we are getting list of all songs available.
    Connecter cr= new Connecter();
    Song song;

    public ArrayList<Song>  showallsongs(){
        Connection con= cr.getConnection();
        ArrayList<Song> list=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select* from musiclist;");
            while (rs.next()){
                list.add(new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6)));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
       return list;
    }

    public void createnewlist(String name,int no){



    }
    public ArrayList<Song> recomendedFromArtist(String column,String name){// here we are getting list of all songs available based on Artist.
        Connection con= cr.getConnection();
        ArrayList<Song> namelist=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select* from musiclist where "+column+" like '"+name+"%';");
            while (rs.next()){
                song=new Song(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getDouble(6));
                namelist.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return namelist;
    }
    public ArrayList<Song> recomendedFromAlbum(String name){
        Connection con= cr.getConnection();
        ArrayList<Song> namelist=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select* from musiclist where Album like '"+name+"%';");
            while (rs.next()){
                song=new Song(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getDouble(6));
                namelist.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return namelist;
    }
    public ArrayList<Song> recomendedFromGener(String name){
        Connection con= cr.getConnection();
        ArrayList<Song> namelist=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select* from musiclist where Gener like '"+name+"%';");
            while (rs.next()){
                song=new Song(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getDouble(6));
                namelist.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return namelist;
    }






}
