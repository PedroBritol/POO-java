public class Lutador extends Combatente{
    public Lutador(String id){
        super(id);
    }

    public int socar(){
        return 5;
    }
    public int chuteLateral(){
        return 8;
    }
    public int chuteFrontal(){
        return 10;
    }
    public int chuteRodado(){
        return 15;
    }

    public void atacar(Combatente adversario){
        int rand = (int)Math.floor(Math.random() * (4 - 1) + 1);
        if(rand == 1){
            System.out.println("Soco");
            adversario.defender(socar());
        } else if (rand == 2) {
            System.out.println("Chute Lateral");
            adversario.defender(chuteLateral());
        } else if (rand == 3) {
            System.out.println("Chute Frontal");
            adversario.defender(chuteFrontal());
        } else if (rand == 4) {
            System.out.println("Chute Rodado");
            adversario.defender(chuteRodado());
        }
    }

}
