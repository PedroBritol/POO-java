import java.util.Random;

public class GeradorDePlaca {

    private String placa = "";
    private static int numSequecial = 0;

    int numeroAleatorio = (int)Math.floor(Math.random() * (9 - 0) + 0);

    GeradorDePlaca(){
        Random random = new Random();
        char[] vetorLetras = new char[4];
        int sequencial = GeradorDePlaca.getSequencial();

        for (int i = 0; i < 4; i++){
            int randomIntegeer = random.nextInt(26);
            char letraAleatoria = (char)(randomIntegeer + 'A');
            vetorLetras[i] = letraAleatoria;
        }

        for(int j = 0 ; j < 4; j++){
            placa += vetorLetras[j];
            if(j == 2){
                placa+="-";
                placa+=numeroAleatorio;
            }
        }
        placa+= String.format("%03d", sequencial);


    }

    public String getPlacaAleatoria(){

       return placa;

    }
    public static int getSequencial(){
        int aux = numSequecial;
        numSequecial++;
        return aux;
    }

}
