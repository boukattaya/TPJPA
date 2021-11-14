package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Emproduit;
import dao.Iproduit;
import metier.Produit;


@WebServlet("/index.php")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	Iproduit metier=new Emproduit();    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			                                  throws ServletException, IOException 
	{
		List<Produit>liste=null;
		String action=request.getParameter("action");
		
		//all produit
		if(action==null)
		{
			liste=metier.Allproduit();
		}
		else  if(action.equals("supprimer"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			metier.delete(id);
			liste=metier.Allproduit();
			
		}
		
		request.setAttribute("liste", liste);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	     }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			                         throws ServletException, IOException 
	{
		List<Produit>liste=null;
	
		String action=request.getParameter("action");
              if (action.equals("rechercher"))
			{
	          String mc=request.getParameter("mc");
	           liste=metier.Getproduitpmc(mc);
	           
			}
              else if(action.equals("ajouter"))
              {
            	  String nom=request.getParameter("nom");
            	  Double prix=(Double.parseDouble(request.getParameter("prix")));
            	  Produit p=new Produit(nom,prix);
            	  metier.Addproduit(p);
            	  liste=metier.Allproduit(); 
            	  
              }  
            	  request.setAttribute("liste", liste);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		 
	}
	

}
