package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Cliente {

    private String numeroTelefono;
    private final String numeroDocumento;
    private String nombreCompleto;
    private String correoElectronico;
    private String direccionResidencia;
    private ArrayList<Equipo> listaEquipos= new ArrayList<>();
    private TechRepair ownedByTechRepair;

    public Cliente(String numeroTelefono, String numeroDocumento, String nombreCompleto, String correoElectronico, String direccionResidencia) {
        this.numeroTelefono = numeroTelefono;
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;

    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public List<Equipo> getListaEquipos() {
        return Collections.unmodifiableList(listaEquipos);
    }

    public String actualizarEquipo(Equipo equipoAnterior, Equipo equipoNuevo) {
        int posicion = listaEquipos.indexOf(equipoAnterior);
        if (posicion < 0) {
            return "No se encontro el equipo que desea actualizar.";
        }
        Optional<Equipo> repetido = buscarEquipo(equipoNuevo.getCodigoUnico());
        if (repetido.isPresent() && repetido.get() != equipoAnterior) {
            return "Ya existe otro equipo con ese codigo.";
        }
        equipoNuevo.setOwnedByCliente(this);
        listaEquipos.set(posicion, equipoNuevo);
        return "Equipo actualizado correctamente.";
    }

    public TechRepair getOwnedByTechRepair() {
        return ownedByTechRepair;
    }

    public void setOwnedByTechRepair(TechRepair ownedByTechRepair) {
        this.ownedByTechRepair = ownedByTechRepair;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numeroTelefono='" + numeroTelefono + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", direccionResidencia='" + direccionResidencia + '\'' +
                '}';
    }

    public String crearEquipo(Equipo equipo){
        Optional<Equipo> optionalEquipo = buscarEquipo(equipo.getCodigoUnico());
        if(optionalEquipo.isEmpty()){
            listaEquipos.add(equipo);
            return "Se creo el equipo de forma exitosa.";
        }else{
            return "No se puede crear el equipo pues ya existe uno con estos datos.";
        }
    }

    public String eliminarEquipo(Equipo equipo){
        Optional<Equipo> optionalEquipo = buscarEquipo(equipo.getCodigoUnico());
        if(optionalEquipo.isEmpty()){
            return "No existe un equipo con esos datos";
        } else {
            listaEquipos.remove(optionalEquipo.get());
            return "Equipo eliminado con exito.";
        }
    }

    public Optional<Equipo> buscarEquipo(String codigoUnico) {
        for (Equipo equipo : listaEquipos) {
            if (equipo.getCodigoUnico().equals(codigoUnico)) {
                return Optional.of(equipo);
            }
        }
        return Optional.empty();
    }
}
