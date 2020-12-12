import java.io.*;
import java.util.Scanner;

public class ProjectFile {
    public static void main(String[] args) throws IOException {
        File path=new File(".\\Projects\\Started");
        File[] listOfFiles = path.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            Scanner in = new Scanner(file);
            String line = in.nextLine ();
            String[] token = line.split(";");
            Project project = new Project(token[0].trim(), token[1].trim(), token[2].trim());
            System.out.println (project);
            in.close();
        }
    }
}
