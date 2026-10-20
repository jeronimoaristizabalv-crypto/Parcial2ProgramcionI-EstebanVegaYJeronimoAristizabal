package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetalleServicio {

    private final String codigoUnico;
    private Equipo equipo;
    private Servicio servicioAsociado;
    private String descripcion;
    private Tecnico tecnicoResp;
    private int horasTrabajo;
    private String observTecnicas;
    private EstadoOrden estadoIntervencion;
    private ArrayList<RepuestoUtilizado> listaRepuestosUtilizados=new ArrayList<>();

    private OrdenServicio ownedByOrdenServicio;

    public DetalleServicio(String codigoUnico, Equipo equipo, Servicio servicioAsociado, String descripcion, Tecnico tecnicoResp, int horasTrabajo, String observTecnicas, EstadoOrden estadoIntervencion) {
        this.codigoUnico = codigoUnico;
        this.equipo = equipo;
        this.servicioAsociado = servicioAsociado;
        this.descripcion = descripcion;
        this.tecnicoResp = tecnicoResp;
        this.horasTrabajo = horasTrabajo;
        this.observTecnicas = observTecnicas;
        this.estadoIntervencion = estadoIntervencion;
    }

    public String getCodigoUnico() {
        return codigoUnico;
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

    public List<RepuestoUtilizado> getListaRepuestosUtilizados() {
        return Collections.unmodifiableList(listaRepuestosUtilizados);
    }

    public OrdenServicio getOwnedByOrdenServicio() {
        return ownedByOrdenServicio;
    }

    public void setOwnedByOrdenServicio(OrdenServicio ownedByOrdenServicio) {
        this.ownedByOrdenServicio = ownedByOrdenServicio;
    }

    void agregarRepuesto(RepuestoUtilizado repuestoUtilizado) {
        repuestoUtilizado.setOwnedByDetalleServicio(this);
        listaRepuestosUtilizados.add(repuestoUtilizado);
    }

    void quitarRepuesto(RepuestoUtilizado repuestoUtilizado) {
        listaRepuestosUtilizados.remove(repuestoUtilizado);
    }

    public double calcularCosto() {
        double costoServicio;
        if (servicioAsociado instanceof ReparacionCorrectiva) {
            costoServicio = horasTrabajo * servicioAsociado.tarifaBase();
        } else if (servicioAsociado instanceof MantenimientoPreventivo) {
            MantenimientoPreventivo mantenimiento = (MantenimientoPreventivo) servicioAsociado;
            costoServicio = mantenimiento.tarifaParaEquipo(equipo);
        } else {
            costoServicio = servicioAsociado.total();
        }
        return costoServicio + calcularCostoRepuestos();
    }

    public double calcularCostoRepuestos() {
        double total = 0;
        for (RepuestoUtilizado usado : listaRepuestosUtilizados) {
            total = total + usado.calcularSubtotal();
        }
        return total;
    }
}
