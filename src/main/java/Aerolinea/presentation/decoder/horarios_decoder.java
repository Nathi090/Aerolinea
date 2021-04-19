/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation.decoder;

import Aerolinea.model.Avion;
import Aerolinea.model.Horario;
import Aerolinea.model.Ruta;
import Aerolinea.model.TipoAvion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author nati2
 */
public class horarios_decoder implements Decoder.Text<Horario> {

    @Override
    public Horario decode(String s) throws DecodeException {
        //Gson gson = new Gson();
        Gson gson=  new GsonBuilder().create();
        Horario respuesta = null;
       try {
          respuesta = gson.fromJson(s, Horario.class);
       }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return respuesta;
        
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig config) {
    // do nothing.
    }

    @Override
    public void destroy() {
    // do nothing.
    }
    
}
