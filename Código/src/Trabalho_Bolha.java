import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Trabalho_Bolha {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Abrindo o Primeiro Buffer Para ler o Txt
        FileReader le = new FileReader("Inserir.txt");
        BufferedReader leBuffer = new BufferedReader(le);

        //Abrindo o Segundo Buffer Para ler o Txt e gravar em uma matriz
        //Eu sei que se tivesse dividido em funcoes eu nao precisaria desse segundo buffer
        FileReader le_2 = new FileReader("Inserir.txt");
        BufferedReader leBuffer_2 = new BufferedReader(le_2);

        //Leio o primeiro numero para saber quantas linha precisso colocar na matriz
        int quantidade_linha = Integer.parseInt(leBuffer.readLine());

        //Variavel Para gravar o text com maior numero de Strings, para colocar no meu numero de colunas
        //Senpre comparando com o lenght
        int guardar_maior_linha = 0;

        for (int i = 0; i < quantidade_linha-1 ; i++) {
            String linha = leBuffer.readLine();
            String vetorVerifica[] = linha.split(" ");
            if (guardar_maior_linha < vetorVerifica.length){
                guardar_maior_linha = vetorVerifica.length;
            }
        }

        System.out.println(guardar_maior_linha+" Maior Linha");

        System.out.println(quantidade_linha+" Quantidade de Colunas");


        //Crio o vetor com as aviaveis a cima
        String bau [][] = new String[quantidade_linha][guardar_maior_linha];

        System.out.println();

        //Aqui eu utilizo o segndo buffer para ler o text novamente do inicio ao fim e gravar dentro da minha matriz
        for (int i = 0; i < bau.length ; i++) {
            String fazer = leBuffer_2.readLine().toLowerCase();
            String vetorStringLinha[] = fazer.split(" ");
            for (int j = 0; j < vetorStringLinha.length; j++) {
                //System.out.print(vetorStringLinha[j]);
                bau[i][j] = vetorStringLinha[j];
            }
        }

        //Imprimo o que eu li no text sempre tomando cuidado para não imprimir alguns nulls
        // Os null aparecem pq me baseei na maior linha para criar a mariz assim as linhas menores recebem null apos gravarem todas as Strings
        for (int i = 0 ; i < bau.length; i++ ){
            for(int j = 0; j < bau[0].length; j++){
                if (bau[i][j] != null) {
                    System.out.print(bau[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println();


        //Utilizo o bolha para organizar a matriz o primeiro for anda nas linhas o segundo compara as linhas várias vezes
        //E o terceiro anda nas colunas
        //Preciso prestar atencao com os nulls aqui tbm
        for (int i = 0; i < bau.length; i++) {
            for( int k = 0; k < bau[0].length; k++){
                for (int j = 0; j < bau[0].length - 1; j++) {
                    if (bau[i][j + 1] != null) {
                        /*
                        if (bau[i][j].length() < bau[i][j + 1].length()) {
                            String temp = bau[i][j];
                            bau[i][j] = bau[i][j + 1];
                            bau[i][j + 1] = temp;
                        }*/
                        if (bau[i][j].compareTo(bau[i][j+1]) > 0) {
                            String temp = bau[i][j];
                            bau[i][j] = bau[i][j + 1];
                            bau[i][j + 1] = temp;
                        }
                    }
                }
            }
        }

        //Imprimo novamente sempre prestando muita atancao com o null
        for (int i = 0 ; i < bau.length; i++ ){
            for(int j = 0; j < bau[0].length; j++){
                if (bau[i][j] != null) {
                    System.out.print(bau[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}