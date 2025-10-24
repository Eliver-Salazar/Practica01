package cr.ufide.practica01.controller;

import cr.ufide.practica01.domain.Arbol;
import cr.ufide.practica01.service.ArbolService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/arboles")
public class ArbolController {

    private final ArbolService service;

    public ArbolController(ArbolService service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public String listar(@RequestParam(required = false) String q, Model model) {
        model.addAttribute("q", q);
        model.addAttribute("arboles", service.listar(q)); // o Collections.emptyList() si quieres probar
        return "arbol/lista"; // -> src/main/resources/templates/arbol/lista.html
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "arbol/form";
    }

    @PostMapping
    public String guardar(@Valid @ModelAttribute Arbol arbol, BindingResult br) {
        if (br.hasErrors()) {
            return "arbol/form";
        }
        service.guardar(arbol);
        return "redirect:/arboles";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        var a = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Árbol no encontrado"));
        model.addAttribute("arbol", a);
        return "arbol/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/arboles";
    }
}
