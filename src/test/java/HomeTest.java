import Bean.Song;

import Model.Recommended;
import Model.ShowSong;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.assertEquals;


public class HomeTest {
    ArrayList<Song> list;
    Recommended recommended;
    ShowSong showSong;
    @Before
    public void setUp(){
         recommended=new Recommended();
         showSong=new ShowSong();
         list=recommended.showallsongs();
    }
    @After
    public void tearDown(){
        recommended=null;
        showSong=null;
    }
    @Test
    public void  recomendedFromArtist(){
        int expected=1;
         ArrayList<Song> recomendedFromArtist=recommended.recomendedFromArtist("Artist_Name","Abe Parker");
         int actual=recomendedFromArtist.size();
         assertEquals(expected,actual);
    }
    @Test
    public void recomendedFromAlbum(){
        int expected=1;
        ArrayList<Song> recomendedFromAlbum=recommended.recomendedFromAlbum("Chhichhore");
        int actual=recomendedFromAlbum.size();
        assertEquals(expected,actual);
    }
    @Test
    public void  recomendedFromGener(){

        int expected=6;
        ArrayList<Song> recomendedFromGener=recommended.recomendedFromGener("Bollywood");
        int actual=recomendedFromGener.size();
        assertEquals(expected,actual);
    }
    @Test
    public void searchByName(){
        int expected=2;
        ArrayList<Song> searchByName=showSong.searchByName("Dil");
        int actual= searchByName.size();
        assertEquals(expected,actual);

    }
}
