package com.ycwang.moduleapp.test;

import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * @author ycwang.
 * @date 2018-9-21.
 */
public class ExternalStorage {

    /**
     * Checks if external storage is available for read and write
     *
     * @return true:available
     */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if external storage is available to at least read
     *
     * @return true:available
     */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * creates a directory for a new photo album in the public pictures directory
     *
     * @param albumName
     * @return
     */
    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("TAG", "Directory not created");
        }
        return file;
    }

}
