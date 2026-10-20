package co.edu.uniquindio.poo.model;

public class Diagnostico extends Servicio {
    public Diagnostico(String codigo, String nombre, String desccripcion, TechRepair ownedByTechRepair) {
        super(codigo, nombre, desccripcion, ownedByTechRepair);
    }

    @Override
    public double tarifaBase(){
        return 35000;
    }

    @Override
    public double total(){
        return tarifaBase();
    }
}
