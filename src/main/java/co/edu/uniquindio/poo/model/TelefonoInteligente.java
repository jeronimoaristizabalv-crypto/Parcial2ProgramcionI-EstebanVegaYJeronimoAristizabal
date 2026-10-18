package co.edu.uniquindio.poo.model;

public class TelefonoInteligente extends Equipo{

    private String OS;
    private int storage;
    private int bateriamAh;
    private boolean red5G;

    public TelefonoInteligente(String codigoUnico, String numSerie, String marca, String modelo, String anioFab, String descripcion, String OS, int storage, int bateriamAh, boolean red5G) {
        super(codigoUnico, numSerie, marca, modelo, anioFab, descripcion);
        this.OS = OS;
        this.storage = storage;
        this.bateriamAh = bateriamAh;
        this.red5G = red5G;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getBateriamAh() {
        return bateriamAh;
    }

    public void setBateriamAh(int bateriamAh) {
        this.bateriamAh = bateriamAh;
    }

    public boolean isRed5G() {
        return red5G;
    }

    public void setRed5G(boolean red5G) {
        this.red5G = red5G;
    }
}
