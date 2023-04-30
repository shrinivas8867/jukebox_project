package Bean;

public class Song implements Comparable<Song> {
    int Songid;
    String Name;
    String Album;
    String Artist;
    String Genre;
    Double Duration;
    String url;

    public Song(int Songid,String Name, String Album, String Artist,String Genre,double Duration) {
        this.Songid=Songid;
        this.Name = Name;
        this.Album = Album;
        this.Artist = Artist;
        this.Genre = Genre;
        this.Duration=Duration;
    }

    public Song(int Songid,String Name, String Album, String Artist, String Genre,double Duration, String url) {
        this.Songid=Songid;
        this.Name = Name;
        this.Album = Album;
        this.Artist = Artist;
        this.Genre = Genre;
        this.Duration=Duration;
        this.url = url;
    }

    public void setSongid(int songid) {
        Songid = songid;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDuration(Double duration) {
        Duration = duration;
    }

    public int getSongid() {
        return Songid;
    }

    public String getName() {
        return Name;
    }

    public String getAlbum() {
        return Album;
    }

    public String getArtist() {
        return Artist;
    }

    public String getGenre() {
        return Genre;
    }

    public String getUrl() {
        return url;
    }

    public Double getDuration() {
        return Duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "Name='" + Name + '\'' +
                ", Album='" + Album + '\'' +
                ", Artist='" + Artist + '\'' +
                ", Genre='" + Genre + '\'' +
                ", url='" + url + '\'' +
                "}\n";
    }
    @Override
    public int compareTo(Song o) {
        int i = ((this.getName().compareTo(o.getName())>0) ? 1 : -1);
        return i;

    }
}

