/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation;

import Aerolinea.model.Avion;
import Aerolinea.model.Model;
import Aerolinea.presentation.decoder.salir_decoder;
import Aerolinea.presentation.encoder.salir_encoder;
import java.io.IOException;
import java.sql.SQLException;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/salir", 
  encoders = salir_encoder.class,
  decoders = salir_decoder.class)

public class salir_WS {
    @OnOpen
    public void onOpen(Session session) throws IOException {
       usuario_WS.user.clear();
       session.close();
    }

    @OnMessage
    public String onMessage(Session session, String msg) throws IOException, SQLException, EncodeException {
        return "Listo";
    }

    @OnClose
    public void onClose(Session session) throws IOException {
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }
}
