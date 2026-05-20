package com.empresa.pedidos.adaptadores.rest;

import com.empresa.pedidos.adaptadores.facade.FachadaPedidos;
import com.empresa.pedidos.dominio.ResultadoPedido;
import com.empresa.pedidos.dominio.TipoPedido;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PedidoController {
    private final FachadaPedidos fachadaPedidos;

    public PedidoController(FachadaPedidos fachadaPedidos) {
        this.fachadaPedidos = fachadaPedidos;
    }

    @PostMapping("/pedidos/{id}")
    public ResultadoPedido crear(
            @PathVariable String id,
            @RequestParam TipoPedido tipo,
            @RequestParam BigDecimal subtotal
    ) {
        return fachadaPedidos.crearYProcesar(id, tipo, subtotal);
    }
}
