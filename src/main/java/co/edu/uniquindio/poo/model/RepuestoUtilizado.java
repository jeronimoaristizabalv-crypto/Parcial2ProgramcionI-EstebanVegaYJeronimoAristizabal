package co.edu.uniquindio.poo.model;

public class RepuestoUtilizado {

    private Repuesto repuestoUtilizado;
    private int cantidad;
    private double precioUnidad;

    private DetalleServicio ownedByDetalleServicio;

    public RepuestoUtilizado(Repuesto repuestoUtilizado, int cantidad, double precioUnidad) {
        this.repuestoUtilizado = repuestoUtilizado;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }

    public Repuesto getRepuestoUtilizado() {
        return repuestoUtilizado;
    }

    public void setRepuestoUtilizado(Repuesto repuestoUtilizado) {
        this.repuestoUtilizado = repuestoUtilizado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public DetalleServicio getOwnedByDetalleServicio() {
        return ownedByDetalleServicio;
    }

    public void setOwnedByDetalleServicio(DetalleServicio ownedByDetalleServicio) {
        this.ownedByDetalleServicio = ownedByDetalleServicio;
    }

    @Override
    public String toString() {
        return "RepuestoUtilizado{" +
                "repuestoUtilizado=" + repuestoUtilizado +
                ", cantidad=" + cantidad +
                ", precioUnidad=" + precioUnidad +
                ", ownedByDetalleServicio=" + ownedByDetalleServicio +
                '}';
    }
}
