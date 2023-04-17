package com.example.labjosegarcia.Controller;

import com.example.labjosegarcia.Repository.DoctorRepository;
import com.example.labjosegarcia.Repository.PacienteRepository;
import com.example.labjosegarcia.entity.Doctor;
import com.example.labjosegarcia.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/listar")
    public String listaPacientes (Model model) {
        List<Paciente> listapacientes = pacienteRepository.findAll();
        model.addAttribute("lista", listapacientes);

        return "paciente/lista";
    }



    @GetMapping("/editar")
    public String editarPaciente(Model model,
                                @RequestParam("id") Integer id){

        Optional<Paciente> optGame = pacienteRepository.findById(id);

        if(optGame.isPresent()){
            Paciente paciente = optGame.get();
            model.addAttribute("paciente",paciente);
            return "paciente/editar";
        }else{
            return "redirect:paciente/listar";
        }


    }

    @PostMapping("/guardar")
    public String guardarJuegos(@RequestParam ("id") Integer id1,
                                @RequestParam ("numeroHabitacion") Integer numeroHabitacion){

        pacienteRepository.cambiarHabitacion(numeroHabitacion,id1);
        return "redirect:/paciente/listar";
    }

    @GetMapping("/derivar")
    public String derivarPacientes (Model model){

        List<Doctor> listaDoctores = doctorRepository.findAll();

         model.addAttribute("lista",listaDoctores);
         return "paciente/derivar";
    }


    @PostMapping("/derivado")
    public String derivadoPacientes (@RequestParam ("id1") Integer id1,
                                     @RequestParam ("id2") Integer id2){

        pacienteRepository.derivarPaciente(id2,id1);
        return "redirect:/paciente/listar";

    }




}
