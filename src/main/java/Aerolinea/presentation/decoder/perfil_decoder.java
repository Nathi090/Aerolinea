/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation.decoder;

import Aerolinea.model.Avion;
import Aerolinea.model.Ruta;
import Aerolinea.model.TipoAvion;
import Aerolinea.model.Usuario;
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
public class perfil_decoder implements Decoder.Text<Usuario> {

    @Override
    public Usuario decode(String s) throws DecodeException {
        Gson gson = new Gson();
        Usuario respuesta = new Usuario("0");
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
