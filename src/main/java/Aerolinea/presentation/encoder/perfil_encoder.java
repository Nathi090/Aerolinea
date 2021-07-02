/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation.encoder;

import Aerolinea.model.Avion;
import Aerolinea.model.TipoAvion;
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
public class perfil_encoder implements Encoder.Text<Usuario>{

    private static Gson gson = new Gson();

    @Override
    public String encode(Usuario user) throws EncodeException {
        
        return gson.toJson(user);
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
