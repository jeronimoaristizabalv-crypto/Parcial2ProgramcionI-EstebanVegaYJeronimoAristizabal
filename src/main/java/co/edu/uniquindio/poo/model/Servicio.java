package co.edu.uniquindio.poo.model;

public abstract class Servicio {


    private final String codigo;
    private String nombre;
    private String desccripcion;
    private final double  tarifaBase;

    private TechRepair ownedByTechRepair;

    public Servicio(String codigo, String nombre, String desccripcion, double tarifaBase, TechRepair ownedByTechRepair) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.desccripcion = desccripcion;
        this.tarifaBase = tarifaBase;
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

    public String getDesccripcion() {
        return desccripcion;
    }

    public void setDesccripcion(String desccripcion) {
        this.desccripcion = desccripcion;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public TechRepair getOwnedByTechRepair() {
        return ownedByTechRepair;
    }

    public void setOwnedByTechRepair(TechRepair ownedByTechRepair) {
        this.ownedByTechRepair = ownedByTechRepair;
    }

    @Override
    public String toString() {
        return "EstadoOrden{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", desccripcion='" + desccripcion + '\'' +
                ", tarifaBase=" + tarifaBase +
                ", ownedByTechRepair=" + ownedByTechRepair +
                '}';
    }


}

