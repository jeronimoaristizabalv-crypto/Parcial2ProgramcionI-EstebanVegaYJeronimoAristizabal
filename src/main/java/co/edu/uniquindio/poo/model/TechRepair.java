package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;

public class TechRepair {
    private ArrayList<Cliente> listaClientes= new ArrayList<>();
    private ArrayList<Tecnico> listaTecnicos= new ArrayList<>();
    private ArrayList<OrdenServicio> listaOrdenesServicios= new ArrayList<>();
    private ArrayList<Servicio> listaServicios= new ArrayList<>();

    public TechRepair(ArrayList<Cliente> listaClientes, ArrayList<Tecnico> listaTecnicos, ArrayList<OrdenServicio> listaOrdenesServicios, ArrayList<Servicio> listaServicios) {
        this.listaClientes = listaClientes;
        this.listaTecnicos = listaTecnicos;
        this.listaOrdenesServicios = listaOrdenesServicios;
        this.listaServicios = listaServicios;
    }

    public ArrayList<Cliente> getListaClientes() {
        return (ArrayList<Cliente>) Collections.unmodifiableList(listaClientes);
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Tecnico> getListaTecnicos() {
        return (ArrayList<Tecnico>) Collections.unmodifiableList(listaTecnicos);
    }

    public void setListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public ArrayList<OrdenServicio> getListaOrdenesServicios() {
        return (ArrayList<OrdenServicio>) Collections.unmodifiableList(listaOrdenesServicios);
    }

    public void setListaOrdenesServicios(ArrayList<OrdenServicio> listaOrdenesServicios) {
        this.listaOrdenesServicios = listaOrdenesServicios;
    }

    public ArrayList<Servicio> getListaServicios() {
        return (ArrayList<Servicio>) Collections.unmodifiableList(listaServicios);
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    @Override
    public String toString() {
        return "TechRepair{" +
                "listaClientes=" + listaClientes +
                ", listaTecnicos=" + listaTecnicos +
                ", listaOrdenesServicios=" + listaOrdenesServicios +
                ", listaServicios=" + listaServicios +
                '}';
    }
}
