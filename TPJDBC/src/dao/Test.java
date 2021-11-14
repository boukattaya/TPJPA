package dao;

import java.sql.Connection;

import metier.Produit;

public class Test {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Connection cnx;
		//cnx=SingletonConnection.getConnection();
		//if(cnx!=null)
			//System.out.println("ok");
		Emproduit metier=new Emproduit();
		System.out.println(metier.Getproduitpmc("pc"));
		System.out.println(metier.Allproduit());
		Produit P=new Produit("radio",150);
		metier.Addproduit(P);
		System.out.println(metier.Allproduit());
		metier.delete(3);
		System.out.println(metier.Allproduit());
		

	}

}
