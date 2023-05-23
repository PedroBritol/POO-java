import java.util.ArrayList;
public class Arma {
    private String descricao;
    private ArrayList<Golpe> golpes = new ArrayList<>();

    public Arma(String descricao) {
        this.descricao = descricao;
    }

    public void addGolpe(String nomeGolpe, double poderOfensivo) {
        this.golpes.add(new Golpe(nomeGolpe,  poderOfensivo));
    }

    public String getId() {
        return this.descricao;
    }

    public Golpe pegarGolpeRandomico() {
        if(golpes.size() > 0) {
            int tipoGolpe = (int) (Math.random() * golpes.size());
            return golpes.get(tipoGolpe);
        }
        return null;
    }
}
