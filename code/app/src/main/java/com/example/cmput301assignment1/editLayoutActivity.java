package com.example.cmput301assignment1;
// Class editLayoutActivity
// Purpose: to edit the experiment, and go back the MainActivity
// Design Rationale: It makes the code design clear and more simple to understand rather than using
//                  fragments
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class editLayoutActivity extends AppCompatActivity {
    public String pass_date = "Empty_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_layout);
        ArrayList<Experiments> experimentsDataList;
        experimentsDataList = ExperimentsManager.getInstance();

        TextView descriptionName = findViewById(R.id.edit_experiment_description);
        TextView dateValue = findViewById(R.id.edit_experiment_date);
        Button cancel = findViewById(R.id.cancel_button);
        Button ok = findViewById(R.id.ok_button);
        Intent intent = getIntent();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String descriptions = descriptionName.getText().toString();
                    String dates = dateValue.getText().toString();
                    int position = intent.getIntExtra("pos",0);

                    if(descriptions.length()!=0 & dates.length()!=0)
                    {
                        DateChecker(dates);
                        if(pass_date!="Empty_string"){
                            Experiments newExperiment;
                            newExperiment = experimentsDataList.get(position);

                            newExperiment.setDescription(descriptions);
                            newExperiment.setDate(dates);
                        }else{
                        }

                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(),"No Input",Toast.LENGTH_LONG);
                        toast.show();
                    }

                    home_activity(v);

            }
        });

    }

    public void home_activity(View view){
        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
   /* CITATION
    Ghayuh F P (https://stackoverflow.com/users/8565985/ghayuh-f-p)
    2021-02-05, cc-by-sa
    https://stackoverflow.com/questions/27580655/how-to-set-a-date-as-input-in-java
    */
    // Checking for correct format of date
    public void DateChecker(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try{
            newDate = dateFormat.parse(date);
            pass_date = new SimpleDateFormat("yyyy-MM-dd").format(newDate);

        } catch (ParseException e){
            Toast toast = Toast.makeText(getApplicationContext(),"Invalid Date Input",Toast.LENGTH_LONG);
            toast.show();
            pass_date = "Empty_string";
        }

    }
}