package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public record OrdenServicio(String codigoUnico, String fechaCreacion, Cliente clienteAsociado, String observaciones, EstadoOrden estadoOrden, ArrayList<DetalleServicio> listaDetallesServicios, TechRepair ownedByTechRepair){
    @Override
    public String codigoUnico() {
        return codigoUnico;
    }

    @Override
    public String fechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public Cliente clienteAsociado() {
        return clienteAsociado;
    }

    @Override
    public String observaciones() {
        return observaciones;
    }

    @Override
    public EstadoOrden estadoOrden() {
        return estadoOrden;
    }

    @Override
    public ArrayList<DetalleServicio> listaDetallesServicios() {
        return listaDetallesServicios;
    }

    @Override
    public TechRepair ownedByTechRepair() {
        return ownedByTechRepair;
    }

    //CRUD DetalleServicio

    public String registrarDetalleServicio(DetalleServicio detalle) {
        Optional<DetalleServicio> detalleAux = buscarDetalleServicio(detalle.getCodigoUnico());
        if (detalleAux.isEmpty()) {
            listaDetallesServicios.add(detalle);
            return "El detalle fue registrado exitosamente.";
        } else return "No se puede registrar, ya existe un detalle con el código " + detalle.getCodigoUnico() + ".";
    }

    public Optional<DetalleServicio> buscarDetalleServicio(String codigoUnico) {
        for (DetalleServicio detalleAux : listaDetallesServicios) {
            if (codigoUnico.equals(detalleAux.getCodigoUnico())) {
                return Optional.of(detalleAux);
            }
        }
        return Optional.empty();
    }

    public String actualizarDetalleServicio(String codigoUnico, String descripcion, Tecnico tecnicoResp, int horasTrabajo, String observTecnicas, EstadoOrden estadoIntervencion) {
        Optional<DetalleServicio> detalleAux = buscarDetalleServicio(codigoUnico);
        if (detalleAux.isPresent()) {
            if (horasTrabajo < 0) {
                return "Las horas de trabajo no pueden ser negativas.";
            }
            DetalleServicio d = detalleAux.get();
            d.setDescripcion(descripcion);
            d.setTecnicoResp(tecnicoResp);
            d.setHorasTrabajo(horasTrabajo);
            d.setObservTecnicas(observTecnicas);
            d.setEstadoIntervencion(estadoIntervencion);
            return "Detalle actualizado correctamente.";
        }
        return "No existe un detalle con el código " + codigoUnico + ".";
    }

    public String borrarDetalleServicio(String codigoUnico) {
        Optional<DetalleServicio> detalleAux = buscarDetalleServicio(codigoUnico);
        if (detalleAux.isEmpty()) {
            return "No existe ningún detalle con ese código.";
        }
        DetalleServicio d = detalleAux.get();
        for (RepuestoUtilizado repuestoUtilizadoAux : d.listarRepuestosUtilizados()) {
            d.borrarRepuestoUtilizado(repuestoUtilizadoAux.getRepuestoUtilizado().getCodigoUnico());
        }
        d.setOwnedByOrdenServicio(null);
        listaDetallesServicios.remove(d);
        return "El detalle fue borrado exitosamente.";
    }
}
