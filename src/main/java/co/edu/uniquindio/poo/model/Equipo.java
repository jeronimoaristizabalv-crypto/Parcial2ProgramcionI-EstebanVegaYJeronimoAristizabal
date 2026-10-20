package co.edu.uniquindio.poo.model;

public abstract class Equipo {

    private final String codigoUnico;
    private final String numSerie;
    private final String marca;
    private final String modelo;
    private final String anioFab;
    private final String descripcion;

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

    public String getNumSerie() {
        return numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnioFab() {
        return anioFab;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Cliente getOwnedByCliente() {
        return ownedByCliente;
    }

    public void setOwnedByCliente(Cliente ownedByCliente) {
        this.ownedByCliente = ownedByCliente;
    }
}
