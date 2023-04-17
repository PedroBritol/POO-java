import java.util.ArrayList;

public class Proprietario {

    private String nome;
    private String cnh;
    private ArrayList<Carro> carros = new ArrayList<Carro>();

    public Proprietario(String nome, String cnh){
        super();
        this.nome = nome;
        this.cnh = cnh;
    }

    public void addCarro(Carro carro){
        this.carros.add(carro);
    }
    public String getNome(){
        return nome;
    }
    public String getCNH(){
        return cnh;
    }
//    public ArrayList<Carro> getCarros(){
//        return carros;
//    }

    public Carro[] getCarros(){
        return (Carro[])this.carros.toArray(new Carro[0]);
    }
}
