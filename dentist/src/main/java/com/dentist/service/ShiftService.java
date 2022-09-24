package com.dentist.service;

import com.dentist.dto.PatientDTO;
import com.dentist.dto.ShiftDTO;
import com.dentist.entity.Shift;
import com.dentist.entity.Shift;
import com.dentist.repository.IPatientRepository;
import com.dentist.repository.IShiftRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ShiftService implements IShiftService{

    @Autowired
    private IShiftRepository shiftRepository;

    @Autowired
    ObjectMapper mapper;

    Logger logger = Logger.getLogger(ShiftService.class);

    private void saveShift(ShiftDTO shiftDTO){

        Shift shift = mapper.convertValue(shiftDTO, Shift.class);
        shiftRepository.save(shift);
        logger.info("shift saved");

    }

    //region CRUD
    @Override
    public void createShift(ShiftDTO shiftDTO) {

        saveShift(shiftDTO);
        logger.info("shift created");

    }

    @Override
    public ShiftDTO readShift(Long id) {

        Optional<Shift> shift = shiftRepository.findById(id);
        ShiftDTO shiftDTO = null;

        logger.info("fetching shift by id");
        if (shift.isPresent())
            shiftDTO = mapper.convertValue(shift, ShiftDTO.class);

        return shiftDTO;

    }

    @Override
    public void modifyShift(ShiftDTO shiftDTO) {

        saveShift(shiftDTO);
        logger.info("shift modified");

    }

    @Override
    public void deleteShift(Long id) {

        shiftRepository.deleteById(id);
        logger.info("shift deleted");

    }

    @Override
    public Set<ShiftDTO> getAllShifts() {

        List<Shift> shifts = shiftRepository.findAll();

        Set<ShiftDTO> shiftsDTO = new HashSet<>();

        logger.info("fetching all shifts");
        for (Shift shift : shifts) {
            shiftsDTO.add(mapper.convertValue(shift, ShiftDTO.class));
        }

        return shiftsDTO;

    }
    //endregion
}
