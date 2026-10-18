package co.edu.uniquindio.poo.model;

public abstract class Equipo {

    private String codigoUnico;
    private String numSerie;
    private String marca;
    private String modelo;
    private String anioFab;
    private String descripcion;

    private Cliente ownedByCliente;

    public Equipo(String codigoUnico, String numSerie, String marca, String modelo, String anioFab, String descripcion) {
        this.codigoUnico = codigoUnico;
        this.numSerie = numSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFab = anioFab;
        this.descripcion = descripcion;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnioFab() {
        return anioFab;
    }

    public void setAnioFab(String anioFab) {
        this.anioFab = anioFab;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getOwnedByCliente() {
        return ownedByCliente;
    }

    public void setOwnedByCliente(Cliente ownedByCliente) {
        this.ownedByCliente = ownedByCliente;
    }


}
