import java.util.ArrayList;

public class AppDetran {

    public static void main(String[] args){
        Multa multa1 = new Multa("Velocidade", 100000);

        Carro meuCarro = new Carro("camaro");
        meuCarro.setModelo("camaro");
        meuCarro.addMulta(multa1);
        meuCarro.setPlaca("gtx1650");

        Carro meuCarro2 = new Carro("fusca");
        meuCarro2.setModelo("fusca");
        meuCarro2.setPlaca("gtx1050ti");

        ArrayList<Carro>carros = new ArrayList<Carro>();

        Proprietario dono = new Proprietario("Pedro", "CNH1");
        dono.addCarro(meuCarro);
        dono.addCarro(meuCarro2);

        Carro[] arrayCarros = dono.getCarros();

        System.out.println("O proprietário " + dono.getNome() + " portador da cnh: " + dono.getCNH() + " possui os carros: \n");

        for(Carro carro : arrayCarros){
            System.out.println(carro.getModelo() +", placa: "+ carro.getPlaca());
            Multa[] arrayMultas = carro.getMultas();

            System.out.println("Multas: ");
            for(Multa multas : arrayMultas){
                System.out.println("Infração: " + multas.getInfracao());
                System.out.println("Valor: " + multas.getValor());
            }
            System.out.println("");
        }
    }
}
