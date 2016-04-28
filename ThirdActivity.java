package com.etna.tiitytheboss.tic_mobi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThirdActivity extends AppCompatActivity {

    private ListView mangaListView;
    private JsonProcess process;
    private String mangaSite;
    private String genreValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setMangaListView((ListView) findViewById(R.id.mangaListView));

        setProcess(new JsonProcess());

        setMangaSite(getIntent().getStringExtra("mangaSite"));
        setGenreValue(getIntent().getStringExtra("genreValue"));

        getProcess().retrieveJson(getMangaSite(), getGenreValue(), 2, 2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, getProcess().getItemList());

        getMangaListView().setAdapter(adapter);
        getMangaListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String mangaValue = (String) getMangaListView()
                        .getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), FourthActivity.class);
                intent.putExtra("mangaSite", getMangaSite());
                intent.putExtra("genreValue", getGenreValue());
                intent.putExtra("mangaValue", mangaValue);
                startActivity(intent);
            }
        });
    }

    // GETTERS
    public ListView getMangaListView() {
        return mangaListView;
    }

    public JsonProcess getProcess() {
        return process;
    }

    public String getGenreValue() {
        return genreValue;
    }

    public String getMangaSite() {
        return mangaSite;
    }

    // SETTERS
    public void setProcess(JsonProcess process) {
        this.process = process;
    }

    public void setMangaListView(ListView mangaListView) {
        this.mangaListView = mangaListView;
    }

    public void setGenreValue(String genreValue) {
        this.genreValue = genreValue;
    }

    public void setMangaSite(String mangaSite) {
        this.mangaSite = mangaSite;
    }
}
