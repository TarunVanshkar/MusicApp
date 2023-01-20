import java.util.*;

public class Main
{
    public static List<Album> albums=new ArrayList<Album>();
    public static void main(String[] args)
    {
        Album album1=new Album("Hit Machine", "Emraan Hashmi");
        album1.addSongstoAlbum("Phir Mohabbat", 5.26);
        album1.addSongstoAlbum("Hale Dil", 4.30);
        album1.addSongstoAlbum("Bhege hot tere", 10.59);
        album1.addSongstoAlbum("Agar tum mil jao", 5.20);

        Album album2=new Album("Popular Track", "Atif Aslam");
        album2.addSongstoAlbum("Aadat", 3.30);
        album2.addSongstoAlbum("Kuch is tarah", 4.55);
        album2.addSongstoAlbum("Tere sang yara", 5.25);
        album2.addSongstoAlbum("Tere Liye", 4.36);

        // Now we will add our created 2 albums in a list
        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("Hale Dil"));

        // Now to add song in our personal playlist from album
        LinkedList<Song> myPlaylist=new LinkedList<>();  // so that we can move froward and backward on O(n) time
        album1.addToPlayListFromAlbum("Phir Mohabbat", myPlaylist);
        album1.addToPlayListFromAlbum(2, myPlaylist);
        album1.addToPlayListFromAlbum(4, myPlaylist);

        album2.addToPlayListFromAlbum("Aadat", myPlaylist);
        album2.addToPlayListFromAlbum(3, myPlaylist);
        album2.addToPlayListFromAlbum(4, myPlaylist);

        // Now we need to play our songs
        play(myPlaylist);
    }

    // Function to play our created playlist
    public static void play(LinkedList<Song> playlist)
    {
        // we will iterate in LinkedList with the help of list iterator
        ListIterator<Song> itr=playlist.listIterator();   // Syntax to declare list iterator
        Scanner sc=new Scanner(System.in);   // To enter the choice to play forward or previous song

        boolean isForward=false;

        if(playlist.size()>0)
        {
            System.out.print("Currently Playing: ");
            System.out.println(itr.next());
            isForward=true;   // flag variable is moved forward
        }
        else
        {
            System.out.println("Playlist is empty");
            return;
        }

        // Now we want to have a choice of user
        System.out.println("Enter your choice");
        printMenu();

        // Since we are entering user choice in numeric form, so we can use switch case
        boolean quit=false;
        while(!quit)
        {
            int choice =sc.nextInt();
            switch(choice)
            {
                case 1:   //Play next Song
                    if(isForward==false)
                    {
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext())
                    {
                        System.out.println(itr.next());   // isforwrd true here
                    }
                    else
                    {
                        System.out.println("You have reached to the end of playlist");
                        isForward=false;  // can only move to backward direction now
                    }
                    break;

                case 2:  //Play previous song
                    if(isForward==true)
                    {
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious())
                    {
                        System.out.println(itr.previous());   // isForward false here
                    }
                    else
                    {
                        System.out.println("You have reached to the begining of the playlist");
                        isForward=true;   // can only move to forward direction now
                    }
                    break;

                case 3:   //Repeat the current song
                    if(isForward==true)
                    {
                        if(itr.hasPrevious())
                        {
                            System.out.println(itr.previous());
                            isForward=false;
                        }
                    }
                    else
                    {
                        if(itr.hasNext())
                        {
                            System.out.println(itr.next());
                            isForward=true;
                        }
                    }
                    break;

                case 4:   //Show menu again
                    printMenu();
                    break;

                case 5:   // Delete the current song
                    itr.remove();
                    System.out.println("Current song has been deleted");
                    break;

                case 6:   // print all songs in playlist
                    printSong(playlist);
                    break;

                case 7:   // exit
                    quit=true;
                    break;
            }
        }
    }

    // Function to print a menu to get user choice
    public static void printMenu()
    {
        System.out.println("1 - Play next Song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in playlist");
        System.out.println("7 - Exit");

        return;
    }

    // Function to print all songs present in PlayList
    public static void printSong(LinkedList<Song> playList)
    {
        for(Song s:playList)
        {
            System.out.println(s.getTitle());
        }
        return;
    }
}