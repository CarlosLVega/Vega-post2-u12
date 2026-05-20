package com.empresa.pedidos.infraestructura;

import com.empresa.pedidos.dominio.PedidoProcesadoEvent;
import org.springframework.context.event.EventListener;

public class NotificadorEmail {
    @EventListener
    public void notificar(PedidoProcesadoEvent evento) {
        System.out.println("Pedido procesado: " + evento.pedidoId());
    }
}
