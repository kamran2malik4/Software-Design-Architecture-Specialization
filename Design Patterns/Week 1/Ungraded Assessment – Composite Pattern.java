/* You have been asked to create a playlist application that will be used on Android devices (using the Java language). 
   We will assume that each playlist can be composed of songs or other playlists, or a combination of both.

   Your project manager has told you that the composite pattern is best used in this situation. 
   The following UML class diagram that communicates the application’s objects and relationships using the composite pattern.

   In this assignment you are required to complete the provided code. 
   (Note: With the exception of the Playlist class, you do not need to actually implement the methods, just write filler comments (eg., // play song).
    With the Playlist class, write out the method to add songs to the playlist). */

import java.util.ArrayList;

interface IMusic{
    public void play();
    public void setPlaybackSpeed(float speed);
    public String getName();
}

class Song implements IMusic{
    private String name;
    private String artist;
    private float speed;
    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.speed = 1.0f;
    }

    @Override
    public void play() {
        System.out.println("Playing: " + name + " by: " + artist + ".");
    }

    @Override
    public void setPlaybackSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getArtist(){
        return artist;
    }
}

class Playlist implements IMusic{
    private String name;
    private ArrayList<IMusic> music;
    public Playlist(String name){
        this.name = name;
        music = new ArrayList();
    }
    public void addMusic(IMusic music){
        this.music.add(music);
    }
    public void removeMusic(IMusic music){
        this.music.remove(music);
    }
    @Override
    public void play() {
        for(int i = 0; i < music.size(); i++){
            music.get(i).play();
        }
    }
    @Override
    public void setPlaybackSpeed(float speed) {
        for(int i = 0; i < music.size(); i++){
            music.get(i).setPlaybackSpeed(speed);
        }
    }
    @Override
    public String getName() {
        return this.name;
    }
}

// Client class
public class App {
    public static void main(String[] args) {
        Song song1 = new Song("One", "Henson");
        Song song2 = new Song("Two", "Sahara");

        Playlist list1 = new Playlist("ListOne");
        list1.addMusic(song1);
        list1.addMusic(song2);

        Playlist mainList = new Playlist("Main");

        mainList.addMusic(list1);

        mainList.addMusic(new Song("Three", "Tnbee"));

        mainList.addMusic(new Song("Four", "Mellow"));

        mainList.play();
        

    }
}
