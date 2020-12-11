package com.example.slowkajangielski;

public class IrregularVerb {
    private String infinitive, pastTense, pastParticiple;

    public IrregularVerb(String inf, String pTense, String pPart) {
        this.infinitive = inf;
        this.pastTense = pTense;
        this.pastParticiple = pPart;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getPastTense() {
        return pastTense;
    }

    public void setPastTense(String pastTense) {
        this.pastTense = pastTense;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public void setPastParticiple(String pastParticiple) {
        this.pastParticiple = pastParticiple;
    }
}
