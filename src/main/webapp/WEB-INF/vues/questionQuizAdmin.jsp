<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CREER UN NOUVEAU QUIZZ</title>
</head>
<body>
<div class="container">
<h2 class="text-center">CREER UN NOUVEAU QUIZ</h2>
<hr/>
<form method="GET" action="creerQuiz" commandName="formulaireCreationQuiz">
<div class="form-group row"> 
<label class="col-2 col-form-label" for="libelle">Libellé : </label> 
<div class="col-6">
<input type ="text" class="form-control" placeholder="JEE,Android,etc." id="libelle"> 
</div>
</div>
<br>
<a href="<c:url value="ajouterQuestion?"/>"><button type="button" class="btn btn-primary">AJOUTER UNE QUESTION</button></a>

<br>
<br>
<div class="row justify-content-md-center">
<div class="col col-lg-8 text-center">
<table class="table table-striped">
<thead class="thead-light">
<tr>
<th>Cocher</th>
<th>Question</th>
<th>Supprimer</th>
<th>Editer</th>
</tr>
</thead>
<tbody>
<c:forEach items="${questions}" var="question">
<tr> 
<td><div class="row">
	<div class="col-lg-6">
	<div class="input-group">
	<span class="input-group-addon">
	<input type="checkbox" class="form-check-input">
	</span>
	</div>
	</div>
	</div>
</td>
<td scope="row"><c:out value="${question.libelle}"/></td>

<td><a href="<c:url value="supprimerQuestion?idQuestion=${question.idQuestion}"/>"><img src="resources/icons/glyphicons-208-remove.png" alt="Remove"></a></td>
<td><a href="<c:url value="editerQuestion?idQuestion=${question.idQuestion}"/>"></a><img src="resources/icons/glyphicons-151-edit.png" alt="Edit"></a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div> 
<button type="submit" class="btn btn-primary" value="creerQuiz">CREER</button>
<a href="<c:url value="/"/>"><button type="reset" class="btn btn-primary">ANNULER</button></a>
</form> 

<br>
</div>
</body>
</html> 

