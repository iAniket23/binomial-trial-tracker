package com.example.cmput301assignment1;
// Class Trial
// Purpose: records number of success, number of failure , total trial and success rate of an
//          experiment
// Design Rationale: It consists of constructors and getters and setters with functions like
//          increaseSuccess.It exists independently of Class Experiments


public class Trials {
    private int success;
    private int fail;
    private int totalTrial;
    private float successRate;

    public Trials() {
        this.success = 0;
        this.fail = 0;
        this.totalTrial = 0;
        this.successRate = 0;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public int getTotalTrial() {
        return totalTrial;
    }

    public void setTotalTrial(int totalTrial) {
        this.totalTrial = totalTrial;
    }

    public float getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(float successRate) {
        this.successRate = successRate;
    }

    public void increaseSuccess(){
        success++;
        setSuccess(success);
    }

    public void increaseFail(){
        fail++;
        setFail(fail);
    }

    public void updateTotalTrial(){
        totalTrial = success + fail;
        setTotalTrial(totalTrial);
    }
    public void updateSuccessRate(){
        successRate = success/(float)totalTrial;
        setSuccessRate(successRate);
    }


}
