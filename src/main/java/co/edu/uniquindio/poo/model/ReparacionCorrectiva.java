package co.edu.uniquindio.poo.model;

public class ReparacionCorrectiva extends Servicio{

    private double horasReparacion;

    public ReparacionCorrectiva(String codigo, String nombre, String descripcion, TechRepair ownedByTechRepair, double horasReparacion) {
        super(codigo, nombre, descripcion, ownedByTechRepair);
        this.horasReparacion=horasReparacion;
    }

    @Override
    public double tarifaBase(){
        return 45000;
    }

    @Override
    public double total(){
        return tarifaBase()*horasReparacion;
    }
}
