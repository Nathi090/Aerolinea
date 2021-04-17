/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation.decoder;

import Aerolinea.model.Avion;
import Aerolinea.model.Ruta;
import Aerolinea.model.TipoAvion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
public class rutas_decoder implements Decoder.Text<Ruta> {

    @Override
    public Ruta decode(String s) throws DecodeException {
        Gson gson = new Gson();
        Ruta respuesta = null;
        System.out.println(s);
        ObjectMapper mapper = new ObjectMapper();
       try {
            List<String> lista = mapper.readValue(s, List.class);
            if (mapper.readValue(lista.get(0), Map.class).get("metodo").toString().equals("Guardar")){
                respuesta = gson.fromJson(mapper.writeValueAsString(lista), Ruta.class);                
                System.out.println(":VVVVVVVVVVVVVVVVVV SIM");
                
            }
       }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return respuesta;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
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
