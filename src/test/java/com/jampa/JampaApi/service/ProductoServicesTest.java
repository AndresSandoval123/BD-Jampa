package com.jampa.JampaApi.service;

import com.jampa.JampaApi.controller.ProductoController;
import com.jampa.JampaApi.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductoController.class)
public class ProductoServicesTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoServices productoServices;

    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    public void setUp() {
        producto1 = new Producto();
        producto1.setId_producto(1L);
        producto1.setNombre_producto("Producto 1");

        producto2 = new Producto();
        producto2.setId_producto(2L);
        producto2.setNombre_producto("Producto 2");
    }

    @Test
    public void testGetAllProductos() throws Exception {
        List<Producto> productos = Arrays.asList(producto1, producto2);
        when(productoServices.getAllProducto()).thenReturn(productos);

        mockMvc.perform(get("/api/v1/productos/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre_producto").value("Producto 1"))
                .andExpect(jsonPath("$[1].nombre_producto").value("Producto 2"));
    }

    @Test
    public void testAddProducto() throws Exception {
        when(productoServices.addProducto(producto1)).thenReturn(producto1);

        mockMvc.perform(post("/api/v1/productos/agregar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre_producto\":\"Producto 1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre_producto").value("Producto 1"));
    }

    @Test
    public void testEliminarProducto() throws Exception {
        when(productoServices.findProducto(1L)).thenReturn(producto1);

        mockMvc.perform(delete("/api/v1/productos/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Producto eliminado con éxito"));
    }

    @Test
    public void testBuscarProductoPorTitulo() throws Exception {
        List<Producto> productos = Arrays.asList(producto1);
        when(productoServices.buscarPorTitulo("Producto 1")).thenReturn(productos);

        mockMvc.perform(get("/api/v1/productos/buscar-producto-titulo/Producto 1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre_producto").value("Producto 1"));
    }

    @Test
    public void testEditProducto() throws Exception {
        mockMvc.perform(put("/api/v1/productos/1/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre_producto\":\"Producto Actualizado\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Producto editado correctamente"));
    }
}
