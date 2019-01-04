package com.udacity.gradle.builditbigger.backend;
/** The object model for the data we are sending through endpoints */
import com.udacity.gradle.builditbigger.MyJokes;
public class MyBean {

    private String myData;
    private MyJokes myjokes;

    MyBean() {myjokes = new MyJokes();}

    public String getData() {
        return myData;
    }

    public String getJoke(){
        return myjokes.getJokes();
    }

    public void setData(String data) {
        myData = data;
    }
}