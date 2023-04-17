package com.example.labjosegarcia.Controller;

import com.example.labjosegarcia.Repository.DoctorRepository;
import com.example.labjosegarcia.Repository.PacienteRepository;
import com.example.labjosegarcia.entity.Doctor;
import com.example.labjosegarcia.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping(value="/doctor")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PacienteRepository pacienteRepository;


    @GetMapping("/listar")
    public String listadoctores (Model model) {
        List<Doctor> listadoctores = doctorRepository.findAll();
        model.addAttribute("lista", listadoctores);

        return "doctor/lista";
    }

    @GetMapping("/paci")
    public String pacientesDoctor (Model model,
                                   @RequestParam("id") Integer id) {
        List<Paciente> listaPacientesFromDoctor = pacienteRepository.buscarPacienteFromDoctor(id);
        model.addAttribute("lista", listaPacientesFromDoctor);

        return "doctor/paci";
    }

    @GetMapping("/cita")
    public String pacientesCitaDoctor (Model model,
                                       @RequestParam("id") Integer id) {
        List<Paciente> listaPacientesFromDoctorCita = pacienteRepository.buscarPacienteAtencion(id);
        model.addAttribute("lista", listaPacientesFromDoctorCita);

        return "doctor/cita";
    }










}
