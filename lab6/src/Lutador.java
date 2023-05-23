public class Lutador extends Combatente implements Karate{
    public Lutador(String id){
        super(id);
    }

    public int MaeGeri(){
        return 20;
    }
    public int DanZuki(){
        return 5;
    }
    public int MawashiGeri(){
        return 15;
    }
    public int UshiroGeri(){
        return 30;
    }
    public int SotoUke(){
        double rand1 = Math.random();
        if(rand1 < 0.33){
            return (int)(rand1*100);

        } else if (rand1 < 0.66) {
            return (int)(rand1*100);
        }else{
            return (int)(rand1*100);
        }
    }
    public int GedanBarai(){
        double rand2 = Math.random();
        if(rand2 < 0.33){
            return (int)(rand2*100);

        } else if (rand2 < 0.66) {
            return (int)(rand2*100);
        }else{
            return 1;
        }
    }

    public void atacar(Combatente adversario){
        int rand = (int)Math.floor(Math.random() * (4 - 1) + 1);
        if(rand == 1){
            System.out.println("Soco");
            adversario.defender(DanZuki());
        } else if (rand == 2) {
            System.out.println("Chute Lateral");
            adversario.defender(MawashiGeri());
        } else if (rand == 3) {
            System.out.println("Chute Frontal");
            adversario.defender(MaeGeri());
        } else if (rand == 4) {
            System.out.println("Chute Rodado");
            adversario.defender(UshiroGeri());
        }
    }
public int aux;
    public void defender(int poderOfensivo){
        double rand = Math.random();
        if(rand < 0.5){
            aux = SotoUke();
            vida-= SotoUke();
            System.out.println("\tDefesa: SotoUke" + "["+ aux + "]");

        }else{
            aux = GedanBarai();
            vida-= GedanBarai();
            System.out.println("\tDefesa: GedanBarai" + "["+ aux + "]");
        }

    }

}
