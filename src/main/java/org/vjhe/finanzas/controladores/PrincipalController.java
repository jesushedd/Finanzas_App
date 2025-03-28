package org.vjhe.finanzas.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import org.vjhe.finanzas.ApplicationFinanzas;
import org.vjhe.finanzas.modelo.ViewModel;

import java.io.IOException;

public class PrincipalController {
    @FXML
    private Control lanzadorVentanaGastos;


    private GastosController gastosController;

    private IngresosController ingresosController;

    private ViewModel modelo;

    public void setModelo(ViewModel modelo){
        this.modelo = modelo;
    }

    @FXML
    private void abrirFormularioGasto() throws IOException {
        //checar si ya existe una ventana de gastos abierta
        if (modelo.ventanaGastos()){
            //TODO traer al frente la ventana ya existente
            return;
        }
        modelo.setVentanaGastos(true);
    }

    @FXML
    private void abrirFormularioIngreso() throws IOException{

    }


    private boolean ventanaSecundaria = false;
}