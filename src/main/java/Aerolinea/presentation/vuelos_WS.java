/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.IOException;
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
    public void onMessage(Session session, String msg){
        Gson gson = new Gson();
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> map = mapper.readValue(msg, Map.class);
               
            System.out.println( map.get("poio") );
            
            switch(map.get("poio")){
                case "123":
                    System.out.println("NOL");
                    break;
                case "en papas":
                    System.out.println("YES");
                    break;
                default:
                    System.out.println("NOLL2");
                    break;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(vuelos_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @OnClose
    public void onClose(Session session){
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        // Do error handling here
    }
}
