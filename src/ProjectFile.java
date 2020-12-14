import ModelClasses.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

//"Using files is more complicated than using database, change my mind" - Yo


public class ProjectFile implements ProjectPersistence{
    private File file;

    public ProjectFile(String fileName)
    {
        file = new File(fileName);
    }

    @Override
    public ProjectList loadAllProjects() {
        File path=new File(".\\Projects\\Started");
        File[] listOfFiles = path.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            Scanner in = new Scanner(file);
            String line = in.nextLine ();
            String[] token = line.split("||");

            Project project = new Project(token[0].trim(), token[1].trim(), token[2].trim(), );
            System.out.println (project);
            in.close();
        }
    }

    @Override
    public Team loadAllTeamMembers() {
        return null;
    }

    @Override
    public void saveAll() {

    }

    @Override
    public void saveProject(Project project) {

    }

    @Override
    public void saveTeamMember(TeamMember teamMember) {

    }
}
