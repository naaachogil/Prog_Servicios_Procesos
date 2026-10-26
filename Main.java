import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // Proceso para linux con un error (la opción -z no existe en ls)
        ProcessBuilder processBuilder = new ProcessBuilder("ls","-");
        Process process = null;
        try {
            //Lanzo el proceso
            process = processBuilder.start();
            BufferedReader stdOut= new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError= new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.out.println("----Salida estandar----");
            stdOut.lines().forEach(System.out::println);
            System.out.println("----Salida error----");
            stdError.lines().forEach(System.out::println);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}