import ModelClasses.Project;
import ModelClasses.ProjectModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProjectFile implements ProjectPersistence{
    private File file;

    public ProjectFile(String fileName)
    {
        file = new File(fileName);
    }
    @Override
    public ProjectModel loadAll() {
        return null;
    }

    @Override
    public void saveAll() {

    }

    @Override
    public void save(Project project) {

    }
}
