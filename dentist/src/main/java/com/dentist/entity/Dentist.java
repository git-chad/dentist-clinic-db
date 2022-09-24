package com.dentist.entity;


import net.minidev.json.annotate.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Dentists")
public class Dentist {

    @Id
    @GeneratedValue
    private Long id;

    private Long regNumber;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Shift> shifts;

    //region getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Long regNumber) {
        this.regNumber = regNumber;
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

    public Set<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(Set<Shift> shifts) {
        this.shifts = shifts;
    }

    //endregion

}

