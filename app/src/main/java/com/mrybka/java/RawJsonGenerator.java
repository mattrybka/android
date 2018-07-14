package com.mrybka.java;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

public class RawJsonGenerator {

    public static final String TAG = RawJsonGenerator.class.getSimpleName();
    private final Gson gson;

    public RawJsonGenerator() {
        gson = new Gson();// biblioteka google do yamieninia json na POJO i odwrotnie
    }

    public <T> T getJsonFileAsClass(Context context, final int resId, final Class<T> classType) {
        InputStream resourceReader = context.getResources().openRawResource(resId);
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            return constructUsingGson(classType, writer.toString());
        } catch (Exception e) {
            Log.e(TAG, "getJsonFileAsClass: ", e);
            return null;
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                Log.e(TAG, "getJsonFileAsClass: ", e);
            }
        }
    }

    private <T> T constructUsingGson(final Class<T> type, final String jsonString) {
        return gson.fromJson(jsonString, type);
    }
}
