import java.util.ArrayList;
import java.util.List;

// Клас проєкту з агрегованими змінами
public class ConstructionProject {
    private String title;
    private List<ProjectChange> changes;

    public ConstructionProject(String title) {
        this.title = title;
        this.changes = new ArrayList<>();
        System.out.println("[Project] Created project: " + title);
    }

    public String getTitle() {
        return title;
    }

    public void addChange(ProjectChange c) {
        changes.add(c);
        System.out.println("[Project] Change added: " + c);
    }

    // Фінальний метод повертає статус проєкту
    public final String getStatus() {
        return "Active (changes: " + changes.size() + ")";
    }

    public List<ProjectChange> getChanges() {
        return changes;
    }
}
