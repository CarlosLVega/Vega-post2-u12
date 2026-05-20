package com.empresa.pedidos.adaptadores.procesadores;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.ResultadoPedido;
import com.empresa.pedidos.dominio.TipoPedido;
import com.empresa.pedidos.dominio.puertos.ProcesadorPedido;

import java.math.BigDecimal;

public class ProcesadorPedidoExpress implements ProcesadorPedido {
    private static final BigDecimal RECARGO_EXPRESS = new BigDecimal("1.20");

    @Override
    public TipoPedido tipoSoportado() {
        return TipoPedido.EXPRESS;
    }

    @Override
    public ResultadoPedido procesar(Pedido pedido) {
        BigDecimal total = pedido.getSubtotal().multiply(RECARGO_EXPRESS);
        return new ResultadoPedido(pedido.getId(), pedido.getTipo(), total, "Procesamiento express");
    }
}
