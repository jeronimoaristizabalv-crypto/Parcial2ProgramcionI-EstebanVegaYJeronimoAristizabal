package co.edu.uniquindio.poo.model;

public class Tecnico {

    private String codigo;
    private String nombre;
    private String ID;
    private Especialidad especialidad;
    private EstadoLaboral estadoLaboral;

    private TechRepair ownedByTechRepair;

    public Tecnico(String codigo, String nombre, String ID, Especialidad especialidad, EstadoLaboral estadoLaboral) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ID = ID;
        this.especialidad = especialidad;
        this.estadoLaboral = estadoLaboral;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public EstadoLaboral getEstadoLaboral() {
        return estadoLaboral;
    }

    public void setEstadoLaboral(EstadoLaboral estadoLaboral) {
        this.estadoLaboral = estadoLaboral;
    }

    public TechRepair getOwnedByTechRepair() {
        return ownedByTechRepair;
    }

    public void setOwnedByTechRepair(TechRepair ownedByTechRepair) {
        this.ownedByTechRepair = ownedByTechRepair;
    }
}
