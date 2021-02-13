package com.example.cmput301assignment1;
// Class Experiments
// Purpose: records number description, date and contains a Trail object
// Design Rationale: This is our class which get and set description, initialize Trial

public class Experiments {
    private String description;
    private String date;
    public Trials trials;

    public Experiments(String description, String date) {
        this.description = description;
        this.date = date;
        this.trials = new Trials();

    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(String date) {
        this.date = date;
    }

    String getDescription() {
        return this.description;
    }
    String getDate() {
        return this.date;
    }

}
