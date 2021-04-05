/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation;

import Aerolinea.model.Avion;
import Aerolinea.model.Model;
import Aerolinea.model.TipoAvion;
import Aerolinea.presentation.decoder.aviones_decoder;
import Aerolinea.presentation.decoder.tipo_aviones_decoder;
import Aerolinea.presentation.encoder.aviones_encoder;
import Aerolinea.presentation.encoder.tipo_aviones_encoder;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/aviones", 
  encoders = aviones_encoder.class,
  decoders = aviones_decoder.class)

public class aviones_WS {
    @OnOpen
    public void onOpen(Session session) throws IOException {
       
    }

    @OnMessage
    public List<Avion> onMessage(Session session, List<Avion> msg) throws IOException, SQLException, EncodeException {
        Aerolinea.model.Model model = Model.instance();
        List<Avion> aviones = new ArrayList<>();
         try {
            aviones = model.aviones();
            System.out.println("sent ");
        } catch (Exception ex) {
             System.out.println(ex);
        }
        return aviones;
    }

    @OnClose
    public void onClose(Session session) throws IOException {
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }
}
