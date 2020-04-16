package main;

import executor.DBService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.WebSocketChatServlet;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

//        System.setProperty("log4j.configurationFile", "cfg\\log4j2.xml");

        DBService dbService = new DBService();
        dbService.printConnectInfo();

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new WebSocketChatServlet(dbService)), "/chat");
        server.setHandler(context);

        server.start();
        logger.info("Server started");
        System.out.println("Server started");
        server.join();

    }

}
