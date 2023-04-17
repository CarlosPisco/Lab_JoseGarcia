package com.example.labjosegarcia.Repository;

import com.example.labjosegarcia.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query(nativeQuery = true, value="select * from doctor where hospital_id = ?1")
    List<Doctor> buscarDoctorFromHospital(Integer idHospital);

}
