package com.example.demolistviewcontactos.controllers;

import com.example.demolistviewcontactos.modelo.Contacto;
import com.example.demolistviewcontactos.service.ContactoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactoController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;

    @FXML
    private ComboBox<String> cbParentesco;

    @FXML
    private ListView<Contacto> listView;

    @FXML
    private Label lblMsg;

    private ContactoService service = new ContactoService();

    private String[] opcionesParentesco = {
            "Padre", "Madre", "Hermano", "Hermana",
            "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {
        cbParentesco.setItems(FXCollections.observableArrayList(opcionesParentesco));
        actualizarVista();
    }



    @FXML
    private void onAgregar() {
        try {
            service.agregar(txtNombre.getText(), txtTelefono.getText(), cbParentesco.getValue());
            onLimpiar();
            msg("agregado", "green");
        } catch (Exception e) {
            msg(e.getMessage(), "red");
        }
    }

    @FXML
    private void onBuscar() {
        Contacto c = service.buscar(txtNombre.getText());
        if (c != null) {
            txtTelefono.setText(c.getTelefono());
            cbParentesco.setValue(c.getParentesco());
            msg("encontrado", "blue");
        } else {
            msg("no existe", "red");
        }

    }

    @FXML
    private void onActualizar() {
        try {
            service.actualizar(txtNombre.getText(), txtTelefono.getText(), cbParentesco.getValue());
            actualizarVista();
            msg("actualizado", "green");
        } catch (Exception e) {
            msg(e.getMessage(), "red");
        }
    }

    @FXML
    private void onEliminar(){
        try {
            service.eliminar(txtNombre.getText());
            actualizarVista();
            onLimpiar();
            msg("contacto eliminado","orange");
        } catch (Exception e) {
            msg(e.getMessage(),"red");
        }
    }

    @FXML
    private void onLimpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
        actualizarVista();
    }

    @FXML
    private void actualizarVista() {
        listView.setItems(FXCollections.observableArrayList(service.getLista()));
    }

    private void msg(String texto, String color) {
        lblMsg.setText(texto);
        lblMsg.setStyle("-fx-text-fill: "+color+";");
    }
}
