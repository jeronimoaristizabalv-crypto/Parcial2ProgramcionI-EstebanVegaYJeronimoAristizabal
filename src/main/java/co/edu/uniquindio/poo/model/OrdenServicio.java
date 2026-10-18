package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;

public record OrdenServicio(String codigoUnico, String fechaCreacion, Cliente clienteAsociado, String observaciones, EstadoOrden estadoOrden, ArrayList<DetalleServicio> listaDetallesServicios, TechRepair ownedByTechRepair){

    //CRUD DetalleServicio


}
