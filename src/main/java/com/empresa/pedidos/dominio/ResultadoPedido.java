package com.empresa.pedidos.dominio;

import java.math.BigDecimal;

public record ResultadoPedido(String pedidoId, TipoPedido tipo, BigDecimal total, String descripcion) {
}
