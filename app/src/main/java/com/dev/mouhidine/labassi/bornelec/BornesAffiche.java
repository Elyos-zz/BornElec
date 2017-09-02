package com.dev.mouhidine.labassi.bornelec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Noussayr on 31/08/17.
 *
 * classe permettant d'afficher l'adresse de toutes les bornes autolib de France sur une ListVew
 */

public class BornesAffiche extends AppCompatActivity {

    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.affiche_bornes);

        listView = (ListView) findViewById(R.id.listView);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.item_layout);

        //Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(itemArrayAdapter);
        //listView.onRestoreInstanceState(state);


        // CSV
        InputStream inputStream = getResources().openRawResource(R.raw.bornes);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> scoreList = csvFile.read();

        for(String[] scoreData:scoreList ) {
            itemArrayAdapter.add(scoreData);
        }
    }


}

