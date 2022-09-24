package com.dentist;

import static org.junit.jupiter.api.Assertions.*;

import com.dentist.dto.PatientDTO;
import com.dentist.entity.Patient;
import com.dentist.service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    private IPatientService patientService;

    @Test
    public void testCreatePatient(){

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setName("Julius");
        patientDTO.setSurname("Nessus");

        patientService.createPatient(patientDTO);

        PatientDTO patientJulius =  patientService.readPatient(1L);

        assertNotNull(patientJulius);

    }

}