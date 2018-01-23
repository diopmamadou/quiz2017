<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Ajouter Personne</title>
 	<link href="resources/styles.css" rel="stylesheet" type="text/css">
 </head>
 <body>
  <h2>Ajouter une personne</h2>
  
  <a href="afficherPersonnes">Afficher la liste</a>
  <!-- commandName deviendra l'id du formulaire -->
  <form:form method="POST" action="ajouterPersonne.do" commandName="monFormulaire">
      <table>
       <tr><th></th><th></th></tr>
       <tr>
      		<%-- génère un label avec un for="nom"  --%>
           <td><form:label path="nom" >Nom :</form:label></td>
           <%-- génère un input avec id="nom", name="nom" et value=le nom de la personne reçue via le modèle --%>
           <td><form:input path="nom" /></td>
       </tr>
     <tr>
           <td><form:label path="prenom" >Prénom :</form:label></td>
           <td><form:input path="prenom" /></td>
       </tr>
          <tr>
         <td colspan="2" class="submit"><input type="submit" value="Ajouter"/></td>
        </tr>
   </table> 
  </form:form>
  
  
 </body>
</html>