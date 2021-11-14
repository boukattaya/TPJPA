<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Produit</title>
 
 <link  href = "bootstrap.min.css"  rel = " stylesheet " >
</head>
<body>
<p></p>
<div class="container">
   <div class="card">
       <div class="card-header">
             Recherche des Produits
       </div>

              <form action="index.php" method="post">
                  <div class="card-body">
                   <label class="col-md-2">Mot cle</label>
                   <input type="text" name="mc">
                   <input type="submit" name="action" value="rechercher"class="btn btn-primary">
                </form>
                </div>
           
           <table class="table table-striped" style="width:1000px">
                <tr>
                <th>id</th><th>Nom</th><th>Quantite</th><th>Action</th>
                </tr>
             <c:forEach items="${liste}" var="p" >
               <tr>
                   <td>${p.id}</td>
                   <td>${p.nom}</td>
                   <td>${p.prix}</td>
                  <td><a href="index.php?action=supprimer&id=${p.id}"class="btn btn-danger">Supprimer</a></td>
                </tr>
              </c:forEach>
        </table>
<br>
<div class="card">
                <div class="card-header">
                      Ajouter un produit
               </div>
               <form action="index.php" method="post">
                   <div class="form-group">
                       <label class="form-label">nom :</label>
                        <input type="text" name="nom" class="form-control car"><br>
                         <label class="form-label">prix :</label>
                        <input type="number" name="prix" class="form-control car"><br>
                      <input type="submit" name="action" value="ajouter"class="btn btn-success">
              </form>
                  </div>
</div>
</div>
</div>
</body>
</html>