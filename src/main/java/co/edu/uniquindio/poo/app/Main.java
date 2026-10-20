package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        TechRepair techRepair = new TechRepair();
        int opcion;

        do {
            opcion= Integer.valueOf(JOptionPane.showInputDialog(null,"Seleccione una opción:\n"
                    + "--- CLIENTES ---          ---SERVICIOS---" +

                    "\n1. Registrar cliente      21. Crear diagnóstico                    43. Reporte de servicios" +
                    "\n2. Consultar cliente      22. Crear mantenimiento preventivo       44. Reporte de técnicos" +
                    "\n3. Actualizar cliente     23. Crear reparación correctiva          45. Consultar inventario crítico" +
                    "\n4. Eliminar cliente       24. Consultar servicios                  46. Salir\nd"
                    + "--- EQUIPOS ---           25.Actualizar servicio" +
                    "\n5. Registrar equipo       26. Eliminar servicio" +
                    "\n6. Consultar equipo       --- DETALLES Y REPUESTOS UTILIZADOS ---" +
                    "\n7. Actualizar equipo      27. Agregar detalle a una orden" +
                    "\n8. Eliminar equipo        28. Consultar detalles de una orden\n"
                    + "--- TÉCNICOS ---          29. Actualizar detalle" +
                    "\n9. Registrar técnico      30. Eliminar detalle" +
                    "\n10. Consultar técnico     31. Asignar técnico" +
                    "\n11. Actualizar técnico    32. Agregar repuesto utilizado" +
                    "\n12. Eliminar técnico      33. Consultar repuestos utilizados\n"
                    + "--- REPUESTOS ---         34. Actualizar repuesto utilizado" +
                    "\n13. Registrar repuesto    35. Eliminar repuesto utilizado" +
                    "\n14. Consultar repuesto    --- FUNCIONALIDADES DEL PARCIAL ---" +
                    "\n15. Actualizar repuesto   36. Calcular costo de un detalle" +
                    "\n16. Eliminar repuesto     37. Calcular valor total de una orden\n"
                    + "--- ÓRDENES ---           38. Actualizar estado de un detalle" +
                    "\n17. Crear orden           39. Finalizar orden" +
                    "\n18. Consultar orden(es)   40. Consultar órdenes de un cliente" +
                    "\n19. Actualizar orden      41. Consultar trabajos de un técnico" +
                    "\n20. Eliminar orden        42. Consultar equipos pendientes"));

            switch (opcion) {
                case 1:
                    registrarCliente(techRepair);
                    break;
                case 2:
                    consultarCliente(techRepair);
                    break;
                case 3:
                    actualizarCliente(techRepair);
                    break;
                case 4:
                    eliminarCliente(techRepair);
                    break;
                case 5:
                    registrarEquipo(techRepair);
                    break;
                case 6:
                    consultarEquipo(techRepair);
                    break;
                case 7:
                    actualizarEquipo(techRepair);
                    break;
                case 8:
                    eliminarEquipo(techRepair);
                    break;
                case 9:
                    registrarTecnico(techRepair);
                    break;
                case 10:
                    consultarTecnico(techRepair);
                    break;
                case 11:
                    actualizarTecnico(techRepair);
                    break;
                case 12:
                    eliminarTecnico(techRepair);
                    break;
                case 13:
                    registrarRepuesto(techRepair);
                    break;
                case 14:
                    consultarRepuesto(techRepair);
                    break;
                case 15:
                    actualizarRepuesto(techRepair);
                    break;
                case 16:
                    eliminarRepuesto(techRepair);
                    break;
                case 17:
                    crearOrdenServicio(techRepair);
                    break;
                case 18:
                    consultarOrdenServicio(techRepair);
                    break;
                case 19:
                    actualizarOrdenServicio(techRepair);
                    break;
                case 20:
                    eliminarOrdenServicio(techRepair);
                    break;
                case 21:
                    crearDiagnostico(techRepair);
                    break;
                case 22:
                    crearMantenimientoPreventivo(techRepair);
                    break;
                case 23:
                    crearReparacionCorrectiva(techRepair);
                    break;
                case 24:
                    consultarServicios(techRepair);
                    break;
                case 25:
                    actualizarServicio(techRepair);
                    break;
                case 26:
                    eliminarServicio(techRepair);
                    break;
                case 27:
                    agregarDetalleServicio(techRepair);
                    break;
                case 28:
                    consultarDetallesOrden(techRepair);
                    break;
                case 29:
                    actualizarDetalleServicio(techRepair);
                    break;
                case 30:
                    eliminarDetalleServicio(techRepair);
                    break;
                case 31:
                    asignarTecnico(techRepair);
                    break;
                case 32:
                    agregarRepuestoUtilizado(techRepair);
                    break;
                case 33:
                    consultarRepuestosUtilizados(techRepair);
                    break;
                case 34:
                    actualizarRepuestoUtilizado(techRepair);
                    break;
                case 35:
                    eliminarRepuestoUtilizado(techRepair);
                    break;
                case 36:
                    calcularValorDetalle(techRepair);
                    break;
                case 37:
                    calcularValorOrden(techRepair);
                    break;
                case 38:
                    actualizarEstadoDetalle(techRepair);
                    break;
                case 39:
                    finalizarOrdenServicio(techRepair);
                    break;
                case 40:
                    consultarOrdenesCliente(techRepair);
                    break;
                case 41:
                    consultarTrabajosTecnico(techRepair);
                    break;
                case 42:
                    consultarEquiposPendientes(techRepair);
                    break;
                case 43:
                    generarReporteServicios(techRepair);
                    break;
                case 44:
                    generarReporteTecnicos(techRepair);
                    break;
                case 45:
                    mostrarRepuestosCriticos(techRepair);
                    break;
                case 46:
                    JOptionPane.showMessageDialog(null, "MUchas gracias por utilizar nuestro sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción elegida no es válidad, vuelva a escoger por favor.");
                    break;
            }
        } while (opcion != 46);
    }

    private static void registrarCliente(TechRepair techRepair) {
        String documento = leerTexto("Documento del cliente:");
        if (documento == null) return;
        String nombre = leerTexto("Nombre completo:");
        String telefono = leerTexto("Número telefónico:");
        String correo = leerTexto("Correo electrónico:");
        String direccion = leerTexto("Dirección de residencia:");
        if (cancelado(nombre, telefono, correo, direccion)) return;

        Cliente cliente = new Cliente(telefono, documento, nombre, correo, direccion);
        mostrar(techRepair.registrarCliente(cliente), "Cliente");
    }

    private static void consultarCliente(TechRepair techRepair) {
        String documento = leerTexto("Documento del cliente que desea consultar:");
        if (documento == null) return;
        Optional<Cliente> cliente = techRepair.buscarCliente(documento);
        if (cliente.isPresent()) {
            mostrar(cliente.get().toString(), "Consulta de cliente");
        } else {
            mostrar("No se encontró un cliente con ese documento.", "Consulta de cliente");
        }
    }

    private static void actualizarCliente(TechRepair techRepair) {
        String documento = leerTexto("Documento del cliente que desea actualizar:");
        if (documento == null) return;
        if (techRepair.buscarCliente(documento).isEmpty()) {
            mostrar("No existe un cliente con ese documento.", "Validación");
            return;
        }
        String nombre = leerTexto("Nuevo nombre completo:");
        String telefono = leerTexto("Nuevo teléfono:");
        String correo = leerTexto("Nuevo correo electrónico:");
        String direccion = leerTexto("Nueva dirección:");
        if (cancelado(nombre, telefono, correo, direccion)) return;
        mostrar(techRepair.actualizarCliente(documento, telefono, nombre, correo, direccion), "Cliente actualizado");
    }

    private static void eliminarCliente(TechRepair techRepair) {
        String documento = leerTexto("Documento del cliente que desea eliminar:");
        if (documento == null) return;
        Optional<Cliente> encontrado = techRepair.buscarCliente(documento);
        if (encontrado.isEmpty()) {
            mostrar("No existe un cliente con ese documento.", "Validación");
            return;
        }
        Cliente cliente = encontrado.get();
        boolean confirmar = confirmar("¿Confirma que desea eliminar a " + cliente.getNombreCompleto() + "?");
        if (confirmar) mostrar(techRepair.borrarCliente(documento), "Cliente");
    }

    private static void registrarEquipo(TechRepair techRepair) {
        String documento = leerTexto("Documento del cliente propietario del equipo:");
        if (documento == null) return;
        Optional<Cliente> encontrado = techRepair.buscarCliente(documento);
        if (encontrado.isEmpty()) {
            mostrar("Debe registrar primero al cliente.", "Validación");
            return;
        }
        String codigo = leerTexto("Código único del equipo:");
        if (codigo == null) return;
        Equipo equipo = capturarEquipo(codigo);
        if (equipo == null) return;
        Cliente propietario = encontrado.get();
        mostrar(techRepair.registrarEquipo(propietario, equipo), "Equipo");
    }

    private static void consultarEquipo(TechRepair techRepair) {
        String codigo = leerTexto("Código del equipo:");
        if (codigo == null) return;
        Optional<Equipo> equipo = techRepair.buscarEquipo(codigo);
        Optional<Cliente> propietario = techRepair.buscarPropietarioEquipo(codigo);
        if (equipo.isPresent() && propietario.isPresent()) {
            mostrar("Propietario: " + propietario.get().getNombreCompleto() + "\n\n"
                    + describirEquipo(equipo.get()), "Consulta de equipo");
        } else {
            mostrar("No existe un equipo con ese codigo.", "Consulta de equipo");
        }
    }

    private static void actualizarEquipo(TechRepair techRepair) {
        String codigo = leerTexto("Código del equipo que desea actualizar:");
        if (codigo == null) return;
        Optional<Equipo> equipoEncontrado = techRepair.buscarEquipo(codigo);
        Optional<Cliente> propietarioEncontrado = techRepair.buscarPropietarioEquipo(codigo);
        if (equipoEncontrado.isEmpty() || propietarioEncontrado.isEmpty()) {
            mostrar("No existe un equipo con ese codigo.", "Validacion");
            return;
        }
        Equipo anterior = equipoEncontrado.get();
        Equipo nuevo = capturarEquipo(anterior.getCodigoUnico());
        if (nuevo == null) return;
        Cliente propietario = propietarioEncontrado.get();
        mostrar(techRepair.actualizarEquipo(propietario, anterior, nuevo) + "\n" + nuevo, "Equipo");
    }

    private static void eliminarEquipo(TechRepair techRepair) {
        String codigo = leerTexto("Código del equipo que desea eliminar:");
        if (codigo == null) return;
        Optional<Equipo> equipo = techRepair.buscarEquipo(codigo);
        Optional<Cliente> propietario = techRepair.buscarPropietarioEquipo(codigo);
        if (equipo.isEmpty() || propietario.isEmpty()) {
            mostrar("No existe un equipo con ese codigo.", "Validacion");
            return;
        }
        mostrar(techRepair.eliminarEquipo(propietario.get(), equipo.get()), "Equipo");
    }

    private static void registrarTecnico(TechRepair techRepair) {
        String codigo = leerTexto("Código del técnico:");
        if (codigo == null) return;
        String nombre = leerTexto("Nombre del técnico:");
        String documento = leerTexto("Documento de identificación:");
        Especialidad especialidad = elegirEspecialidad();
        EstadoLaboral estado = elegirEstadoLaboral();
        if (cancelado(nombre, documento) || especialidad == null || estado == null) return;
        Tecnico tecnico = new Tecnico(codigo, nombre, documento, especialidad, estado);
        mostrar(techRepair.registrarTecnico(tecnico), "Técnico");
    }

    private static void consultarTecnico(TechRepair techRepair) {
        String codigo = leerTexto("Código del técnico:");
        if (codigo == null) return;
        Optional<Tecnico> tecnico = techRepair.buscarTecnico(codigo);
        if (tecnico.isPresent()) {
            mostrar(describirTecnico(tecnico.get()), "Consulta de técnico");
        } else {
            mostrar("No existe ese técnico.", "Consulta de técnico");
        }
    }

    private static void actualizarTecnico(TechRepair techRepair) {
        String codigo = leerTexto("Código del técnico que desea actualizar:");
        if (codigo == null) return;
        if (techRepair.buscarTecnico(codigo).isEmpty()) {
            mostrar("No existe ese técnico.", "Validación");
            return;
        }
        String nombre = leerTexto("Nuevo nombre:");
        String documento = leerTexto("Nuevo documento:");
        Especialidad especialidad = elegirEspecialidad();
        EstadoLaboral estado = elegirEstadoLaboral();
        if (cancelado(nombre, documento) || especialidad == null || estado == null) return;
        mostrar(techRepair.actualizarTecnico(codigo, nombre, documento, especialidad, estado), "Técnico");
    }

    private static void eliminarTecnico(TechRepair techRepair) {
        String codigo = leerTexto("Código del técnico que desea eliminar:");
        if (codigo == null) return;
        Optional<Tecnico> encontrado = techRepair.buscarTecnico(codigo);
        if (encontrado.isEmpty()) {
            mostrar("No existe ese técnico.", "Validación");
            return;
        }
        boolean confirmar = confirmar("¿Desea eliminar al técnico " + encontrado.get().getNombre() + "?");
        if (confirmar) mostrar(techRepair.borrarTecnico(codigo), "Técnico");
    }

    private static void registrarRepuesto(TechRepair techRepair) {
        String codigo = leerTexto("Código único del repuesto:");
        if (codigo == null) return;
        if (techRepair.buscarRepuesto(codigo).isPresent()) {
            mostrar("Ya existe un repuesto con ese código.", "Validación");
            return;
        }
        String nombre = leerTexto("Nombre del repuesto:");
        String descripcion = leerTexto("Descripción:");
        double precio = leerDecimal("Precio unitario:");
        int cantidad = leerEntero("Cantidad inicial disponible:");
        String compatibilidad = leerTexto("Categoría de compatibilidad:");
        if (cancelado(nombre, descripcion, compatibilidad) || precio == -1 || cantidad == -1) return;
        if (precio < 0 || cantidad < 0) {
            mostrar("El precio y la cantidad no pueden ser negativos.", "Validación");
            return;
        }
        Repuesto repuesto = new Repuesto(codigo, nombre, descripcion, precio, cantidad, compatibilidad);
        mostrar(techRepair.registrarRepuesto(repuesto), "Repuesto");
    }

    private static void consultarRepuesto(TechRepair techRepair) {
        String codigo = leerTexto("Código del repuesto:");
        if (codigo == null) return;
        Optional<Repuesto> repuesto = techRepair.buscarRepuesto(codigo);
        if (repuesto.isPresent()) {
            mostrar(repuesto.get().toString(), "Consulta de repuesto");
        } else {
            mostrar("No existe ese repuesto.", "Consulta de repuesto");
        }
    }

    private static void actualizarRepuesto(TechRepair techRepair) {
        String codigo = leerTexto("Código del repuesto que desea actualizar:");
        if (codigo == null) return;
        if (techRepair.buscarRepuesto(codigo).isEmpty()) {
            mostrar("No existe ese repuesto.", "Validación");
            return;
        }
        String nombre = leerTexto("Nuevo nombre:");
        String descripcion = leerTexto("Nueva descripción:");
        double precio = leerDecimal("Nuevo precio unitario:");
        int cantidad = leerEntero("Nueva cantidad disponible:");
        String compatibilidad = leerTexto("Nueva categoría de compatibilidad:");
        if (cancelado(nombre, descripcion, compatibilidad) || precio == -1 || cantidad == -1) return;
        if (precio < 0 || cantidad < 0) {
            mostrar("El precio y la cantidad no pueden ser negativos.", "Validación");
            return;
        }
        mostrar(techRepair.actualizarRepuesto(codigo, nombre, descripcion, precio, cantidad, compatibilidad), "Repuesto");
    }

    private static void eliminarRepuesto(TechRepair techRepair) {
        String codigo = leerTexto("Código del repuesto que desea eliminar:");
        if (codigo == null) return;
        Optional<Repuesto> repuesto = techRepair.buscarRepuesto(codigo);
        if (repuesto.isEmpty()) {
            mostrar("No existe ese repuesto.", "Validación");
            return;
        }
        boolean confirmar = confirmar("¿Desea eliminar el repuesto " + repuesto.get().getNombre() + "?");
        if (confirmar) mostrar(techRepair.borrarRepuesto(codigo), "Repuesto");
    }

    private static void crearOrdenServicio(TechRepair techRepair) {
        String documentoCliente = leerTexto("Documento del cliente:");
        if (documentoCliente == null) return;
        Optional<Cliente> cliente = techRepair.buscarCliente(documentoCliente);
        if (cliente.isEmpty()) {
            mostrar("El cliente no existe. Regístrelo primero.", "Validación");
            return;
        }
        String codigo = leerTexto("Código único de la orden:");
        String fecha = leerTexto("Fecha de creación (dd/mm/aaaa):");
        String observaciones = leerTexto("Observaciones generales:");
        if (cancelado(codigo, fecha, observaciones)) return;
        OrdenServicio orden = new OrdenServicio(codigo, fecha, cliente.get(), observaciones,
                EstadoOrden.ABIERTA, new ArrayList<>(), techRepair);
        mostrar(techRepair.registrarOrdenServicio(orden), "Orden de servicio");
    }

    private static void consultarOrdenServicio(TechRepair techRepair) {
        String codigo = leerTextoOpcional("Código de orden (deje vacío para listar todas):");
        if (codigo == null) return;
        if (codigo.trim().isEmpty()) {
            mostrar(listarOrdenes(techRepair), "Órdenes de servicio");
        } else {
            Optional<OrdenServicio> orden = techRepair.buscarOrdenServicio(codigo);
            if (orden.isPresent()) {
                mostrar(detalleOrden(orden.get()), "Orden de servicio");
            } else {
                mostrar("No existe esa orden.", "Orden de servicio");
            }
        }
    }

    private static void actualizarOrdenServicio(TechRepair techRepair) {
        String codigo = leerTexto("Codigo de la orden que desea actualizar:");
        if (codigo == null) return;
        Optional<OrdenServicio> encontrado = techRepair.buscarOrdenServicio(codigo);
        if (encontrado.isEmpty()) {
            mostrar("No existe esa orden.", "Validacion");
            return;
        }
        OrdenServicio orden = encontrado.get();
        String fecha = leerTexto("Nueva fecha (dd/mm/aaaa):");
        String observaciones = leerTextoOpcional("Nuevas observaciones (puede dejar vacio):");
        EstadoOrden estado = elegirEstadoOrden();
        if (cancelado(fecha, observaciones) || estado == null) return;

        OrdenServicio actualizada = new OrdenServicio(orden.codigoUnico(), fecha,
                orden.clienteAsociado(), observaciones, estado,
                orden.listaDetallesServicios(), techRepair);
        mostrar(techRepair.actualizarOrdenServicio(actualizada), "Orden de servicio");
    }

    private static void eliminarOrdenServicio(TechRepair techRepair) {
        String codigo = leerTexto("Código de la orden que desea eliminar:");
        if (codigo == null) return;
        Optional<OrdenServicio> orden = techRepair.buscarOrdenServicio(codigo);
        if (orden.isEmpty()) {
            mostrar("No existe esa orden.", "Validación");
            return;
        }
        boolean confirmar = confirmar("¿Eliminar la orden " + codigo + "? Si tiene repuestos utilizados, se devolverán al inventario.");
        if (confirmar) {
            mostrar(techRepair.eliminarOrdenServicio(orden.get()), "Orden de servicio");
        }
    }

    private static void crearDiagnostico(TechRepair techRepair) {
        String codigo = leerTexto("Código del servicio:");
        String nombre = leerTexto("Nombre del servicio:");
        String descripcion = leerTexto("Descripción:");
        if (cancelado(codigo, nombre, descripcion)) return;
        Servicio servicio = new Diagnostico(codigo, nombre, descripcion, techRepair);
        mostrar(techRepair.registrarServicio(servicio) + "\nTarifa fija: $35.000", "Diagnóstico");
    }

    private static void crearMantenimientoPreventivo(TechRepair techRepair) {
        String codigo = leerTexto("Código del servicio:");
        String nombre = leerTexto("Nombre del servicio:");
        String descripcion = leerTexto("Descripción:");
        TipoDispositivo tipo = elegirTipoDispositivo();
        if (cancelado(codigo, nombre, descripcion) || tipo == null) return;
        Servicio servicio = new MantenimientoPreventivo(codigo, nombre, descripcion, techRepair, tipo);
        mostrar(techRepair.registrarServicio(servicio) + "\nTarifa base: $" + formato(servicio.tarifaBase()), "Mantenimiento preventivo");
    }

    private static void crearReparacionCorrectiva(TechRepair techRepair) {
        String codigo = leerTexto("Código del servicio:");
        String nombre = leerTexto("Nombre del servicio:");
        String descripcion = leerTexto("Descripción:");
        double horasEstimadas = leerDecimal("Horas estimadas de reparación (el valor final se calculará con las horas del detalle):");
        if (cancelado(codigo, nombre, descripcion) || horasEstimadas == -1) return;
        if (horasEstimadas < 0) {
            mostrar("Las horas no pueden ser negativas.", "Validación");
            return;
        }
        Servicio servicio = new ReparacionCorrectiva(codigo, nombre, descripcion, techRepair, horasEstimadas);
        mostrar(techRepair.registrarServicio(servicio) + "\nTarifa de mano de obra: $45.000 por hora", "Reparación correctiva");
    }

    private static void consultarServicios(TechRepair techRepair) {
        String codigo = leerTextoOpcional("Código del servicio (deje vacío para listar todos):");
        if (codigo == null) return;
        if (codigo.trim().isEmpty()) {
            mostrar(listarServicios(techRepair), "Servicios");
        } else {
            Optional<Servicio> servicio = techRepair.buscarServicio(codigo);
            if (servicio.isPresent()) {
                mostrar(detalleServicioCatalogo(servicio.get()), "Servicio");
            } else {
                mostrar("No existe ese servicio.", "Servicio");
            }
        }
    }

    private static void actualizarServicio(TechRepair techRepair) {
        String codigo = leerTexto("Código del servicio que desea actualizar:");
        if (codigo == null) return;
        if (techRepair.buscarServicio(codigo).isEmpty()) {
            mostrar("No existe ese servicio.", "Validación");
            return;
        }
        String nombre = leerTexto("Nuevo nombre:");
        String descripcion = leerTexto("Nueva descripción:");
        if (cancelado(nombre, descripcion)) return;
        mostrar(techRepair.actualizarServicio(codigo, nombre, descripcion), "Servicio");
    }

    private static void eliminarServicio(TechRepair techRepair) {
        String codigo = leerTexto("Código del servicio que desea eliminar:");
        if (codigo == null) return;
        Optional<Servicio> servicio = techRepair.buscarServicio(codigo);
        if (servicio.isEmpty()) {
            mostrar("No existe ese servicio.", "Validación");
            return;
        }
        boolean confirmar = confirmar("¿Desea eliminar el servicio " + servicio.get().getNombre() + "?");
        if (confirmar) mostrar(techRepair.borrarServicio(codigo), "Servicio");
    }

    private static void agregarDetalleServicio(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        if (codigoOrden == null) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        String codigoDetalle = leerTexto("Código del detalle (único dentro de la orden):");
        if (codigoDetalle == null) return;
        String codigoEquipo = leerTexto("Código de un equipo registrado a nombre de "
                + orden.clienteAsociado().getNombreCompleto() + ":\n" + listarEquiposCliente(orden.clienteAsociado()));
        String codigoServicio = leerTexto("Código del servicio:\n" + listarServicios(techRepair));
        String descripcion = leerTexto("Descripción de la falla o necesidad reportada:");
        if (cancelado(codigoEquipo, codigoServicio, descripcion)) return;
        Optional<Equipo> equipo = orden.clienteAsociado().buscarEquipo(codigoEquipo);
        Optional<Servicio> servicio = techRepair.buscarServicio(codigoServicio);
        if (equipo.isEmpty() || servicio.isEmpty()) {
            mostrar("El equipo debe pertenecer al cliente de la orden y el servicio debe existir.", "Validación");
            return;
        }
        int horas = leerHoras(servicio.get(), "Horas de trabajo estimadas (puede ingresar 0 si todavía no se conoce):");
        if (horas == -1) return;
        String observacionesTecnicas = leerTextoOpcional("Observaciones técnicas iniciales (puede dejar este campo vacío):");
        if (observacionesTecnicas == null) return;
        DetalleServicio detalle = new DetalleServicio(codigoDetalle, equipo.get(), servicio.get(), descripcion,
                null, horas, observacionesTecnicas, EstadoOrden.ABIERTA);
        String resultado = techRepair.agregarDetalleServicio(orden, detalle);
        if (resultado.equals("Detalle agregado correctamente.")) {
            mostrar(resultado + " Recuerde asignar un técnico desde la opción 31.\n" + detalleResumen(detalle), "Detalle de servicio");
        } else {
            mostrar(resultado, "Detalle de servicio");
        }
    }

    private static void consultarDetallesOrden(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        if (codigoOrden == null) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        mostrar(listarDetalles(orden), "Detalles de servicio");
    }

    private static void actualizarDetalleServicio(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle que desea actualizar:");
        if (cancelado(codigoOrden, codigoDetalle)) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        DetalleServicio detalle = obtenerDetalle(techRepair, orden, codigoDetalle);
        if (detalle == null) return;
        String codigoEquipo = leerTexto("Nuevo código de equipo perteneciente al cliente:\n" + listarEquiposCliente(orden.clienteAsociado()));
        String codigoServicio = leerTexto("Nuevo código de servicio:\n" + listarServicios(techRepair));
        String descripcion = leerTexto("Nueva descripción de la falla:");
        if (cancelado(codigoEquipo, codigoServicio, descripcion)) return;
        Optional<Equipo> equipo = orden.clienteAsociado().buscarEquipo(codigoEquipo);
        Optional<Servicio> servicio = techRepair.buscarServicio(codigoServicio);
        if (equipo.isEmpty() || servicio.isEmpty()) {
            mostrar("Equipo o servicio no válido.", "Validación");
            return;
        }
        int horas = leerHoras(servicio.get(), "Horas de trabajo (0 o más):");
        if (horas == -1) return;
        String observaciones = leerTextoOpcional("Nuevas observaciones técnicas (puede dejar vacío):");
        if (observaciones == null) return;
        mostrar(techRepair.actualizarDatosDetalle(orden, detalle, equipo.get(), servicio.get(),
                descripcion, horas, observaciones), "Detalle");
    }

    private static void eliminarDetalleServicio(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle a eliminar:");
        if (cancelado(codigoOrden, codigoDetalle)) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        if (!techRepair.ordenModificable(orden)) {
            mostrar("No se pueden eliminar detalles de una orden finalizada, entregada o cancelada.", "Validación");
            return;
        }
        if (obtenerDetalle(techRepair, orden, codigoDetalle) == null) return;
        boolean confirmar = confirmar("¿Eliminar el detalle " + codigoDetalle + "? Se devolverán al inventario los repuestos que tenía asociados.");
        if (confirmar) {
            mostrar(techRepair.eliminarDetalleServicio(orden, codigoDetalle), "Detalle");
        }
    }

    private static void asignarTecnico(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle:");
        String codigoTecnico = leerTexto("Código del técnico que se asignará:\n" + listarTecnicos(techRepair));
        if (cancelado(codigoOrden, codigoDetalle, codigoTecnico)) return;
        Optional<OrdenServicio> orden = techRepair.buscarOrdenServicio(codigoOrden);
        Optional<Tecnico> tecnico = techRepair.buscarTecnico(codigoTecnico);
        if (orden.isEmpty() || tecnico.isEmpty()) {
            mostrar("La orden o el técnico no existen.", "Validación");
            return;
        }
        DetalleServicio detalle = obtenerDetalle(techRepair, orden.get(), codigoDetalle);
        if (detalle == null) return;
        mostrar(techRepair.asignarTecnico(orden.get(), detalle, tecnico.get()), "Asignación");
    }

    private static void agregarRepuestoUtilizado(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle:");
        String codigoRepuesto = leerTexto("Código del repuesto:\n" + listarRepuestos(techRepair));
        int cantidad = leerEntero("Cantidad que se utilizará:");
        if (cancelado(codigoOrden, codigoDetalle, codigoRepuesto) || cantidad == -1) return;
        if (cantidad <= 0) {
            mostrar("La cantidad debe ser mayor que cero.", "Validación");
            return;
        }
        Optional<OrdenServicio> orden = techRepair.buscarOrdenServicio(codigoOrden);
        Optional<Repuesto> repuesto = techRepair.buscarRepuesto(codigoRepuesto);
        if (orden.isEmpty() || repuesto.isEmpty()) {
            mostrar("La orden o el repuesto no existen.", "Validación");
            return;
        }
        DetalleServicio detalle = obtenerDetalle(techRepair, orden.get(), codigoDetalle);
        if (detalle == null) return;
        RepuestoUtilizado usado = new RepuestoUtilizado(repuesto.get(), cantidad, repuesto.get().getPrecioUnidad());
        mostrar(techRepair.registrarRepuestoUtilizado(orden.get(), detalle, usado), "Inventario");
    }

    private static void consultarRepuestosUtilizados(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle:");
        if (cancelado(codigoOrden, codigoDetalle)) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        DetalleServicio detalle = obtenerDetalle(techRepair, orden, codigoDetalle);
        if (detalle == null) return;
        mostrar(listarRepuestosUsados(detalle), "Repuestos utilizados");
    }

    private static void actualizarRepuestoUtilizado(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle:");
        String codigoRepuesto = leerTexto("Código del repuesto utilizado que desea actualizar:");
        int cantidad = leerEntero("Nueva cantidad:");
        double precio = leerDecimal("Precio unitario aplicado a esta reparación:");
        if (cancelado(codigoOrden, codigoDetalle, codigoRepuesto) || cantidad == -1 || precio == -1) return;
        if (cantidad <= 0 || precio < 0) {
            mostrar("La cantidad debe ser mayor que cero y el precio no puede ser negativo.", "Validación");
            return;
        }
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        DetalleServicio detalle = obtenerDetalle(techRepair, orden, codigoDetalle);
        if (detalle == null) return;
        mostrar(techRepair.actualizarRepuestoUtilizado(orden, detalle, codigoRepuesto, cantidad, precio), "Repuesto utilizado");
    }

    private static void eliminarRepuestoUtilizado(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle:");
        String codigoRepuesto = leerTexto("Código del repuesto utilizado que desea retirar:");
        if (cancelado(codigoOrden, codigoDetalle, codigoRepuesto)) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        DetalleServicio detalle = obtenerDetalle(techRepair, orden, codigoDetalle);
        if (detalle == null) return;
        mostrar(techRepair.borrarRepuestoUtilizado(orden, detalle, codigoRepuesto), "Inventario");
    }

    private static void calcularValorDetalle(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle:");
        if (cancelado(codigoOrden, codigoDetalle)) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        DetalleServicio detalle = obtenerDetalle(techRepair, orden, codigoDetalle);
        if (detalle == null) return;
        mostrar("Detalle: " + detalle.getCodigoUnico() + "\nServicio: " + detalle.getServicioAsociado().getNombre()
                + "\nEquipo: " + detalle.getEquipo().getCodigoUnico() + "\nCosto total: $" + formato(detalle.calcularCosto()), "Costo del detalle");
    }

    private static void calcularValorOrden(TechRepair techRepair) {
        String codigo = leerTexto("Código de la orden:");
        if (codigo == null) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigo);
        if (orden == null) return;
        mostrar("Orden: " + codigo + "\nCantidad de detalles: " + orden.listaDetallesServicios().size()
                + "\nValor total: $" + formato(orden.calcularValorTotal()), "Costo de la orden");
    }

    private static void actualizarEstadoDetalle(TechRepair techRepair) {
        String codigoOrden = leerTexto("Código de la orden:");
        String codigoDetalle = leerTexto("Código del detalle:");
        if (cancelado(codigoOrden, codigoDetalle)) return;
        OrdenServicio orden = obtenerOrden(techRepair, codigoOrden);
        if (orden == null) return;
        DetalleServicio detalle = obtenerDetalle(techRepair, orden, codigoDetalle);
        if (detalle == null) return;
        String[] estados = {"ABIERTA", "EN_PROCESO", "FINALIZADA"};
        String estadoSeleccionado = elegirOpcion("Nuevo estado del detalle:", estados);
        if (estadoSeleccionado == null) return;
        mostrar(techRepair.actualizarEstadoDetalle(orden, detalle, EstadoOrden.valueOf(estadoSeleccionado)), "Detalle");
    }

    private static void finalizarOrdenServicio(TechRepair techRepair) {
        String codigo = leerTexto("Código de la orden que desea finalizar:");
        if (codigo == null) return;
        mostrar(techRepair.finalizarOrden(codigo), "Orden de servicio");
    }

    private static void consultarOrdenesCliente(TechRepair techRepair) {
        String documento = leerTexto("Documento del cliente:");
        if (documento == null) {
            return;
        }
        Optional<Cliente> cliente = techRepair.buscarCliente(documento);
        if (cliente.isEmpty()) {
            mostrar("No existe un cliente con ese documento.", "Consulta de ordenes");
            return;
        }
        List<OrdenServicio> ordenes = techRepair.OrdenesCliente(documento);
        if (ordenes.isEmpty()) {
            mostrar("El cliente no tiene ordenes de servicio.", "Consulta de ordenes");
            return;
        }
        String texto = "ORDENES DEL CLIENTE: " + cliente.get().getNombreCompleto() + "\n\n";
        for (OrdenServicio orden : ordenes) {
            texto = texto + detalleOrden(orden) + "\n\n------------------------------\n\n";
        }
        mostrar(texto, "Ordenes del cliente");
    }

    private static void consultarTrabajosTecnico(TechRepair techRepair) {
        String codigo = leerTexto("Codigo del tecnico:");
        if (codigo == null) {
            return;
        }
        mostrar(techRepair.consultarTrabajosTecnico(codigo), "Trabajos del tecnico");
    }

    private static void consultarEquiposPendientes(TechRepair techRepair) {
        List<Equipo> pendientes = techRepair.equiposPendientes();
        if (pendientes.isEmpty()) {
            mostrar("No hay equipos con intervenciones pendientes.", "Equipos pendientes");
            return;
        }
        String texto = "EQUIPOS CON TRABAJOS PENDIENTES\n\n";
        for (Equipo equipo : pendientes) {
            texto = texto + equipo.getCodigoUnico() + " | " + equipo.getMarca() + " "
                    + equipo.getModelo() + " | Serie: " + equipo.getNumSerie() + "\n";
        }
        mostrar(texto, "Equipos pendientes");
    }

    private static void generarReporteServicios(TechRepair techRepair) {
        mostrar(techRepair.generarReporteServicios(), "Reporte de servicios");
    }

    private static void generarReporteTecnicos(TechRepair techRepair) {
        mostrar(techRepair.generarReporteTecnicos(), "Reporte de tecnicos");
    }

    private static void mostrarRepuestosCriticos(TechRepair techRepair) {
        List<Repuesto> criticos = techRepair.inventarioCritico();
        if (criticos.isEmpty()) {
            mostrar("No hay repuestos con existencias inferiores a cinco unidades.", "Inventario critico");
            return;
        }
        String texto = "REPUESTOS CON MENOS DE 5 UNIDADES\n\n";
        for (Repuesto repuesto : criticos) {
            texto = texto + repuesto.toString() + "\n\n";
        }
        mostrar(texto, "Inventario critico");
    }

    private static OrdenServicio obtenerOrden(TechRepair techRepair, String codigoOrden) {
        Optional<OrdenServicio> orden = techRepair.buscarOrdenServicio(codigoOrden);
        if (orden.isEmpty()) {
            mostrar("No existe esa orden.", "Validación");
            return null;
        }
        return orden.get();
    }

    private static DetalleServicio obtenerDetalle(TechRepair techRepair, OrdenServicio orden, String codigoDetalle) {
        Optional<DetalleServicio> detalle = techRepair.buscarDetalle(orden, codigoDetalle);
        if (detalle.isEmpty()) {
            mostrar("No existe ese detalle dentro de la orden.", "Validación");
            return null;
        }
        return detalle.get();
    }

    private static String categoriaServicio(Servicio servicio) {
        if (servicio instanceof Diagnostico) {
            return "Diagnostico";
        }
        if (servicio instanceof MantenimientoPreventivo) {
            return "Mantenimiento preventivo";
        }
        if (servicio instanceof ReparacionCorrectiva) {
            return "Reparacion correctiva";
        }
        return "Servicio";
    }

    private static Equipo capturarEquipo(String codigo) {
        String serie = leerTexto("Número de serie:");
        String marca = leerTexto("Marca:");
        String modelo = leerTexto("Modelo:");
        String anio = leerTexto("Año de fabricación:");
        String descripcion = leerTexto("Descripción del estado físico al ingresar:");
        String[] categorias = {"Computador portátil", "Computador de escritorio", "Teléfono inteligente"};
        String categoria = elegirOpcion("Categoría del equipo:", categorias);

        if (cancelado(serie, marca, modelo, anio, descripcion, categoria)) {
            return null;
        }

        if (categoria.equals("Computador portátil")) {
            int pantalla = leerEntero("Tamaño de pantalla en pulgadas (entero):");
            int ram = leerEntero("Memoria RAM en GB:");
            int almacenamiento = leerEntero("Almacenamiento en GB:");
            boolean bateria = confirmar("¿Tiene batería extraíble?");

            if (pantalla == -1 || ram == -1 || almacenamiento == -1) {
                return null;
            }
            if (pantalla <= 0 || ram <= 0 || almacenamiento <= 0) {
                mostrar("Pantalla, memoria RAM y almacenamiento deben ser mayores que cero.", "Validación");
                return null;
            }
            return new ComputadorPortatil(codigo, serie, marca, modelo, anio, descripcion,
                    pantalla, ram, almacenamiento, bateria);
        } else if (categoria.equals("Computador de escritorio")) {
            String procesador = leerTexto("Tipo de procesador:");
            int ram = leerEntero("Memoria RAM en GB:");
            int almacenamiento = leerEntero("Almacenamiento en GB:");
            boolean grafica = confirmar("¿Posee tarjeta gráfica dedicada?");

            if (cancelado(procesador) || ram == -1 || almacenamiento == -1) {
                return null;
            }
            if (ram <= 0 || almacenamiento <= 0) {
                mostrar("Memoria RAM y almacenamiento deben ser mayores que cero.", "Validación");
                return null;
            }
            return new ComputadorEscritorio(codigo, serie, marca, modelo, anio, descripcion,
                    procesador, ram, almacenamiento, grafica);
        } else if (categoria.equals("Teléfono inteligente")) {
            String sistema = leerTexto("Sistema operativo:");
            int almacenamiento = leerEntero("Almacenamiento en GB:");
            int bateria = leerEntero("Capacidad de batería en mAh:");
            boolean cincoG = confirmar("¿Es compatible con 5G?");

            if (cancelado(sistema) || almacenamiento == -1 || bateria == -1) {
                return null;
            }
            if (almacenamiento <= 0 || bateria <= 0) {
                mostrar("Almacenamiento y batería deben ser mayores que cero.", "Validación");
                return null;
            }
            return new TelefonoInteligente(codigo, serie, marca, modelo, anio, descripcion,
                    sistema, almacenamiento, bateria, cincoG);
        } else {
            mostrar("Categoría de equipo no válida.", "Validación");
            return null;
        }
    }

    private static String detalleOrden(OrdenServicio orden) {
        String texto = "ORDEN " + orden.codigoUnico()
                + "\nFecha: " + orden.fechaCreacion()
                + "\nCliente: " + orden.clienteAsociado().getNombreCompleto()
                + " (Documento: " + orden.clienteAsociado().getNumeroDocumento() + ")"
                + "\nEstado: " + orden.estadoOrden()
                + "\nObservaciones: " + orden.observaciones()
                + "\nDetalles: " + orden.listaDetallesServicios().size()
                + "\nValor total calculado: $" + formato(orden.calcularValorTotal()) + "\n";

        for (DetalleServicio detalle : orden.listaDetallesServicios()) {
            String nombreTecnico = "Sin asignar";
            if (detalle.getTecnicoResp() != null) {
                nombreTecnico = detalle.getTecnicoResp().getNombre();
            }
            texto = texto + "\n  Detalle " + detalle.getCodigoUnico()
                    + " | Equipo: " + detalle.getEquipo().getCodigoUnico()
                    + " | Servicio: " + detalle.getServicioAsociado().getNombre()
                    + " | Estado: " + detalle.getEstadoIntervencion()
                    + " | Tecnico: " + nombreTecnico
                    + " | Valor: $" + formato(detalle.calcularCosto()) + "\n";
        }
        return texto;
    }

    private static String listarOrdenes(TechRepair techRepair) {
        if (techRepair.getListaOrdenesServicios().isEmpty()) {
            return "No hay ordenes registradas.";
        }
        String texto = "";
        for (OrdenServicio orden : techRepair.getListaOrdenesServicios()) {
            texto = texto + detalleOrden(orden) + "\n----------------------------------------\n";
        }
        return texto;
    }

    private static String detalleServicioCatalogo(Servicio servicio) {
        String texto = "Codigo: " + servicio.getCodigo()
                + "\nNombre: " + servicio.getNombre()
                + "\nTipo: " + categoriaServicio(servicio)
                + "\nDescripcion: " + servicio.getDescripcion()
                + "\nTarifa base: $" + formato(servicio.tarifaBase());
        if (servicio instanceof ReparacionCorrectiva) {
            texto = texto + " por hora";
        }
        return texto;
    }

    private static String listarServicios(TechRepair techRepair) {
        if (techRepair.getListaServicios().isEmpty()) {
            return "No hay servicios registrados.";
        }
        String texto = "";
        for (Servicio servicio : techRepair.getListaServicios()) {
            texto = texto + detalleServicioCatalogo(servicio) + "\n\n";
        }
        return texto;
    }

    private static String listarEquiposCliente(Cliente cliente) {
        if (cliente.getListaEquipos().isEmpty()) {
            return "El cliente no tiene equipos registrados.";
        }
        String texto = "";
        for (Equipo equipo : cliente.getListaEquipos()) {
            texto = texto + describirEquipo(equipo) + "\n";
        }
        return texto;
    }

    private static String listarTecnicos(TechRepair techRepair) {
        if (techRepair.getListaTecnicos().isEmpty()) {
            return "No hay tecnicos registrados.";
        }
        String texto = "";
        for (Tecnico tecnico : techRepair.getListaTecnicos()) {
            texto = texto + tecnico.getCodigo() + " | " + tecnico.getNombre()
                    + " | " + tecnico.getEspecialidad()
                    + " | " + tecnico.getEstadoLaboral() + "\n";
        }
        return texto;
    }

    private static String listarRepuestos(TechRepair techRepair) {
        if (techRepair.getListaRepuestos().isEmpty()) {
            return "No hay repuestos registrados.";
        }
        String texto = "";
        for (Repuesto repuesto : techRepair.getListaRepuestos()) {
            texto = texto + repuesto.getCodigoUnico() + " | " + repuesto.getNombre()
                    + " | Disponibles: " + repuesto.getCantidadExistente()
                    + " | Precio: $" + formato(repuesto.getPrecioUnidad()) + "\n";
        }
        return texto;
    }

    private static String listarDetalles(OrdenServicio orden) {
        if (orden.listaDetallesServicios().isEmpty()) {
            return "La orden no tiene detalles de servicio.";
        }
        String texto = "ORDEN: " + orden.codigoUnico() + "\n\n";
        for (DetalleServicio detalle : orden.listaDetallesServicios()) {
            String tecnico = "Sin asignar";
            if (detalle.getTecnicoResp() != null) {
                tecnico = detalle.getTecnicoResp().getNombre();
            }
            texto = texto + "Codigo: " + detalle.getCodigoUnico()
                    + "\nEquipo: " + describirEquipo(detalle.getEquipo())
                    + "\nServicio: " + detalleServicioCatalogo(detalle.getServicioAsociado())
                    + "\nFalla/necesidad: " + detalle.getDescripcion()
                    + "\nTecnico: " + tecnico
                    + "\nHoras de trabajo: " + detalle.getHorasTrabajo()
                    + "\nObservaciones tecnicas: " + detalle.getObservTecnicas()
                    + "\nEstado: " + detalle.getEstadoIntervencion()
                    + "\nRepuestos: " + detalle.getListaRepuestosUtilizados().size()
                    + "\nCosto total: $" + formato(detalle.calcularCosto())
                    + "\n\n-------------------------\n\n";
        }
        return texto;
    }

    private static String listarRepuestosUsados(DetalleServicio detalle) {
        List<RepuestoUtilizado> usados = detalle.getListaRepuestosUtilizados();
        if (usados.isEmpty()) {
            return "Este detalle no tiene repuestos utilizados.";
        }
        String texto = "Detalle: " + detalle.getCodigoUnico() + "\n\n";
        for (RepuestoUtilizado usado : usados) {
            texto = texto + "Codigo: " + usado.getRepuestoUtilizado().getCodigoUnico()
                    + " | Repuesto: " + usado.getRepuestoUtilizado().getNombre()
                    + " | Cantidad: " + usado.getCantidad()
                    + " | Precio unitario aplicado: $" + formato(usado.getPrecioUnidad())
                    + " | Subtotal: $" + formato(usado.calcularSubtotal()) + "\n";
        }
        texto = texto + "\nTotal de repuestos: $" + formato(detalle.calcularCostoRepuestos());
        return texto;
    }

    private static String describirEquipo(Equipo equipo) {
        String texto = "Codigo: " + equipo.getCodigoUnico()
                + "\nSerie: " + equipo.getNumSerie()
                + "\nMarca/modelo: " + equipo.getMarca() + " " + equipo.getModelo()
                + "\nAno: " + equipo.getAnioFab()
                + "\nEstado fisico: " + equipo.getDescripcion();

        if (equipo instanceof ComputadorPortatil) {
            ComputadorPortatil portatil = (ComputadorPortatil) equipo;
            texto = texto + "\nCategoria: Computador portatil"
                    + "\nPantalla: " + portatil.getPantallaInch() + " pulgadas"
                    + "\nRAM: " + portatil.getRAM() + " GB"
                    + "\nAlmacenamiento: " + portatil.getStorage() + " GB"
                    + "\nBateria extraible: " + portatil.isBateriaExtraible();
        } else if (equipo instanceof ComputadorEscritorio) {
            ComputadorEscritorio escritorio = (ComputadorEscritorio) equipo;
            texto = texto + "\nCategoria: Computador de escritorio"
                    + "\nProcesador: " + escritorio.getProcesador()
                    + "\nRAM: " + escritorio.getRAM() + " GB"
                    + "\nAlmacenamiento: " + escritorio.getStorage() + " GB"
                    + "\nGrafica dedicada: " + escritorio.isGraficaDed();
        } else if (equipo instanceof TelefonoInteligente) {
            TelefonoInteligente telefono = (TelefonoInteligente) equipo;
            texto = texto + "\nCategoria: Telefono inteligente"
                    + "\nSistema operativo: " + telefono.getOS()
                    + "\nAlmacenamiento: " + telefono.getStorage() + " GB"
                    + "\nBateria: " + telefono.getBateriamAh() + " mAh"
                    + "\nCompatible con 5G: " + telefono.isRed5G();
        }
        return texto;
    }

    private static String describirTecnico(Tecnico tecnico) {
        return "Código: " + tecnico.getCodigo() + "\nNombre: " + tecnico.getNombre()
                + "\nDocumento: " + tecnico.getID() + "\nEspecialidad: " + tecnico.getEspecialidad()
                + "\nEstado laboral: " + tecnico.getEstadoLaboral();
    }

    private static String detalleResumen(DetalleServicio detalle) {
        return "Código: " + detalle.getCodigoUnico()
                + "\nEquipo: " + detalle.getEquipo().getCodigoUnico()
                + "\nServicio: " + detalle.getServicioAsociado().getNombre()
                + "\nDescripción: " + detalle.getDescripcion()
                + "\nEstado: " + detalle.getEstadoIntervencion()
                + "\nValor actual: $" + formato(detalle.calcularCosto());
    }

    private static String formato(double valor) {
        return String.format("%,.0f", valor);
    }

    private static boolean esEntero(String texto) {
        if (texto.isEmpty()) {
            return false;
        }
        int inicio = 0;
        if (texto.charAt(0) == '-') {
            inicio = 1;
        }
        if (inicio == texto.length()) {
            return false;
        }
        for (int i = inicio; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void mostrar(String texto, String titulo) {
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensaje);
            if (entrada == null) return null;
            entrada = entrada.trim();
            if (!entrada.isEmpty()) return entrada;
            JOptionPane.showMessageDialog(null, "El dato no puede estar vacío.", "Validación", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static String leerTextoOpcional(String mensaje) {
        String entrada = JOptionPane.showInputDialog(null, mensaje);
        if (entrada == null) {
            return null;
        }
        return entrada.trim();
    }

    private static int leerEntero(String mensaje, String titulo) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                return -1;
            }
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entero válido.", "Validación", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static int leerEntero(String mensaje) {
        return leerEntero(mensaje, "Dato requerido");
    }
    private static int leerHoras(Servicio servicio, String mensaje) {
        if (!(servicio instanceof ReparacionCorrectiva)) {
            return 0;
        }
        int horas = leerEntero(mensaje);
        if (horas < -1) {
            mostrar("Las horas no pueden ser negativas.", "Validación");
            return -1;
        }
        return horas;
    }

    private static double leerDecimal(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensaje);
            if (entrada == null) {
                return -1;
            }
            try {
                return Double.parseDouble(entrada.trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número decimal válido.", "Validación", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static String elegirOpcion(String mensaje, String[] opciones) {
        return (String) JOptionPane.showInputDialog(null, mensaje, "Seleccione una opción",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
    }

    private static Especialidad elegirEspecialidad() {
        String[] opciones = {"COMPUTADORES", "DISPOSITIVOS_MOVILES", "SOPORTE_GENERAL"};
        String opcion = elegirOpcion("Seleccione la especialidad del técnico:", opciones);
        if (opcion == null) {
            return null;
        }
        return Especialidad.valueOf(opcion);
    }

    private static EstadoLaboral elegirEstadoLaboral() {
        String[] opciones = {"ACTIVO", "INACTIVO"};
        String opcion = elegirOpcion("Seleccione el estado laboral:", opciones);
        if (opcion == null) {
            return null;
        }
        return EstadoLaboral.valueOf(opcion);
    }

    private static TipoDispositivo elegirTipoDispositivo() {
        String[] opciones = {"CELULAR", "PORTATIL", "MESA"};
        String opcion = elegirOpcion("Seleccione el tipo de dispositivo:", opciones);
        if (opcion == null) {
            return null;
        }
        return TipoDispositivo.valueOf(opcion);
    }

    private static EstadoOrden elegirEstadoOrden() {
        String[] opciones = {"ABIERTA", "EN_PROCESO", "FINALIZADA", "ENTREGADA", "CANCELADA"};
        String opcion = elegirOpcion("Seleccione el estado de la orden:", opciones);
        if (opcion == null) {
            return null;
        }
        return EstadoOrden.valueOf(opcion);
    }

    private static boolean confirmar(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar operación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    private static boolean cancelado(String... datos) {
        for (String dato : datos) {
            if (dato == null) {
                return true;
            }
        }
        return false;
    }
}