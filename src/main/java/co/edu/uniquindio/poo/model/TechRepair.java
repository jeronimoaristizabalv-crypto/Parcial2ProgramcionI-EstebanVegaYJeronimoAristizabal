package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TechRepair {

    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Tecnico> listaTecnicos = new ArrayList<>();
    private ArrayList<OrdenServicio> listaOrdenesServicios = new ArrayList<>();
    private ArrayList<Servicio> listaServicios = new ArrayList<>();
    private ArrayList<Repuesto> listaRepuestos = new ArrayList<>();

    public List<Cliente> getListaClientes() {
        return Collections.unmodifiableList(listaClientes);
    }

    public List<Tecnico> getListaTecnicos() {
        return Collections.unmodifiableList(listaTecnicos);
    }

    public List<OrdenServicio> getListaOrdenesServicios() {
        return Collections.unmodifiableList(listaOrdenesServicios);
    }

    public List<Servicio> getListaServicios() {
        return Collections.unmodifiableList(listaServicios);
    }

    public List<Repuesto> getListaRepuestos() {
        return Collections.unmodifiableList(listaRepuestos);
    }

    @Override
    public String toString() {
        return "TechRepair{" +
                "listaClientes=" + listaClientes +
                ", listaTecnicos=" + listaTecnicos +
                ", listaOrdenesServicios=" + listaOrdenesServicios +
                ", listaServicios=" + listaServicios +
                ", listaRepuestos=" + listaRepuestos +
                '}';
    }

    public String registrarCliente(Cliente cliente) {
        Optional<Cliente> encontrado = buscarCliente(cliente.getNumeroDocumento());
        if (encontrado.isPresent()) {
            return "No se puede registrar: ya existe un cliente con ese documento.";
        }
        cliente.setOwnedByTechRepair(this);
        listaClientes.add(cliente);
        return "El cliente fue registrado exitosamente.";
    }

    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNumeroDocumento().equals(documentoIdentidad)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    public String actualizarCliente(String numeroDocumento, String numeroTelefono, String nombreCompleto,
                                    String correoElectronico, String direccionResidencia) {
        Optional<Cliente> encontrado = buscarCliente(numeroDocumento);
        if (encontrado.isEmpty()) {
            return "No existe un cliente con el documento " + numeroDocumento + ".";
        }
        Cliente cliente = encontrado.get();
        cliente.setNumeroTelefono(numeroTelefono);
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setCorreoElectronico(correoElectronico);
        cliente.setDireccionResidencia(direccionResidencia);
        return "Cliente actualizado correctamente.";
    }

    public String borrarCliente(String numeroDocumento) {
        Optional<Cliente> encontrado = buscarCliente(numeroDocumento);
        if (encontrado.isEmpty()) {
            return "No existe un cliente con ese documento.";
        }
        Cliente cliente = encontrado.get();
        if (!cliente.getListaEquipos().isEmpty() || !OrdenesCliente(numeroDocumento).isEmpty()) {
            return "No se puede eliminar el cliente porque tiene equipos u ordenes asociadas.";
        }
        listaClientes.remove(cliente);
        return "El cliente fue eliminado exitosamente.";
    }

    public String registrarEquipo(Cliente cliente, Equipo equipo) {
        if (cliente == null || equipo == null) {
            return "Debe indicar un cliente y un equipo validos.";
        }
        Optional<Cliente> clienteRegistrado = buscarCliente(cliente.getNumeroDocumento());
        if (clienteRegistrado.isEmpty() || clienteRegistrado.get() != cliente) {
            return "El cliente debe estar registrado antes de agregarle un equipo.";
        }
        if (buscarEquipo(equipo.getCodigoUnico()).isPresent()) {
            return "Ya existe un equipo con ese codigo.";
        }
        if (serieEquipoExiste(equipo.getNumSerie(), null)) {
            return "Ya existe un equipo con ese numero de serie.";
        }
        equipo.setOwnedByCliente(cliente);
        return cliente.crearEquipo(equipo);
    }

    public String actualizarEquipo(Cliente cliente, Equipo equipoAnterior, Equipo equipoNuevo) {
        if (cliente == null || equipoAnterior == null || equipoNuevo == null) {
            return "No se encontro el equipo que desea actualizar.";
        }
        if (serieEquipoExiste(equipoNuevo.getNumSerie(), equipoAnterior.getCodigoUnico())) {
            return "Otro equipo ya utiliza ese numero de serie.";
        }
        equipoNuevo.setOwnedByCliente(cliente);
        String resultado = cliente.actualizarEquipo(equipoAnterior, equipoNuevo);
        if (!resultado.equals("Equipo actualizado correctamente.")) {
            return resultado;
        }
        for (OrdenServicio orden : listaOrdenesServicios) {
            for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                if (detalle.getEquipo() == equipoAnterior) {
                    detalle.setEquipo(equipoNuevo);
                }
            }
        }
        return resultado;
    }

    public String eliminarEquipo(Cliente cliente, Equipo equipo) {
        if (cliente == null || equipo == null) {
            return "No se encontro el equipo que desea eliminar.";
        }
        if (equipoEstaEnDetalle(equipo)) {
            return "No se puede eliminar el equipo porque aparece en un detalle de servicio.";
        }
        return cliente.eliminarEquipo(equipo);
    }

    public Optional<Equipo> buscarEquipo(String codigoUnico) {
        for (Cliente cliente : listaClientes) {
            Optional<Equipo> encontrado = cliente.buscarEquipo(codigoUnico);
            if (encontrado.isPresent()) {
                return encontrado;
            }
        }
        return Optional.empty();
    }

    public Optional<Cliente> buscarPropietarioEquipo(String codigoUnico) {
        for (Cliente cliente : listaClientes) {
            if (cliente.buscarEquipo(codigoUnico).isPresent()) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    public boolean serieEquipoExiste(String serie, String codigoExcluir) {
        for (Cliente cliente : listaClientes) {
            for (Equipo equipo : cliente.getListaEquipos()) {
                boolean mismoCodigo = codigoExcluir != null && equipo.getCodigoUnico().equals(codigoExcluir);
                if (!mismoCodigo && equipo.getNumSerie().equalsIgnoreCase(serie)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String registrarTecnico(Tecnico tecnico) {
        if (buscarTecnico(tecnico.getCodigo()).isPresent()) {
            return "No se puede registrar: ya existe un tecnico con ese codigo.";
        }
        if (documentoTecnicoExiste(tecnico.getID(), null)) {
            return "No se puede registrar: ya existe un tecnico con ese documento.";
        }
        tecnico.setOwnedByTechRepair(this);
        listaTecnicos.add(tecnico);
        return "El tecnico fue registrado exitosamente.";
    }

    public Optional<Tecnico> buscarTecnico(String codigo) {
        for (Tecnico tecnico : listaTecnicos) {
            if (tecnico.getCodigo().equals(codigo)) {
                return Optional.of(tecnico);
            }
        }
        return Optional.empty();
    }

    public String actualizarTecnico(String codigo, String nombre, String documento, Especialidad especialidad,
                                    EstadoLaboral estadoLaboral) {
        Optional<Tecnico> encontrado = buscarTecnico(codigo);
        if (encontrado.isEmpty()) {
            return "No existe un tecnico con el codigo " + codigo + ".";
        }
        if (documentoTecnicoExiste(documento, codigo)) {
            return "No se puede actualizar: otro tecnico ya tiene ese documento.";
        }
        Tecnico tecnico = encontrado.get();
        tecnico.setNombre(nombre);
        tecnico.setID(documento);
        tecnico.setEspecialidad(especialidad);
        tecnico.setEstadoLaboral(estadoLaboral);
        return "Tecnico actualizado correctamente.";
    }

    public String borrarTecnico(String codigo) {
        Optional<Tecnico> encontrado = buscarTecnico(codigo);
        if (encontrado.isEmpty()) {
            return "No existe un tecnico con ese codigo.";
        }
        if (tecnicoEstaAsignado(codigo)) {
            return "No se puede eliminar el tecnico porque tiene intervenciones asignadas.";
        }
        listaTecnicos.remove(encontrado.get());
        return "El tecnico fue eliminado exitosamente.";
    }

    public String registrarRepuesto(Repuesto repuesto) {
        if (buscarRepuesto(repuesto.getCodigoUnico()).isPresent()) {
            return "No se puede registrar: ya existe un repuesto con ese codigo.";
        }
        if (repuesto.getCantidadExistente() < 0 || repuesto.getPrecioUnidad() < 0) {
            return "El precio y la cantidad no pueden ser negativos.";
        }
        repuesto.setOwnedByTechRepair(this);
        listaRepuestos.add(repuesto);
        return "El repuesto fue registrado exitosamente.";
    }

    public Optional<Repuesto> buscarRepuesto(String codigoUnico) {
        for (Repuesto repuesto : listaRepuestos) {
            if (repuesto.getCodigoUnico().equals(codigoUnico)) {
                return Optional.of(repuesto);
            }
        }
        return Optional.empty();
    }

    public String actualizarRepuesto(String codigo, String nombre, String descripcion, double precio,
                                     int cantidad, String compatibilidad) {
        Optional<Repuesto> encontrado = buscarRepuesto(codigo);
        if (encontrado.isEmpty()) {
            return "No existe un repuesto con ese codigo.";
        }
        if (precio < 0 || cantidad < 0) {
            return "El precio y la cantidad no pueden ser negativos.";
        }
        Repuesto repuesto = encontrado.get();
        repuesto.setNombre(nombre);
        repuesto.setDescripcion(descripcion);
        repuesto.setPrecioUnidad(precio);
        repuesto.setCantidadExistente(cantidad);
        repuesto.setCompatibilidad(compatibilidad);
        return "Repuesto actualizado correctamente.";
    }

    public String borrarRepuesto(String codigoUnico) {
        Optional<Repuesto> encontrado = buscarRepuesto(codigoUnico);
        if (encontrado.isEmpty()) {
            return "No existe un repuesto con ese codigo.";
        }
        if (repuestoEstaUtilizado(codigoUnico)) {
            return "No se puede eliminar un repuesto que aparece en una reparacion.";
        }
        listaRepuestos.remove(encontrado.get());
        return "El repuesto fue eliminado exitosamente.";
    }

    public String registrarServicio(Servicio servicio) {
        if (buscarServicio(servicio.getCodigo()).isPresent()) {
            return "No se puede registrar: ya existe un servicio con ese codigo.";
        }
        servicio.setOwnedByTechRepair(this);
        listaServicios.add(servicio);
        return "El servicio fue registrado exitosamente.";
    }

    public Optional<Servicio> buscarServicio(String codigo) {
        for (Servicio servicio : listaServicios) {
            if (servicio.getCodigo().equals(codigo)) {
                return Optional.of(servicio);
            }
        }
        return Optional.empty();
    }

    public String actualizarServicio(String codigo, String nombre, String descripcion) {
        Optional<Servicio> encontrado = buscarServicio(codigo);
        if (encontrado.isEmpty()) {
            return "No existe un servicio con ese codigo.";
        }
        encontrado.get().setNombre(nombre);
        encontrado.get().setDescripcion(descripcion);
        return "Servicio actualizado correctamente.";
    }

    public String borrarServicio(String codigo) {
        Optional<Servicio> encontrado = buscarServicio(codigo);
        if (encontrado.isEmpty()) {
            return "No existe un servicio con ese codigo.";
        }
        if (servicioEstaEnUso(codigo)) {
            return "No se puede eliminar un servicio que aparece en un detalle de servicio.";
        }
        listaServicios.remove(encontrado.get());
        return "El servicio fue eliminado exitosamente.";
    }

    public String registrarOrdenServicio(OrdenServicio ordenServicio) {
        if (buscarOrdenServicio(ordenServicio.codigoUnico()).isPresent()) {
            return "No se puede registrar: ya existe una orden con ese codigo.";
        }
        listaOrdenesServicios.add(ordenServicio);
        for (DetalleServicio detalle : ordenServicio.listaDetallesServicios()) {
            detalle.setOwnedByOrdenServicio(ordenServicio);
        }
        return "La orden de servicio fue registrada exitosamente.";
    }

    public Optional<OrdenServicio> buscarOrdenServicio(String codigoUnico) {
        for (OrdenServicio orden : listaOrdenesServicios) {
            if (orden.codigoUnico().equals(codigoUnico)) {
                return Optional.of(orden);
            }
        }
        return Optional.empty();
    }

    public String actualizarOrdenServicio(OrdenServicio nuevaOrden) {
        Optional<OrdenServicio> encontrada = buscarOrdenServicio(nuevaOrden.codigoUnico());
        if (encontrada.isEmpty()) {
            return "No existe una orden con ese codigo.";
        }

        OrdenServicio anterior = encontrada.get();
        if (anterior.estadoOrden() == EstadoOrden.ENTREGADA || anterior.estadoOrden() == EstadoOrden.CANCELADA) {
            return "No se puede actualizar una orden entregada o cancelada.";
        }
        if (anterior.estadoOrden() == EstadoOrden.FINALIZADA && nuevaOrden.estadoOrden() != EstadoOrden.ENTREGADA) {
            return "Una orden finalizada solo puede pasar a entregada.";
        }
        if (nuevaOrden.estadoOrden() == EstadoOrden.FINALIZADA) {
            return "Para finalizar una orden utilice el metodo finalizarOrden.";
        }
        if (nuevaOrden.estadoOrden() == EstadoOrden.ENTREGADA && anterior.estadoOrden() != EstadoOrden.FINALIZADA) {
            return "Una orden debe estar finalizada antes de marcarse como entregada.";
        }

        reemplazarOrdenInterno(nuevaOrden);
        return "Orden actualizada correctamente.";
    }

    private void reemplazarOrdenInterno(OrdenServicio nuevaOrden) {
        for (int i = 0; i < listaOrdenesServicios.size(); i++) {
            if (listaOrdenesServicios.get(i).codigoUnico().equals(nuevaOrden.codigoUnico())) {
                listaOrdenesServicios.set(i, nuevaOrden);
                for (DetalleServicio detalle : nuevaOrden.listaDetallesServicios()) {
                    detalle.setOwnedByOrdenServicio(nuevaOrden);
                }
                return;
            }
        }
    }

    private OrdenServicio cambiarEstadoOrden(OrdenServicio orden, EstadoOrden estado) {
        OrdenServicio nueva = new OrdenServicio(orden.codigoUnico(), orden.fechaCreacion(),
                orden.clienteAsociado(), orden.observaciones(), estado,
                orden.listaDetallesServicios(), this);
        reemplazarOrdenInterno(nueva);
        return nueva;
    }

    public String eliminarOrdenServicio(OrdenServicio ordenServicio) {
        Optional<OrdenServicio> encontrada = buscarOrdenServicio(ordenServicio.codigoUnico());
        if (encontrada.isEmpty()) {
            return "La orden que intenta eliminar no existe.";
        }
        OrdenServicio orden = encontrada.get();
        for (DetalleServicio detalle : orden.listaDetallesServicios()) {
            devolverTodosLosRepuestos(detalle);
        }
        listaOrdenesServicios.remove(orden);
        return "La orden fue eliminada exitosamente y el inventario fue actualizado.";
    }

    public String agregarDetalleServicio(OrdenServicio orden, DetalleServicio detalle) {
        if (orden == null || detalle == null) {
            return "Debe seleccionar una orden y un detalle.";
        }
        Optional<OrdenServicio> ordenRegistrada = buscarOrdenServicio(orden.codigoUnico());
        if (ordenRegistrada.isEmpty() || ordenRegistrada.get() != orden) {
            return "La orden debe estar registrada antes de agregar detalles.";
        }
        if (!ordenModificable(orden)) {
            return "No se pueden agregar detalles a una orden finalizada, entregada o cancelada.";
        }
        if (buscarDetalle(orden, detalle.getCodigoUnico()).isPresent()) {
            return "Ya existe un detalle con ese codigo dentro de la orden.";
        }
        if (orden.clienteAsociado().buscarEquipo(detalle.getEquipo().getCodigoUnico()).isEmpty()) {
            return "El equipo debe pertenecer al cliente de la orden.";
        }
        if (buscarServicio(detalle.getServicioAsociado().getCodigo()).isEmpty()) {
            return "El servicio debe estar registrado en el sistema.";
        }
        orden.agregarDetalle(detalle);
        if (orden.estadoOrden() == EstadoOrden.ABIERTA) {
            cambiarEstadoOrden(orden, EstadoOrden.EN_PROCESO);
        }
        return "Detalle agregado correctamente.";
    }

    public Optional<DetalleServicio> buscarDetalle(OrdenServicio orden, String codigoDetalle) {
        if (orden == null) {
            return Optional.empty();
        }
        for (DetalleServicio detalle : orden.listaDetallesServicios()) {
            if (detalle.getCodigoUnico().equals(codigoDetalle)) {
                return Optional.of(detalle);
            }
        }
        return Optional.empty();
    }

    public String actualizarDatosDetalle(OrdenServicio orden, DetalleServicio detalle, Equipo equipo,
                                         Servicio servicio, String descripcion, int horasTrabajo,
                                         String observacionesTecnicas) {
        String error = validarDetalleEnOrden(orden, detalle,
                "No se pueden modificar detalles de una orden finalizada, entregada o cancelada.");
        if (error != null) {
            return error;
        }
        if (!detalle.getListaRepuestosUtilizados().isEmpty()) {
            return "Para cambiar el equipo o el servicio, primero debe retirar los repuestos utilizados.";
        }
        if (orden.clienteAsociado().buscarEquipo(equipo.getCodigoUnico()).isEmpty()) {
            return "El equipo debe pertenecer al cliente de la orden.";
        }
        if (buscarServicio(servicio.getCodigo()).isEmpty()) {
            return "El servicio debe estar registrado en el sistema.";
        }
        if (horasTrabajo < 0) {
            return "Las horas de trabajo no pueden ser negativas.";
        }
        detalle.setEquipo(equipo);
        detalle.setServicioAsociado(servicio);
        detalle.setDescripcion(descripcion);
        detalle.setHorasTrabajo(horasTrabajo);
        detalle.setObservTecnicas(observacionesTecnicas);
        detalle.setTecnicoResp(null);
        return "Detalle actualizado correctamente. Debe volver a asignar un tecnico.";
    }

    public String eliminarDetalleServicio(OrdenServicio orden, String codigoDetalle) {
        if (orden == null) {
            return "No existe la orden seleccionada.";
        }
        if (!ordenModificable(orden)) {
            return "No se pueden eliminar detalles de una orden finalizada, entregada o cancelada.";
        }
        Optional<DetalleServicio> encontrado = buscarDetalle(orden, codigoDetalle);
        if (encontrado.isEmpty()) {
            return "No existe ese detalle.";
        }
        devolverTodosLosRepuestos(encontrado.get());
        orden.eliminarDetalle(encontrado.get());
        return "Detalle eliminado correctamente y el inventario fue actualizado.";
    }

    public boolean ordenModificable(OrdenServicio orden) {
        return orden != null && orden.estadoOrden() != EstadoOrden.FINALIZADA
                && orden.estadoOrden() != EstadoOrden.ENTREGADA
                && orden.estadoOrden() != EstadoOrden.CANCELADA;
    }

    public String asignarTecnico(OrdenServicio orden, DetalleServicio detalle, Tecnico tecnico) {
        if (tecnico == null || orden == null || detalle == null) {
            return "Debe seleccionar una orden, un detalle y un tecnico.";
        }
        String error = validarDetalleEnOrden(orden, detalle,
                "No se puede asignar un tecnico a una orden finalizada, entregada o cancelada.");
        if (error != null) {
            return error;
        }
        Optional<Tecnico> tecnicoRegistrado = buscarTecnico(tecnico.getCodigo());
        if (tecnicoRegistrado.isEmpty() || tecnicoRegistrado.get() != tecnico) {
            return "El tecnico debe estar registrado en el sistema.";
        }
        if (tecnico.getEstadoLaboral() != EstadoLaboral.ACTIVO) {
            return "Solo se pueden asignar tecnicos activos.";
        }
        if (!especialidadAutorizada(tecnico, detalle.getEquipo())) {
            return "La especialidad del tecnico no corresponde al equipo.";
        }
        detalle.setTecnicoResp(tecnico);
        return "Tecnico asignado correctamente.";
    }

    public String actualizarEstadoDetalle(OrdenServicio orden, DetalleServicio detalle, EstadoOrden estado) {
        String error = validarDetalleEnOrden(orden, detalle,
                "No se puede cambiar el estado de detalles de una orden finalizada, entregada o cancelada.");
        if (error != null) {
            return error;
        }
        if (estado != EstadoOrden.ABIERTA && estado != EstadoOrden.EN_PROCESO
                && estado != EstadoOrden.FINALIZADA) {
            return "El estado elegido no es valido para un detalle de servicio.";
        }
        if (estado == EstadoOrden.FINALIZADA && detalle.getTecnicoResp() == null) {
            return "Debe asignar un tecnico antes de finalizar la intervencion.";
        }
        detalle.setEstadoIntervencion(estado);
        return "Estado del detalle actualizado a " + estado + ".";
    }

    public String registrarRepuestoUtilizado(OrdenServicio orden, DetalleServicio detalle,
                                             RepuestoUtilizado repuestoUtilizado) {
        if (repuestoUtilizado == null || orden == null || detalle == null) {
            return "Debe indicar una orden, un detalle y un repuesto.";
        }
        String error = validarDetalleEnOrden(orden, detalle,
                "No se pueden agregar repuestos a una orden finalizada, entregada o cancelada.");
        if (error != null) {
            return error;
        }
        if (repuestoUtilizado.getRepuestoUtilizado() == null) {
            return "Debe seleccionar un repuesto valido.";
        }
        Optional<Repuesto> repuestoRegistrado = buscarRepuesto(repuestoUtilizado.getRepuestoUtilizado().getCodigoUnico());
        if (repuestoRegistrado.isEmpty() || repuestoRegistrado.get() != repuestoUtilizado.getRepuestoUtilizado()) {
            return "El repuesto debe estar registrado en el inventario.";
        }
        if (!(detalle.getServicioAsociado() instanceof ReparacionCorrectiva)) {
            return "Los repuestos solo pueden agregarse a una reparacion correctiva.";
        }
        if (repuestoUtilizado.getCantidad() <= 0) {
            return "La cantidad debe ser mayor a cero.";
        }
        Repuesto repuesto = repuestoUtilizado.getRepuestoUtilizado();
        if (buscarRepuestoUtilizado(detalle, repuesto.getCodigoUnico()).isPresent()) {
            return "No se puede registrar, el repuesto " + repuesto.getCodigoUnico() + " ya está registrado en este detalle.";
        }
        if (repuestoUtilizado.getCantidad() > repuesto.getCantidadExistente()) {
            return "Inventario insuficiente del repuesto " + repuesto.getCodigoUnico()
                    + ": se solicitan " + repuestoUtilizado.getCantidad()
                    + " y hay " + repuesto.getCantidadExistente() + " disponibles.";
        }
        repuesto.setCantidadExistente(repuesto.getCantidadExistente() - repuestoUtilizado.getCantidad());
        detalle.agregarRepuesto(repuestoUtilizado);
        return "El repuesto fue registrado exitosamente y se descontó del inventario.";
    }

    public Optional<RepuestoUtilizado> buscarRepuestoUtilizado(DetalleServicio detalle, String codigoRepuesto) {
        for (RepuestoUtilizado usado : detalle.getListaRepuestosUtilizados()) {
            if (usado.getRepuestoUtilizado().getCodigoUnico().equals(codigoRepuesto)) {
                return Optional.of(usado);
            }
        }
        return Optional.empty();
    }

    public String actualizarRepuestoUtilizado(OrdenServicio orden, DetalleServicio detalle,
                                              String codigoRepuesto, int cantidad, double precioUnidad) {
        String error = validarDetalleEnOrden(orden, detalle,
                "No se pueden modificar repuestos de una orden finalizada, entregada o cancelada.");
        if (error != null) {
            return error;
        }
        Optional<RepuestoUtilizado> encontrado = buscarRepuestoUtilizado(detalle, codigoRepuesto);
        if (encontrado.isEmpty()) {
            return "El repuesto " + codigoRepuesto + " no está registrado en este detalle.";
        }
        if (cantidad <= 0) {
            return "La cantidad debe ser mayor a cero.";
        }
        if (precioUnidad < 0) {
            return "El precio por unidad no puede ser negativo.";
        }
        RepuestoUtilizado usado = encontrado.get();
        Repuesto repuesto = usado.getRepuestoUtilizado();
        int diferencia = cantidad - usado.getCantidad();
        if (diferencia > repuesto.getCantidadExistente()) {
            return "Inventario insuficiente del repuesto " + codigoRepuesto
                    + ": se necesitan " + diferencia + " unidades adicionales y hay "
                    + repuesto.getCantidadExistente() + " disponibles.";
        }
        repuesto.setCantidadExistente(repuesto.getCantidadExistente() - diferencia);
        usado.setCantidad(cantidad);
        usado.setPrecioUnidad(precioUnidad);
        return "Repuesto utilizado actualizado correctamente.";
    }

    public String borrarRepuestoUtilizado(OrdenServicio orden, DetalleServicio detalle, String codigoRepuesto) {
        String error = validarDetalleEnOrden(orden, detalle,
                "No se pueden modificar repuestos de una orden finalizada, entregada o cancelada.");
        if (error != null) {
            return error;
        }
        Optional<RepuestoUtilizado> encontrado = buscarRepuestoUtilizado(detalle, codigoRepuesto);
        if (encontrado.isEmpty()) {
            return "El repuesto no está registrado en este detalle.";
        }
        RepuestoUtilizado usado = encontrado.get();
        Repuesto repuesto = usado.getRepuestoUtilizado();
        repuesto.setCantidadExistente(repuesto.getCantidadExistente() + usado.getCantidad());
        detalle.quitarRepuesto(usado);
        return "El repuesto fue borrado exitosamente. Se devolvieron " + usado.getCantidad() + " unidades al inventario.";
    }

    // 67676767676767
    private boolean especialidadAutorizada(Tecnico tecnico, Equipo equipo) {
        if (tecnico.getEspecialidad() == Especialidad.SOPORTE_GENERAL) {
            return true;
        }
        if (equipo instanceof TelefonoInteligente) {
            return tecnico.getEspecialidad() == Especialidad.DISPOSITIVOS_MOVILES;
        }
        return tecnico.getEspecialidad() == Especialidad.COMPUTADORES;
    }

    public String finalizarOrden(String codigoOrden) {
        Optional<OrdenServicio> encontrada = buscarOrdenServicio(codigoOrden);
        if (encontrada.isEmpty()) {
            return "No existe una orden con ese codigo.";
        }
        OrdenServicio orden = encontrada.get();
        if (orden.estadoOrden() == EstadoOrden.FINALIZADA) {
            return "La orden ya esta finalizada.";
        }
        if (orden.estadoOrden() == EstadoOrden.ENTREGADA || orden.estadoOrden() == EstadoOrden.CANCELADA) {
            return "No se puede finalizar una orden entregada o cancelada.";
        }
        if (orden.listaDetallesServicios().isEmpty()) {
            return "No se puede finalizar una orden sin detalles.";
        }
        if (!orden.todosLosDetallesEstanFinalizados()) {
            return "No se puede finalizar: hay intervenciones pendientes.";
        }
        OrdenServicio actualizada = cambiarEstadoOrden(orden, EstadoOrden.FINALIZADA);
        return "Orden finalizada correctamente. Valor total: $" + actualizada.calcularValorTotal();
    }

    public List<OrdenServicio> OrdenesCliente(String numeroDocumento) {
        ArrayList<OrdenServicio> resultado = new ArrayList<>();
        for (OrdenServicio orden : listaOrdenesServicios) {
            if (orden.clienteAsociado() != null
                    && orden.clienteAsociado().getNumeroDocumento().equals(numeroDocumento)) {
                resultado.add(orden);
            }
        }
        return Collections.unmodifiableList(resultado);
    }

    public List<Equipo> equiposPendientes() {
        ArrayList<Equipo> resultado = new ArrayList<>();
        for (OrdenServicio orden : listaOrdenesServicios) {
            if (orden.estadoOrden() == EstadoOrden.CANCELADA || orden.estadoOrden() == EstadoOrden.ENTREGADA) {
                continue;
            }
            for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                if (detalle.getEstadoIntervencion() != EstadoOrden.FINALIZADA
                        && detalle.getEstadoIntervencion() != EstadoOrden.ENTREGADA
                        && detalle.getEstadoIntervencion() != EstadoOrden.CANCELADA) {
                    if (!OrdenServicio.contieneEquipo(resultado, detalle.getEquipo())) {
                        resultado.add(detalle.getEquipo());
                    }
                }
            }
        }
        return Collections.unmodifiableList(resultado);
    }

    public String consultarTrabajosTecnico(String codigoTecnico) {
        Optional<Tecnico> encontrado = buscarTecnico(codigoTecnico);
        if (encontrado.isEmpty()) {
            return "No existe un tecnico con ese codigo.";
        }
        String texto = "TRABAJOS DEL TECNICO: " + encontrado.get().getNombre() + "\n";
        boolean tieneTrabajos = false;
        for (EstadoOrden estado : EstadoOrden.values()) {
            texto = texto + "\n===== " + estado + " =====\n";
            int cantidad = 0;
            for (OrdenServicio orden : listaOrdenesServicios) {
                for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                    Tecnico asignado = detalle.getTecnicoResp();
                    if (asignado != null && asignado.getCodigo().equals(codigoTecnico)
                            && detalle.getEstadoIntervencion() == estado) {
                        tieneTrabajos = true;
                        cantidad++;
                        texto = texto + "Orden: " + orden.codigoUnico()
                                + " | Detalle: " + detalle.getCodigoUnico()
                                + " | Equipo: " + detalle.getEquipo().getCodigoUnico()
                                + " | Servicio: " + detalle.getServicioAsociado().getNombre()
                                + " | Valor: $" + detalle.calcularCosto() + "\n";
                    }
                }
            }
            if (cantidad == 0) {
                texto = texto + "Sin trabajos en este estado.\n";
            }
        }
        if (!tieneTrabajos) {
            texto = texto + "\nEste tecnico todavia no tiene intervenciones asignadas.";
        }
        return texto;
    }

    public String generarReporteServicios() {
        int[] cantidades = new int[3];
        double[] totales = new double[3];
        String[] categorias = {"Diagnostico", "Mantenimiento preventivo", "Reparacion correctiva"};

        for (OrdenServicio orden : listaOrdenesServicios) {
            for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                int posicion = posicionCategoria(detalle.getServicioAsociado());
                cantidades[posicion] = cantidades[posicion] + 1;
                totales[posicion] = totales[posicion] + detalle.calcularCosto();
            }
        }

        String reporte = "REPORTE DE SERVICIOS POR CATEGORIA\n\n";
        boolean hayServicios = false;
        for (int i = 0; i < categorias.length; i++) {
            if (cantidades[i] > 0) {
                hayServicios = true;
                reporte = reporte + "Categoria: " + categorias[i]
                        + "\nCantidad de intervenciones: " + cantidades[i]
                        + "\nTotal facturado: $" + totales[i] + "\n\n";
            }
        }
        if (!hayServicios) {
            return "No hay servicios registrados para generar el reporte.";
        }
        return reporte;
    }

    public String generarReporteTecnicos() {
        String reporte = "REPORTE DE INTERVENCIONES FINALIZADAS POR TECNICO\n\n";
        boolean hayResultados = false;
        for (Tecnico tecnico : listaTecnicos) {
            int cantidad = 0;
            double total = 0;
            for (OrdenServicio orden : listaOrdenesServicios) {
                for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                    if (detalle.getTecnicoResp() != null
                            && detalle.getTecnicoResp().getCodigo().equals(tecnico.getCodigo())
                            && detalle.getEstadoIntervencion() == EstadoOrden.FINALIZADA) {
                        cantidad++;
                        total = total + detalle.calcularCosto();
                    }
                }
            }
            if (cantidad > 0) {
                hayResultados = true;
                reporte = reporte + "Tecnico: " + tecnico.getNombre() + " (" + tecnico.getCodigo() + ")"
                        + "\nIntervenciones finalizadas: " + cantidad
                        + "\nValor de los servicios atendidos: $" + total + "\n\n";
            }
        }
        if (!hayResultados) {
            return "No hay intervenciones finalizadas y asignadas para generar el reporte.";
        }
        return reporte;
    }

    public List<Repuesto> inventarioCritico() {
        ArrayList<Repuesto> resultado = new ArrayList<>();
        for (Repuesto repuesto : listaRepuestos) {
            if (repuesto.getCantidadExistente() < 5) {
                resultado.add(repuesto);
            }
        }
        return Collections.unmodifiableList(resultado);
    }

    private void devolverTodosLosRepuestos(DetalleServicio detalle) {
        for (RepuestoUtilizado usado : new ArrayList<>(detalle.getListaRepuestosUtilizados())) {
            Repuesto repuesto = usado.getRepuestoUtilizado();
            repuesto.setCantidadExistente(repuesto.getCantidadExistente() + usado.getCantidad());
            detalle.quitarRepuesto(usado);
        }
    }

    private String validarDetalleEnOrden(OrdenServicio orden, DetalleServicio detalle, String mensajeNoModificable) {
        if (orden == null || detalle == null) {
            return "Debe seleccionar una orden y un detalle.";
        }
        if (!ordenModificable(orden)) {
            return mensajeNoModificable;
        }
        Optional<DetalleServicio> detalleRegistrado = buscarDetalle(orden, detalle.getCodigoUnico());
        if (detalleRegistrado.isEmpty() || detalleRegistrado.get() != detalle) {
            return "El detalle no pertenece a la orden seleccionada.";
        }
        return null;
    }

    public boolean equipoEstaEnDetalle(Equipo equipoBuscado) {
        for (OrdenServicio orden : listaOrdenesServicios) {
            for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                if (detalle.getEquipo() == equipoBuscado) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean documentoTecnicoExiste(String documento, String codigoExcluir) {
        for (Tecnico tecnico : listaTecnicos) {
            boolean esOtroTecnico = codigoExcluir == null || !tecnico.getCodigo().equals(codigoExcluir);
            if (esOtroTecnico && tecnico.getID().equals(documento)) {
                return true;
            }
        }
        return false;
    }

    public boolean tecnicoEstaAsignado(String codigoTecnico) {
        for (OrdenServicio orden : listaOrdenesServicios) {
            for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                if (detalle.getTecnicoResp() != null
                        && detalle.getTecnicoResp().getCodigo().equals(codigoTecnico)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repuestoEstaUtilizado(String codigoRepuesto) {
        for (OrdenServicio orden : listaOrdenesServicios) {
            for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                if (buscarRepuestoUtilizado(detalle, codigoRepuesto).isPresent()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean servicioEstaEnUso(String codigoServicio) {
        for (OrdenServicio orden : listaOrdenesServicios) {
            for (DetalleServicio detalle : orden.listaDetallesServicios()) {
                if (detalle.getServicioAsociado().getCodigo().equals(codigoServicio)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int posicionCategoria(Servicio servicio) {
        if (servicio instanceof Diagnostico) {
            return 0;
        }
        if (servicio instanceof MantenimientoPreventivo) {
            return 1;
        }
        return 2;
    }
}
