import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album
{
    private String name;
    private String artist;
    private List<Song> songs;  // It is just a reference. Not allocated memory yet

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title)
    {
        for(Song s:songs)
        {
            if(s.getTitle().equals(title))
            {
                return true;
            }
        }
        return false;
    }

    // To add song im Album
    public void addSongstoAlbum(String title, double duration)
    {
        Song s=new Song(title, duration);
        if(findSong(s.getTitle())==true)
        {
            System.out.println("Song is already Present");
        }
        else
        {
            songs.add(s);
            System.out.println("New song has been Added");
        }
        return;
    }

    // Concept of polymorphism -> Run Time Polymorphism
    public void addToPlayListFromAlbum(String title, LinkedList<Song> playList)
    {
        if(findSong((title))==true)
        {
            for(Song song:songs)
            {
                if(song.getTitle().equals(title))
                {
                    playList.add(song);
                    System.out.println("Song has been added to your playlist");
                    break;
                }
            }
        }
        else
        {
            System.out.println("Song is not present in the Album");
        }
        return;
    }

    public void addToPlayListFromAlbum(int trackNo, LinkedList<Song> playList)
    {
        int index=trackNo-1;   // because list has Zero based indexing
        if(index>=0 && index<songs.size())
        {
            playList.add(songs.get(index));
            System.out.println("Song has been added to your playlist");
        }
        else
        {
            System.out.println("Invalid track Number");
        }
        return;
    }
}
