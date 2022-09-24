package com.dentist.service;

import com.dentist.dto.DentistDTO;
import com.dentist.dto.PatientDTO;
import com.dentist.entity.Dentist;
import com.dentist.entity.Patient;
import com.dentist.repository.IDentistRepository;
import com.dentist.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService{

    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    Logger logger = Logger.getLogger(DentistService.class);

    private void saveDentist(DentistDTO dentistDTO){

        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
        logger.info("saved dentist in db");

    }

    //region CRUD
    @Override
    public void createDentist(DentistDTO dentistDTO) {

        saveDentist(dentistDTO);

    }


    @Override
    public DentistDTO readDentist(Long id) {

        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDTO dentistDTO = null;

        logger.info("fetching dentist by id");
        if (dentist.isPresent())
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);

        return dentistDTO;

    }

    @Override
    public void modifyDentist(DentistDTO dentistDTO) {

        saveDentist(dentistDTO);
        logger.info("dentist data modified");

    }

    @Override
    public void deleteDentist(Long id) {

        dentistRepository.deleteById(id);
        logger.info("dentist deleted");

    }

    @Override
    public Set<DentistDTO> getAllDentists() {

        List<Dentist> dentists = dentistRepository.findAll();

        Set<DentistDTO> dentistsDTO = new HashSet<>();

        logger.info("fetching all dentists");
        for (Dentist dentist : dentists) {
            dentistsDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }

        return dentistsDTO;

    }

    @Override
    public Set<DentistDTO> getDentistsWithSurnameLike(String surname) {

        Set<Dentist> allDentists = dentistRepository.getDentistsBySurnameLike(surname);
        Set<DentistDTO> allDentistsDTO = new HashSet<>();
        for (Dentist dentist : allDentists)
            allDentistsDTO.add(mapper.convertValue(dentist, DentistDTO.class));

        return allDentistsDTO;

    }

    //endregion
}
