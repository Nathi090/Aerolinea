package Aerolinea.model;

import Aerolinea.data.AvionDAO;
import Aerolinea.data.HorarioDAO;
import Aerolinea.data.ReservaDAO;
import Aerolinea.data.RutasDAO;
import Aerolinea.data.TipoAvionDAO;
import Aerolinea.data.TiqueteDAO;
import Aerolinea.data.UsuarioDAO;
import Aerolinea.data.VueloDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Model {

    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }
    
    AvionDAO avion;
    TipoAvionDAO tipo;
    UsuarioDAO usuario;
    RutasDAO rutas;
    HorarioDAO horarios;
    
    private Model(){
        avion = new AvionDAO();
        tipo = new TipoAvionDAO();
        usuario = new UsuarioDAO();
        rutas = new RutasDAO();
        horarios = new HorarioDAO();
        
    }
    
    public List<Avion> aviones() throws SQLException{
        return avion.selectAll();
    }
    
    public List<TipoAvion> tipos() throws SQLException{
        return tipo.selectAll();
    }

    public Usuario existe_usuario(Usuario usu) {
        Usuario usuario_prueba = usuario.select(usu.getUsername());       
        if(usuario_prueba != null && usu.getClave().equals(usuario_prueba.getClave())){
            return usuario_prueba;
        }
        return null;
    }

    public List<Ruta> rutas() {
        return rutas.selectAll();
    }

    public void insertRuta(Ruta ruta) {
        rutas.insert(ruta);
    }
    
    public List<Vuelo> vuelos(){
        return VueloDAO.selectAll();
    }

    public void horario(Horario horario) {
        horarios.insert(horario);
    }

    public void insertAvion(Avion avionn) {
        avion.insert(avionn);
    }

    public void reservar(Reserva reserva, ArrayList<Tiquete> tiquetes) {
        int val = 0;
        ReservaDAO.insert(reserva);
        val = ReservaDAO.selectLastID();
        
        for(int i=0; i< tiquetes.size(); i++){
            tiquetes.get(i).setReserva(new Reserva(val));
            TiqueteDAO.insert(tiquetes.get(i));
        }
    }
    
}
