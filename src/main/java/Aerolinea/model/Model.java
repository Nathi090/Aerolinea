package Aerolinea.model;

import Aerolinea.data.AvionDAO;
import Aerolinea.data.TipoAvionDAO;
import Aerolinea.data.UsuarioDAO;
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
    
    private Model(){
        avion = new AvionDAO();
        tipo = new TipoAvionDAO();
        usuario = new UsuarioDAO();

        
    }
    
    public List<Avion> aviones() throws SQLException{
        return avion.selectAll();
    }
    
    public List<TipoAvion> tipos() throws SQLException{
        return tipo.selectAll();
    }

    public Boolean existe_usuario(Usuario usu) {
        Usuario usuario_prueba = usuario.select(usu.getUsername());       
        return  usuario_prueba != null && usu.getClave().equals(usuario_prueba.getClave());
    }
    
}
