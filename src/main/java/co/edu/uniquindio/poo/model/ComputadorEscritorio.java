package co.edu.uniquindio.poo.model;

public class ComputadorEscritorio extends Equipo{

    private String procesador;
    private int RAM;
    private int storage;
    private boolean graficaDed;

    public ComputadorEscritorio(String codigoUnico, String numSerie, String marca, String modelo, String anioFab, String descripcion, String procesador, int RAM, int storage, boolean graficaDed) {
        super(codigoUnico, numSerie, marca, modelo, anioFab, descripcion);
        this.procesador = procesador;
        this.RAM = RAM;
        this.storage = storage;
        this.graficaDed = graficaDed;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public boolean isGraficaDed() {
        return graficaDed;
    }

    public void setGraficaDed(boolean graficaDed) {
        this.graficaDed = graficaDed;
    }

    @Override
    public String toString() {
        return "ComputadorEscritorio{" +
                "procesador='" + procesador + '\'' +
                ", RAM=" + RAM +
                ", storage=" + storage +
                ", graficaDed=" + graficaDed +
                '}';
    }
}
