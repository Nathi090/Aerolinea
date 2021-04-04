/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.presentation.decoder;

import Aerolinea.model.TipoAvion;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author nati2
 */
public class tipo_aviones_decoder  implements Decoder.Text<List<TipoAvion>> {

    @Override
    public List<TipoAvion> decode(String s) throws DecodeException {
        return new ArrayList<TipoAvion>();
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
