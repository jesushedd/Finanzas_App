package org.vjhe.finanzas.controladores;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.vjhe.finanzas.modelo.ViewModel;



public class GastosController {

    @FXML
    public ChoiceBox<String> selectorCategorias;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonAceptar;
    @FXML
    private TextField inputMonto;

    private ViewModel modelo;

    public void setModelo(ViewModel modelo){
        this.modelo = modelo;
    }


    private DoubleProperty monto = new SimpleDoubleProperty();

    public void initialize(){
        restringirEntradaNumerica(inputMonto);
    }

    private void restringirEntradaNumerica(TextField campo){
        campo.textProperty().addListener((observable, oldValue, newValue) -> {
           if (newValue.matches("\\d*[\\d.]?\\d*")){
               return;
           } else {
               campo.setText(oldValue);
           }
        });
    }
}
