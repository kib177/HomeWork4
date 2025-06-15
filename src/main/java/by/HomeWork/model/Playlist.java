package by.HomeWork.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Playlist {
    //пробую двоюродного барта ConcurrentHashMap
    private final List<Song> songs = new CopyOnWriteArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(String title) {
        songs.removeIf(song -> song.getTitle().equals(title));
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs);
    }
}