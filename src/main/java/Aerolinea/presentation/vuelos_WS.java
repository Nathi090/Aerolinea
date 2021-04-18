/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation;

import Aerolinea.model.Model;
import Aerolinea.model.Ruta;
import Aerolinea.model.Vuelo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/vuelos")
public class vuelos_WS {
    @OnOpen
    public void onOpen(Session session){
       
    }

    @OnMessage
    public String onMessage(Session session, String msg){
        Gson gson = new Gson();
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<String> lista = mapper.readValue(msg, List.class);
            String response = "[" + lista.get(0);
            switch( mapper.readValue(lista.get(0), Map.class).get("metodo").toString() ){
                case "selectAll":
                    List<Vuelo> vuelos = Model.instance().vuelos();
                    response += gson.toJson(vuelos).replace('[', ',');
                    return response;
                case "insert":
                    return "121234";
                default:
                    return "1 - a";
            }
            
        } catch (IOException ex) {
            Logger.getLogger(vuelos_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Nothing";
    }

    @OnClose
    public void onClose(Session session){
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        // Do error handling here
    }
}
