package pl.umcs.oop.music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {



    public Song atSecond(int seconds){
        if (seconds < 0) {
            throw new IndexOutOfBoundsException("negative time");
        }
        for (Song s : this){
            seconds -= s.duration();
            if(seconds <= 0){
                return s;
            }
        }
        throw new IndexOutOfBoundsException("beyond playtime");
    }
}
