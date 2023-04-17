package com.example.labjosegarcia.Repository;

import com.example.labjosegarcia.entity.Doctor;
import com.example.labjosegarcia.entity.Hospital;
import com.example.labjosegarcia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {




}
