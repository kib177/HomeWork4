package by.HomeWork.service;

import by.HomeWork.data.PlaylistRepository;
import by.HomeWork.model.Playlist;
import by.HomeWork.model.Song;

import java.util.List;

public class PlaylistService {
    private final PlaylistRepository repository = new PlaylistRepository();

    public void addSong(String email, Song song) {
        Playlist playlist = repository.getByUserEmail(email);
        playlist.addSong(song);
        repository.save(email, playlist);
    }

    public void removeSong(String email, String songId) {
        Playlist playlist = repository.getByUserEmail(email);
        playlist.removeSong(songId);
        repository.save(email, playlist);
    }

    public List<Song> getSongs(String email) {
        return repository.getByUserEmail(email).getSongs();
    }
}