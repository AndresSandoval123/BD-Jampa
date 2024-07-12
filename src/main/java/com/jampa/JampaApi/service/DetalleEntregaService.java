package com.jampa.JampaApi.service;

import com.jampa.JampaApi.dto.DetalleEntregaDTO;
import com.jampa.JampaApi.model.DetalleEntrega;
import com.jampa.JampaApi.model.Venta;
import com.jampa.JampaApi.repository.DetalleEntregaRepository;
import com.jampa.JampaApi.repository.VentaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleEntregaService {

    @Autowired
    private DetalleEntregaRepository detalleEntregaRepository;

    @Autowired
    private VentaServices ventaServices;

    public List<DetalleEntrega> getAllDetalles() {
        return detalleEntregaRepository.findAll();
    }

    public DetalleEntrega findDetalle(Long id) {
        return detalleEntregaRepository.findById(id).orElse(null);
    }

    // Método para agregar un detalle de entrega
    public DetalleEntrega agregarDetalleEntrega(DetalleEntregaDTO detalleDTO) {
        // Verificar si la venta asociada existe
        Venta venta = ventaServices.findVenta(detalleDTO.getId_venta());
        if (venta == null) {
            throw new EntityNotFoundException("No se encontró la venta con ID: " + detalleDTO.getId_venta());
        }

        //creamos el objeto DetalleEntrega a partir del DTO recibido
        DetalleEntrega detalleEntrega = new DetalleEntrega();
        detalleEntrega.setPersona_que_recibe(detalleDTO.getPersona_que_recibe());
        detalleEntrega.setDireccion_entrega(detalleDTO.getDireccion_entrega());
        detalleEntrega.setCiudad(detalleDTO.getCiudad());
        detalleEntrega.setTelefono_quien_recibe(detalleDTO.getTelefono_quien_recibe());
        detalleEntrega.setVenta(venta); // Asociar la venta al detalle de entrega

        // Guardar el detalle de entrega en la base de datos
        return detalleEntregaRepository.save(detalleEntrega);
    }


    // Método para convertir DetalleEntrega a DetalleEntregaDTO
    public DetalleEntregaDTO convertirADetalleEntregaDTO(DetalleEntrega detalle) {
        DetalleEntregaDTO detalleDTO = new DetalleEntregaDTO();
        detalleDTO.setId_entrega(detalle.getId_entrega());
        detalleDTO.setId_venta(detalle.getVenta().getId_venta());
        detalleDTO.setPersona_que_recibe(detalle.getPersona_que_recibe());
        detalleDTO.setDireccion_entrega(detalle.getDireccion_entrega());
        detalleDTO.setCiudad(detalle.getCiudad());
        detalleDTO.setTelefono_quien_recibe(detalle.getTelefono_quien_recibe());
        return detalleDTO;
    }

    // Implementación para actualizar un detalle de entrega

    public DetalleEntrega actualizarDetalleEntrega(Long idEntrega, DetalleEntregaDTO detalleEntregaDTO) {
        Optional<DetalleEntrega> detalleEntregaOptional = detalleEntregaRepository.findById(idEntrega);
        if (detalleEntregaOptional.isEmpty()) {
            throw new IllegalArgumentException("No se encontró detalle de entrega con ID: " + idEntrega);
        }

        DetalleEntrega detalleEntrega = detalleEntregaOptional.get();
        // Actualizar los campos del detalle de entrega
        detalleEntrega.setPersona_que_recibe(detalleEntregaDTO.getPersona_que_recibe());
        detalleEntrega.setDireccion_entrega(detalleEntregaDTO.getDireccion_entrega());
        detalleEntrega.setCiudad(detalleEntregaDTO.getCiudad());
        detalleEntrega.setTelefono_quien_recibe(detalleEntregaDTO.getTelefono_quien_recibe());

        return detalleEntregaRepository.save(detalleEntrega);
    }

    public Optional<DetalleEntrega> buscarPorId(Long idEntrega) {
        return detalleEntregaRepository.findById(idEntrega);
    }
}
