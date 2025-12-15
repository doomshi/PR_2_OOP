package com.construction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class ConstructionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class)
                .annotatedWith(Names.named("JDBC URL"))
                .toInstance("jdbc:sqlite:target/construction.db");
    }

    @Provides
    @Singleton
    Connection provideConnection(@Named("JDBC URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    private void createTableIfNotExists(Connection connection) {
        // Table for ProjectChange attributes (from class ConstructionProject's
        // aggregation of ProjectChange)
        String createTableSQL = "CREATE TABLE IF NOT EXISTS project_changes (" +
                "description TEXT NOT NULL, " +
                "impact TEXT NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }
}
