package com.jampa.JampaApi.service;

import com.jampa.JampaApi.model.Pedido;
import com.jampa.JampaApi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServices {

    @Autowired //Inyectamos la dependencia del PedidoRepository
    private PedidoRepository pedidoRepository;

    //Método ver todos los Pedidos de la lista
    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

    //Método agregar un pedido
    public Pedido addPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }


    //Método eliminar un pedido
    public void eliminarProducto(Long id){
        pedidoRepository.deleteById(id);
    }

    //buscar un pedido por id
    public Pedido findPedido(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    // editar un producto
    public void editPedido(Pedido pedido) {
        this.addPedido(pedido);
    }

//    public Pedido guardarPedido(Pedido pedido) {
//        // Aquí podrías realizar alguna lógica adicional antes de guardar
//        return pedidoRepository.save(pedido);
//    }
}
