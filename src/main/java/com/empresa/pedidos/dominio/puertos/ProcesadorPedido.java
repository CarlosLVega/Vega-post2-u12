package com.empresa.pedidos.dominio.puertos;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.ResultadoPedido;
import com.empresa.pedidos.dominio.TipoPedido;

public interface ProcesadorPedido {
    TipoPedido tipoSoportado();

    ResultadoPedido procesar(Pedido pedido);
}
