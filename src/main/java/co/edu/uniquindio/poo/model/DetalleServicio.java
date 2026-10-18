package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;

public class DetalleServicio {

    private String codigoUnico;
    private Equipo equipo;
    private Servicio servicioAsociado;
    private String descripcion;
    private Tecnico tecnicoResp;
    private int horasTrabajo;
    private String observTecnicas;
    private EstadoOrden estadoIntervencion;
    private ArrayList<RepuestoUtilizado> listaRepuestosUtilizados=new ArrayList<>();

    private OrdenServicio ownedByOrdenServicio;

    public DetalleServicio(String codigoUnico, Equipo equipo, Servicio servicioAsociado, String descripcion, Tecnico tecnicoResp, int horasTrabajo, String observTecnicas, EstadoOrden estadoIntervencion, ArrayList<RepuestoUtilizado> listaRepuestosUtilizados) {
        this.codigoUnico = codigoUnico;
        this.equipo = equipo;
        this.servicioAsociado = servicioAsociado;
        this.descripcion = descripcion;
        this.tecnicoResp = tecnicoResp;
        this.horasTrabajo = horasTrabajo;
        this.observTecnicas = observTecnicas;
        this.estadoIntervencion = estadoIntervencion;
        this.listaRepuestosUtilizados = listaRepuestosUtilizados;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Servicio getServicioAsociado() {
        return servicioAsociado;
    }

    public void setServicioAsociado(Servicio servicioAsociado) {
        this.servicioAsociado = servicioAsociado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tecnico getTecnicoResp() {
        return tecnicoResp;
    }

    public void setTecnicoResp(Tecnico tecnicoResp) {
        this.tecnicoResp = tecnicoResp;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public String getObservTecnicas() {
        return observTecnicas;
    }

    public void setObservTecnicas(String observTecnicas) {
        this.observTecnicas = observTecnicas;
    }

    public EstadoOrden getEstadoIntervencion() {
        return estadoIntervencion;
    }

    public void setEstadoIntervencion(EstadoOrden estadoIntervencion) {
        this.estadoIntervencion = estadoIntervencion;
    }

    public ArrayList<RepuestoUtilizado> getListaRepuestosUtilizados() {
        return (ArrayList<RepuestoUtilizado>) Collections.unmodifiableList(listaRepuestosUtilizados);
    }

    public void setListaRepuestosUtilizados(ArrayList<RepuestoUtilizado> listaRepuestosUtilizados) {
        this.listaRepuestosUtilizados = listaRepuestosUtilizados;
    }

    public OrdenServicio getOwnedByOrdenServicio() {
        return ownedByOrdenServicio;
    }

    public void setOwnedByOrdenServicio(OrdenServicio ownedByOrdenServicio) {
        this.ownedByOrdenServicio = ownedByOrdenServicio;
    }

    //CRUD RepuestoUtilizado
}
