package com.gt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gt.beans.Tache;

public class TacheDaoImpl implements TacheDao {
	private DaoFactory daoFactory;

	public TacheDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void ajouter(Tache tache) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO Taches(nom,datedebut,datefin,tag,tache) VALUES(?,?,?,?,?);");
			preparedStatement.setString(1, tache.getNomcomplet());
			preparedStatement.setDate(2, (Date) tache.getDatedebut());
			preparedStatement.setDate(3,(Date) tache.getDatefin());
			preparedStatement.setString(4, tache.getTag());
			preparedStatement.setString(5, tache.getTache());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimer(int id) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("DELETE FROM taches WHERE id = ? ;");
			preparedStatement.setInt(1, id);
			

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Tache tache) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

        try  {
        	connexion = daoFactory.getConnection();
            String sql = "UPDATE taches SET nom = ?, datedebut = ?, datefin = ? , tag = ?, tache = ? WHERE id = ?";
            
            preparedStatement = connexion.prepareStatement(sql);
            preparedStatement.setString(1, tache.getNomcomplet());
            preparedStatement.setDate(2, tache.getDatedebut());
            preparedStatement.setDate(3, tache.getDatefin());
            preparedStatement.setString(4, tache.getTag());
            preparedStatement.setString(5, tache.getTache());
            preparedStatement.setInt(6, tache.getId());
            
            preparedStatement.executeUpdate();
            
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public Tache chercher(int id) {
		
		Tache tache = null ;
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
       

        try {
        	connection = daoFactory.getConnection();
            String sql = "SELECT * FROM taches WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultat = preparedStatement.executeQuery();

            if (resultat.next()) {
                // Retrieve data from the result set and create a Record object
            	int Id = resultat.getInt("id"); 
            	
                String nom = resultat.getString("nom");
                Date datedebut = resultat.getDate("datedebut");
                Date datefin = resultat.getDate("datefin");
                String tag = resultat.getString("tag");
                String tacheInfo = resultat.getString("tache");
                // ... Retrieve other columns as needed

                tache = new Tache(id,nom,datedebut,datefin,tag,tacheInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultat != null) resultat.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return tache;
	}

	@Override
	public List<Tache> lister() {
		 List<Tache> taches = new ArrayList<Tache>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT id,nom,datedebut,datefin,tag,tache  FROM taches ;");

	            while (resultat.next()) {
	            	int id = resultat.getInt("id"); 
	            	
	                String nom = resultat.getString("nom");
	                Date datedebut = resultat.getDate("datedebut");
	                Date datefin = resultat.getDate("datefin");
	                String tag = resultat.getString("tag");
	                String tacheInfo = resultat.getString("tache");

	               Tache tache = new Tache(id,nom,datedebut,datefin,tag,tacheInfo);
	               taches.add(tache);
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       
	        return taches;
	}

}
