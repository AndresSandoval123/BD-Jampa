package com.jampa.JampaApi.service;

import com.jampa.JampaApi.model.Pedido;
import com.jampa.JampaApi.model.Producto;
import com.jampa.JampaApi.model.Usuario;
import com.jampa.JampaApi.repository.PedidoRepository;
import com.jampa.JampaApi.repository.ProductoRepository;
import com.jampa.JampaApi.repository.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServices {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<PedidoDTO> getAllPedidosDTO() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDTO> pedidosDTO = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            PedidoDTO pedidoDTO = new PedidoDTO();

            pedidoDTO.setId_pedido(pedido.getId_pedido());
            pedidoDTO.setCantidad(pedido.getCantidad());
            pedidoDTO.setNombre_usuario(pedido.getUsuario().getNombre_usuario());
            pedidoDTO.setNombre_producto(pedido.getProducto().getNombre_producto()); // Aseguramos que el nombre del producto se obtenga correctamente

            pedidosDTO.add(pedidoDTO);
        }

        return pedidosDTO;
    }

    @Transactional
    public Pedido addPedido(Pedido pedido) {
        Producto producto = productoRepository.findById(pedido.getProducto().getId_producto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        pedido.setProducto(producto);

        Usuario usuario = usuarioRepository.findById(pedido.getUsuario().getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        pedido.setUsuario(usuario);

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
