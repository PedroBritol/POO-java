import java.util.ArrayList;
import java.util.Iterator;

public class AppArena {

    static int qtdLutadores = 0;
    static int qtdFeras = 0;
    static int qtdGladiador = 0;

    private int numCobatentes;
    private Combatente combatentes[];

    private ArrayList<Combatente> arrayCombatentes = new ArrayList<>();

    public AppArena(int numCombatentes) {
        this.numCobatentes = numCombatentes;
        combatentes = gerarVetorCombatentes(numCobatentes);
    }

    private Gladiador geraGladiador()
    {
        Gladiador gladiador = new Gladiador("" + qtdGladiador++);

        Arma espada = new Arma("Escalibur"+ qtdGladiador);
        espada.addGolpe("Ataque frontal", 50);
        espada.addGolpe("Ataque Lateral", 40);
        gladiador.addArma(espada);

        return gladiador;
    }

    private Combatente[] gerarVetorCombatentes(int qtdCombatentes) {
        Combatente[] combatentes = new Combatente[qtdCombatentes];
        for (int i = 0; i < combatentes.length; i++) {
            if (Math.random() < 0.33) {
                combatentes[i] = new Lutador("Lutador " + qtdLutadores++);
            }else if(Math.random() < 0.66) {
                combatentes[i] = new Fera("Fera " + qtdFeras++);
            }
            else {
                combatentes[i] = geraGladiador();
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

        if ((combatente1 instanceof Gladiador) && (combatente2 instanceof Gladiador)) {
            Combatente perdedor = combatente1.status() ? combatente2 : combatente1;
            Combatente vencedor = combatente1.status() ? combatente1 : combatente2;

            for (int i = 0; i < ((Gladiador)perdedor).armas.size(); i++) {
                System.out.println("arma " + ((Gladiador)perdedor).armas.get(i).getId() + " transferida para " + vencedor.getId());
                ((Gladiador)vencedor).addArma(((Gladiador)perdedor).armas.get(i));

            }
            System.out.println("arsenal transferido");

        }

        return combatente1.status() ? combatente1 : combatente2;

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

        AppArena arena = new AppArena(50);

        arena.iniciarTorneio();

    }

}
