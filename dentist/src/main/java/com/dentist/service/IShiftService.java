package com.dentist.service;

import com.dentist.dto.PatientDTO;
import com.dentist.dto.ShiftDTO;

import java.util.Set;

public interface IShiftService {

    void createShift(ShiftDTO shiftDTO);
    ShiftDTO readShift(Long id);
    void modifyShift(ShiftDTO shiftDTO);
    void deleteShift(Long id);

    Set<ShiftDTO> getAllShifts();

}
