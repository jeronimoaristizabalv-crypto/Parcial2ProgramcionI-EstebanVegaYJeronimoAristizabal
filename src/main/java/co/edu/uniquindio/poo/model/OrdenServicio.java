package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record OrdenServicio(String codigoUnico, String fechaCreacion, Cliente clienteAsociado,
                            String observaciones, EstadoOrden estadoOrden,
                            List<DetalleServicio> listaDetallesServicios, TechRepair ownedByTechRepair) {

    public OrdenServicio {
        listaDetallesServicios = new ArrayList<>(listaDetallesServicios);
    }

    @Override
    public List<DetalleServicio> listaDetallesServicios() {
        return Collections.unmodifiableList(listaDetallesServicios);
    }

    void agregarDetalle(DetalleServicio detalle) {
        listaDetallesServicios.add(detalle);
        detalle.setOwnedByOrdenServicio(this);
    }

    void eliminarDetalle(DetalleServicio detalle) {
        listaDetallesServicios.remove(detalle);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (DetalleServicio detalle : listaDetallesServicios) {
            total = total + detalle.calcularCosto();
        }
        return total;
    }

    public boolean todosLosDetallesEstanFinalizados() {
        if (listaDetallesServicios.isEmpty()) {
            return false;
        }
        for (DetalleServicio detalle : listaDetallesServicios) {
            if (detalle.getEstadoIntervencion() != EstadoOrden.FINALIZADA) {
                return false;
            }
        }
        return true;
    }
    static boolean contieneEquipo(List<Equipo> equipos, Equipo buscado) {
        for (Equipo equipo : equipos) {
            if (equipo.getCodigoUnico().equals(buscado.getCodigoUnico())) {
                return true;
            }
        }
        return false;
    }
}
