package co.edu.uniquindio.poo.model;

public class Diagnostico extends Servicio {
    public Diagnostico(String codigo, String nombre, String desccripcion, int tarifaBase, TechRepair ownedByTechRepair) {
        super(codigo, nombre, desccripcion, 35000, ownedByTechRepair);
    }

}
