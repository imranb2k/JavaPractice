package com.ibapp.domain;

/**
 * Created by imranbordiwala on 08/05/2015.
 */
public class Product {

    private Boolean sectionA;
    private Boolean sectionB;
    private Boolean state;

    public Boolean getSectionA() { return sectionA; }

    public void setSectionA(Boolean sectionA) {
        this.sectionA = sectionA;
    }

    public Boolean getSectionB() {
        return sectionB;
    }

    public void setSectionB(Boolean sectionB) {
        this.sectionB = sectionB;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
