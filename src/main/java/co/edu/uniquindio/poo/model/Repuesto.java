package co.edu.uniquindio.poo.model;

public class Repuesto {

    private final String codigoUnico;
    private String nombre;
    private String descripcion;
    private double precioUnidad;
    private int cantidadExistente;
    private String compatibilidad;

    private TechRepair ownedByTechRepair;

    public Repuesto(String codigoUnico, String nombre, String descripcion, double precioUnidad, int cantidadExistente, String compatibilidad) {
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnidad = precioUnidad;
        this.cantidadExistente = cantidadExistente;
        this.compatibilidad = compatibilidad;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public String getCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(String compatibilidad) {
        this.compatibilidad = compatibilidad;
    }

    public TechRepair getOwnedByTechRepair() {
        return ownedByTechRepair;
    }

    public void setOwnedByTechRepair(TechRepair ownedByTechRepair) {
        this.ownedByTechRepair = ownedByTechRepair;
    }

    @Override
    public String toString() {
        return "Repuesto{" +
                "codigoUnico='" + codigoUnico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnidad=" + precioUnidad +
                ", cantidadExistente=" + cantidadExistente +
                ", compatibilidad='" + compatibilidad + '\'' +
                '}';
    }
}
