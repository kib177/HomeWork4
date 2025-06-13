package by.HomeWork.Service;

import by.HomeWork.Data.PlaylistData;
import by.HomeWork.Model.Song;

import java.util.Set;

public class PlaylistService {
    private final PlaylistData repository = PlaylistData.getInstance();

    public void addSong(String email, Song song) {
        repository.addSong(email, song);
    }

    public void removeSong(String email, Song song) {
        repository.removeSong(email, song);
    }

    public Set<Song> getSongs(String email) {
        return repository.getSongs(email);
    }
}
