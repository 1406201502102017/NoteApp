package com.gb.android.noteapp;

import java.util.Random;

import com.gb.android.noteapp.R;

public class ImageConverterIndex {

    private static final Random rnd = new Random();
    private static final Object syncObj = new Object();

    private static final int[] picIndex = {
            R.drawable.logo1,
            R.drawable.logo2,
            R.drawable.logo3,
            R.drawable.logo4,
            R.drawable.logo5,
            R.drawable.logo6,
            R.drawable.logo7,
    };

    public static int randomImageIndex(){
        synchronized (syncObj){
            return rnd.nextInt(picIndex.length);
        }
    }

    public static int getImageByIndex(int index){
        if (index < 0 || index >= picIndex.length){
            index = 0;
        }
        return picIndex[index];
    }

    public static int getIndexByImage(int picture){
        for(int i = 0; i < picIndex.length; i++){
            if (picIndex[i] == picture){
                return i;
            }
        }
        return 0;
    }
}
