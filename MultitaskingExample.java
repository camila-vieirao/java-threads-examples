package javathreadsexamples;

class MusicPlayer extends Thread {
    @Override
    public void run() {
        System.out.println("Playing music...");
        try {
            Thread.sleep(3000); // Simulate music playing for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Music stopped.");
    }
}

class PlaylistUpdater extends Thread {
    @Override
    public void run() {
        System.out.println("Updating playlist...");
        try {
            Thread.sleep(2000); // Simulate playlist update for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Playlist updated.");
    }
}

public class MultitaskingExample {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        PlaylistUpdater playlistUpdater = new PlaylistUpdater();

        // Start threads
        musicPlayer.start();
        playlistUpdater.start();
    }
}