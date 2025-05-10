package demo.lab4_20206303.controller;
import jakarta.validation.constraints.*;
import demo.lab4_20206303.entity.*;
import demo.lab4_20206303.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/clinicas")
public class ClinicController {

    @Autowired
    private ClinicRepository clinicRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaClinicas", clinicRepo.findAll());
        return "clinicas/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("clinic", new Clinic());
        return "clinicas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("clinic") @Valid Clinic clinic, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "clinicas/formulario";
        }
        clinicRepo.save(clinic);
        return "redirect:/clinicas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("clinic", clinicRepo.findById(id).orElse(null));
        return "clinicas/formulario";
    }

    @GetMapping("/crear/{id}")
    public String crear(@PathVariable("id") Integer id) {
        clinicRepo.deleteById(id);
        return "redirect:/clinicas";
    }
}
