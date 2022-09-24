package com.dentist.entity;

import net.minidev.json.annotate.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private Long dni;

    private String name;
    private String surname;
    private String residence;
    private String dischargeDate;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Shift> shifts;

    //region getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Set<Shift> getShiftSet() {
        return shifts;
    }

    public void setShiftSet(Set<Shift> shiftSet) {
        this.shifts = shiftSet;
    }

    //endregion
}
