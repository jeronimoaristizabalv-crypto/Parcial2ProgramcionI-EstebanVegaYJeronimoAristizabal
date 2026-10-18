package co.edu.uniquindio.poo.model;

public class ComputadorPortatil extends Equipo{

    private int pantallaInch;
    private int RAM;
    private int storage;
    private boolean bateriaExtraible;

    public ComputadorPortatil(String codigoUnico, String numSerie, String marca, String modelo, String anioFab, String descripcion, int pantallaInch, int RAM, int storage, boolean bateriaExtraible) {
        super(codigoUnico, numSerie, marca, modelo, anioFab, descripcion);
        this.pantallaInch = pantallaInch;
        this.RAM = RAM;
        this.storage = storage;
        this.bateriaExtraible = bateriaExtraible;
    }

    public int getPantallaInch() {
        return pantallaInch;
    }

    public void setPantallaInch(int pantallaInch) {
        this.pantallaInch = pantallaInch;
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

    public boolean isBateriaExtraible() {
        return bateriaExtraible;
    }

    public void setBateriaExtraible(boolean bateriaExtraible) {
        this.bateriaExtraible = bateriaExtraible;
    }
}
