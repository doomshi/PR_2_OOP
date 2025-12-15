package com.construction;
// Бізнес-об'єкт: опис змін в проєкті
public class ProjectChange {
    private String description;
    private String impact;

    public ProjectChange(String description, String impact) {
        this.description = description;
        this.impact = impact;
    }

    public String getDescription() {
        return description;
    }

    public String getImpact() {
        return impact;
    }

    @Override
    public String toString() {
        return "Change[desc='" + description + "', impact='" + impact + "']";
    }
}
