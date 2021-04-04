package Aerolinea.model;

import Aerolinea.data.AvionDAO;
import Aerolinea.data.TipoAvionDAO;
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
    
    private Model(){
        avion = new AvionDAO();
        tipo = new TipoAvionDAO();

        
    }
    
    public List<Avion> aviones() throws SQLException{
        return avion.selectAll();
    }
    
    public List<TipoAvion> tipos() throws SQLException{
        return tipo.selectAll();
    }
    
}
