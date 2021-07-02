/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation;

import Aerolinea.model.Model;
import Aerolinea.model.Reserva;
import Aerolinea.model.Ruta;
import Aerolinea.model.Tiquete;
import Aerolinea.model.Vuelo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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
import jdk.nashorn.internal.runtime.JSONFunctions;

@ServerEndpoint(value="/vuelos")
public class vuelos_WS {
    @OnOpen
    public void onOpen(Session session){
       
    }

    @OnMessage
    public String onMessage(Session session, String msg){
        Gson gson = new Gson();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(msg);
        
        try {
            List<String> lista = mapper.readValue(msg, List.class);
            String response = "[" + lista.get(0);
            
            switch( mapper.readValue(lista.get(0), Map.class).get("metodo").toString() ){
                case "selectAll":
                    List<Vuelo> vuelos = Model.instance().vuelos();
                    response += gson.toJson(vuelos).replace('[', ',');
                    return response;
                case "selectReservations":
                    String user = mapper.readValue(lista.get(1), Map.class).get("user").toString();
                    List<Reserva> reservas = Model.instance().reservas(user);
                    response += gson.toJson(reservas).replace('[', ',');
                    return response;
                case "insert":
                    Reserva reserva = gson.fromJson(lista.get(1), Reserva.class);
                    lista.remove(0);
                    lista.remove(1);
                    ArrayList<Tiquete> tiquetes = new ArrayList<>();
                    for(int i = 0; i<lista.size(); i++){
                        tiquetes.add(gson.fromJson(lista.get(i), Tiquete.class));
                    }
                    Model.instance().reservar(reserva, tiquetes);
                    return response+"]";
                case "updateSeats":
                    for (Session sess : session.getOpenSessions()) {
                        if (sess.isOpen())
                            sess.getBasicRemote().sendText(msg);
                    }
                default:
                    return "false";
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
