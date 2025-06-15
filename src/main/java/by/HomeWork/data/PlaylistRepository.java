package by.HomeWork.data;

import by.HomeWork.model.Playlist;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PlaylistRepository {

        private static final Map<String, Playlist> storage = new ConcurrentHashMap<>();

        public Playlist getByUserEmail(String email) {
            return storage.computeIfAbsent(email, k -> new Playlist());
        }

        public void save(String email, Playlist playlist) {
            storage.put(email, playlist);
        }
    }