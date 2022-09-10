package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {


    // Initialize Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models
        ParseObject.registerSubclass(Post.class);


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("T2KUTfleJcncpgck6g2G8wSk63QTiMHs64kopkl4")
                .clientKey("qQtBz3moFcjR0GC0iWoDHDb6hYz0hteeafOSac3N")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
    }

