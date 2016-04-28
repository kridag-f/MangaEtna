package com.etna.tiitytheboss.tic_mobi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView sitesListView;
    private JsonProcess process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSitesListView((ListView) findViewById(R.id.sitesListView));

        setProcess(new JsonProcess());
        getProcess().retrieveJson(null, null, 0, 0);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, getProcess().getItemList());

        getSitesListView().setAdapter(adapter);

        getSitesListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String mangaSite = (String) getSitesListView()
                        .getItemAtPosition(position);
                // String comp = "mangastream.com";

                if (mangaSite.equals("mangastream.com")){

                    // On affiche ce texte avec un Toast
                    Toast.makeText(
                            getApplicationContext(),
                                mangaSite + " : Désolé, cette source n'est pas encore valide...", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("mangaSite", mangaSite);
                    startActivity(intent);
                }
            }

        });
    }

    public ListView getSitesListView() {
        return sitesListView;
    }

    public void setSitesListView(ListView sitesListView) {
        this.sitesListView = sitesListView;
    }

    public JsonProcess getProcess() {
        return process;
    }

    public void setProcess(JsonProcess process) {
        this.process = process;
    }
}