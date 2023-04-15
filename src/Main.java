import spotify.Album;
import spotify.Song;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Album> list = new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("Arijit Singh", "Old Songs");
        album.addToAlbum("Pathan", 4.5);
        album.addToAlbum("Channa Merya", 3.5);
        album.addToAlbum("Naina", 4.0);

        list.add(album);
        album = new Album("Mohit Chauhan", "New Songs");

        album.addToAlbum("Tum hi ho", 4.0);
        album.addToAlbum("Kasoor", 3.5);
        album.addToAlbum("Nadan Prinday", 3.0);

        list.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();
        list.get(0).addSongToPlayList("Pathan", playlist_1);
        list.get(0).addSongToPlayList("Naina", playlist_1);
        list.get(1).addSongToPlayList("Kasoor", playlist_1);
        list.get(1).addSongToPlayList("Nadan Prinday", playlist_1);

        play(playlist_1);
    }
    public static void play(LinkedList<Song> playlist) {
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0) {
            return;
        }
        Scanner sc = new Scanner(System.in);
        playMenu();
        System.out.println("Now playing " + listIterator.next());
        boolean forward = true;
        boolean quit = false;

        while(quit == false) {
            int choice = sc.nextInt();
            switch (choice) {
                case 0 :
                    quit = true;
                    break;
                case 1 :
                    if(forward == false) {
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println(listIterator.next().toString());
                    }
                    else {
                        System.out.println("You are at the last song");
                    }
                    break;
                case 2 :
                    if(forward == true) {
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous().toString());
                    }
                    else System.out.println("You are already at the first song");
                    break;
                case 3 :
                    if(forward == true) {
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    }
                    else {
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    break;
                case 4 :
                    printAllSongs(playlist);
                    break;
                case 5 :
                    playMenu();
                    break;
                case 6 :
                    if(playlist.size() > 0) {
                        System.out.println(listIterator.previous().toString() + " has been removed from the playlist");
                        listIterator.remove();
                        if(playlist.size() > 0 && listIterator.hasPrevious()) {
                            System.out.println("Now Playing " + listIterator.next().toString());
                        }
                        else if(playlist.size() > 0 && listIterator.hasNext()) {
                            System.out.println("Now Playing " + listIterator.previous().toString());
                        }
                    }
                    else System.out.println("The playlist is already empty");
                    break;
            }
        }
    }
    private static void printAllSongs(LinkedList<Song> songs) {
        ListIterator<Song> listIterator = songs.listIterator();
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next().toString());
        }
    }
    public static void playMenu() {
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all song\n" +
                "5 - print all available options\n" +
                "6 - delete current song\n");
    }
}