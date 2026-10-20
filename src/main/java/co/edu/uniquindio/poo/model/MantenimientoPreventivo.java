package co.edu.uniquindio.poo.model;

public class MantenimientoPreventivo extends Servicio{

    private TipoDispositivo tipoDispositivo;

    public MantenimientoPreventivo(String codigo, String nombre, String descripcion, TechRepair ownedByTechRepair, TipoDispositivo tipoDispositivo) {
        super(codigo, nombre, descripcion, ownedByTechRepair);

        this.tipoDispositivo =tipoDispositivo;
    }

    @Override
    public double tarifaBase(){
        if(tipoDispositivo==TipoDispositivo.PORTATIL){
            return 60000;
        }else if(tipoDispositivo==TipoDispositivo.MESA){
            return 70000;
        }else{
            return 40000;
        }
    }

    @Override
    public double total(){
        return tarifaBase();
    }

    public double tarifaParaEquipo(Equipo equipo) {
        if (equipo instanceof ComputadorPortatil) {
            return 60000;
        }
        if (equipo instanceof ComputadorEscritorio) {
            return 70000;
        }
        if (equipo instanceof TelefonoInteligente) {
            return 40000;
        }
        return tarifaBase();
    }
}
