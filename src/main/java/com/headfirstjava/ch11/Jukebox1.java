package com.headfirstjava.ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jukebox1 {
    public static void main(String[] args) {
        new Jukebox1().go();
    }

    public void go() {
        List<SongV2> songList = MockSongs.getSongV2();
        System.out.println(songList);

        // compile error
        //Collections.sort(songList);
        //System.out.println(songList);
    }
}

class SongV2 {
    private String title;
    private String artist;
    private int bpm;

    SongV2(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getBpm() {
        return bpm;
    }
    public String toString() {
        return title;
    }
}

// 아래 있는 건 '모의' 코드. (Mock)
// 다른 프로그래머가 나중에 만들어서 줄 진짜 I/O 코드 대신 임시로 끼워넣어 사용할 코드.
class MockSongs {
    public static List<String> getSongStrings() {
        // <> : 다이아몬드 연산자.
        // 우측에 <> 로 표시한 건 컴파일러가 타입 추론 (type inference) 기능을 이용하여 추론.
        List<String> songs = new ArrayList<>();
        songs.add("somersault");
        songs.add("cassidy");
        songs.add("$10");
        songs.add("havana");
        songs.add("Cassidy");
        songs.add("50 Ways");
        return songs;
    }

    public static List<SongV2> getSongV2() {
        List<SongV2> songs = new ArrayList<>();
        songs.add(new SongV2("somersault", "zero 7", 147));
        songs.add(new SongV2("cassidy", "grateful dead", 158));
        songs.add(new SongV2("$10", "hitchhiker", 140));

        songs.add(new SongV2("havana", "cabello", 105));
        songs.add(new SongV2("Cassidy", "grateful dead", 158));
        songs.add(new SongV2("50 ways", "simon", 102));
        return songs;
    }
}
