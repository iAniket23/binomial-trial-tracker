package com.example.cmput301assignment1;
// Class experimentFragment
// Purpose: it is a gui component, which allows us to add new experiment using DialogFragments
// Design Rationale: It gives a alert dialog when user tries to enter a new experiment
/* CITATION
Abdul Ali Bangash, "Lab 3"
2021-02-04, Public Domain
 https://eclass.srv.ualberta.ca/pluginfile.php/6713984/mod_resource/content/0/Lab%203%20Instructions%20Slide.pdf
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class experimentFragment extends DialogFragment {
    private EditText descriptionName;
    private EditText dateValue;
    private OnFragmentInteractionListener listener;
    public String pass_date = "Empty_string";

    public interface OnFragmentInteractionListener {

        void onOkPressed(Experiments experiments);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.experiment_fragment_layout, null);
        descriptionName = view.findViewById(R.id.edit_experiment_description);
        dateValue = view.findViewById(R.id.edit_experiment_date);
        // Setting up Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Add Experiment")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Not taking any action if any field is left empty
                        String descriptions = descriptionName.getText().toString();
                        String dates = dateValue.getText().toString();
                        if(descriptions.length() != 0 & dates.length()!=0){
                            DateChecker(dates);
                            if(pass_date != "Empty_string"){
                                listener.onOkPressed(new Experiments(descriptions, pass_date));
                            }else{}
                        }else {
                            Toast toast = Toast.makeText(getContext(),"Wrong Input",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }}).create();
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
            Toast toast = Toast.makeText(getContext(),"Invalid Date Input",Toast.LENGTH_LONG);
            toast.show();
            pass_date = "Empty_string";

        }


    }
}