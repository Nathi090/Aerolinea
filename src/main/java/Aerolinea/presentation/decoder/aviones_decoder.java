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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author nati2
 */
public class aviones_decoder implements Decoder.Text<Avion> {

    @Override
    public Avion decode(String s) throws DecodeException {
        Gson gson = new Gson();
        Avion respuesta = new Avion(0);
        System.out.println(s.getClass());
        ObjectMapper mapper = new ObjectMapper();
       try {
            String lista= mapper.readValue(s, String.class);
            System.out.println(s);
            Map<String, String> aux = mapper.readValue(lista, Map.class);
            if (aux.get("metodo").equals("Guardar")){
                aux.remove("metodo");
                respuesta = gson.fromJson(mapper.writeValueAsString(aux), Avion.class);   
                respuesta.setId(1);
                respuesta.setTipoavion(new TipoAvion(1));
                
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
