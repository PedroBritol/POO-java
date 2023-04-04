public class AppDetran {

    public static void main(String[] args){
        Carro meuCarro = new Carro("camaro");
        meuCarro.setModelo("camaro");
        String modeloCarro = meuCarro.getModelo();

        Proprietario dono = new Proprietario("Pedro", meuCarro);
        dono.setDono("Pedro", meuCarro);
        String nomeDono = dono.getNome();

        System.out.println(nomeDono + " é dono de um " + modeloCarro);
    }
}
