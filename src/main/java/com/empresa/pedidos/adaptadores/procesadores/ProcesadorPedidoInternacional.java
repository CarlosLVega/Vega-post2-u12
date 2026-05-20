package com.empresa.pedidos.adaptadores.procesadores;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.ResultadoPedido;
import com.empresa.pedidos.dominio.TipoPedido;
import com.empresa.pedidos.dominio.puertos.ProcesadorPedido;

import java.math.BigDecimal;

public class ProcesadorPedidoInternacional implements ProcesadorPedido {
    private static final BigDecimal IMPUESTO_IMPORTACION = new BigDecimal("1.35");

    @Override
    public TipoPedido tipoSoportado() {
        return TipoPedido.INTERNACIONAL;
    }

    @Override
    public ResultadoPedido procesar(Pedido pedido) {
        BigDecimal total = pedido.getSubtotal().multiply(IMPUESTO_IMPORTACION);
        return new ResultadoPedido(pedido.getId(), pedido.getTipo(), total, "Procesamiento internacional");
    }
}
