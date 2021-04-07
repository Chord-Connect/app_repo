package com.example.chordconnect;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("AR8iHouzxtoV8s5R1GFRGUUMCQXqEipH0URLVxMN")
                .clientKey("SIKqJXLM93Qnk3ii1FC6cADtM9k7TeLZ5fn5uw5c")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
