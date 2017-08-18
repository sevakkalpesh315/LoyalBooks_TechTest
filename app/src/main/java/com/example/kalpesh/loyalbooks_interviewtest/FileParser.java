package com.example.kalpesh.loyalbooks_interviewtest;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalpesh on 17/08/2017.
 */

public class FileParser {

    /**
     * Helper Method to load words
     * @param filename File location
     * @return splitWords list of all words
     */

    public String[] readWords(String filename) {
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader bufferedReader = null;
        try{

            fIn = MyApplication.getAppContext().getResources().getAssets()
                    .open(filename, Context.MODE_PRIVATE);
            isr = new InputStreamReader(fIn);
            bufferedReader = new BufferedReader(isr);
            List<String> listOfWords = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[\\p{Punct}\\s]+");
                for(String word : words){
                    listOfWords.add(word.toLowerCase());
                }
            }
            bufferedReader.close();
            return listOfWords.toArray(new String[listOfWords.size()]);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;

    }

}
