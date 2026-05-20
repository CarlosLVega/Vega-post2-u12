package com.empresa.pedidos.dominio.puertos;

import com.empresa.pedidos.dominio.PedidoProcesadoEvent;

public interface PublicadorEventos {
    void publicar(PedidoProcesadoEvent evento);
}
