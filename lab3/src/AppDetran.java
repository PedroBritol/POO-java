import java.util.ArrayList;
import java.math.*;
import java.util.Random;
import java.lang.Math;

public class AppDetran {
    private static int totalMultasGeradas = 0;
    private static int proprietariosGerados = 0;
    private static int carrosGerados = 0;
    Random random = new Random();

    public Proprietario criaProprietario(){
        Proprietario novoProprietario = new Proprietario("Pessoa-"+random.nextInt(1000), "ES-"+random.nextInt(1000000, 9999999));
        this.proprietariosGerados++;
        return novoProprietario;
    }

    public Carro criaCarro(){
        Carro novoCarro = new Carro();
        return novoCarro;
    }
    public void criaMulta(Carro novosCarros){
        Multa multa1 = new Multa("Infração"+random.nextInt(100), 100+random.nextInt(1000));
        if(Math.random() > 0.7) {
            novosCarros.addMulta(multa1);
        }
    }

    public static void main(String[] args){

        Carro meuCarro = new Carro();
        meuCarro.setModelo("camaro");

        Carro meuCarro2 = new Carro();
        meuCarro2.setModelo("fusca");


        AppDetran detran = new AppDetran();

        for( int i = 0; i < 5; i++){
            Proprietario novosProprietarios = detran.criaProprietario();
            for(int j = 0; j < 3; j++){
                Carro novosCarros = detran.criaCarro();
                novosCarros.setModelo("camaro"+j);
                carrosGerados ++;
                for (int k = 0; k < 5; k++) {
                    detran.criaMulta(novosCarros);
                }
                novosProprietarios.addCarro(novosCarros);
            }

            Carro[] arrayCarros = novosProprietarios.getCarros();

            System.out.println(novosProprietarios.getNome()+" "+novosProprietarios.getCNH());
            for(Carro carro : arrayCarros){
                System.out.println("\t"+carro.getModelo() +" , placa: "+ carro.getPlaca());

                System.out.println("\t\tMultas: ");
                Multa[] arrayMultas = carro.getMultas();
                totalMultasGeradas += arrayMultas.length;
                for(Multa multas : arrayMultas){
                    System.out.println("\t\tInfração: " + multas.getInfracao());
                    System.out.println("\t\tValor: " + multas.getValor());
                }
            }
        }
        System.out.println("total de multas geradas pelo detran: " + totalMultasGeradas);
        System.out.println("total de Proprietários cadastrados pelo detran: " + proprietariosGerados);
        System.out.println("total de Carros cadastrados pelo detran: " + carrosGerados);

    }
}
