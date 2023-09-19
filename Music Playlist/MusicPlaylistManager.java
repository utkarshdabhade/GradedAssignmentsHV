import java.util.Random;
import java.util.Scanner;

class Song {
    String title;
    String artist;
    String album;
    int duration;
    Song next;

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.next = null;
    }
}

class Playlist {
    Song head;
    int totalDuration;

    public Playlist() {
        head = null;
        totalDuration = 0;
    }

    public void addSongToPlaylist(String title, String artist, String album, int duration) {
        Song newSong = new Song(title, artist, album, duration);
        if (head == null) {
            head = newSong;
        } else {
            Song currentSong = head;
            while (currentSong.next != null) {
                currentSong = currentSong.next;
            }
            currentSong.next = newSong;
        }
        totalDuration += duration;
    }

    public void removeSongFromPlaylist(String titleToRemove) {
        if (head == null) {
            return;
        }

        if (head.title.equals(titleToRemove)) {
            totalDuration -= head.duration;
            head = head.next;
            return;
        }

        Song currentSong = head;
        Song prevSong = null;

        while (currentSong != null && !currentSong.title.equals(titleToRemove)) {
            prevSong = currentSong;
            currentSong = currentSong.next;
        }

        if (currentSong != null) {
            prevSong.next = currentSong.next;
            totalDuration -= currentSong.duration;
        }
    }

    public void moveSongToPosition(String titleToMove, int newPosition) {
    if (head == null || newPosition < 1) {
        return;
    }

    Song currentSong = head;
    Song prevSong = null;
    int currentPosition = 1;

    // Find the song to move and its current position
    while (currentSong != null && (currentPosition < newPosition || !currentSong.title.equals(titleToMove))) {
        prevSong = currentSong;
        currentSong = currentSong.next;
        currentPosition++;
    }

    if (currentSong == null || currentPosition != newPosition) {
        return; // Song not found or invalid position
    }

    // Remove the song from its current position
    if (prevSong == null) {
        head = currentSong.next;
    } else {
        prevSong.next = currentSong.next;
    }

    // Insert the song at the new position
    if (newPosition == 1) {
        currentSong.next = head;
        head = currentSong;
    } else {
        Song temp = head;
        for (int i = 1; i < newPosition - 1; i++) {
            temp = temp.next;
        }
        currentSong.next = temp.next;
        temp.next = currentSong;
    }
}


    public void displayPlaylist() {
        Song currentSong = head;
        while (currentSong != null) {
            System.out.println("Title: " + currentSong.title);
            System.out.println("Artist: " + currentSong.artist);
            System.out.println("Album: " + currentSong.album);
            System.out.println("Duration: " + currentSong.duration + " seconds\n");
            currentSong = currentSong.next;
        }
    }

    public int calculateTotalDuration() {
        return totalDuration;
    }




public void shufflePlaylist() {
    Song[] songs = new Song[calculateTotalDuration()];
    Song currentSong = head;
    int index = 0;

    // Copy songs to an array
    while (currentSong != null) {
        songs[index++] = currentSong;
        currentSong = currentSong.next;
    }

    Random random = new Random();

    // Shuffle the array
    for (int i = songs.length - 1; i > 0; i--) {
        int j = random.nextInt(i + 1);
        Song temp = songs[i];
        songs[i] = songs[j];
        songs[j] = temp;
    }

    // Rebuild the shuffled playlist
    head = null;
    totalDuration = 0;
    for (Song song : songs) {
        addSongToPlaylist(song.title, song.artist, song.album, song.duration);
    }
}
}


public class MusicPlaylistManager {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMusic Playlist Manager");
            System.out.println("1. Add Song to Playlist");
            System.out.println("2. Remove Song from Playlist");
            System.out.println("3. Display Playlist");
            System.out.println("4. Calculate Total Duration");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter album: ");
                    String album = scanner.nextLine();
                    System.out.print("Enter duration (in seconds): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    playlist.addSongToPlaylist(title, artist, album, duration);
                    break;
                case 2:
                    System.out.print("Enter the title of the song to remove: ");
                    String titleToRemove = scanner.nextLine();
                    playlist.removeSongFromPlaylist(titleToRemove);
                    break;
                case 3:
                    System.out.println("Playlist:");
                    playlist.displayPlaylist();
                    break;
                case 4:
                    int totalDuration = playlist.calculateTotalDuration();
                    System.out.println("Total Duration: " + totalDuration + " seconds");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
