package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class TechRepair {
    private ArrayList<Cliente> listaClientes= new ArrayList<>();
    private ArrayList<Tecnico> listaTecnicos= new ArrayList<>();
    private ArrayList<OrdenServicio> listaOrdenesServicios= new ArrayList<>();
    private ArrayList<Servicio> listaServicios= new ArrayList<>();
    private ArrayList<Repuesto> listaRepuestos= new ArrayList<>();

    public TechRepair(ArrayList<Cliente> listaClientes, ArrayList<Tecnico> listaTecnicos, ArrayList<OrdenServicio> listaOrdenesServicios, ArrayList<Servicio> listaServicios, ArrayList<Repuesto> listaRepuestos) {
        this.listaClientes = listaClientes;
        this.listaTecnicos = listaTecnicos;
        this.listaOrdenesServicios = listaOrdenesServicios;
        this.listaServicios = listaServicios;
        this.listaRepuestos = listaRepuestos;
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

    public ArrayList<Repuesto> getListarespuestos() {
        return (ArrayList<Repuesto>) Collections.unmodifiableList(listaRepuestos);
    }

    public void setListarespuestos(ArrayList<Repuesto> listarespuestos) {
        this.listaRepuestos = listarespuestos;
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

    //CRUD Cliente


    public String registrarCliente(Cliente cliente){
        Optional<Cliente> clienteAux = buscarCliente(cliente.getNumeroDocumento());
        if(clienteAux.isEmpty()){
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        }else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }

    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        for (Cliente clienteAux :listaClientes){
            if (documentoIdentidad.equals(clienteAux.getNumeroDocumento())){
                return Optional.of(clienteAux);
            }
        }
        return Optional.empty();
    }

    public String actualizarCliente(String numeroDocumento, String numeroTelefono, String nombreCompleto, String correoElectronico, String direccionResidencia) {
        Optional<Cliente> clienteAux = buscarCliente(numeroDocumento);
        if (clienteAux.isPresent()) {
            Cliente c = clienteAux.get();
            c.setNumeroTelefono(numeroTelefono);
            c.setNombreCompleto(nombreCompleto);
            c.setCorreoElectronico(correoElectronico);
            c.setDireccionResidencia(direccionResidencia);
            return "Cliente actualizado correctamente.";
        }
        return "No existe un cliente con el documento " + numeroDocumento + ".";
    }

    public String borrarCliente(String numeroDocumento){
        Optional<Cliente> clienteAux= buscarCliente(numeroDocumento);
        if(clienteAux.isEmpty()){
            return "No existe ningún cliente con ese número de documento";
        }
        listaClientes.remove(clienteAux.get());
        return "El cliente fue borrado exitosamente";
    }

    //CRUD Tecnico

    public String registrarTecnico(Tecnico tecnico){
        Optional<Tecnico> tecnicoAux = buscarTecnico(tecnico.getID());
        if(tecnicoAux.isEmpty()){
            listaTecnicos.add(tecnico);
            return "El técnico fue registrado exitosamente";
        }else return "No se puede registrar, ya existe un técnico con esa informacion registrado anteriormente.";
    }

    public Optional<Tecnico> buscarTecnico (String documentoIdentidad) {
        for (Tecnico tecnicoAux :listaTecnicos){
            if (documentoIdentidad.equals(tecnicoAux.getID())){
                return Optional.of(tecnicoAux);
            }
        }
        return Optional.empty();
    }

    public String actualizarTecnico(String codigo, String nombre, String ID, Especialidad especialidad, EstadoLaboral estadoLaboral) {
        Optional<Tecnico> tecnicoAux = buscarTecnico(ID);
        if (tecnicoAux.isPresent()) {
            Tecnico t =tecnicoAux.get();
            t.setNombre(nombre);
            t.setID(ID);
            t.setEspecialidad(especialidad);
            t.setEstadoLaboral(estadoLaboral);
            return "Técnico actualizado correctamente.";
        }
        return "No existe un técnico con el código " + codigo + ".";
    }


    public String borrarTecnico(String ID){
        Optional<Tecnico> tecnicoAux= buscarTecnico(ID);
        if(tecnicoAux.isEmpty()){
            return "No existe ningún técnico con ese número de documento";
        }
        listaTecnicos.remove(tecnicoAux.get());
        return "El técnico fue borrado exitosamente";
    }

    //CRUD Repuesto

    public String registrarRepuesto(Repuesto repuesto){
        Optional<Repuesto> RepuestoAux = buscarRepuesto(repuesto.getCodigoUnico());
        if(RepuestoAux.isEmpty()){
            listaRepuestos.add(repuesto);
            return "El repuesto fue registrado exitosamente";
        }else return "No se puede registrar, ya existe un repuesto con esa información registrado anteriormente.";
    }

    public Optional<Repuesto> buscarRepuesto (String codigoUnico) {
        for (Repuesto repuestoAux: listaRepuestos){
            if (codigoUnico.equals(repuestoAux.getCodigoUnico())){
                return Optional.of(repuestoAux);
            }
        }
        return Optional.empty();
    }

    public String actualizarRepuesto(String codigoUnico, String nombre, String descripcion, double precioUnidad, int cantidadExistente, String compatibilidad) {
        Optional<Repuesto> repuestoAux = buscarRepuesto(codigoUnico);
        if (repuestoAux.isPresent()) {
            Repuesto r = repuestoAux.get();
            r.setNombre(nombre);
            r.setDescripcion(descripcion);
            r.setPrecioUnidad(precioUnidad);
            r.setCantidadExistente(cantidadExistente);
            r.setCompatibilidad(compatibilidad);
            return "Repuesto actualizado correctamente.";
        }
        return "No existe un repuesto con el código " + codigoUnico + ".";
    }

    public String borrarRepuesto(String codigoUnico){
        Optional<Repuesto> repuestoAux= buscarRepuesto(codigoUnico);
        if(repuestoAux.isEmpty()){
            return "No existe ningún repuesto con ese número de documento";
        }
        listaRepuestos.remove(repuestoAux.get());
        return "El repuesto fue borrado exitosamente";
    }

    //CRUD OrdenServicio

    public Optional<OrdenServicio> buscarOrdenServicio (String codigoUnico) {
        for (OrdenServicio ordenServicioAux: listaOrdenesServicios) {
            if (codigoUnico.equals(ordenServicioAux.codigoUnico())) {
                return Optional.of(ordenServicioAux);
            }
        }
        return Optional.empty();
    }

    //CRUD Servicio

    public String registrarServicio(Servicio servicio){
        Optional<Servicio> servicioAux = buscarServicio(servicio.getCodigo());
        if(servicioAux.isEmpty()){
            listaServicios.add(servicio);
            return "El servicio fue registrado exitosamente";
        }else return "No se puede registrar, ya existe un servicio con esa informacion registrado anteriormente.";
    }

    public Optional<Servicio> buscarServicio (String codigo) {
        for (Servicio servicioAux: listaServicios){
            if (codigo.equals(servicioAux.getCodigo())){
                return Optional.of(servicioAux);
            }
        }
        return Optional.empty();
    }

    public String actualizarServicio(String codigo, String nombre, String descripcion) {
        Optional<Servicio> servicioAux = buscarServicio(codigo);
        if(servicioAux.isPresent()) {
            Servicio s = servicioAux.get();
            s.setDesccripcion(descripcion);
            s.setNombre(nombre);
            return "Servicio actualizado correctamente";
        }
        return "No existe un servicio con el cóidgo indicado";
    }

    public String borrarServicio(String codigo){
        Optional<Servicio> servicioAux= buscarServicio(codigo);
        if(servicioAux.isEmpty()){
            return "No existe ningún servicio con ese número de documento";
        }
        listaServicios.remove(servicioAux.get());
        return "El servicio fue borrado exitosamente";
    }

}
