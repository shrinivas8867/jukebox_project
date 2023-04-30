package View;

import Bean.Song;
import Controller.Print;
import Model.Recommended;

import java.util.ArrayList;

public class SubSection {
    Print print=new Print();
    ArrayList<Song> list;
    Recommended recommended=new Recommended();
    public String recommendedByArtistprint(int art){
        String artist="";
        try{
            switch (art) {
                case 1: {
                    list=recommended.recomendedFromArtist("Artist_Name", "A. R. Rahman");
                    print.printexistedlist(list);
                    artist="A. R. Rahman";
                }
                break;
                case 2: {
                    list=recommended.recomendedFromArtist("Artist_Name", "Abe Parker");
                    print.printexistedlist(list);
                    artist="Abe Parker";
                }
                break;
                case 3: {
                    list=recommended.recomendedFromArtist("Artist_Name", "Arijit Singh");
                    print.printexistedlist(list);
                    artist="Arijit Singh";
                }
                break;
                case 4: {
                    list=recommended.recomendedFromArtist("Artist_Name", "Bombay Jayashri");
                    print.printexistedlist(list);
                    artist="Bombay Jayashri";
                }
                break;
                case 5: {
                    list=recommended.recomendedFromArtist("Artist_Name", "David Simon,Anitha");
                    print.printexistedlist(list);
                    artist="David Simon,Anitha";
                }
                break;
                case 6: {
                    list=recommended.recomendedFromArtist("Artist_Name", "Dylan Mathew and Slander");
                    print.printexistedlist(list);
                    artist="Dylan Mathew and Slander";
                }
                break;
                case 7: {
                    list=recommended.recomendedFromArtist("Artist_Name", "Henry_Moodie");
                    print.printexistedlist(list);
                    artist="Henry_Moodie";
                }
                break;
                case 8: {
                    list=recommended.recomendedFromArtist("Artist_Name", "Nani, Sudheer Babu");
                    print.printexistedlist(list);
                    artist="Nani, Sudheer Babu";
                }
                break;
                case 9: {
                    list=recommended.recomendedFromArtist("Artist_Name", "Neha Kakkar Yasser Desai");
                    print.printexistedlist(list);
                    artist="Neha Kakkar Yasser Desai";
                }
                break;
                default: {
                    System.out.println("Invalid Input");
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return artist;
    }

    public String recommendedByAlbumprint(int alb){
        String album="";
        try{
            switch (alb) {
                case 1: {
                    list=recommended.recomendedFromArtist("Album", "Chhichhore");
                    print.printexistedlist(list);
                    album="Chhichhore";
                }
                break;
                case 2: {
                    list=recommended.recomendedFromArtist("Album", "Dil Bechara");
                    print.printexistedlist(list);
                    album="Dil Bechara";
                }
                break;
                case 3: {
                    list=recommended.recomendedFromArtist("Album", "Dil Ko Karaar Aaya");
                    print.printexistedlist(list);
                    album="Dil Ko Karaar Aaya";
                }
                break;
                case 4: {
                    list=recommended.recomendedFromArtist("Album", "Heart Break");
                    print.printexistedlist(list);
                    album="Heart Break";
                }
                break;
                case 5: {
                    list=recommended.recomendedFromArtist("Album", "Iddarammayilatho");
                    print.printexistedlist(list);
                    album="Iddarammayilatho";
                }
                break;
                case 6: {
                    list=recommended.recomendedFromArtist("Album", "MixLoaded.Com");
                    print.printexistedlist(list);
                    album="MixLoaded.Com";
                }
                break;
                case 7: {
                    list=recommended.recomendedFromArtist("Album", "Stupid Face");
                    print.printexistedlist(list);
                    album="Stupid Face";
                }
                break;
                case 8: {
                    list=recommended.recomendedFromArtist("Album", "V");
                    print.printexistedlist(list);
                    album="V";
                }
                break;
                case 9: {
                    list=recommended.recomendedFromArtist("Album", "Zara Zara Behekta Hai");
                    print.printexistedlist(list);
                    album="Zara Zara Behekta Hai";
                }
                break;
                default: {
                    System.out.println("Invalid Input");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return album;

    }
    public String  recommendedByGenersprint(int gen){
        String gener="";
        try{ switch (gen) {
            case 1: {
                list=recommended.recomendedFromArtist("Gener", "Bollywood");

                print.printexistedlist(list);
                 gener="Bollywood";
            }
            break;
            case 2: {
                list=recommended.recomendedFromArtist("Gener", "English Song");
                print.printexistedlist(list);
                gener="English Song";
            }
            break;
            case 3: {
                list=recommended.recomendedFromArtist("Gener", "Telugu Song");
                print.printexistedlist(list);
                gener="Telugu Song";
            }
            break;
            default: {
                System.out.println("Invalid Input");
            }
        }


        }catch (Exception e){
            System.out.println(e);
        }
        return gener;
    }


}
