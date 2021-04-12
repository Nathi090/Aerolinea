/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation.encoder;

import Aerolinea.model.Avion;
import Aerolinea.model.Usuario;
import com.google.gson.Gson;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author nati2
 */
public class usuario_encoder implements Encoder.Text<Boolean>{

    private static Gson gson = new Gson();

    @Override
    public String encode(Boolean respuesta) throws EncodeException {
        return gson.toJson(respuesta);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
    
}
