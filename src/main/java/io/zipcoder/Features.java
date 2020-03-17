package io.zipcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class Features {

    Console console = new Console(System.in, System.out);
    private static ArrayList<Music> musicArrayList = new ArrayList<Music>();
    ListIterator<Song> listIterator;
    LinkedList<Song> playlist;
    boolean quit = false;
    boolean forward = true;

    public void addMusic(){
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

    public void addPlaylist() {
        LinkedList<Song> playlist = new LinkedList<Song>();
        musicArrayList.get(0).addToPlaylist("I Loved you", playlist);
        musicArrayList.get(0).addToPlaylist("Congratulations", playlist);
        musicArrayList.get(0).addToPlaylist("I Wait", playlist);
        musicArrayList.get(1).addToPlaylist(3, playlist);
        musicArrayList.get(1).addToPlaylist(7, playlist);
        musicArrayList.get(1).addToPlaylist(2, playlist);

        play(playlist);
    }


    public void play(LinkedList<Song> playlist) {
        this.listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }
    }


    public void mainFeature() {
        while (!this.quit) {
            int action = console.getIntegerInput("Enter a song number");
            console.println("", action);

            switch (action) {
                case 1:
                    forward();
                    break;
                case 2:
                    previous();
                    break;
                case 3:
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    System.out.println("Playlist complete.");
                    this.quit = true;
                    break;
            }
        }
    }


    public void forward() {
        if (!this.forward) {
            if (this.listIterator.hasNext()) this.listIterator.next();
        }
        this.forward = true;
        if (this.listIterator.hasNext()) {
            System.out.println("Now playing " + this.listIterator.next().toString());
        } else {
            System.out.println("You have reached the end of the playlist!");
            this.forward = false;
        }
    }


    public void previous() {
        if (forward) {
            if (listIterator.hasPrevious()) listIterator.previous();
            forward = false;
        }
        if (listIterator.hasPrevious()) {
            System.out.println("Now playing " + listIterator.previous().toString());
        } else {
            System.out.println("We are at the start of the playlist");
            this.forward = true;
        }
    }


    public void printMenu() {
        console.println("Press the following options for:");
        console.println("1 - to play next song\n" +
                            "2 - to play previous song\n" +
                            "3 - to replay the current song\n" +
                            "4 - show available actions" +
                            "5 - to quit");
    }
}
