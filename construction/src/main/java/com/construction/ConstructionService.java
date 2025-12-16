package com.construction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Сервіс для роботи з таблицею змін проєкту.
 */
public class ConstructionService {
    private Connection connection;

    /**
     * Конструктор з впровадженням залежності від драйвера бази даних.
     *
     * @param connection з'єднання з базою даних
     */
    @Inject
    public ConstructionService(Connection connection) {
        this.connection = connection;
    }

    public void saveProjectChange(ProjectChange change) {
        String sql = "INSERT INTO project_changes (description, impact) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, change.getDescription());
            statement.setString(2, change.getImpact());
            statement.executeUpdate();
            System.out.println("[Service] Saved change to DB: " + change);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save project change", e);
        }
    }

    /**
     * Отримує всі зміни проєкту з бази даних.
     */
    public List<ProjectChange> getAllProjectChanges() {
        List<ProjectChange> changes = new ArrayList<>();
        String sql = "SELECT description, impact FROM project_changes";

        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String description = resultSet.getString("description");
                String impact = resultSet.getString("impact");
                changes.add(new ProjectChange(description, impact));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to load project changes", e);
        }

        return changes;
    }
}
