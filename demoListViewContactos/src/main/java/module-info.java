module com.example.demolistviewcontactos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.demolistviewcontactos.controllers to javafx.fxml;

    opens com.example.demolistviewcontactos.modelo to javafx.base;

    exports com.example.demolistviewcontactos;
    exports com.example.demolistviewcontactos.controllers;
}