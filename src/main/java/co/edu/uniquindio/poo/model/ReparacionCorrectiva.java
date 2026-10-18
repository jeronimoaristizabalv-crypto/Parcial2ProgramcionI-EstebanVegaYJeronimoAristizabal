package co.edu.uniquindio.poo.model;

public class ReparacionCorrectiva extends Servicio{

    public ReparacionCorrectiva(String codigo, String nombre, String desccripcion, int tarifaBase, TechRepair ownedByTechRepair) {
        super(codigo, nombre, desccripcion, 45000, ownedByTechRepair);
    }
}
