package org.vjhe.finanzas.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;


public class ViewModel {

    private final BooleanProperty ventanaGastosAbierta = new SimpleBooleanProperty(false);
    private final BooleanProperty ventanaIngresosAbieta = new SimpleBooleanProperty(false);
    private final ObservableList<Categoria> categorias = FXCollections.observableArrayList();
    private final BackModel modeloReal = new BackModel();







    public ViewModel(){
        var categoriasSet  =  modeloReal.getCategorias();
        categorias.addAll(categoriasSet);
        addCategoriasBase();

    }

    private void addCategoriasBase(){
        crearCategoria("Alimentación");
        crearCategoria("Transporte");
    }

    public boolean ventanaGastos(){
        return ventanaGastosAbierta.get();
    }

    public void setVentanaGastos(boolean estado){
        ventanaGastosAbierta.set(estado);
    }

    public BooleanProperty ventanaGastosPoperty(){
        return ventanaGastosAbierta;
    }
    public BooleanProperty getVentanaGastosAbierta(){
    return null;
    }

    public ObservableList<Categoria> getCategorias() {
        return categorias;
    }

    public void crearCategoria(String catStr ){
        Categoria nCategoria = new Categoria(catStr);
        if (categorias.contains(nCategoria)) return;
        modeloReal.crearCategoria(nCategoria);
        categorias.add(nCategoria);
    }


}
