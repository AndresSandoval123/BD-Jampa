package com.jampa.JampaApi.service;

import com.jampa.JampaApi.model.Venta;
import com.jampa.JampaApi.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServices {
    @Autowired //Inyectamos la dependencia del VentaServices
    private VentaRepository ventaRepository;

    //Método ver todas las ventas
    public List<Venta> getAllVentas(){
        return ventaRepository.findAll();
    }

    //Método agregar una venta
    public Venta addVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    //Método eliminar una venta
    public void eliminarVenta(Long id){
        ventaRepository.deleteById(id);
    }

    //buscar una sola venta
    public Venta findVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }
}
