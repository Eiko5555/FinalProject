package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.ParcelUuid;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;
import com.example.showjokes.ShowJokes;
import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Pair
        <Context, String>, Void, String> {
    private static MyApi myApi = null;
    private Context context;
    private static final String KEY = "KEY";

    public EndpointAsyncTask(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
    if (myApi == null){
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api")
                .setGoogleClientRequestInitializer(
                        new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(
                                    AbstractGoogleClientRequest<?> request)
                                    throws IOException {
                                request.setDisableGZipContent(true);
                            }
                        });
        myApi = builder.build();
    }
    try {
        MyBean myBean = myApi.putJoke().execute();
        return myBean.getJoke();
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Intent intent = new Intent(context, ShowJokes.class);
        intent.putExtra(KEY, s);
        context.startActivity(intent);
    }
}
