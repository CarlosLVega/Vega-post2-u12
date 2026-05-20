package com.empresa.pedidos.infraestructura;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.puertos.RepositorioPedidos;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class RepositorioPedidosMemoria implements RepositorioPedidos {
    private final Map<String, Pedido> pedidos = new ConcurrentHashMap<>();

    @Override
    public Pedido guardar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> buscarPorId(String id) {
        return Optional.ofNullable(pedidos.get(id));
    }
}
