import ModelClasses.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
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
        ProjectList projectList = new ProjectList();
        String path = ".\\Projects\\Started";
        File[] directories = new File(path).listFiles(File::isDirectory);
        for(int i = 0; i< directories.length; i++)
        {
            try {
                String pathToRequirements = directories[i].getPath() + "\\" + directories[i].getName() + ".txt";
                File projectFile = new File(pathToRequirements);
                Scanner in = new Scanner(projectFile);
                String line = in.nextLine();
                String[] token = line.split("-");
                String[] fckMyLf = token[3].split(".");
                MyDate date = new MyDate(Integer.parseInt(fckMyLf[0]), Integer.parseInt(fckMyLf[1]), Integer.parseInt(fckMyLf[2]));
                projectList.addProject(token[0], token[1], token[2], date, token[4]);
                in.close();
            }
            catch (Exception e)
            {
                e.getMessage();
            }
        }
        return projectList;
    }

    @Override
    public Team loadAllTeamMembers() {
        Team team = new Team();
        File path=new File(".\\Teams");
        File[] listOfFiles = path.listFiles();
        for(int i = 0; i< listOfFiles.length; i++)
        {
            try {
                File file = new File(".\\Teams");
                Scanner in = new Scanner(file);
                String line = in.nextLine();
                String[] token = line.split("-");
                TeamMember teamMember = new TeamMember(token[1], token[0]);
                team.addTeamMember(teamMember);
                in.close();
            }
            catch (Exception e)
            {
                e.getMessage();
            }
        }
        return team;
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
