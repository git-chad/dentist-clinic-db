package com.dentist.service;

import com.dentist.dto.PatientDTO;
import com.dentist.entity.Patient;
import com.dentist.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    Logger logger = Logger.getLogger(PatientService.class);

    private void savePatient(PatientDTO patientDTO){

        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
        logger.info("patient saved in db");

    }

    //region CRUD
    @Override
    public void createPatient(PatientDTO patientDTO) {

        savePatient(patientDTO);
        logger.info("patient created");

    }

    @Override
    public PatientDTO readPatient(Long id) {

        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;

        logger.info("fetching patient by id");
        if (patient.isPresent())
            patientDTO = mapper.convertValue(patient, PatientDTO.class);

        return patientDTO;

    }

    @Override
    public void modifyPatient(PatientDTO patientDTO) {

        savePatient(patientDTO);
        logger.info("patient modified");

    }

    @Override
    public void deletePatient(Long id) {

        patientRepository.deleteById(id);
        logger.info("patient deleted");

    }

    @Override
    public Set<PatientDTO> getAllPatients() {

        List<Patient> patients = patientRepository.findAll();

        Set<PatientDTO> patientsDTO = new HashSet<>();

        logger.info("fetching all patients");
        for (Patient patient : patients) {
            patientsDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }

        return patientsDTO;

    }
    //endregion
}
