<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>Question</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script  type="text/javascript">
var longDateD = '<c:out value="${quiz.dateDebutQuestion.getTime()}"/>';
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
		doSomething();
	} else {
		if (timeLeft>1) {
			elem.innerHTML="Reste : " +timeLeft + " secondes";
		} else {
			elem.innerHTML="Reste : " +timeLeft + " seconde";
		}
	  	timeLeft--;
	}
}

function doSomething(){
	var links = document.getElementsByClassName("proposition");
	for (var i=0; i<links.length;i++) {
		links[i].href = "#";
	}
};
</script>
<script src="resources/bootstrap/js/bootstrap.bundle.js" ></script>
</head>
<body>

<c:set var="numclassement" value="0"></c:set>
<c:set var="nbjoueurs" value="6"></c:set>

<div class="container">
<div class="row justify-content-md-center">
<h2>QUESTION N°<c:out value="${question.idQuestion}"/></h2>
</div>
<hr>
<div class="row justify-content-md-center">
<c:if test="${quiz.etape == '3'}">
Classement : <c:out value="${numclassement}"/> / <c:out value="${nbjoueurs}"/> joueurs
</c:if>
</div>
<div class="row justify-content-md-center">
<label id="label_timer">Reste : </label>
</div>
<c:if test="${!empty question}">
<div class="row justify-content-md-center">
<div class="col col-lg-6 text-center">
 <table class="table table-bordered table-sm">
  <thead class="thead-light">
    <tr>
      <th scope="col"><c:out value="${question.libelle}"/></th>
      <c:if  test="${quiz.etape == '2' }">
      <th scope="col">%</th>
      </c:if>
      <c:if  test="${quiz.etape == '3'}">
      	<th scope="col">Réponse</th>
      </c:if>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${question.propositions}" var="proposition">
    <tr>
      <td>
      	<c:choose>
		    <c:when test="${quiz.etape == '1' }">
	      		<a class="proposition" href="repondre?idQuestion=<c:out value='${question.idQuestion}'/>&idReponse=<c:out value='${proposition.idProposition }'/>">
		      	  <c:out value="${proposition.libelle}"/>
		      	</a>
	    	</c:when>
		    <c:otherwise>
	    		<c:out value="${proposition.libelle}"/>
	    	</c:otherwise>
	      </c:choose>
      </td>
      <c:if  test="${quiz.etape == '2' }">
      <td>
      	<c:out value="${'0'}"/>
      </td>
      </c:if>
      <c:if  test="${quiz.etape == '3' }">
	      <c:choose>
		      <c:when test="${proposition.bonneReponse==true }">
		      	<td bgcolor="green"></td>
		      </c:when>
		      <c:otherwise>
		      	<td bgcolor="red"></td>
		      </c:otherwise>
	      </c:choose>
      </c:if>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</div>

<c:if test="${quiz.etape == '3'}">
<div class="row justify-content-md-center">
<h2>RESULTAT</h2>
</div>
<hr>
<div class="row justify-content-md-center">
<div class="col col-lg-6 text-center">
 <table class="table table-bordered table-sm">
  <thead class="thead-light">
    <tr>
      <th scope="col">N°</th>
      <th scope="col">Participant</th>
      <th scope="col">Score</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${ranking}" var="utilisateur">
	 <tr>
	  <td><c:out value="1"/></td>
	  <td><c:out value="${utilisateur.participant}"/></td>
	  <td><c:out value="${utilisateur.score}"/></td>
	 </tr>
	</c:forEach>
  </tbody>
</table>
</div>
</div>
</c:if>
</c:if>

</div>
</body>
</html>