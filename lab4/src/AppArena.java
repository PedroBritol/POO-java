import java.util.ArrayList;
import java.util.Iterator;

public class AppArena {

    static int qtdLutadores = 0;
    static int qtdFeras = 0;

    private int numCobatentes;
    private Combatente combatentes[];

    private ArrayList<Combatente> arrayCombatentes = new ArrayList<>();

    public AppArena(int numCombatentes) {
        this.numCobatentes = numCombatentes;
        combatentes = gerarVetorCombatentes(numCobatentes);
    }


    private Combatente[] gerarVetorCombatentes(int qtdCombatentes) {
        Combatente[] combatentes = new Combatente[qtdCombatentes];
        for (int i = 0; i < combatentes.length; i++) {
            if (Math.random() > 0.5) {
                combatentes[i] = new Lutador("Lutador " + qtdLutadores++);
            }else {
                combatentes[i] = new Fera("Fera " + qtdFeras++);
            }
        }

        return combatentes;
    }


    public Combatente iniciarCombate(Combatente combatente1, Combatente combatente2) {

        int turno = 1;
        while(combatente1.status() && combatente2.status()) {
            Combatente atacante, defensor;
            if(turno ==1) {
                atacante = combatente1;
                defensor = combatente2;
            }else {
                atacante = combatente2;
                defensor = combatente1;
            }
            turno*= -1;
            System.out.println("Ataque de "+ atacante.getId() + "[" + atacante.vida + "]" +
                    " em " + defensor.getId() + "[" + defensor.getVida()+"]");
            atacante.atacar(defensor);
        }

        return combatente1.status()?combatente1:combatente2;

    }

    public void iniciarTorneio() {

        while(this.combatentes.length > 1){
            for (int j = 0; j < this.combatentes.length; j+=2) {

                if(j == combatentes.length-1){
                    System.out.println("\n------------------------------------------------");
                    System.out.println("vencedor do combate por KO: " + this.combatentes[j].getId());
                    System.out.println("------------------------------------------------\n");
                    arrayCombatentes.add(this.combatentes[combatentes.length-1]);
                }
                else{
                    System.out.println( "Inicio de Combate:" + this.combatentes[j].getId() + " vs." + this.combatentes[j+1].getId());

                    Combatente campeao = iniciarCombate(this.combatentes[j], this.combatentes[j+1]);

                    System.out.println("\n------------------------------------------------");
                    System.out.println("Vencedor do combate: " + campeao.getId());
                    System.out.println("------------------------------------------------\n");
                    arrayCombatentes.add(campeao);
                }
            }

            this.combatentes = arrayCombatentes.toArray(new Combatente[arrayCombatentes.size()]);
            arrayCombatentes.clear();
        }

        System.out.println("Vencedor do torneio: " + combatentes[0].getId());

    }



    public static void main(String[] args) {

        AppArena arena = new AppArena(5);

        arena.iniciarTorneio();

    }

}
