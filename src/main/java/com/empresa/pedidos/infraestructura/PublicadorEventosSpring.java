package com.empresa.pedidos.infraestructura;

import com.empresa.pedidos.dominio.PedidoProcesadoEvent;
import com.empresa.pedidos.dominio.puertos.PublicadorEventos;
import org.springframework.context.ApplicationEventPublisher;

public class PublicadorEventosSpring implements PublicadorEventos {
    private final ApplicationEventPublisher publisher;

    public PublicadorEventosSpring(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publicar(PedidoProcesadoEvent evento) {
        publisher.publishEvent(evento);
    }
}
