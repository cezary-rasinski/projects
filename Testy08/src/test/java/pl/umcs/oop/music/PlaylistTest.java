package pl.umcs.oop.music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {


    @Test //for a function to become a test we need to add a decorator (@Test)
    public void testIfNewPlaylistIsEmpty() {
        Playlist playlist = new Playlist();

        //we test using assert functions
        assertTrue(playlist.isEmpty());
    }

    @Test
    public void testIfHasOneSong() {
        Song song = new Song("billie", "bury", 34);
        Playlist playlist = new Playlist();
        playlist.add(song);

        assertTrue(playlist.size() == 1);
        //assertEquals(1, playlist.size());
    }

    @Test
    public void testIfHasSameSong() {
        Song song = new Song("billie", "bury", 34);
        Playlist playlist = new Playlist();
        playlist.add(song);

        assertTrue(playlist.contains(song));
    }

    @Test
    void atSecond() {
        Song song1 = new Song("billie", "bury", 50);
        Song song2 = new Song("not_billie", "friend", 40);
        Playlist playlist = new Playlist();
        playlist.add(song1);
        playlist.add(song2);
        int seconds = 35;
        assertEquals(song1, playlist.atSecond(seconds));
    }

    @Test
    public void atSecondThrowException() {
        Song song1 = new Song("billie", "bury", 50);
        Song song2 = new Song("not_billie", "friend", 40);
        Playlist playlist = new Playlist();
        playlist.add(song1);
        playlist.add(song2);
        int seconds = 100;
        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    playlist.atSecond(seconds);
                }
        );
        //understand how it exactly works
    }

    @Test
    public void atSecondThrowExceptionNegativeTime() {
        Song song1 = new Song("billie", "bury", 50);
        Song song2 = new Song("not_billie", "friend", 40);
        Playlist playlist = new Playlist();
        playlist.add(song1);
        playlist.add(song2);
        int seconds = -100;
        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    playlist.atSecond(seconds);
                },"negative time"
                );
    }
}