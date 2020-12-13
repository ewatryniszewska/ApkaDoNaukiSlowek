package com.example.slowkajangielski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mainList;
    private ArrayList<IrregularVerb> irregularVerbs;
    private RadioButton rInfinitive, rTense, rParticiple;
    private Button test, reset;
    private IrregularVerbAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainList = findViewById(R.id.mainList);
        rInfinitive = findViewById(R.id.radioInf);
        rTense = findViewById(R.id.radioTense);
        rParticiple = findViewById(R.id.radioPart);

        rInfinitive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    adapter.setState(1);
                }
            }
        });

        rTense.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    adapter.setState(2);
                }
            }
        });

        rParticiple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    adapter.setState(3);
                }
            }
        });

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

        adapter = new IrregularVerbAdapter(this, irregularVerbs);
        mainList.setAdapter(adapter);
    }

    public void resetList(View view) {
        rInfinitive.setChecked(false);
        rTense.setChecked(false);
        rParticiple.setChecked(false);

        adapter.checkAnswers(false);
        adapter.setState(0);
    }

    public void test(View view) {
        adapter.checkAnswers(true);
    }
}