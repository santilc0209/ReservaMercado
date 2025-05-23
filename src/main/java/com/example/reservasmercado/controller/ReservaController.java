package com.example.reservasmercado.controller;

import com.example.reservasmercado.model.Reserva;
import com.example.reservasmercado.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", service.listarReservas());
        model.addAttribute("reserva", new Reserva());
        return "reservas";
    }

    @PostMapping
    public String crear(@ModelAttribute Reserva reserva) {
        service.crearReserva(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminarReserva(id);
        return "redirect:/reservas";
    }
}
