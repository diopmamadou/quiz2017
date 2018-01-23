<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>Animateur</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script  type="text/javascript">
var longDateD = '<c:out value="${quiz.dateDebutQuestion.sysUpTime}"/>';
var longDateDebut = Date.now();
var dat1 =  (longDateDebut - longDateD)/1000;
var timeLeft = Math.round(30 - dat1);
var elem;
var timerId;

window.onload = function() {
	elem = document.getElementById("label_timer");
	
	timerId = setInterval(countdown, 1000);
}

function countdown() {
	if (timeLeft == 0) {
	  	clearTimeout(timerId);
		elem.innerHTML="Reste : 0 seconde";
	} else {
		if (timeLeft>1) {
			elem.innerHTML="Reste : " +timeLeft + " secondes";
		} else {
			elem.innerHTML="Reste : " +timeLeft + " seconde";
		}
	  	timeLeft--;
	}
}

</script>
<script src="resources/bootstrap/js/bootstrap.bundle.js" ></script>

</head>
<body>

<div class="container">
<c:if test="${!empty question}">
<div class="row justify-content-md-center">
	<a class="btn btn-primary" href="statistiques" role="button">Statistiques</a> 
	<a class="btn btn-primary" href="bonneReponse" role="button">Bonne réponse</a> 
	<a class="btn btn-primary" href="questionSuivante?id=<c:out value='${question.idQuestion}'/>" role="button">Question suivante</a> 
</div>

<div class="row justify-content-md-center">
	<h2>QUESTION N°<c:out value="${question.idQuestion}"/></h2>
</div>
<hr>
<div class="row justify-content-md-center">
<div class="col col-lg-6 text-center">
<label id="label_timer" >Reste : </label>

 <table class="table table-bordered table-sm">
  <thead class="thead-light">
    <tr>
      <th scope="col"><c:out value="${question.libelle}"/></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${question.propositions}" var="proposition">
    <tr>
      <td>
      	<c:out value="${proposition.libelle}"/>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>

</div>
</div>
</c:if>
</div>
</body>
</html>