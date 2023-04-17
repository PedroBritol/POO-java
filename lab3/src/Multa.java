public class Multa {
    private String infracao;
    private float valor;

    public Multa(String infracao, float valor){
        super();
        this.infracao = infracao;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public String getInfracao() {
        return infracao;
    }
}
