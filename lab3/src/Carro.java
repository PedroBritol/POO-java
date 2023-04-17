import java.util.ArrayList;

import static java.lang.System.exit;

public class Carro {
    private String modelo;
    private ArrayList<Multa> multas = new ArrayList<>();
    private String placa;

    public Carro(){
        GeradorDePlaca placa = new GeradorDePlaca();
        this.placa = placa.getPlacaAleatoria();
    }

    public void setModelo(String model){
        this.modelo = model;
    }
    public String getModelo(){
        return modelo;
    }

    public void addMulta(Multa multa){
        this.multas.add(multa);
    }
    public Multa[] getMultas(){
        return (Multa[])this.multas.toArray(new Multa[0]);
    }

    public String getPlaca() {
        return placa;
    }
}
