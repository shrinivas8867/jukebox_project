package Model;

import Bean.Song;

import java.sql.*;
import java.util.ArrayList;

public class ShowSong {
    Connecter cr= new Connecter();
    Song song;

    public void createnewlist(String name){
        Connection con= cr.getConnection();
        int table=0;
        try {
            /*PreparedStatement pre=con.prepareStatement("insert into playlist values('?'); ");
            pre.setString(1,name);
            table=pre.executeUpdate();*/
            Statement st= con.createStatement();
            System.out.println(name);
            //table=st.executeUpdate("create table playlist (Playlist_name varchar(20)unique ) ;");
            //table=st.executeUpdate("create table playlistdetails(Playlist_name varchar(20),Foreign key(Playlist_name) references playlist ( Playlist_name) ,Song_Id int, Foreign key(Song_Id) references musiclist(Song_Id));");
            table=st.executeUpdate("insert into playlist values('"+name+"'); ");
            System.out.println(table );
        } catch (SQLException e) {
            System.out.println("hhh");
            throw new RuntimeException(e);
        }
    }
    public void addrow(String table,String name,String artist,String gener,String album,double duration,String url){
        Connection con= cr.getConnection();
        int row=0;
        int row1=0;
        try{
            Statement st=con.createStatement();
            /*PreparedStatement pre=con.prepareStatement("insert into ?(Song_Name,Artist_Name,Gener,Album,Duration,url) values('?','?','?','?',?,'?');");
            pre.setString(1,table);
            pre.setString(2,name);
            pre.setString(3,artist);
            pre.setString(4,gener);
            pre.setString(5,album);
            pre.setString(6,duration);
            pre.setString(7,url);
            row=pre.executeUpdate()*/
            row=st.executeUpdate("insert into  musiclist(Song_Name,Artist_Name,Gener,Album,Duration,url) values('"+name+"','"+artist+"','"+gener+"','"+album+"',"+duration+",'"+url+"');");
            ResultSet rs=st.executeQuery("Select Song_Id from musiclist where url like '"+url+"%';");
            System.out.println(rs.getInt(1));
            System.out.println(row);
            if (row==1){
                System.out.println("Song Added Successfully");
            }
            else
                System.out.println("Song not added");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Song> searchByName(String name){
        Connection con= cr.getConnection();
        ArrayList<Song> namelist=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select* from musiclist where Song_Name like '"+name+"%';");
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
    public void add_list_to_main_List(String playlistname){
        Connection con= cr.getConnection();
        int row=0;
        try{
            Statement st=con.createStatement();
            row=st.executeUpdate("insert into musiclist(Song_Name,Artist_Name,Gener,Album,Duration,url) select Song_Name,Artist_Name,Gener,Album,Duration,url from "+playlistname+";");
            /*if(row==1){
                System.out.println("Playlist added Successfully");
            }
            else
                System.out.println("Playlist not added to the main table");*/

        }
        catch (SQLException s){
            System.out.println("playlist not added to the main table");
        }

    }
    public void add_list_from_main(String playlistname,int sid){
        Connection con= cr.getConnection();
        int row=0;
        try{
            Statement st = con.createStatement();
            row = st.executeUpdate("insert into playlistdetails value('"+playlistname+"',"+sid+"); ");
            //System.out.println(row);
            if (row == 1) {
                System.out.println("song added added Successfully");
            } else
                System.out.println("song not added to the main table");
        }
        catch (SQLException s){
            System.out.println(s);
        }

    }
    public ArrayList<String> showplaylist(){
        Connection con= cr.getConnection();
        ArrayList<String> table=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from playlist;");
            while(rs.next()){
                table.add(rs.getString(1));
            }
        }
        catch (SQLException s){
            System.out.println(s);
        }
         return  table;
    }
    public ArrayList<Song> show_playlist_songs(String name){
        Connection con= cr.getConnection();
        ArrayList<Song> list=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select playlistdetails.Song_Id, Song_Name, Artist_Name, Gener, Album,Duration, url from  playlistdetails,playlist,musiclist where  playlist.Playlist_name = playlistdetails.Playlist_name and playlistdetails.Song_Id= musiclist.Song_Id and playlistdetails.Playlist_name like'"+name+"'  ;");
            while (rs.next()){
                list.add(new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6)));
            }
        }
        catch(SQLException e){
            System.out.println("------Please Enter the correct PlayList name as Shown above------");
        }
        return list;
    }


}
