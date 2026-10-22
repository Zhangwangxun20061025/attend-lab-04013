package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        // Render 会通过环境变量 PORT 告诉我们用哪个端口
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "10000"));
        Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new Attend()), "/*");

        server.start();
        server.join();
    }
}
