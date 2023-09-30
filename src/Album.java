import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Album {

    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // functionalities in the album

    boolean findSong(String songName) {
        for(Song song: songs) {
            if(song.getTitle().equals(songName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // add song
    public String addSongToAlbum(String title, double duration) {
        if(!findSong(title)) {
            Song song = new Song(title, duration);
            this.songs.add(song);
            return "Song has been added to the Album";
        }
        return "Song already exists";
    }

    // add to playlist from album
    public String addToPlaylistFromAlbum(String title, LinkedList<Song> playlist) {
        for(Song song: songs) {
            if(song.getTitle().equals(title)) {
                playlist.add(song);
                return "Song has been added to your playlist";
            }
        }
        return "Song doesn't exist in album";
    }

    /**
     * polymorphism: compile time - method overloading
     * @param songNo
     * @param playlist
     * @return
     */
    public String addToPlaylistFromAlbum(int songNo, LinkedList<Song> playlist) {
        int index = songNo - 1;
        if(index >= 0 && index < songs.size()) {
            playlist.add(songs.get(index));
            return "Song has been added successfully";
        }
        return "Incorrect song number";
    }
}
