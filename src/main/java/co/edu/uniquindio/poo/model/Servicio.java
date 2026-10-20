package co.edu.uniquindio.poo.model;

public abstract class Servicio {


    private final String codigo;
    private String nombre;
    private String descripcion;

    private TechRepair ownedByTechRepair;

    public Servicio(String codigo, String nombre, String descripcion, TechRepair ownedByTechRepair) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ownedByTechRepair = ownedByTechRepair;
    }

    public String getCodigo() {
        return codigo;
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

    public void setDescripcion(String desccripcion) {
        this.descripcion = desccripcion;
    }

    public TechRepair getOwnedByTechRepair() {
        return ownedByTechRepair;
    }

    public void setOwnedByTechRepair(TechRepair ownedByTechRepair) {
        this.ownedByTechRepair = ownedByTechRepair;
    }

    public abstract double total();

    public abstract double tarifaBase();

}

