package com.construction;

import java.util.ArrayList;
import java.util.List;

// Клас проєкту з агрегованими змінами
public class ConstructionProject {
    private String title;
    private List<ProjectChange> changes;
    private ConstructionService service;

    // Constructor injection commented out for Task 3.2
    // @com.google.inject.Inject
    // public ConstructionProject(ConstructionService service) {
    // this.service = service;
    // this.changes = new ArrayList<>();
    // }

    public ConstructionProject() {
        this.changes = new ArrayList<>();
    }

    @com.google.inject.Inject
    public void setConstructionService(ConstructionService service) {
        this.service = service;
    }

    public void setTitle(String title) {
        this.title = title;
        System.out.println("[Project] Created project: " + title);
    }

    public String getTitle() {
        return title;
    }

    public void addChange(ProjectChange c) {
        changes.add(c);
        System.out.println("[Project] Change added: " + c);
        // Save to DB
        service.saveProjectChange(c);
    }

    /**
     * Повертає всі зміни проєкту, зчитані з бази даних.
     */
    public List<ProjectChange> getAllProjectChanges() {
        return service.getAllProjectChanges();
    }

    // Фінальний метод повертає статус проєкту
    public final String getStatus() {
        return "Active (changes: " + changes.size() + ")";
    }

    public List<ProjectChange> getChanges() {
        return changes;
    }
}
