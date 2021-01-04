import ModelClasses.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//"Using files is more complicated than using database, change my mind" - Yo


public class ProjectFile implements ProjectPersistence {
    private File file;

    public ProjectFile(String fileName) {
        file = new File(fileName);
    }

    //Checking every folder in Started to take the information for projects
    //Does not get requirement/task/team members
    @Override
    public ProjectList loadAllProjects() {
        ProjectList projectList = new ProjectList();
        String path = "..\\Projects\\Started";

        File[] directories = new File(path).listFiles(File::isDirectory);
        for (int i = 0; i < directories.length; i++) {
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
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return projectList;
    }

    //Reading every file in Teams to take the information for projects
    //Does not get tasks but can be seen that only task ID are stored
    @Override
    public Team loadAllTeamMembers() {
        Team team = new Team();
        File path = new File(".\\Teams");
        File[] listOfFiles = path.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            try {
                File file = new File(".\\Teams");
                Scanner in = new Scanner(file);
                String line = in.nextLine();
                String[] token = line.split("-");
                TeamMember teamMember = new TeamMember(token[1], token[0]);
                teamMember.setRole(token[2]);
                team.addTeamMember(teamMember);
                String[] taskID = token[3].substring(1, token.length - 1).split(", ");
                teamMember.addTasks(getAllTasksOfTeamMember(taskID));
                in.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return team;
    }

    @Override
    public void saveAll() {

    }

    //this probably saves in file
    @Override
    public void saveProject(Project project) {
        boolean saved = false;
        try {
            String path = ".\\Projects\\Started";
            File[] directories = new File(path).listFiles(File::isDirectory);
            for (int i = 0; i < directories.length; i++) {
                if (directories[i].getName().equals(project.getProjectId())) {
                    String filePath = directories[i].getPath() + "\\" + directories[i].getPath() + ".txt";
                    File file = new File(filePath);
                    PrintWriter out = new PrintWriter(file);
                    out.println(project.toString());
                    out.flush();
                    out.close();
                    saved = true;
                }
            }
            if (!saved) {
                File file = new File(project.getProjectId());
                PrintWriter out = new PrintWriter(file);
                out.println(project.toString());
                out.flush();
                out.close();
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void saveTeamMember(TeamMember teamMember) {
        boolean saved = false;
        try {
            String path = ".\\Teams";
            File[] files = new File(path).listFiles();
            File[] directories = new File(path).listFiles(File::isDirectory);
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().equals(teamMember.getTeamMemberId())) {
                    String filePath = files[i].getPath();
                    File file = new File(filePath);
                    PrintWriter out = new PrintWriter(file);
                    out.println(teamMember.toString());
                    out.flush();
                    out.close();
                    saved = true;
                }
            }
            if (!saved) {
                File file = new File(teamMember.getTeamMemberId());
                PrintWriter out = new PrintWriter(file);
                out.println(teamMember.toString());
                out.flush();
                out.close();
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            String path = ".\\Projects\\Started";
            File[] directories = new File(path).listFiles(File::isDirectory);
            for (int i = 0; i < directories.length; i++) {
                String newDirectory = directories[i].getPath() + "\\Requirements";
                File[] newDirectories = new File(newDirectory).listFiles(File::isDirectory);

                for (int j = 0; j < newDirectories.length; j++) {
                    File[] taskDirectory = new File(newDirectories[j].getPath()).listFiles(File::isDirectory);
                    File filePath = new File(taskDirectory[j].getPath());
                    File[] listOfFiles = filePath.listFiles();
                    for (int k = 0; k < listOfFiles.length; k++) {
                        File file = listOfFiles[k];
                        Scanner in = new Scanner(file);
                        String line = in.nextLine();
                        String[] token = line.split("-");
                        Task task = new Task(token[0], token[1], Double.parseDouble(token[2]), token[5]);
                        task.setStatus(token[3]);
                        task.setTimeSpent(Double.parseDouble(token[4]));
                        tasks.add(task);
                        in.close();
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return tasks;
    }

    @Override
    public ArrayList<Task> getAllTasksOfTeamMember(String[] ids) {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            String path = ".\\Projects\\Started";
            File[] directories = new File(path).listFiles(File::isDirectory);
            for (int i = 0; i < directories.length; i++) {
                String newDirectory = directories[i].getPath() + "\\Requirements";
                File[] newDirectories = new File(newDirectory).listFiles(File::isDirectory);

                for (int j = 0; j < newDirectories.length; j++) {
                    File[] taskDirectory = new File(newDirectories[j].getPath()).listFiles(File::isDirectory);
                    File filePath = new File(taskDirectory[j].getPath());
                    File[] listOfFiles = filePath.listFiles();
                    for (int k = 0; k < listOfFiles.length; k++) {
                        File file = listOfFiles[k];
                        if(Arrays.asList(ids).contains(file.getName())){
                            Scanner in = new Scanner(file);
                            String line = in.nextLine();
                            String[] token = line.split("-");
                            Task task = new Task(token[0], token[1], Double.parseDouble(token[2]), token[5]);
                            task.setStatus(token[3]);
                            task.setTimeSpent(Double.parseDouble(token[4]));
                            tasks.add(task);
                            in.close();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return tasks;
    }
}
