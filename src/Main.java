import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album kkAlbum = new Album("KrishnaKumar", "KK's Album");
        Album alanAlbum = new Album("Alan Walker", "Walker's Album");

        kkAlbum.addSongToAlbum("Yaaron" , 3.5);
        kkAlbum.addSongToAlbum("Dil Ibaadat" , 2.7);
        kkAlbum.addSongToAlbum("Tujhe Sochta Hoon" , 4.6);

        alanAlbum.addSongToAlbum("Faded" , 2.3);
        alanAlbum.addSongToAlbum("Alone" , 3.48);
        alanAlbum.addSongToAlbum("Darkside" , 4.1);


        LinkedList<Song> myPlaylist = new LinkedList<>();

        System.out.println(kkAlbum.addToPlaylistFromAlbum("Yaaron", myPlaylist));
        System.out.println(kkAlbum.addToPlaylistFromAlbum(2, myPlaylist));
        System.out.println(kkAlbum.addToPlaylistFromAlbum(5, myPlaylist));

        System.out.println(alanAlbum.addToPlaylistFromAlbum("Darkside", myPlaylist));
        System.out.println(alanAlbum.addToPlaylistFromAlbum(2, myPlaylist));

        play(myPlaylist);
    }

    private static void play(LinkedList<Song> myPlaylist) {

        if(myPlaylist.size() == 0) {
            System.out.println("Empty Playlist!!!");
            return;
        }

        ListIterator<Song> itr = myPlaylist.listIterator();
        System.out.println("Now Playing: " + itr.next());
        boolean wasNext = true;

        Scanner sc = new Scanner(System.in);
        printMenu();

        boolean quit = false;
        while(!quit) {
            System.out.println("Please enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(wasNext == false) {
                        itr.next();
                        wasNext = true;
                    }
                    if(!itr.hasNext()) {
                        System.out.println("you have reached the end of the playlist");
                    } else{
                        System.out.println("Currently playing: " + itr.next());
                    }
                    break;
                case 3:
                    if(wasNext == true) {
                        itr.previous();
                        wasNext = false;
                    }
                    if(!itr.hasPrevious()) {
                        System.out.println("Your are at the start of the playlist");
                    } else{
                        System.out.println("Currently Playing: " + itr.previous());
                    }
                    break;
                case 4:
                    if(wasNext == true) {
                        System.out.println("Currently Playing: " + itr.previous());
                        wasNext = false;
                    } else{
                        System.out.println("Currently playing: " + itr.next());
                        wasNext = true;
                    }
                    break;
                case 5:
                    if(wasNext == false) {
                        myPlaylist.remove(itr.next());
                    } else{
                        myPlaylist.remove(itr.previous());
                    }
                    break;
                case 6:
                    printSongs(myPlaylist);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice. Please select again");
            }
        }
    }

    private static void printSongs(LinkedList<Song> myPlaylist) {

        for(Song song: myPlaylist) {
            System.out.println(song);
        }
        return;
    }

    private static void printMenu() {

        System.out.println("1. Show the menu again");
        System.out.println("2. Play next song");
        System.out.println("3. Play previous song");
        System.out.println("4. Play current song again");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. print all the songs in playlist");
        System.out.println("7. Quit application");

    }
}