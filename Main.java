import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main{
    public static void main (String[]args){

        //Sistema operativo
        String os = System.getProperty("os.name");
        System.out.println("Nuestro sistema operativo es = "+os);

        String command="";
        String directorio="";

        //Crear comando segun el SO
        if(os.equalsIgnoreCase("Linux")){
             command = "sh -c ls";
             directorio="/tmp";
        }else{
             command = "cmd /c dir";
             directorio="c:/tmp";
        }

        try {
            ProcessBuilder pBuilder = new ProcessBuilder(command.split("\\s"));

            //Cambiamos directorio
            pBuilder.directory(new File(directorio));

            //Creo proceso
            Process process = pBuilder.start();

            //Stream del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            reader.lines().forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}