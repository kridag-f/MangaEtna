package com.etna.tiitytheboss.tic_mobi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {

    private ListView genreListView;
    private JsonProcess process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setGenreListView((ListView) findViewById(R.id.genreListView));

        setProcess(new JsonProcess());
        getProcess().retrieveJson(getIntent().getStringExtra("mangaSite"), null, 1, 1);

    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, getProcess().getItemList());

        getGenreListView().setAdapter(adapter);
        getGenreListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                    String genreValue = (String) getGenreListView()
                        .getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra("mangaSite", getIntent().getStringExtra("mangaSite"));
                intent.putExtra("genreValue", genreValue);
                startActivity(intent);
            }

        });
    }

    public ListView getGenreListView() {
        return genreListView;
    }

    public void setGenreListView(ListView genreListView) {
        this.genreListView = genreListView;
    }

    public JsonProcess getProcess() {
        return process;
    }

    public void setProcess(JsonProcess process) {
        this.process = process;
    }
}
