package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class Emproduit implements Iproduit {

	@Override
	public List<Produit> Allproduit()
	{
		List<Produit>L=new ArrayList<>();
		Connection Cnx=SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps=Cnx.prepareStatement("select * from produits" );
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Produit P=new Produit();
				P.setId(rs.getInt(1));
				P.setNom(rs.getString(2));
				P.setPrix(rs.getDouble(3));
				L.add(P);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return L;
	}

	@Override
	public List<Produit> Getproduitpmc(String mc)
	{
		List<Produit>Lprod=new ArrayList<>();
		Connection cnx;
		cnx=SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps=cnx.prepareStatement("select * from produits where nom_PRODUIT like ?");
			ps.setString(1,"%"+mc+"%");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Produit P=new Produit();
				P.setId(rs.getInt(1));//P.setId(rs.getInt("ID_PRODUIT"));
				P.setNom(rs.getString(2));
				P.setPrix(rs.getDouble(3));
				Lprod.add(P);
			}
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return Lprod;
	}

	@Override
	public void Addproduit(Produit P) 
	{
		Connection cnx;
		cnx=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=cnx.prepareStatement("insert into produits(nom_PRODUIT,prix) value(?,?)");
			ps.setString(1,P.getNom());
			ps.setDouble(2,P.getPrix());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}
		
	}

	@Override
	public void delete(int id)
	{
		Connection cnx;
		cnx=SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps=cnx.prepareStatement("delete from produits where ID_PRODUIT like ?" );
		    ps.setInt(1,id);
		    ps.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
	}
		
		
	}

	
	


