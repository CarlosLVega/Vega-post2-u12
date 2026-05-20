package com.empresa.pedidos.adaptadores.facade;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.PedidoProcesadoEvent;
import com.empresa.pedidos.dominio.ResultadoPedido;
import com.empresa.pedidos.dominio.TipoPedido;
import com.empresa.pedidos.dominio.puertos.ProcesadorPedido;
import com.empresa.pedidos.dominio.puertos.PublicadorEventos;
import com.empresa.pedidos.dominio.puertos.RepositorioPedidos;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class FachadaPedidos {
    private final RepositorioPedidos repositorioPedidos;
    private final PublicadorEventos publicadorEventos;
    private final Map<TipoPedido, ProcesadorPedido> procesadores;

    public FachadaPedidos(
            RepositorioPedidos repositorioPedidos,
            PublicadorEventos publicadorEventos,
            List<ProcesadorPedido> procesadores
    ) {
        this.repositorioPedidos = repositorioPedidos;
        this.publicadorEventos = publicadorEventos;
        this.procesadores = new EnumMap<>(TipoPedido.class);
        procesadores.forEach(procesador -> this.procesadores.put(procesador.tipoSoportado(), procesador));
    }

    public ResultadoPedido crearYProcesar(String id, TipoPedido tipo, BigDecimal subtotal) {
        Pedido pedido = new Pedido(id, tipo, subtotal);
        ProcesadorPedido procesador = procesadores.get(tipo);
        if (procesador == null) {
            throw new IllegalArgumentException("No existe procesador para el tipo " + tipo);
        }

        ResultadoPedido resultado = procesador.procesar(pedido);
        pedido.marcarProcesado();
        repositorioPedidos.guardar(pedido);
        publicadorEventos.publicar(new PedidoProcesadoEvent(pedido.getId(), pedido.getTipo()));
        return resultado;
    }
}
