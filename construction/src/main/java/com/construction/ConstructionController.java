package com.construction;

import java.util.List;

import com.google.inject.Inject;

/**
 * Контролер, що з'єднує веб-рівень із моделлю ConstructionProject.
 */
public class ConstructionController {
    private final ConstructionProject project;

    @Inject
    public ConstructionController(ConstructionProject project) {
        this.project = project;
    }

    /**
     * Повертає всі зміни проєкту з бази даних.
     */
    public List<ProjectChange> getAllProjectChanges() {
        return project.getAllProjectChanges();
    }
}

