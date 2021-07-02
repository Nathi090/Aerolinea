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
import Aerolinea.model.Usuario;
import Aerolinea.presentation.decoder.perfil_decoder;
import Aerolinea.presentation.encoder.perfil_encoder;
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

@ServerEndpoint(value="/perfil", 
  encoders = perfil_encoder.class,
  decoders = perfil_decoder.class)

public class perfil_WS {
    @OnOpen
    public void onOpen(Session session) throws IOException {
       
    }

    @OnMessage
    public Usuario onMessage(Session session, Usuario user) throws IOException, SQLException, EncodeException {
        System.out.println("Entró a PerfilWS");
        Aerolinea.model.Model model = Model.instance();   
        
        
         try {
            user = model.usuario(usuario_WS.user.get("usuario"));
            System.out.println("sent ");
        } catch (Exception ex) {
             System.out.println(ex);
        }
        
        return user;
    }

    @OnClose
    public void onClose(Session session) throws IOException {
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }
}
