package Übung_9;

/**
 * Created by Simon on 12.12.2016.
 */
public class PlayListMixerStart {

    public static void main(String[]args){
        PlayListMixer mix = new PlayListMixer();
        mix.readFile("PlaylistTest.txt");
        mix.writeToFile();
        for(String s : mix.allTracks){
            System.out.println(s);
        }
    }
}
