package com.example.labjosegarcia.Controller;

import com.example.labjosegarcia.Repository.DoctorRepository;
import com.example.labjosegarcia.Repository.HospitalRepository;
import com.example.labjosegarcia.Repository.PacienteRepository;
import com.example.labjosegarcia.entity.Doctor;
import com.example.labjosegarcia.entity.Hospital;
import com.example.labjosegarcia.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="hospital")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PacienteRepository pacienteRepository;



    @GetMapping("/listar")
    public String listahospitales (Model model) {
        List<Hospital> listahospitales = hospitalRepository.findAll();
        model.addAttribute("lista", listahospitales);

        return "hospital/lista";
    }

    @GetMapping("/doct")
    public String mostrarDoctoresHospital(Model model,
                                          @RequestParam("id") Integer id){

        List<Doctor> listaDoctoresDeHospital =doctorRepository.buscarDoctorFromHospital(id);
        model.addAttribute("lista",listaDoctoresDeHospital);


        return "hospital/doct";
    }

    @GetMapping("/paci")
    public String mostrarPacientesHospital(Model model,
                                          @RequestParam("id") Integer id){

        List<Paciente> listaPacienteDeHospital =pacienteRepository.buscarPacienteFromHospital(id);
        model.addAttribute("lista",listaPacienteDeHospital);
        return "hospital/paci";
    }




}
