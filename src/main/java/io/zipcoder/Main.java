package io.zipcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    private static ArrayList<Music> musicArrayList = new ArrayList<Music>();

    public static void main(String[] args) {
        addMusic();
        addPlaylist();

    }

    private static void addMusic(){
        Music music = new Music("MOONRISE", "SUNRISE");
        music.addSong("You Were Beautiful", 4.42);
        music.addSong("Shoot Me", 2.56);
        music.addSong("Sweet Chaos", 3.54);
        music.addSong("I Loved You", 3.29);
        music.addSong("Congratulations", 4.12);
        music.addSong("Time of Our Life", 4.09);
        music.addSong("Letting Go", 3.09);
        music.addSong("I Wait", 4.24);
        music.addSong("I smile", 3.49);
        musicArrayList.add(music);

        music = new Music("The Book of Us: Gravity", "Remember Us: Youth Part 2");
        music.addSong("When You Love Someone", 3.45);
        music.addSong("hurt road", 2.45);
        music.addSong("Not Fine", 3.23);
        music.addSong("Beautiful feeling", 4.20);
        music.addSong("I like you", 3.17);
        music.addSong("Somehow", 3.06);
        music.addSong("I Need Somebody", 3.49);
        music.addSong("Deep In Love", 4.08);
        musicArrayList.add(music);
    }

    private static void addPlaylist() {
        LinkedList<Song> playlist = new LinkedList<Song>();
        musicArrayList.get(0).addToPlaylist("hurt road", playlist);
        musicArrayList.get(0).addToPlaylist("Congratulations", playlist);
        musicArrayList.get(0).addToPlaylist("I Wait", playlist);
        musicArrayList.get(1).addToPlaylist(3, playlist);
        musicArrayList.get(1).addToPlaylist(7, playlist);
        musicArrayList.get(1).addToPlaylist(20, playlist);

        play(playlist);
    }

    private static void play(LinkedList<Song> playlist) {
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }
    }


}
