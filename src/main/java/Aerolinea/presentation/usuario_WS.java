/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation;

import Aerolinea.model.Model;
import Aerolinea.model.TipoAvion;
import Aerolinea.model.Usuario;
import Aerolinea.presentation.decoder.usuario_decoder;
import Aerolinea.presentation.encoder.usuario_encoder;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/usuario", 
  encoders = usuario_encoder.class,
  decoders = usuario_decoder.class)

public class usuario_WS {
    
    public static HashMap<String, String> user = new HashMap<>();
    
    @OnOpen
    public void onOpen(Session session) throws IOException {
       
    }

    @OnMessage
    public String onMessage(Session session, Usuario usuario) throws IOException, SQLException, EncodeException {
        Aerolinea.model.Model model = Model.instance(); 
        Usuario existe = model.existe_usuario(usuario);
        if(existe != null){
            user.put(session.getId(), existe.getUsername());
            user.put("usuario", existe.getUsername());
            user.put("tipo", String.valueOf(existe.getTipo()));
        }
        Gson gson = new Gson();
        return gson.toJson(existe);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
      
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println(throwable);
    }
}
