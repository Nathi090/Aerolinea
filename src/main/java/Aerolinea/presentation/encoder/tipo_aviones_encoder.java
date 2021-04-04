/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation.encoder;

import Aerolinea.model.Model;
import Aerolinea.model.TipoAvion;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author nati2
 */
public class tipo_aviones_encoder implements Encoder.Text<List<TipoAvion>>{

    private static Gson gson = new Gson();

    @Override
    public String encode(List<TipoAvion> tipos) throws EncodeException {
        
        return gson.toJson(tipos);
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

