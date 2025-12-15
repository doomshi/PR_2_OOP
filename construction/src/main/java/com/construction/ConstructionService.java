package com.construction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.inject.Inject;

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
}
