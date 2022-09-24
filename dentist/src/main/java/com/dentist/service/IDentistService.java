package com.dentist.service;

import com.dentist.dto.DentistDTO;
import com.dentist.dto.PatientDTO;
import com.dentist.entity.Dentist;

import java.util.Set;

public interface IDentistService {

    void createDentist(DentistDTO dentistDTO);
    DentistDTO readDentist(Long id);
    void modifyDentist(DentistDTO dentistDTO);
    void deleteDentist(Long id);

    Set<DentistDTO> getAllDentists();

    Set<DentistDTO> getDentistsWithSurnameLike(String surname);

}
