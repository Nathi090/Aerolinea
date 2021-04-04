
import Aerolinea.model.Avion;
import Aerolinea.model.Model;
import Aerolinea.model.TipoAvion;
import Aerolinea.presentation.decoder.tipo_aviones_decoder;
import Aerolinea.presentation.encoder.tipo_aviones_encoder;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/tipo_aviones", 
  encoders = tipo_aviones_encoder.class,
  decoders = tipo_aviones_decoder.class)

public class tipo_aviones_WS {
//    private static Set<tipo_aviones_WS> TAWS 
//      = new CopyOnWriteArraySet<>();
    
    @OnOpen
    public void onOpen(Session session) throws IOException {
       
    }

    @OnMessage
    public List<TipoAvion> onMessage(Session session, List<TipoAvion> msg) throws IOException, SQLException, EncodeException {
        Aerolinea.model.Model model = Model.instance();
        TipoAvion tipos = (TipoAvion) model.tipos();
        System.out.println(tipos.toString());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
         try {
            session.getBasicRemote().sendObject(tipos);
            System.out.println("sent ");
        } catch (Exception ex) {
             System.out.println(ex);
        }
        return model.tipos();
    }

    @OnClose
    public void onClose(Session session) throws IOException {
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }
}