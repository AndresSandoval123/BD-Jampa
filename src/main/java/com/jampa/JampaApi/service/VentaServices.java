package com.jampa.JampaApi.service;

import com.jampa.JampaApi.dto.PedidoDTO;
import com.jampa.JampaApi.dto.VentaDTO;
import com.jampa.JampaApi.model.Pedido;
import com.jampa.JampaApi.model.Venta;
import com.jampa.JampaApi.repository.VentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServices {

    @Autowired //Inyectamos la dependencia del VentaServices
    private VentaRepository ventaRepository;

    @Autowired
    private PedidoServices pedidoService;

    ///
    @Autowired
    private ModelMapper modelMapper; // Necesario para la conversión de entidades a DTOs

    public List<VentaDTO> getAllVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream().map(this::convertToDTOVenta).collect(Collectors.toList());
    }



    //Método agregar una venta
    @Transactional
    public Venta addVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    //buscar una sola venta por id
    public Venta findVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Transactional
    public Venta crearVenta(VentaDTO ventaDTO) {
        Venta venta = new Venta();
        venta.setFecha_venta(ventaDTO.getFecha_venta());
        venta.setValor_envio(ventaDTO.getValor_envio());

        Pedido pedido = pedidoService.findPedido(ventaDTO.getPedido().getId_pedido());
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido no encontrado con ID: " + ventaDTO.getPedido().getId_pedido());
        }
        if (pedido.getVenta() != null) {
            throw new IllegalArgumentException("El pedido con ID: " + ventaDTO.getPedido().getId_pedido() + " ya está asociado a una venta.");
        }
        venta.setPedido(pedido);

        return addVenta(venta);
    }

    private VentaDTO convertToDTO(Venta venta) {
        VentaDTO.PedidoDTO pedidoDTO = new VentaDTO.PedidoDTO();
        if (venta.getPedido() != null) {
            pedidoDTO.setId_pedido(venta.getPedido().getId_pedido());
            pedidoDTO.setCantidad(venta.getPedido().getCantidad());
            pedidoDTO.setNombre_usuario(venta.getPedido().getUsuario().getNombre_usuario());
        }
        return new VentaDTO(
                        venta.getId_venta(),
                        venta.getFecha_venta(),
                venta.getEstado() != null ? venta.getEstado() : true, // Maneja valor_envio nulo
                venta.getValor_envio() != null ? venta.getValor_envio() : BigDecimal.ZERO, // Maneja estado nulo, default true
                        pedidoDTO
                );
    }

    //convertimos Venta a VentaDTO
    private VentaDTO convertToDTO(Venta venta) {
        VentaDTO.PedidoDTO pedidoDTO = new VentaDTO.PedidoDTO();
        if (venta.getPedido() != null) {
            pedidoDTO.setId_pedido(venta.getPedido().getId_pedido());
            pedidoDTO.setCantidad(venta.getPedido().getCantidad());
            pedidoDTO.setNombre_usuario(venta.getPedido().getUsuario().getNombre_usuario());
        }
        // Asignar un valor por defecto para estado si es nulo
        Boolean estadoVenta = venta.getEstado() != null ? venta.getEstado() : true;

        return new VentaDTO(
                venta.getId_venta(),
                venta.getFecha_venta(),
                venta.getValor_envio(),
                estadoVenta,
                pedidoDTO
        );
    }
//
//    public List<VentaDTO> convertirAVentaDTOList(List<Venta> ventas) {
//        List<VentaDTO> ventaDTOList = new ArrayList<>();
//        for (Venta venta : ventas) {
//            VentaDTO ventaDTO = convertirAVentaDTO(venta);
//            ventaDTOList.add(ventaDTO);
//        }
//        return ventaDTOList;
//    }


    //Método ver todas las ventas
//    public List<Venta> getAllVentas(){
//        return ventaRepository.findAll();
//    }


    //Método eliminar una venta
    public void eliminarVenta(Long id){
        ventaRepository.deleteById(id);
    }


}
