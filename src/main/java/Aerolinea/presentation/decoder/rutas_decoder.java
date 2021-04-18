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
        Ruta respuesta = new Ruta(0);
        System.out.println(s);
        ObjectMapper mapper = new ObjectMapper();
       try {
            List<String> lista = mapper.readValue(s, List.class);
            System.out.println(lista.get(0));
            Map<String, String> aux = mapper.readValue(lista.get(0), Map.class);
            if (aux.get("metodo").equals("Guardar")){
                aux.remove("metodo");
                respuesta = gson.fromJson(mapper.writeValueAsString(aux), Ruta.class);   
                respuesta.setId(1);
                
            }
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
