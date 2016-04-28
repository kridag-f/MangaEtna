package com.etna.tiitytheboss.tic_mobi;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Vector;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ConnectApi extends AsyncTask<String, Void, String> {

    private Integer choiceRequest;
    private String completeChoice;
    private String choiceSite;
    private Vector tableChoice;
    private Vector getItemChoice;

    public ConnectApi() {
        this.choiceRequest = null;
        this.completeChoice = null;
        this.choiceSite = null;
        this.tableChoice = new Vector();
        this.getItemChoice = new Vector();
    }

    @Override
    protected String doInBackground(String... params) {

        getItemChoice.add(0, "siteId");
        getItemChoice.add(1, "genreId");
        getItemChoice.add(2, "mangaId");
        getItemChoice.add(3, "chapterId");

        System.out.println(getCompleteChoice());

        tableChoice.add(0, "https://doodle-manga-scraper.p.mashape.com/");
        tableChoice.add(1, "https://doodle-manga-scraper.p.mashape.com/" + getChoiceSite() + "/search/genres");
        tableChoice.add(2, "https://doodle-manga-scraper.p.mashape.com/" + getChoiceSite() + "/search/genres/" + getCompleteChoice());
        tableChoice.add(3, "https://doodle-manga-scraper.p.mashape.com/" + getChoiceSite() + "/manga/" + getCompleteChoice());

        try {
            OkHttpClient http_client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url((String) getTableChoice().get(getChoiceRequest()))
                    .header("X-Mashape-Key", "mrjGSMrLCBmshHW41x8Q6lX8zbDrp1TNp5MjsnR4DiMov6ykzU")
                    .header("Accept", "text/plain")
                    .build();

            Response response = http_client.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.e("ConnectApi : ", e.getMessage());
            return "{}";
        }
    }




    // GETTERS
    public Integer getChoiceRequest() {
        return choiceRequest;
    }

    public String getCompleteChoice() {
        return completeChoice;
    }

    public Vector getTableChoice() {
        return tableChoice;
    }

    public Vector getGetItemChoice() {
        return getItemChoice;
    }

    public String getChoiceSite() {
        return choiceSite;
    }

    // SETTERS
    public void setChoiceRequest(Integer choiceRequest) {
        this.choiceRequest = choiceRequest;
    }

    public void setCompleteChoice(String completeChoice) {
        this.completeChoice = completeChoice;
    }

    public void setTableChoice(Vector tableChoice) {
        this.tableChoice = tableChoice;
    }

    public void setGetItemChoice(Vector getItemChoice) {
        this.getItemChoice = getItemChoice;
    }

    public void setChoiceSite(String choiceSite) {
        this.choiceSite = choiceSite;
    }
}

