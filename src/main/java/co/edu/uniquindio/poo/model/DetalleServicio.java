package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

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

    public String registrarRepuestoUtilizado(RepuestoUtilizado repuestoUtilizado) {

        if (repuestoUtilizado.getCantidad() <= 0) {
            return "La cantidad debe ser mayor a cero.";
        }
        Repuesto repuesto = repuestoUtilizado.getRepuestoUtilizado();
        Optional<RepuestoUtilizado> repuestoAux = buscarRepuestoUtilizado(repuesto.getCodigoUnico());
        if (repuestoAux.isPresent()) {
            return "No se puede registrar, el repuesto " + repuesto.getCodigoUnico() + " ya está registrado en este detalle.";
        }
        if (repuestoUtilizado.getCantidad() > repuesto.getCantidadExistente()) {
            return "Inventario insuficiente del repuesto " + repuesto.getCodigoUnico()
                    + ": se solicitan " + repuestoUtilizado.getCantidad()
                    + " y hay " + repuesto.getCantidadExistente() + " disponibles.";
        }
        repuesto.setCantidadExistente(repuesto.getCantidadExistente() - repuestoUtilizado.getCantidad());
        listaRepuestosUtilizados.add(repuestoUtilizado);
        return "El repuesto fue registrado exitosamente y se descontó del inventario.";
    }

    public Optional<RepuestoUtilizado> buscarRepuestoUtilizado(String codigoRepuesto) {
        for (RepuestoUtilizado repuestoAux : listaRepuestosUtilizados) {
            if (codigoRepuesto.equals(repuestoAux.getRepuestoUtilizado().getCodigoUnico())) {
                return Optional.of(repuestoAux);
            }
        }
        return Optional.empty();
    }

    public ArrayList<RepuestoUtilizado> listarRepuestosUtilizados() {
        return new ArrayList<>(listaRepuestosUtilizados);
    }

    public String actualizarRepuestoUtilizado(String codigoRepuesto, int cantidad, double precioUnidad) {
        Optional<RepuestoUtilizado> repuestoAux = buscarRepuestoUtilizado(codigoRepuesto);
        if (repuestoAux.isPresent()) {
            if (cantidad <= 0) {
                return "La cantidad debe ser mayor a cero.";
            }
            if (precioUnidad < 0) {
                return "El precio por unidad no puede ser negativo.";
            }
            RepuestoUtilizado ru = repuestoAux.get();
            Repuesto repuesto = ru.getRepuestoUtilizado();
            int diferencia = cantidad - ru.getCantidad();   // positivo: se necesitan mas; negativo: se devuelven
            if (diferencia > repuesto.getCantidadExistente()) {
                return "Inventario insuficiente del repuesto " + codigoRepuesto
                        + ": se necesitan " + diferencia + " unidades adicionales y hay "
                        + repuesto.getCantidadExistente() + " disponibles.";
            }
            repuesto.setCantidadExistente(repuesto.getCantidadExistente() - diferencia);
            ru.setCantidad(cantidad);
            ru.setPrecioUnidad(precioUnidad);
            return "Repuesto utilizado actualizado correctamente.";
        }
        return "El repuesto " + codigoRepuesto + " no está registrado en este detalle.";
    }

    public String borrarRepuestoUtilizado(String codigoRepuesto) {
        Optional<RepuestoUtilizado> repuestoAux = buscarRepuestoUtilizado(codigoRepuesto);
        if (repuestoAux.isEmpty()) {
            return "El repuesto no está registrado en este detalle.";
        }
        RepuestoUtilizado ru = repuestoAux.get();
        Repuesto repuesto = ru.getRepuestoUtilizado();
        repuesto.setCantidadExistente(repuesto.getCantidadExistente() + ru.getCantidad());
        listaRepuestosUtilizados.remove(ru);
        return "El repuesto fue borrado exitosamente. Se devolvieron " + ru.getCantidad() + " unidades al inventario.";
    }
}
