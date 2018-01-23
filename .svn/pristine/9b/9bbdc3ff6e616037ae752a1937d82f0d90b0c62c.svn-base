<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>Afficher Personnes</title>
<link href="resources/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Liste personnes</h2><br>

<a href="ajouterPersonne">Ajouter une personne</a>


<c:if test="${!empty personnes}">
 <table>
  <tr>
   <th>id</th>
   <th>nom</th>
   <th>prénom</th>
   </tr>

  <c:forEach items="${personnes}" var="personne">
   <tr>
    <td><c:out value="${personne.id}"/></td>
    <td><c:out value="${personne.nom}"/></td>
    <td><c:out value="${personne.prenom}"/></td>
    </tr>
  </c:forEach>
 </table>
</c:if>



</body>
</html>