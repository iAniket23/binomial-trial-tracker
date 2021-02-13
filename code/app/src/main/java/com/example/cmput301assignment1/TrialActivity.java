package com.example.cmput301assignment1;
// Class TrialActivity
// Purpose: It is a gui component used to show success, failure, total trial , success rate and
//          and provide user to edit , delete or go back to main activity features
// Design Rationale: Making this activity makes us to show a particular experiment in detail

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TrialActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);

        // using singleton method to access the Array
        ArrayList<Experiments> experimentsDataList;
        experimentsDataList = ExperimentsManager.getInstance();

        // Getting the intent
        Intent intent = getIntent();
        int position = (int) intent.getIntExtra("pos",0);
        Experiments transferred_object = experimentsDataList.get(position);


        // Assigning the TextView and buttons
        TextView description_name   = (TextView)findViewById(R.id.experiment_name);
        TextView total_trial_value  = (TextView)findViewById(R.id.total_trial);
        TextView success_rate_value = (TextView)findViewById(R.id.success_rate);
        TextView success_number     = (TextView)findViewById(R.id.success_number);
        TextView fail_number        = (TextView)findViewById(R.id.fail_number);

        Button success  = (Button)findViewById(R.id.success);
        Button fail     = (Button)findViewById(R.id.fail);
        Button delete   = (Button)findViewById(R.id.delete);
        Button edit     = (Button)findViewById(R.id.edit);

        // Setting the value to display

            // description name
            description_name.setText(transferred_object.getDescription());

            // total trial
            total_trial_value.setText(String.valueOf(transferred_object.trials.getTotalTrial()));

            // Success Rate
            float value = transferred_object.trials.getSuccessRate();
            String str = String.format("%.2f",value);
            success_rate_value.setText(str);

            // success
            success_number.setText(String.valueOf(transferred_object.trials.getSuccess()));

            // fail
            fail_number.setText(String.valueOf(transferred_object.trials.getFail()));

        // Setting on click listener
            success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increasing success
                transferred_object.trials.increaseSuccess();

                // updating Total trial and success rate
                transferred_object.trials.updateTotalTrial();
                transferred_object.trials.updateSuccessRate();

                // Setting up text to display
                success_number.setText(String.valueOf(transferred_object.trials.getSuccess()));
                total_trial_value.setText(String.valueOf(transferred_object.trials.getTotalTrial()));
                float value = transferred_object.trials.getSuccessRate();
                String str = String.format("%.2f",value);
                success_rate_value.setText(str);
                }
            });


            fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increasing fail
                transferred_object.trials.increaseFail();

                // updating total trial and success rate
                transferred_object.trials.updateTotalTrial();
                transferred_object.trials.updateSuccessRate();

                // Setting up text to display
                fail_number.setText(String.valueOf(transferred_object.trials.getFail()));
                total_trial_value.setText(String.valueOf(transferred_object.trials.getTotalTrial()));
                float value = transferred_object.trials.getSuccessRate();
                String str = String.format("%.2f",value);
                success_rate_value.setText(str);

                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    experimentsDataList.remove(position);
                    main_activity(v);
                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TrialActivity.this, editLayoutActivity.class);
                    intent.putExtra("Edit",1);
                    startActivity(intent);
                }
            });

    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    // To return back to the main activity
    public void main_activity(View view){
        this.finish();

    }


}