import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WorkWithFiles {
    public static void main(String[] args) {
        //File myFile = new File("my_file.txt");
        try {
            /*boolean created = myFile.createNewFile();
            if(created) {
                System.out.println("File is created");
            } else {
                System.out.println("File is not created");
            }*/
            FileWriter writer = new FileWriter("my_file.txt");
            writer.write("Hello, Ugur");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File file = new File("my_file.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length());

        //file.delete();


    }
}
