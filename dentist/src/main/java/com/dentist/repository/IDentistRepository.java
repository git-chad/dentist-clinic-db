package com.dentist.repository;

import com.dentist.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {

    @Query("from Dentist where d.surname like %:surname")
    Set<Dentist> getDentistsBySurnameLike(@Param("surname") String surname);

}
