package co.edu.uniquindio.poo.model;

public enum TarifaBase {
    COMPUTADOR_PORTATIL(60000),COMPUTADOR_ESCRITORIO(70000), TELEFONO_INTELIGENTE(40000);

    private final double valor;

    TarifaBase(double valor) {
        this.valor = valor;
    }

    public double getValor() { return valor; }
}
