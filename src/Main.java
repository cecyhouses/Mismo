import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String CPHmo= "C:/Users/cecyh/Downloads/codigos_postales_hmo.txt";
        int MAX_NUMEROS = 1000; // cant de CP limitado...

        try (BufferedReader br = new BufferedReader(new FileReader(CPHmo))) {
            String linea;
            String[] numeros = new String[MAX_NUMEROS];
            int[] repeticiones = new int[MAX_NUMEROS];
            int numEntradas = 0;

            while ((linea = br.readLine()) != null) {
                if (linea.length() >= 5) {
                    String primerosCincoNumeros = linea.substring(0, 5);
                    boolean encontrado = false;

                    for (int i = 0; i < numEntradas; i++) {
                        if (numeros[i].equals(primerosCincoNumeros)) {
                            repeticiones[i]++;
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado && numEntradas < MAX_NUMEROS) {
                        numeros[numEntradas] = primerosCincoNumeros;
                        repeticiones[numEntradas] = 1;
                        numEntradas++;
                    }
                }
            }

            for (int i = 0; i < numEntradas; i++) {
                System.out.println("CP: " + numeros[i] + " - Asentamientos que comparten el mismo código postal: " + repeticiones[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File file= new File("C:/Users/cecyh/Downloads/codigos_postales_hmo.txt");
        //Scanner scan= new Scanner(file);

        //while (scan.hasNextLine()) {

          //System.out.println(scan.nextLine());
        //}
    }
}