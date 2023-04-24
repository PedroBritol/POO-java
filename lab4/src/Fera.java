public class Fera extends Combatente{
    public Fera(String id){
        super(id);
    }

    public int investida(){
        return 10;
    }
    public int usarGarra(){
        return 15;
    }
    public int morder(){
        return 20;
    }

    public void atacar(Combatente adversario){
        int rand = (int)Math.floor(Math.random() * (3 - 1) + 1);
        if(rand == 1){
            System.out.println("Investida");
            adversario.defender(investida());
        } else if (rand == 2) {
            System.out.println("Garras Afiadas");
            adversario.defender(usarGarra());
        } else if (rand == 3) {
            System.out.println("Presas Afiadas");
            adversario.defender(morder());
        }
    }
}
