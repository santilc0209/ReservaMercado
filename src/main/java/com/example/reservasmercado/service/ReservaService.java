package com.example.reservasmercado.service;

import com.example.reservasmercado.model.Reserva;
import com.example.reservasmercado.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> listarReservas() {
        return repository.findAll();
    }

    public Reserva crearReserva(Reserva reserva) {
        return repository.save(reserva);
    }

    public void eliminarReserva(Long id) {
        repository.deleteById(id);
    }
}
