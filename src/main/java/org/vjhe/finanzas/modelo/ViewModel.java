package org.vjhe.finanzas.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ViewModel {

    private final BooleanProperty ventanaGastosAbierta = new SimpleBooleanProperty(false);

    public boolean ventanaGastos(){
        return ventanaGastosAbierta.get();
    }

    public void setVentanaGastos(boolean estado){
        ventanaGastosAbierta.set(estado);
    }

    public BooleanProperty ventanaGastosPoperty(){
        return ventanaGastosAbierta;
    }

    public void VentanaSecundariaAlfrente(){

    }


}
