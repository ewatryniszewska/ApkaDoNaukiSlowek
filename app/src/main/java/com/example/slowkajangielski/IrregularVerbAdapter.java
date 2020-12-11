package com.example.slowkajangielski;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class IrregularVerbAdapter extends ArrayAdapter<IrregularVerb> {
    private Context context;
    private ArrayList<IrregularVerb> verbs;

    public IrregularVerbAdapter(Context context, ArrayList<IrregularVerb> verbs){
        super(context, R.layout.verb_layout, verbs);

        this.context = context;
        this.verbs = verbs;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.verb_layout, parent, false);

        TextView infinitiveVerb = rowView.findViewById(R.id.infinitive);
        TextView pastTenseVerb = rowView.findViewById(R.id.pastTense);
        TextView pastPartVerb = rowView.findViewById(R.id.pastParticiple);

        infinitiveVerb.setText(verbs.get(position).getInfinitive());
        pastTenseVerb.setText(verbs.get(position).getPastTense());
        pastPartVerb.setText(verbs.get(position).getPastParticiple());

        return rowView;
    }
}
