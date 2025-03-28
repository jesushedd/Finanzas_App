package org.vjhe.finanzas.modelo;

import java.time.LocalDate;

public class Movimiento {
    private int id;
    private String tipo;
    private LocalDate fecha;
    private String detalle;
    private Categoria categoria;
}
