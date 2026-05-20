package com.empresa.pedidos.adaptadores.procesadores;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.ResultadoPedido;
import com.empresa.pedidos.dominio.TipoPedido;
import com.empresa.pedidos.dominio.puertos.ProcesadorPedido;

public class ProcesadorPedidoEstandar implements ProcesadorPedido {
    @Override
    public TipoPedido tipoSoportado() {
        return TipoPedido.ESTANDAR;
    }

    @Override
    public ResultadoPedido procesar(Pedido pedido) {
        return new ResultadoPedido(pedido.getId(), pedido.getTipo(), pedido.getSubtotal(), "Procesamiento estandar");
    }
}
