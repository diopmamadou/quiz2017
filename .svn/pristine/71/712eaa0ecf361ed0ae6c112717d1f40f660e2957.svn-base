<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript">
	function verifmail() {
		var mail = document.getElementById("mail").value;
		if (mail !== "") {
			var regex = /^[a-z0-9._-]+@[a-z0-9._-]+\.[a-z]{2,6}$/;
			if (!regex.test(mail)) {
				document.getElementById("mailverif").innerHTML = "";
				var DOM_img = document.createElement("img");
				DOM_img.src = "resources/icons/glyphicons-200-ban-circle.png";
				document.getElementById("mailverif").appendChild(DOM_img);
				return false;
			} else {
				document.getElementById("mailverif").innerHTML = "";
				var DOM_img = document.createElement("img");
				DOM_img.src = "resources/icons/glyphicons-199-ok-circle.png";
				document.getElementById("mailverif").appendChild(DOM_img);
				return true;
			}
		} else {
			document.getElementById("mailverif").innerHTML = "";
			var DOM_img = document.createElement("img");
			DOM_img.src = "resources/icons/glyphicons-200-ban-circle.png";
			document.getElementById("mailverif").appendChild(DOM_img);
			return false;
		}
	}

	function verifmdp() {
		var prenom = document.getElementById("mdp").value;
		if (prenom !== "") {
			document.getElementById("mdpverif").innerHTML = "";
			var DOM_img = document.createElement("img");
			DOM_img.src = "resources/icons/glyphicons-199-ok-circle.png";
			document.getElementById("mdpverif").appendChild(DOM_img);
			return true;
		} else {
			document.getElementById("mdpverif").innerHTML = "";
			var DOM_img = document.createElement("img");
			DOM_img.src = "resources/icons/glyphicons-200-ban-circle.png";
			document.getElementById("mdpverif").appendChild(DOM_img);
			return false;
		}
	}

	function verifbouton() {
		console.log("verifmail :" + verifmail());
		console.log("verifmdp :" + verifmdp());
		if (verifmail() & verifmdp()) {
			console.log("false");
			document.getElementById("submitbutton").disabled = false;
		} else {
			console.log("true");
			document.getElementById("submitbutton").disabled = true;
		}
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12"></div>
			<br> <br>
			<div class="col-sm-12 form-control">
				<h1>Bienvenue</h1>
				<hr>
				<br>
				<form method="POST" action="Connexion"
					commandName="formulaireConnexion">
					<div class="row">
						<div class="col-sm-6 text-right">
							<label for="mail" class="col-form-label"><img
								src="resources/icons/glyphicons-4-user.png" alt="User">
								Adresse mail :</label> <br>
						</div>
						<div class="col-sm-6 text-left">
							<div class="row">
								<div class="col-sm-5">
									<input type="text" id="mail" name="mail" class="form-control"
										placeholder="nom@domaine.com"
										onkeyup="verifmail();verifbouton();" required />
								</div>
								<label id="mailverif" class="col-form-label"></label>
							</div>
						</div>
						<br> <br> <br>
					</div>
					<div class="row">
						<div class="col-sm-6 text-right">
							<label for="mdp" class="col-form-label"><img
								src="resources/icons/glyphicons-45-keys.png" alt="Key">
								Mot de passe :</label> <br>
						</div>
						<div class="col-sm-6 text-left">
							<div class="row">
								<div class="col-sm-5">
									<input type="password" id="mdp" name="mdp" class="form-control"
										placeholder="Mot de passe" required
										onkeyup="verifmdp();verifbouton();" />
								</div>
								<label id="mdpverif" class="col-form-label"></label>
							</div>
						</div>
						<br> <br> <br>
					</div>
					<div class="col-sm-12 text-center">
						<p>
							<input id="submitbutton" type="submit" class="btn btn-primary"
								value="Connexion" disabled /> ou <a href="inscription">inscription</a>
						</p>
					</div>
				</form>
			</div>
		</div>
		<br>
		<c:if test="${messageErreur != null}">
			<div class="alert alert-danger">
				<strong>Attention !</strong>
				<c:out value="${messageErreur}" />
			</div>
		</c:if>
	</div>
</body>
</html>