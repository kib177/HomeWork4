package by.HomeWork.Data;

import by.HomeWork.Model.Song;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PlaylistData {
    private static final PlaylistData instance = new PlaylistData();
    private final Map<String, Set<Song>> userPlaylists = new ConcurrentHashMap<>();

    private PlaylistData() {}

    public static PlaylistData getInstance() {
        return instance;
    }

    public void addSong(String email, Song song) {
        userPlaylists.computeIfAbsent(email, k -> ConcurrentHashMap.newKeySet()).add(song);
    }

    public void removeSong(String email, Song song) {
        if (userPlaylists.containsKey(email)) {
            userPlaylists.get(email).remove(song);
        }
    }

    public Set<Song> getSongs(String email) {
        return userPlaylists.getOrDefault(email, Collections.emptySet());
    }
}