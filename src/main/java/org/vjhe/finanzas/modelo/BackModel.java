package org.vjhe.finanzas.modelo;

import org.vjhe.finanzas.modelo.persistencia.CategoriaDAO;

import java.util.Set;
import java.util.TreeSet;

public class BackModel {
    private final Set<Categoria> categorias = new TreeSet<>();
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();


    void crearCategoria(Categoria categoriaACrear ){
        if (categorias.contains(categoriaACrear)){
            return;
        }
        categoriaDAO.guardar(categoriaACrear);
        sincronizarDB();
    }

    private void saveCategoria(Categoria categoria){

    }

    public  BackModel(){
        sincronizarDB();

    }

    private void sincronizarDB(){

        categorias.addAll(categoriaDAO.obtenerTodos());
    }

    public Set<Categoria> getCategorias(){
        return categorias;
    }

}
