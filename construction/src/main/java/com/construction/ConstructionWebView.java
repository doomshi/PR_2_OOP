package com.construction;

import com.construction.webserver.HttpContext;
import com.construction.webserver.WebServer;
import com.google.inject.Inject;

/**
 * Веб-інтерфейс для перегляду змін будівельного проєкту через Javalin.
 */
public class ConstructionWebView {
    private final ConstructionController controller;
    private final WebServer server;

    @Inject
    public ConstructionWebView(ConstructionController controller, WebServer server) {
        this.controller = controller;
        this.server = server;
        setupRoutes();
    }

    private void setupRoutes() {
        // CORS для роботи з Live Server/браузером
        server.before(context -> {
            context.header("Access-Control-Allow-Origin", "*");
            context.header("Access-Control-Allow-Methods", "GET, OPTIONS");
            context.header("Access-Control-Allow-Headers", "Content-Type");
        });

        // Preflight
        server.options("/*", context -> context.status(200));

        // API
        server.get("/api/changes", this::getAllChanges);
    }

    private void getAllChanges(HttpContext context) {
        try {
            context.json(controller.getAllProjectChanges());
        } catch (Exception e) {
            context.status(500).result("Помилка при отриманні даних: " + e.getMessage());
        }
    }

    public void start(int port) {
        server.start(port);
        System.out.println("──────────────────────────────────────────────");
        System.out.println("Construction Web Server запущено!\n");
        System.out.println("REST API: http://localhost:" + port + "\n");
        System.out.println("Відкрийте construction/src/main/resources/index.html");
        System.out.println("за допомогою Live Server (VS Code extension)\n");
        System.out.println("Endpoint:");
        System.out.println("   GET  /api/changes - перегляд змін проєкту");
        System.out.println("──────────────────────────────────────────────");
    }

    public void stop() {
        server.stop();
    }
}

