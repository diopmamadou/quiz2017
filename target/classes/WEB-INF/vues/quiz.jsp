<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Quiz</title>
		<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.bundle.js" ></script>
	</head>
	<!-- Nom des variables requises :
			Personne : personne
			Liste des quiz : listeQuiz
			
		Methodes utilisés sur les boutons :
			jouerQuiz
			resultatQuiz
			lancerQuiz
			editerQuiz
			supprimerQuiz
			questionQuizAdmin

		-->
	<body> 
	
	<c:set var = "isAdmin" scope = "page" value ="${personne.droits}"/>
	
	<div class="container">
		<h2 class="text-center">CONSULTEZ LES QUIZ</h2>	
		<hr/>
		<br/>
			 <div class="row justify-content-md-center">
				<div class="col col-lg-6 text-center">
					<table class="table table-bordered table-sm">
						<thead class="thead-light">
							<tr>
								<th>Libellé</th>
								<th>Questions</th>
								<th>Date</th> 
								<c:choose>
									<c:when test="${isAdmin == 10}">
											<th>Jouer</th>
											<th>Résultat</th>
											
									</c:when>
									<c:when test="${isAdmin == 1000}">
										<th>(Re)Lancer</th>
										<th>Editer</th>
										<th>Supprimer</th>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listeQuiz}" var="quiz">
					   		 <tr>
					          <th class="align-middle" scope="row" ><c:out value="${quiz.libelle}"/></th>
						      <td class="align-middle"><c:out value="${fn:length(quiz.questions)}"/></td>
						      <jsp:useBean id="dateValue" class="java.util.Date"/>
							  <jsp:setProperty name="dateValue" property="time" value="${quiz.dateDebutQuestion.getTime()}"/>
						      <td class="align-middle" ><fmt:formatDate value="${dateValue}" pattern="MM/dd/yyyy HH:mm"/></td>
						      <c:choose>
									<c:when test="${isAdmin == 10}">
									      <td class="align-middle">
									      	<c:if test="${quiz.etat == 10}">
									      	<a href="<c:url value="jouerQuiz?id=${quiz.idQuiz}"/>"><img src="resources/icons/glyphicons-174-play.png" alt="Jouer"></a>
									      	</c:if>
									      </td>
									      <td class="align-middle">
									      	<c:if test="${quiz.etat > 10}">
									      	<a href="<c:url value="resultatQuiz?id=${quiz.idQuiz}"/>"><img src="resources/icons/glyphicons-42-charts.png" alt="Résultat"></a>
									      	</c:if>
									      </td>
							      </c:when>
							      <c:when test="${isAdmin == 1000}">
							      		  <td class="align-middle">
								      		  <c:if test="${quiz.etat != 10 }">
											  <a href="<c:url value="lancerQuiz?id=${quiz.idQuiz}"/>"><img src="resources/icons/glyphicons-174-play.png" alt="Lancer"></a>
											  </c:if>
										  </td>
									      <td class="align-middle">
										      <c:if test="${quiz.etat != 10}">
										      <a href="<c:url value="editerQuiz?id=${quiz.idQuiz}"/>"><img src="resources/icons/glyphicons-31-pencil.png" alt="Editer"></a>
										      </c:if>
									      </td>
									      <td class="align-middle">
										      <c:if test="${quiz.etat != 10 }">
										      <a href="<c:url value="supprimerQuiz?id=${quiz.idQuiz}"/>"><img src="resources/icons/glyphicons-200-ban-circle.png" alt="Suprimer"></a>
										      </c:if>
									      </td>
								    </c:when>
									<c:otherwise>
							      	</c:otherwise>
								</c:choose>
							</tr>
							</c:forEach>
							</tbody>
				   	</table> 
				   	<c:if test="${isAdmin == 1000}">
				   	<div class="row justify-content-md-center">
				   		<a href="<c:url value="questionQuizAdmin"/>"><button class = "btn btn-primary" value="" type="button" >Ajouter un quiz</button></a> 
				   	</div>
				   	</c:if>
		   	 	</div>
		   	</div>
	   </div>
	</body>
</html>