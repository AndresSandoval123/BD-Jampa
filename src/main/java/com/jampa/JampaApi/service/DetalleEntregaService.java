package com.jampa.JampaApi.service;

import com.jampa.JampaApi.model.DetalleEntrega;
import com.jampa.JampaApi.repository.DetalleEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleEntregaService {

    @Autowired //Inyectamos la dependencia del DetalleEntregaRepository
    private DetalleEntregaRepository detalleEntregaRepository;

    //Método ver todos los detalles pedidos de la las ventas
    public List<DetalleEntrega> getAllDetEntrega(){
        return detalleEntregaRepository.findAll();
    }

    //Método detalle de entrega
    public DetalleEntrega addDetEntregaPedido(DetalleEntrega detalle){
        return detalleEntregaRepository.save(detalle);
    }

    //Método eliminar un pedido
    public void eliminarDetEntregaPedido(Long id){
        detalleEntregaRepository.deleteById(id);
    }

    //buscar un detalle de entrega de pedido por id
    public DetalleEntrega findDetEntregaPedido(Long id) {
        return detalleEntregaRepository.findById(id).orElse(null);
    }

    // editar un producto
    public void editDetEntregaPedido(DetalleEntrega pedido) {
        this.addDetEntregaPedido(pedido);
    }
}
