package Controller;

import Model.Recommended;
import Bean.Song;
import Model.ShowSong;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;




public class Print {
    Recommended recommended=new Recommended();

    public ArrayList<Song> getListOfCustomersSortedByName(ArrayList<Song> song){
        ArrayList l= new ArrayList<>();
        Collections.sort(song);

        return song;
    }


    public void printexistedlist(ArrayList<Song> list) {
        //this method will  print all the tables.
        Collections.sort(list);
        // Comparator<Song> Name=(o1,o2)->((o1.getName(list.get()).compareTo(o2.getName())>0)?1:-1);
        System.out.println("=========================================================================================================================================================");
        System.out.println("| Song Id |            Name              |            Artist            |            Album             |         Genre          |  Duration in Minutes  |");
        System.out.println("=========================================================================================================================================================");
        //while(iterator.hasNext())

        for (Song s : list) {
            System.out.printf("| %-8d|  %-28s|  %-28s|  %-28s|  %-22s|  %-21f|\n",s.getSongid(),s.getName(),s.getAlbum(),s.getGenre(),s.getArtist(),s.getDuration());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        }


    }
    public void print_existed_playlist(){
        //this method will print existing list.
        ShowSong showSong=new ShowSong();
        ArrayList<String> playlisst_name=showSong.showplaylist();
        Iterator iterator=playlisst_name.iterator();
        System.out.println("----------------All Playlist---------------");
        while(iterator.hasNext()) {
             // System.out.println("hello");
            System.out.printf("|               %-26s|\n",iterator.next());
        }
        System.out.println("-------------------------------------------");

    }


}
