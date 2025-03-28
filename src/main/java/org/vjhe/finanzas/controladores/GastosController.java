package org.vjhe.finanzas.controladores;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.vjhe.finanzas.modelo.Categoria;
import org.vjhe.finanzas.modelo.ViewModel;



public class GastosController {

    @FXML
    public ChoiceBox<Categoria> selectorCategorias;
    @FXML
    public TextField inputCategoria;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonAceptar;
    @FXML
    private TextField inputMonto;

    private ViewModel viewModel;

    public void setViewModel(ViewModel viewModel){
        this.viewModel = viewModel;
    }


    private DoubleProperty monto = new SimpleDoubleProperty();

    public void initialize(){
        restringirEntradaNumerica(inputMonto);
    }

    public void setChoiceBox(){
        selectorCategorias.setItems(viewModel.getCategorias());

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

    public void crearCategoria(ActionEvent actionEvent) {
        String categoriaIngresada = inputCategoria.getText();
        if (categoriaIngresada.isBlank()) return;
        viewModel.crearCategoria(categoriaIngresada);

    }
}
