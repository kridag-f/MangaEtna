package com.etna.tiitytheboss.tic_mobi;

import android.widget.ListView;

import org.json.JSONArray;

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
        String fin = null;

        getApi.setChoiceSite(choiceSite);
        getApi.setCompleteChoice(completChoice);
        getApi.setChoiceRequest(choiceRequest);

        try {
            fin = getApi.execute().get();
            jsonData = new JSONArray(fin);

            setItemList(new String[jsonData.length()]);
            String[] tmp = new String[jsonData.length()];

            if (choiceRequest < 3) {
                for(Integer i = 0; i < jsonData.length(); i++) {
                    tmp[i] = jsonData.getJSONObject(i).getString((String) getApi.getGetItemChoice().get(itemChoice));
                }
                setItemList(tmp);
            } else {
                // Faire le tableau de string pour les chapitres vu que l'api return un JSONArray
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
