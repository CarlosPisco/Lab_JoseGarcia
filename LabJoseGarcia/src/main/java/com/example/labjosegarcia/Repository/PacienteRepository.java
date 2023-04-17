package com.example.labjosegarcia.Repository;

import com.example.labjosegarcia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    @Query(nativeQuery = true, value="select * from paciente where hospital_id =  ?1")
    List<Paciente> buscarPacienteFromHospital(Integer idHospital);


    @Query(nativeQuery = true, value="select * from paciente where doctor_id = ?1")
    List<Paciente> buscarPacienteFromDoctor(Integer idDoctor);

    @Query(nativeQuery = true,value="select * from paciente p  where fecha_cita< '2023-04-11 00:00:00' and  p.doctor_id =  ?1")
    List<Paciente> buscarPacienteAtencion (Integer idDoctor);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="update paciente set doctor_id = ?1 where doctor_id = ?2")
    void derivarPaciente (Integer idDoctor1, Integer idDoctor2);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="update paciente set numero_habitacion = ?1 where id = ?2")
    void cambiarHabitacion (Integer numHab, Integer idPaciente);

}
