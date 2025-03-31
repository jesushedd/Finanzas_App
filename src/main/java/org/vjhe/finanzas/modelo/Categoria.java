package org.vjhe.finanzas.modelo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import java.util.Objects;

public class Categoria implements Comparable<Categoria>{
    private int id;
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Categoria(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria(String nombre){
        this.nombre = StringUtils.normalizeSpace(WordUtils.capitalizeFully(nombre));
    }

    @Override
    public int compareTo(Categoria o) {
        return nombre.compareToIgnoreCase(o.nombre);
    }
}
