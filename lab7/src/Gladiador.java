import java.util.ArrayList;
public class Gladiador extends Lutador{
    ArrayList<Arma> armas = new ArrayList<>();

    public Gladiador(String nome)
    {
        super("Gladiador " + nome);
    }
    public void addArma(Arma arma){
        this.armas.add(arma);
    }

    public void atacar(Combatente adversario){
        if(armas.size() > 0) {
            int tipoArma = (int) (Math.random() * armas.size());
            Arma arma= armas.get(tipoArma);
            System.out.println("Ataque com " + arma.getId());
            adversario.defender((int)arma.pegarGolpeRandomico().poderGolpe);
        }
    }

}
