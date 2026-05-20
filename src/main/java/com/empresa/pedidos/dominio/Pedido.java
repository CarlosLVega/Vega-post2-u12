package com.empresa.pedidos.dominio;

import java.math.BigDecimal;
import java.util.Objects;

public class Pedido {
    private final String id;
    private final TipoPedido tipo;
    private final BigDecimal subtotal;
    private EstadoPedido estado;

    public Pedido(String id, TipoPedido tipo, BigDecimal subtotal) {
        if (subtotal == null || subtotal.signum() <= 0) {
            throw new IllegalArgumentException("El subtotal debe ser mayor que cero");
        }
        this.id = Objects.requireNonNull(id, "id");
        this.tipo = Objects.requireNonNull(tipo, "tipo");
        this.subtotal = subtotal;
        this.estado = EstadoPedido.CREADO;
    }

    public String getId() {
        return id;
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void marcarProcesado() {
        estado = EstadoPedido.PROCESADO;
    }
}
