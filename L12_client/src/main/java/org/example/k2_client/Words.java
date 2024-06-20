package org.example.k2_client;

import java.time.LocalTime;

public class Words {
    String word;
    LocalTime time;

    public Words(String word, LocalTime time) {
        this.word = word;
        this.time = time;
    }

    public String getWord() {
        return word;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
