package View;

import Bean.Song;
import Controller.Print;
import Model.Connecter;
import Model.PlaySong;
import Model.Recommended;
import Model.ShowSong;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class Home {
    public static void main(String[] args) {
        int choose = 0;
        do{
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("==========================================================Welcome to JukeBox==============================================================");
            System.out.println("");
            System.out.println("--------------Please select the option--------------");
            System.out.println("|             1.Your Playlists.                    |");
            System.out.println("|             2.Available Songs.                   |");
            System.out.println("|             3.Search by Artist.                  |");
            System.out.println("|             4.Search by Album.                   |");
            System.out.println("|             5.Search by Genre.                   |");
            System.out.println("|             6.Search Songs.                      |");
            System.out.println("|             7.Exit.                              |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter your choise here = ");
            choose = sc.nextInt();
            ArrayList<Song> list;
            //I created objects of what I required for each function.
            Recommended recommended = new Recommended();
            ShowSong showSong = new ShowSong();
            Print print = new Print();
            SubSection subSection = new SubSection();
            PlaySong playSong = new PlaySong();
            //switch case are used to get in to perticular function.
            switch (choose) {
                case 1: {//For Your Playlist function.
                    int l = 0;
                    do {
                        try {
                            System.out.println("--------------Please select the option--------------");
                            System.out.println("|             1.Create new playlist.               |");
                            System.out.println("|             2.Show existed playlist.             |");
                            System.out.println("|             3.Go back to main menu.              |");
                            System.out.println("----------------------------------------------------");
                            System.out.print("Enter your choise here = ");
                            l = sc.nextInt();
                            if (l == 1) {
                                int p=0;
                                do {
                                    System.out.println("----------------Create new playlist---------------");
                                    System.out.println("| 1.Do you want to add song from Available songs |");
                                    System.out.println("| 2.Do you want to add song from Others sourse   |");
                                    System.out.println("| 4.Go Back                                      |");
                                    System.out.println("--------------------------------------------------");
                                    System.out.print("Enter your choise here = ");
                                    p = sc.nextInt();
                                    if (p == 2) {
                                        System.out.println("-----------Add song from Others sourse-----------");
                                        System.out.print("Enter the Name of new playlist =");
                                        String s = sc.next();
                                        System.out.println("");
                                        showSong.createnewlist(s);
                                        System.out.print("How many number of songs you want to Add to the " + s + " Playlist =");
                                        int no = sc.nextInt();
                                        if (no > 0) {
                                            //showSong.createnewlist(s);
                                            for (int i = 1; i <= no; i++) {
                                                System.out.println("ALERT == All sentences 'should not include spaces'");
                                                System.out.print("Enter Name of " + i + " song =");
                                                String nm = sc.next();
                                                System.out.print("Enter Artist name of " + i + " song =");
                                                String ast = sc.next();
                                                System.out.print("Enter Album name of " + i + " song =");
                                                String alb = sc.next();
                                                System.out.print("Enter Gener of " + i + " song =");
                                                String gen = sc.next();
                                                System.out.print("Enter Duration of " + i + " song =");
                                                double due = sc.nextDouble();
                                                System.out.print("Enter url of " + i + " song =");
                                                String url = sc.nextLine();
                                                showSong.addrow(s, nm, ast, alb, gen, due, url);

                                            }
                                        } else {
                                            System.out.println("Invalid input");
                                        }
                                        System.out.println("Do you want to add list to All songs");
                                        System.out.println("Press 1 for 'YES'");
                                        System.out.println("Press any number for 'NO'");
                                        int yes = sc.nextInt();
                                        if (yes == 1) {
                                            showSong.add_list_to_main_List(s);
                                            list=showSong.show_playlist_songs("musiclist");
                                            print.printexistedlist(list);
                                        } else {
                                            System.out.println("list is not added to main list");
                                            list=showSong.show_playlist_songs(s);
                                            print.printexistedlist(list);
                                            playSong.playsong(s);
                                        }

                                    } else if (p == 1) {
                                        System.out.println("-------Add song from Available songs---------");
                                        System.out.print("Enter the Name of new playlist =");
                                        sc.nextLine();
                                        String s1 = sc.nextLine();
                                        System.out.println("");
                                        showSong.createnewlist(s1);
                                       // System.out.print("How many number of songs you want to Add to the " + s1 + " Playlist =");
                                        int no =0;
                                       // if (no > 0) {

                                            //showSong.createnewlist(s);
                                            list = recommended.showallsongs();
                                            print.printexistedlist(list);
                                            //for (int i = 1; i <= no; i++) {
                                            do{
                                                System.out.println("Enter the Song id of the song you want to ADD");
                                                int add=sc.nextInt();
                                                showSong.add_list_from_main(s1,add);
                                            System.out.println("Press 1 to add another song or press 0 to go back");
                                            no=sc.nextInt();
                                            }while(no==1);
                                            list=showSong.show_playlist_songs(s1);
                                            print.printexistedlist(list);
                                                playSong.playsong_of_playlist(s1);

                                    }

                                    else System.out.println("Invalid input");
                                }while (p!=4);


                            } else if (l == 2) {
                                System.out.println("==========================================Existed Playlist=================================================");
                                System.out.println("       ========ALERT======== \n       'No Space Allowed'");
                                ArrayList<String> playlisst_name = showSong.showplaylist();
                                print.print_existed_playlist();
                                System.out.println("Enter the name of the playlist to view");
                                String playlist_name = sc.next();
                                list = showSong.show_playlist_songs(playlist_name);
                                print.printexistedlist(list);
                                playSong.playsong_of_playlist(playlist_name);

                            } else
                                    System.out.println("==============================================Invalid input================================================");

                            } catch(Exception e){
                                System.out.println(e);
                            }
                        } while (l != 3) ;
                    }
                break;
                case 2: {//For available song.
                    try {
                        //do {
                            System.out.println("===========================================Available Songs===========================================");
                            System.out.println("");
                            list = recommended.showallsongs();
                            print.printexistedlist(list);
                            playSong.playsong("musiclist");
                        //}while ()

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                break;
                case 3: {//For search by Astist.
                    int art=0;
                    do{
                    try {
                        System.out.println("===========================================Recommended Artist========================================");
                        System.out.println("---------------------Select the Artist-----------------------");
                        System.out.println("|                    1.A.R.Rahman                           |");
                        System.out.println("|                    2.Abe Parker                           |");
                        System.out.println("|                    3.Arijit Singh                         |");
                        System.out.println("|                    4.Bombay Jayashri                      |");
                        System.out.println("|                    5.David Simon,Anitha                   |");
                        System.out.println("|                    6.Dylan Mathew and Slander             |");
                        System.out.println("|                    7.Henry_Moodie                         |");
                        System.out.println("|                    8.Nani, Sudheer Babu                   |");
                        System.out.println("|                    9.Neha Kakkar Yasser Desai             |");
                        System.out.println("|                    10.Go Back                             |");
                        System.out.println("-------------------------------------------------------------");
                        System.out.print("  Enter your choise here = ");
                        art = sc.nextInt();
                        String artist=subSection.recommendedByArtistprint(art);
                        //print.printexistedlist();
                        System.out.println(art);
                        if(art<10)
                        playSong.playsongbyArtist("musiclist",artist);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }while (art!=10);
                }

                break;
                case 4: {//For search ny Album.
                    int alb=0;
                    while(alb!=10) {
                        try {
                            System.out.println("==================================================Recommended Album================================================");
                            System.out.println("--------------------Select the Album--------------------");
                            System.out.println("|                   1.Chhichhore                       |");
                            System.out.println("|                   2.Dil Bechara                      |");
                            System.out.println("|                   3.Dil Ko Karaar Aaya               |");
                            System.out.println("|                   4.Heart Break                      |");
                            System.out.println("|                   5.Iddarammayilatho                 |");
                            System.out.println("|                   6.MixLoaded.Com                    |");
                            System.out.println("|                   7.Stupid Face                      |");
                            System.out.println("|                   8.V                                |");
                            System.out.println("|                   9.Zara Zara Behekta Hai            |");
                            System.out.println("|                   10.Go Back                         |");
                            System.out.println("--------------------------------------------------------");
                            System.out.print("Enter your choise here = ");
                            alb = sc.nextInt();
                            String album = subSection.recommendedByAlbumprint(alb);
                            if(alb<10)
                            playSong.playsongbyAlbum("musiclist", album);

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
                break;
                case 5: {//For search by geners;
                    int gen=0;

                    do {
                        try {
                            System.out.println("==============================================Recommended Geners===============================================");
                            System.out.println("-----------------Select the Geners-----------------");
                            System.out.println("|                1.Bollywood                      |");
                            System.out.println("|                2.English Song                   |");
                            System.out.println("|                3.Telugu Song                    |");
                            System.out.println("|                4.Go Back                        |");
                            System.out.println("---------------------------------------------------");
                            System.out.print("Enter your choise here = ");
                            gen = sc.nextInt();
                            String gener = subSection.recommendedByGenersprint(gen);
                            if(gen<4)
                            playSong.playsongbyGener("musiclist", gener);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }while(gen!=4);
                }
                break;
                case 6: {//For search by name.
                    int exit=0;
                    do {
                    try {
                        System.out.println("=============================================Search By Name==================================================");
                        System.out.println("1. To Continue");
                        System.out.println("Press any number to Go back ");
                        exit=sc.nextInt();
                        if(exit==1) {
                            sc.nextLine();
                            System.out.print("Enter name of song to search = ");
                            String name = sc.nextLine();
                            list = showSong.searchByName(name);
                            print.printexistedlist(list);

                            playSong.playsongbyname("musiclist", name);
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }while (exit==1);
                }
                break;
                default: {
                    System.out.println("=======================================================Thank You==================================================================");

                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }while (choose!=7);
    }
}
