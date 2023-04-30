package Model;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class PlaySong {

    public void playsong(String table){
       Scanner sc=new Scanner(System.in);
        try{
            Timers timers=new Timers();

            Connecter cr= new Connecter();
            Connection con= cr.getConnection();
            Statement st=con.createStatement();
            String statement="select * from "+table;
            ResultSet rs=st.executeQuery( statement);
            System.out.println("Press 1 to continue from Starting");
            System.out.println("Press 2 to start from Song Id");
            System.out.println("Press any number to Go Back");
            int cont=sc.nextInt();
            while (cont<=2) {
                if (cont == 1) {

                    while (rs.next()) {
                        File file = new File(rs.getString(7));
                        //System.out.println(rs.getString(1));
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        int input = 0;
                        while (input != 4) {
                            System.out.println("-----------------------Select the option-------------------------");
                            System.out.println("| 1= play/Resume. 2= Pause. 3= Reset. 4= Next. 5= Loop. 6= End. |");
                            System.out.println("-----------------------------------------------------------------");
                            System.out.print("Enter the choise here = ");


                            input = sc.nextInt();

                            switch (input) {
                                case 1:
                                    clip.start();
                                    //System.out.println(clip.getFramePosition()/10000);
                                    //int songtime= clip.getFrameLength();
                                    //timers.runTime(songtime);
                                    break;
                                case 2:
                                    clip.stop();
                                   // timers.pouse();
                                    // System.out.println(clip.getMicrosecondLength());
                                    break;
                                case 3:
                                    clip.setMicrosecondPosition(0);
                                    clip.start();
                                    break;
                                case 4:
                                    clip.close();
                                   // timers.cancle();

                                    clip.setMicrosecondPosition(0);
                                    clip.start();
                                    break;
                                case 5:
                                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                                    System.out.println("Current song is Looping");
                                    break;

                                case 6:
                                    clip.stop();
                                    return;
                                default:
                                    System.out.println("Not a valid response");
                            }
                        }
                    }
                }
                 else if (cont == 2) {
                    System.out.println("Enter Song Id to play that song");
                    int id = sc.nextInt();
                    while (rs.next()) {

                        // System.out.println(rs.getInt(1));
                        if (rs.getInt(1) == id) {
                            // while (rs.next()) {
                            File file = new File(rs.getString(7));
                            //System.out.println(rs.getString(1));
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            int input = 0;
                            while (input != 4) {
                                System.out.println("-----------------------Select the option-------------------------");
                                System.out.println("| 1= play/Resume. 2= Pause. 3= Reset. 4= Next. 5= Loop. 6= End. |");
                                System.out.println("-----------------------------------------------------------------");
                                System.out.print("Enter the choise here = ");

                                input = sc.nextInt();

                                switch (input) {
                                    case 1:
                                        clip.start();
                                        //System.out.println(clip.getFrameLength());

                                        break;
                                    case 2:

                                        clip.stop();
                                        break;
                                    case 3:
                                        clip.setMicrosecondPosition(0);
                                        clip.start();
                                        break;
                                    case 4:
                                        clip.close();
                                        clip.setMicrosecondPosition(0);
                                        clip.start();

                                        break;
                                    case 5:
                                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                                        System.out.println("Current song is Looping");
                                        break;
                                    case 6:
                                        clip.stop();
                                        return;
                                    default:
                                        System.out.println("Not a valid response");
                                }
                            }

                        }

                    }
                 }

            }
        }
            catch (UnsupportedAudioFileException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        }
        public void playsong_of_playlist(String name){
        Scanner sc=new Scanner(System.in);
        try{
            Timers timers=new Timers();
            Connecter cr= new Connecter();
            Connection con= cr.getConnection();
            Statement st=con.createStatement();
            String statement=("select playlistdetails.Song_Id, Song_Name, Artist_Name, Gener, Album,Duration, url from  playlistdetails,playlist,musiclist where  playlist.Playlist_name = playlistdetails.Playlist_name and playlistdetails.Song_Id= musiclist.Song_Id and playlistdetails.Playlist_name like'"+name+"';");
            ResultSet rs=st.executeQuery( statement);
            System.out.println("Press 1 to continue from Starting");
            System.out.println("Press 2 to start from Song Id");
            System.out.println("Press any number to Go Back");
            int cont=sc.nextInt();
            while (cont<=2) {
                if (cont == 1) {
                    while (rs.next()) {
                        File file = new File(rs.getString(7));
                        //System.out.println(rs.getString(1));
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        int input = 0;
                        while (input != 4) {
                            System.out.println("-----------------------Select the option-------------------------");
                            System.out.println("| 1= play/Resume. 2= Pause. 3= Reset. 4= Next. 5= Loop. 6= End. |");
                            System.out.println("-----------------------------------------------------------------");
                            System.out.print("Enter the choise here = ");


                            input = sc.nextInt();

                            switch (input) {
                                case 1:
                                    clip.start();
                                    //int songtime= clip.getFrameLength();
                                    //timers.runTime(songtime);
                                    break;
                                case 2:
                                    clip.stop();
                                    // System.out.println(clip.getMicrosecondLength());
                                    break;
                                case 3:
                                    clip.setMicrosecondPosition(0);
                                    clip.start();
                                    break;
                                case 4:
                                    clip.close();
                                    clip.setMicrosecondPosition(0);
                                    clip.start();
                                    break;
                                case 5:
                                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                                    System.out.println("Current song is Looping");
                                    break;

                                case 6:
                                    clip.stop();
                                    return;
                                default:
                                    System.out.println("Not a valid response");
                            }
                        }
                    }
                } else if (cont == 2) {
                    System.out.println("Enter Song Id to play that song");
                    int id = sc.nextInt();
                    while (rs.next()) {

                        // System.out.println(rs.getInt(1));
                        if (rs.getInt(1) == id) {
                            // while (rs.next()) {
                            File file = new File(rs.getString(7));
                            //System.out.println(rs.getString(1));
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            int input = 0;
                            while (input != 4) {
                                System.out.println("-----------------------Select the option-------------------------");
                                System.out.println("| 1= play/Resume. 2= Pause. 3= Reset. 4= Next. 5= Loop. 6= End. |");
                                System.out.println("-----------------------------------------------------------------");
                                System.out.print("Enter the choise here = ");

                                input = sc.nextInt();

                                switch (input) {
                                    case 1:
                                        clip.start();
                                        //System.out.println(clip.getFrameLength());

                                        break;
                                    case 2:

                                        clip.stop();
                                        break;
                                    case 3:
                                        clip.setMicrosecondPosition(0);
                                        clip.start();
                                        break;
                                    case 4:
                                        clip.close();
                                        clip.setMicrosecondPosition(0);
                                        clip.start();

                                        break;
                                    case 5:
                                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                                        System.out.println("Current song is Looping");
                                        break;
                                    case 6:
                                        clip.stop();
                                        return;
                                    default:
                                        System.out.println("Not a valid response");
                                }
                            }

                        }

                    }
                }
            }
        }
        catch (SQLException io){
            System.out.println("a");
            throw new RuntimeException(io);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("b");
            throw new RuntimeException(e);
        }  catch (LineUnavailableException e) {
            System.out.println("d");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("c");
            throw new RuntimeException(e);
        }

    }




    public void playsongbyArtist(String table,String artist){
        Scanner sc=new Scanner(System.in);
        try{
            Connecter cr= new Connecter();
            Connection con= cr.getConnection();
            Statement st=con.createStatement();
            String statement="select * from "+table+" where Artist_Name like '"+artist+"%';";
            ResultSet rs=st.executeQuery( statement);
            while(rs.next()){
                File file =new File(rs.getString(7));
                //System.out.println(rs.getString(1));
                AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(file);
                Clip clip= AudioSystem.getClip();
                clip.open(audioInputStream);
                int input=0;
                while (input!=4) {
                    System.out.println("-----------------------Select the option-------------------------");
                    System.out.println("| 1= play/Resume. 2= Pause. 3= Reset. 4= Next. 5= Loop. 6= End. |");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.print("Enter the choise here = ");

                    input = sc.nextInt();

                    switch (input) {
                        case 1:
                            clip.start();
                            break;
                        case 2:

                            clip.stop();
                            break;
                        case 3:
                            clip.setMicrosecondPosition(0);
                            clip.start();
                            break;
                        case 4:
                            clip.close();
                            break;
                        case 5:
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                            System.out.println("Current song is Looping");
                            break;

                        case 6:
                            clip.stop();
                            return;
                        default:
                            System.out.println("Not a valid response");
                    }
                }
            }
        }
        catch (SQLException io){
            System.out.println("a");
            throw new RuntimeException(io);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("b");
            throw new RuntimeException(e);
        }  catch (LineUnavailableException e) {
            System.out.println("d");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("c");
            throw new RuntimeException(e);
        }

    }
    public void playsongbyAlbum(String table,String album){
        Scanner sc=new Scanner(System.in);
        try{
            Connecter cr= new Connecter();
            Connection con= cr.getConnection();
            Statement st=con.createStatement();
            String statement="select * from "+table+" where Album like '"+album+"%';";
            ResultSet rs=st.executeQuery( statement);
            while(rs.next()){
                File file =new File(rs.getString(7));
                //System.out.println(rs.getString(1));
                AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(file);
                Clip clip= AudioSystem.getClip();
                clip.open(audioInputStream);
                int input=0;
                while (input!=4) {
                    System.out.println("-----------------------Select the option-------------------------");
                    System.out.println("| 1= play/Resume. 2= Pause. 3= Reset. 4= Next. 5= Loop. 6= End. |");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.print("Enter the choise here = ");
                    input = sc.nextInt();

                    switch (input) {
                        case 1:
                            clip.start();

                            break;
                        case 2:

                            clip.stop();
                            break;
                        case 3:
                            clip.setMicrosecondPosition(0);
                            clip.start();
                            break;
                        case 4:
                            clip.close();

                            break;
                        case 5:
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                            System.out.println("Current song is Looping");
                            break;

                        case 6:
                            clip.stop();
                            return;
                        default:
                            System.out.println("Not a valid response");
                    }
                }
            }
        }
        catch (SQLException io){
            System.out.println("a");
            throw new RuntimeException(io);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("b");
            throw new RuntimeException(e);
        }  catch (LineUnavailableException e) {
            System.out.println("d");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("c");
            throw new RuntimeException(e);
        }

    }
    public void playsongbyGener(String table,String gener){
        Scanner sc=new Scanner(System.in);
        try{
            Connecter cr= new Connecter();
            Connection con= cr.getConnection();
            Statement st=con.createStatement();
            String statement="select * from "+table+" where Gener like '"+gener+"%';";
            ResultSet rs=st.executeQuery( statement);
            while(rs.next()){
                File file =new File(rs.getString(7));
                //System.out.println(rs.getString(1));
                AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(file);
                Clip clip= AudioSystem.getClip();
                clip.open(audioInputStream);
                int input=0;
                while (input!=4) {
                    System.out.println("-----------------------Select the option-------------------------");
                    System.out.println("| 1= play/Resume. 2= Pause. 3= Reset. 4= Next. 5= Loop. 6= End. |");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.print("Enter the choise here = ");
                    input = sc.nextInt();

                    switch (input) {
                        case 1:
                            clip.start();
                            break;
                        case 2:

                            clip.stop();
                            break;
                        case 3:
                            clip.setMicrosecondPosition(0);
                            clip.start();
                            break;
                        case 4:
                            clip.close();

                            break;
                        case 5:
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                            System.out.println("Current song is Looping");
                            break;

                        case 6:
                            clip.stop();
                            return;
                        default:
                            System.out.println("Not a valid response");
                    }
                }
            }
        }
        catch (SQLException io){
            System.out.println("a");
            throw new RuntimeException(io);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("b");
            throw new RuntimeException(e);
        }  catch (LineUnavailableException e) {
            System.out.println("d");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("c");
            throw new RuntimeException(e);
        }

    }
    public void playsongbyname(String table,String gener){
        Scanner sc=new Scanner(System.in);
        try{
            Connecter cr= new Connecter();
            Connection con= cr.getConnection();
            Statement st=con.createStatement();
            String statement="select * from "+table+" where Song_Name like '"+gener+"%';";
            ResultSet rs=st.executeQuery( statement);
            while(rs.next()){
                File file =new File(rs.getString(7));
                //System.out.println(rs.getString(1));
                AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(file);
                Clip clip= AudioSystem.getClip();
                clip.open(audioInputStream);
                int input=0;
                while (input!=4) {
                    System.out.println("-----------------------Select the option-------------------------");
                    System.out.println("| 1= play/Resume. 2= Pause. 3= Reset. 4= Next. 5= Loop. 6= End. |");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.print("Enter the choise here = ");
                    input = sc.nextInt();

                    switch (input) {
                        case 1:
                            clip.start();
                            break;
                        case 2:
                            clip.stop();
                            break;
                        case 3:
                            clip.setMicrosecondPosition(0);
                            clip.start();
                            break;
                        case 4:
                            clip.close();
                            break;
                        case 5:
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                            System.out.println("Current song is Looping");
                            break;
                        case 6:
                            clip.stop();
                            return;
                        default:
                            System.out.println("Not a valid response");
                    }
                }
            }
        }
        catch (SQLException io){
            System.out.println("a");
            throw new RuntimeException(io);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("b");
            throw new RuntimeException(e);
        }  catch (LineUnavailableException e) {
            System.out.println("d");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("c");
            throw new RuntimeException(e);
        }

    }


}
