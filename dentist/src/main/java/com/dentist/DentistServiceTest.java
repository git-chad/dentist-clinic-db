package com.dentist;

import com.dentist.dto.DentistDTO;
import com.dentist.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    IDentistService dentistService;

    @Test
    public void testGetDentistsWithSurnameLike(){

        DentistDTO dentist = new DentistDTO();
        dentist.setSurname("TestSrNm");
        dentist.setName("TestNm");

        dentistService.createDentist(dentist);
        Set<DentistDTO> dentists = dentistService.getDentistsWithSurnameLike("Test");

        boolean result = dentists.size() > 0;

        assertTrue(result);

    }

}