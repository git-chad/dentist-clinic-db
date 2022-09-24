package com.dentist.service;

import com.dentist.dto.PatientDTO;

import java.util.Set;

public interface IPatientService {

    void createPatient(PatientDTO patientDTO);
    PatientDTO readPatient(Long id);
    void modifyPatient(PatientDTO patientDTO);
    void deletePatient(Long id);

    Set<PatientDTO> getAllPatients();

}
