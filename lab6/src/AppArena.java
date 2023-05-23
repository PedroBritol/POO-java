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
            if (Math.random() > 0.4) {
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
            System.out.println("Ataque de " + atacante + " em " + defensor);
            atacante.atacar(defensor);
        }

        return combatente1.status()?combatente1:combatente2;

    }

    public static int k =0;
    Combatente campeao;
    public void iniciarTorneio() {
        while(this.combatentes.length > 1){


            if(k == combatentes.length-1){
                System.out.println( "Inicio de Combate:" + this.combatentes[k].getId() + " vs." + this.arrayCombatentes.get(0));
                campeao = iniciarCombate(this.combatentes[k], this.arrayCombatentes.get(0));
                arrayCombatentes.add(campeao);
                arrayCombatentes.remove(0);
                this.combatentes = arrayCombatentes.toArray(new Combatente[arrayCombatentes.size()]);
                arrayCombatentes.clear();
                k = 0;
            }
            else{
                System.out.println( "Inicio de Combate:" + this.combatentes[k].getId() + " vs." + this.combatentes[k+1].getId());
                campeao = iniciarCombate(this.combatentes[k], this.combatentes[k+1]);
                arrayCombatentes.add(campeao);
                if(k == combatentes.length-2){
                    this.combatentes = arrayCombatentes.toArray(new Combatente[arrayCombatentes.size()]);
                    arrayCombatentes.clear();
                    k = 0;
                }else{
                    k += 2;
                }

            }

            System.out.println("\n------------------------------------------------");
            System.out.println("Vencedor do combate: " + campeao.getId() + "[" + campeao.getVida() + "]");
            System.out.println("------------------------------------------------\n");


        }
        System.out.println("Vencedor do torneio: " + combatentes[0].getId());
    }


    public static void main(String[] args) {

        AppArena arena = new AppArena(10);

        arena.iniciarTorneio();

    }

}
