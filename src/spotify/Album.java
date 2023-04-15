package spotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String artistName;
    public String albumName;
    public List<Song> songList;
    public Album(String artistName, String albumName) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.songList = new ArrayList<>();
    }
    public boolean findSongInAlbum(String title) {
        for(Song song : songList) {
            if(song.title == title) {
                return true;
            }
        }
        return false;
    }
    public String addToAlbum(String title, double duration) {
        if(findSongInAlbum(title)) {
            return "Song is already present in the album";
        }
        else {
            songList.add(new Song(title, duration));
        }
        return "Song is added to playlist";
    }
    public String addSongToPlayList(int trackNo, LinkedList<Song> playlist) {
        int index = trackNo - 1;
        if(index >= 0 && index < this.songList.size()) {
            Song song = this.songList.get(index);
            playlist.add(song);
            return "Song is added to playlist";
        }
        return "Invalid track number";
    }
    public String addSongToPlayList(String title, LinkedList<Song> playlist) {
        for(Song song : songList) {
            if(song.title == title) {
                playlist.add(song);
                return "Song is added successfully";
            }
        }
        return "Song is does not exist";
    }
}
