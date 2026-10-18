package co.edu.uniquindio.poo.model;

public class MantenimientoPreventivo extends Servicio{

    public MantenimientoPreventivo(String codigo, String nombre, String descripcion, TarifaBase tarifaBase, TechRepair ownedByTechRepair) {
        super(codigo, nombre, descripcion, tarifaBase.getValor(), ownedByTechRepair);
    }
}
