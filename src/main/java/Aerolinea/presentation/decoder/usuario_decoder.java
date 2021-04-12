/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation.decoder;

import Aerolinea.model.Avion;
import Aerolinea.model.Usuario;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author nati2
 */
public class usuario_decoder implements Decoder.Text<Usuario> {

    private static Gson gson = new Gson();
    
    @Override
    public Usuario decode(String s) throws DecodeException {
        return gson.fromJson(s, Usuario.class);
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
