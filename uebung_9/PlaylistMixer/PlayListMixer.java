package Übung_9;

/**
 * Created by Simon on 09.12.2016.
 */

import java.io.*;
import java.util.Random;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;

public class PlayListMixer {
    BufferedWriter br;
    String track;
    ArrayList<String> allTracks;
    Path filePath;

    public PlayListMixer(){
        allTracks = new ArrayList<>();
    }

    public void writeToFile(){
        allTracks = mixAllTracks(allTracks);
        try{
            BufferedWriter br = Files.newBufferedWriter(filePath);
        }
        catch(IOException ioe){
            System.out.println("Problem with Creating the Writer");
        }
        for (String s : allTracks){
            try{
                System.out.println(s);
                
                //guess it will just add to the file ; need to delete the previous stuff
                br.write(s);
            }
            catch(Exception e){
                System.out.println("Writing problem");
            }
        }
    }
    public ArrayList<String> mixAllTracks(ArrayList<String> oldTracks){
        ArrayList<String> res= new ArrayList<>();
        Random r = new Random();
        int index;
        while(oldTracks.size()>0){
           index = r.nextInt(oldTracks.size());
           res.add(oldTracks.get(index));
           oldTracks.remove(index);
        }
        return res;
    }
    public void readFile(String fileName){
        BufferedReader br = null;
        String[] kek;
        boolean con = true;
        try {
            URL url = getClass().getResource(fileName);     
            filePath = Paths.get(url.toURI());
            
            //Seems like BufferedReader is beeing created, because no exceptions are thrown
            br = Files.newBufferedReader(filePath);
            
            //Using a Stream to get an Array-> But kek is always empty. Why is that?
            kek = br.lines().toArray(size->new String[size]);
            
            //Check if something in kek-Array -> not needed but for visualization
            for (int i = 0 ; i<kek.length ; i++){
                System.out.println(kek[i]);
            }
            // adding every element to the allTracks ArrayList
            for (int i = 0; i<kek.length;i++) {
                allTracks.add(kek[i]);
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("problem reading file");
        }
    }
}
