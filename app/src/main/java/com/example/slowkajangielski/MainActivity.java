package com.example.slowkajangielski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mainList;
    private ArrayList<IrregularVerb> irregularVerbs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainList = findViewById(R.id.mainList);

        irregularVerbs = new ArrayList<>();
        irregularVerbs.add(new IrregularVerb("be", "was/were","been"));
        irregularVerbs.add(new IrregularVerb("become","became","become"));
        irregularVerbs.add(new IrregularVerb("begin","began","begun"));
        irregularVerbs.add(new IrregularVerb("break","broke","broken"));
        irregularVerbs.add(new IrregularVerb("bring","brought","brought"));
        irregularVerbs.add(new IrregularVerb("build","built","built"));
        irregularVerbs.add(new IrregularVerb("buy","bought","bought"));
        irregularVerbs.add(new IrregularVerb("catch","caught","caught"));
        irregularVerbs.add(new IrregularVerb("choose","chose","chosen"));
        irregularVerbs.add(new IrregularVerb("come","came","come"));

        IrregularVerbAdapter adapter = new IrregularVerbAdapter(this, irregularVerbs);
        mainList.setAdapter(adapter);
    }
}