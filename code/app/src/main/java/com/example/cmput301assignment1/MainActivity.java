package com.example.cmput301assignment1;
// Class MainActivity
// Purpose: It is a gui component. It shows list of experiments, allows user to add experiments
// Design Rationale: This is our initial screen.

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements experimentFragment.OnFragmentInteractionListener{

    // Declare the variables so that you will be able to reference it later.
    ListView experimentList;
    ArrayList<Experiments> experimentsDataList;
    ArrayAdapter<Experiments> experimentsArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning to the list view
        experimentList = findViewById(R.id.experiment_list);

        // Making an Array using a singleton format class
        experimentsDataList = ExperimentsManager.getInstance();

        // Making custom ArrayAdapter
        experimentsArrayAdapter = new CustomList(this, experimentsDataList);

        // Setting ArrayAdapter
        experimentList.setAdapter(experimentsArrayAdapter);

        // Assigning add experiment Button
        Button addExperimentButton = findViewById(R.id.add_experiment_button);

        // Adding functionality to the addExperimentButton
        addExperimentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new experimentFragment().show(getSupportFragmentManager(), "ADD_EXPERIMENTS");
            }
        });

        // Starting TrialActivity when any item of experimentList is clicked
        experimentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,TrialActivity.class);
                // Sending position of the item clicked
                intent.putExtra("pos",position);

                startActivity(intent);
            }
        });
    }

    // To Update when Activities are switched
    @Override
    protected void onResume() {
        experimentsArrayAdapter.notifyDataSetChanged();
        super.onResume();
    }

   // onOkPressed function called from experimentFragment in order to make a new experiment
   @Override
    public void onOkPressed(Experiments newExperiments) {
       experimentsArrayAdapter.add(newExperiments);
    }


}
