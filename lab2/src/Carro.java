import java.util.ArrayList;

import static java.lang.System.exit;

public class Carro {
    private String modelo;
    private ArrayList<Multa> multas = new ArrayList<>();
    private String placa;

    Carro(String modelo){

    }

    public void setModelo(String model){
        this.modelo = model;
    }

    public void setPlaca(String placa){
        if(placa.length() <= 7){
            this.placa = placa;
        }
        else{
            this.placa = null;
//            System.out.println("Erro: Placa invalida, referente ao carro do modelo:" + modelo);
//            exit(0);
        }

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
