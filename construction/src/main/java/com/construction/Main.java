package com.construction;

import com.google.inject.Guice;
import com.google.inject.Injector;

// Головний клас для демонстрації послідовності дій згідно з UML
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Simulation start ---");

        Injector injector = Guice.createInjector(new ConstructionModule());
        ConstructionProject project = injector.getInstance(ConstructionProject.class);
        project.setTitle("New Office Building");

        Foreman foreman = new Foreman(1, "Ivan", 10);
        Engineer engineer = new Engineer(2, "Olena", "ENG-12345");
        Supplier supplier = new Supplier(3, "Petro", "BuildSupply LLC");

        // Прораб ініціює зміну
        ProjectChange change = foreman.initiateChange("Extend foundation depth", "Increased cost and time");

        // Проект додає зміну (агрегація)
        project.addChange(change);

        // Проект повідомляє інженера (послідовність)
        engineer.handleChange(change);

        // Прораб закриває етап
        foreman.closeStage();

        // Постачальник доставляє матеріали (залежність)
        supplier.deliverMaterials(project);

        System.out.println("[Main] Project status: " + project.getStatus());
        System.out.println("--- Simulation end ---");

        // Запускаємо веб-сервер для перегляду
        runWebMode(injector);
    }

    private static void runWebMode(Injector injector) {
        ConstructionWebView webView = injector.getInstance(ConstructionWebView.class);
        webView.start(8080);
    }
}
