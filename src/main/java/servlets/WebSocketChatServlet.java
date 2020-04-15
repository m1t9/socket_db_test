package servlets;

import executor.DBService;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import sockets.ChatWebSocket;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "WebSocketChatServlet", urlPatterns = {"/chat"})
public class WebSocketChatServlet extends WebSocketServlet {

    DBService dbService;

    public WebSocketChatServlet(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.setCreator((req, resp) -> new ChatWebSocket(dbService));
    }
}
