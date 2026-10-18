package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;

public class Cliente {

    private String numeroTelefono;
    private String numeroDocumento;
    private String nombreCompleto;
    private String correoElectronico;
    private String direccionResidencia;
    private ArrayList<Equipo> listaEquipos= new ArrayList<>();
    private TechRepair ownedByTechRepair;

    public Cliente(String numeroTelefono, String numeroDocumento, String nombreCompleto, String correoElectronico, String direccionResidencia, ArrayList<Equipo> listaEquipos) {
        this.numeroTelefono = numeroTelefono;
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.listaEquipos = listaEquipos;
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

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public ArrayList<Equipo> getListaEquipos() {
        return (ArrayList<Equipo>) Collections.unmodifiableList(listaEquipos);
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
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
                ", listaEquipos=" + listaEquipos +
                ", ownedByTechRepair=" + ownedByTechRepair +
                '}';
    }

    // CRUDs
}
