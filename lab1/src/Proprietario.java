
public class Proprietario {

    private String nome;
    private Carro meuCarro;

    Proprietario(String nome, Carro meuCarro){

    }

    public void setDono(String nome, Carro meuCarro){
        this.nome = nome;
        this.meuCarro = meuCarro;
    }

    public String getNome(){
        return nome;
    }
}
