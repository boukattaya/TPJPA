package dao;

import java.util.List;

import metier.Produit;

public interface Iproduit 
{
	List<Produit>Allproduit();
	List<Produit>Getproduitpmc(String mc);
	void Addproduit(Produit P);
	void delete(int id);
	
}
