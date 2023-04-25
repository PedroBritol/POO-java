public class Combatente {
    protected String id;
    protected int vida;

    public Combatente(String indentidicacao){
        this.id = indentidicacao;
        boolean fera = indentidicacao.matches("Fera.*");
        if(fera){
            double rand2 = Math.random();
            if(rand2 > 0.5){
                this.vida = 150;
            }else{
                this.vida = 100 + (int)(rand2*100);
            }
        }else{
            this.vida = 100;
        }

    }

    public void atacar(Combatente adversario){
        int poderOfenciso = (int)Math.floor(Math.random() * (90 - 10) + 10);
        adversario.defender(poderOfenciso);
    }

    public String getId() {
        return id;
    }

    public int getVida() {
        return vida;
    }

    public String toString(){
        return this.id + " [" + vida + "]";
    }
    public void defender(int poderOfensivo){
        double rand = Math.random();
        if(rand < 0.33){
            System.out.println("\tDefesa completa");

        } else if (rand > 0.33 && rand < 0.66) {
            vida-=(poderOfensivo/2);
            System.out.println("\tDefesa parcial 8|");
        }else{
            vida-=poderOfensivo;
            System.out.println("\tDefesa falhou :(");
        }

    }
    public boolean status(){
        if(vida > 0){
            return true;
        }else{
            return false;
        }
    }
}
