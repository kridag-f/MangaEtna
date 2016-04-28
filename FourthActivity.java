package com.etna.tiitytheboss.tic_mobi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FourthActivity extends AppCompatActivity {


    private ListView chaptersListView;
    private JsonProcess process;
    private String mangaSite;
    // Inutile ?
    private String genreValue;
    private String mangaValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        setChaptersListView((ListView) findViewById(R.id.chaptersListView));

        setProcess(new JsonProcess());

        setMangaSite(getIntent().getStringExtra("mangaSite"));
        // Inutile ?
        setGenreValue(getIntent().getStringExtra("genreValue"));
        setMangaValue(getIntent().getStringExtra("mangaValue"));

        getProcess().retrieveJson(getMangaSite(), getMangaValue(), 3, 3);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, getProcess().getItemList());

        getChaptersListView().setAdapter(adapter);
    }

    // GETTERS
    public ListView getChaptersListView() {
        return chaptersListView;
    }

    public JsonProcess getProcess() {
        return process;
    }

    public String getMangaSite() {
        return mangaSite;
    }

    public String getGenreValue() {
        return genreValue;
    }

    public String getMangaValue() {
        return mangaValue;
    }

    // SETTERS
    public void setChaptersListView(ListView chaptersListView) {
        this.chaptersListView = chaptersListView;
    }

    public void setProcess(JsonProcess process) {
        this.process = process;
    }

    public void setMangaSite(String mangaSite) {
        this.mangaSite = mangaSite;
    }

    public void setGenreValue(String genreValue) {
        this.genreValue = genreValue;
    }

    public void setMangaValue(String mangaValue) {
        this.mangaValue = mangaValue;
    }
}
