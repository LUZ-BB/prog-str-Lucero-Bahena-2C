package com.example.demolistviewcontactos.service;

import com.example.demolistviewcontactos.modelo.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {

    private List<Contacto> lista=new ArrayList<>();

    public void agregar(String nom,String tel,String par){
        validar(nom,tel,par);
        if (buscar(nom) !=null) throw new IllegalArgumentException("el nombre ya existe");
        lista.add(new Contacto(nom,tel,par));
    }
    public Contacto buscar(String nombre){
        for (Contacto c:lista){
            if (c.getNombre().equalsIgnoreCase(nombre.trim())) return c;
        }
        return null;
    }

    public void actualizar(String nom,String tel,String par){
        Contacto c =buscar(nom);
        if (c==null)throw new IllegalArgumentException("contacto no encontrado");
        validar(nom,tel,par);
        c.setTelefono(tel);
        c.setParentesco(par);
    }

    public void eliminar(String nom){
        Contacto c =buscar(nom);
        if (c==null)throw new IllegalArgumentException("no se encontro para eliminar");
        lista.remove(c);
    }

    public List<Contacto> getLista() {
        return lista;
    }

    private void validar(String nom, String tel,String par){
        if (nom==null||nom.isBlank()) throw new IllegalArgumentException("nombre vacio");
        if (tel==null||tel.length() !=10) throw new IllegalArgumentException("el telefono debe de ser de 10 digitos");
        if (par==null)throw new IllegalArgumentException("seleccione el parentesco");

    }
}
