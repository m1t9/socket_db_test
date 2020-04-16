package sockets;

import dataset.MessageDataSet;
import executor.DBService;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ChatWebSocket {
    private Session session;
    private MessageDataSet messageDataSetToSave;
    DBService dbService;

    public ChatWebSocket(DBService dbService) {
        this.dbService = dbService;
    }

    @OnWebSocketConnect
    public void connect(Session session) {
        this.session = session;
    }

    @OnWebSocketMessage
    public void sendString(String message) {
        try {
            session.getRemote().sendString(message);
            long id = dbService.addMessage(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
