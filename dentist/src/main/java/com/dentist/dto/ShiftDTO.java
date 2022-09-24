package com.dentist.dto;

import com.dentist.entity.Dentist;
import com.dentist.entity.Patient;

public class ShiftDTO {

    private String date;

    private Dentist dentist;
    private Patient patient;

    //region getters & setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    //endregion

}
