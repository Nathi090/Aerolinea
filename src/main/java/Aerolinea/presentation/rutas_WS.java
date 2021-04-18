/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation;

import Aerolinea.model.Avion;
import Aerolinea.model.Model;
import Aerolinea.model.Ruta;
import Aerolinea.model.TipoAvion;
import Aerolinea.presentation.decoder.aviones_decoder;
import Aerolinea.presentation.decoder.rutas_decoder;
import Aerolinea.presentation.encoder.aviones_encoder;
import Aerolinea.presentation.encoder.rutas_encoder;
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

@ServerEndpoint(value="/rutas", 
  encoders = rutas_encoder.class,
  decoders = rutas_decoder.class)

public class rutas_WS {
    @OnOpen
    public void onOpen(Session session) throws IOException {
       
    }

    @OnMessage
    public List<Ruta> onMessage(Session session, Ruta ruta) throws IOException, SQLException, EncodeException { 
        System.out.println("Entró a rutasWS");
        Aerolinea.model.Model model = Model.instance();   
        
        if (ruta.getId() != 0){
            model.insertRuta(ruta);
        }
             
        List<Ruta> rutas = new ArrayList<>();
         try {
            rutas = model.rutas();
            System.out.println("sent ");
        } catch (Exception ex) {
             System.out.println(ex);
        }
        
        return rutas;
    }

    @OnClose
    public void onClose(Session session) throws IOException {
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }
}
