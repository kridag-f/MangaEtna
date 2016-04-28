package com.etna.tiitytheboss.tic_mobi;

import android.provider.Settings;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by TiityTheBoSs on 28/04/2016.
 */
public class JsonProcess {

    private String[] itemList;
    private ConnectApi getApi;

    public JsonProcess() {

        setItemList(null);
        setGetApi(new ConnectApi());
    }

    public void retrieveJson(String choiceSite, String completChoice, Integer choiceRequest, Integer itemChoice) {

        JSONArray jsonData = null;
        JSONObject chapterJsonData = null;
        String fin = null;

        getApi.setChoiceSite(choiceSite);
        getApi.setCompleteChoice(completChoice);
        getApi.setChoiceRequest(choiceRequest);

        try {
            fin = getApi.execute().get();

            if (choiceRequest < 3) {

                jsonData = new JSONArray(fin);
                setItemList(new String[jsonData.length()]);
                String[] tmp = new String[jsonData.length()];

                for(Integer i = 0; i < jsonData.length(); i++) {
                    tmp[i] = jsonData.getJSONObject(i).getString((String) getApi.getGetItemChoice().get(itemChoice));
                }
                setItemList(tmp);
            } else {
                chapterJsonData = new JSONObject(fin);
                String[] tmp = new String[chapterJsonData.getJSONArray("chapters").length()];

                System.out.print(chapterJsonData.getJSONArray("chapters").getJSONObject(0));

                for(Integer j = 0; j < chapterJsonData.getJSONArray("chapters").length(); j++) {
                    tmp[j] = chapterJsonData.getJSONArray("chapters").getJSONObject(j).getString((String) getApi.getGetItemChoice().get(itemChoice));
                }
                setItemList(tmp);
            }

            // System.out.println(jsonData.getJSONObject(0).getString("genreId"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // GETTERS
    public ConnectApi getGetApi() {
        return getApi;
    }

    public String[] getItemList() {
        return itemList;
    }

    // SETTERS
    public void setItemList(String[] itemList) {
        this.itemList = itemList;
    }

    public void setGetApi(ConnectApi getApi) {
        this.getApi = getApi;
    }
}
