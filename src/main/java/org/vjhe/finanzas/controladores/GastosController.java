package org.vjhe.finanzas.controladores;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.vjhe.finanzas.modelo.Categoria;
import org.vjhe.finanzas.modelo.ViewModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class GastosController {

    @FXML
    public ChoiceBox<Categoria> selectorCategorias;
    @FXML
    public TextField inputCategoria;
    public Label fechaLabel;
    public DatePicker fechaSelector;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonAceptar;
    @FXML
    private TextField inputMonto;

    private ViewModel viewModel;

    private ObjectProperty<LocalDate> fechaSeleccionada ;
    private ObjectProperty<Categoria> categoriaSeleccionada;

    public void setViewModel(ViewModel viewModel){
        this.viewModel = viewModel;
    }


    private DoubleProperty monto = new SimpleDoubleProperty();

    public void initialize(){
        restringirEntradaNumerica(inputMonto);
        establecerSelecciones();


        fechaSelector.setValue(LocalDate.now());
        fechaSelector.setOnAction(this::cambiarFechaLabel);

    }

    private void cambiarFechaLabel(ActionEvent actionEvent){
        if (actionEvent.getSource() != fechaSelector) return;
        var fecha =    fechaSelector.getValue();
        String prefijo = "";
        var fechaS =fecha.format(DateTimeFormatter.ofPattern("d-M-y").localizedBy(Locale.of("ES")));
        System.out.println(fechaS);
    }
    private void establecerSelecciones(){
        fechaSeleccionada = fechaSelector.valueProperty();
        categoriaSeleccionada = selectorCategorias.valueProperty();
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
