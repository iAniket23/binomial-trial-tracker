package com.example.cmput301assignment1;
// Class CustomList
// Purpose: inflates the view , sets value to the corresponding gui component
// Design Rationale: This is custom Adapter for our Class object

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomList extends ArrayAdapter<Experiments> {

    private ArrayList<Experiments> experiments;
    private Context context;

    public CustomList(Context context, ArrayList<Experiments> experiments) {
        super(context,0, experiments);
        this.experiments = experiments;
        this.context = context;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content,parent,false);
        }

        Experiments experiment_object = this.experiments.get(position);

        // Assigning the textView with the appropriate id
        TextView descriptionName = view.findViewById(R.id.description_text);
        TextView dateValue = view.findViewById(R.id.date_text);
        TextView totalTrialValue = view.findViewById(R.id.total_trial_integer);
        TextView successRateValue = view.findViewById(R.id.success_rate_integer);

        // Setting up the text to display
        descriptionName.setText(experiment_object.getDescription());
        dateValue.setText(experiment_object.getDate());
        totalTrialValue.setText(String.valueOf(experiment_object.trials.getTotalTrial()));
        float value = experiment_object.trials.getSuccessRate();
        String str = String.format("%.2f",value);
        successRateValue.setText(str);

        return view;
    }

}
