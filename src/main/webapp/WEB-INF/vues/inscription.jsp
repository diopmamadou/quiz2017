<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">

<script type="text/javascript">
	function verifmdp() {
		var mdp = document.getElementById("mdp").value, mdp2 = document
				.getElementById("repassword").value;
		if (mdp !== "" | mdp2 !== "") {
			if (mdp !== mdp2) {
				document.getElementById("mdpverif").innerHTML = "";
				var DOM_img = document.createElement("img");
				DOM_img.src = "resources/icons/glyphicons-200-ban-circle.png";
				document.getElementById("mdpverif").appendChild(DOM_img);
				return false;
			}
			if (mdp === mdp2) {
				document.getElementById("mdpverif").innerHTML = "";
				var DOM_img = document.createElement("img");
				DOM_img.src = "resources/icons/glyphicons-199-ok-circle.png";
				document.getElementById("mdpverif").appendChild(DOM_img);
				return true;
			}
		} else {
			document.getElementById("mdpverif").innerHTML = "";
			var DOM_img = document.createElement("img");
			DOM_img.src = "resources/icons/glyphicons-200-ban-circle.png";
			document.getElementById("mdpverif").appendChild(DOM_img);
			return false;
		}
	}

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

	function verifnom() {
		var nom = document.getElementById("nom").value;
		if (nom !== "") {
			document.getElementById("nomverif").innerHTML = "";
			var DOM_img = document.createElement("img");
			DOM_img.src = "resources/icons/glyphicons-199-ok-circle.png";
			document.getElementById("nomverif").appendChild(DOM_img);
			return true;
		} else {
			document.getElementById("nomverif").innerHTML = "";
			var DOM_img = document.createElement("img");
			DOM_img.src = "resources/icons/glyphicons-200-ban-circle.png";
			document.getElementById("nomverif").appendChild(DOM_img);
			return false;
		}
	}
	function verifprenom() {
		var prenom = document.getElementById("prenom").value;
		if (prenom !== "") {
			document.getElementById("prenomverif").innerHTML = "";
			var DOM_img = document.createElement("img");
			DOM_img.src = "resources/icons/glyphicons-199-ok-circle.png";
			document.getElementById("prenomverif").appendChild(DOM_img);
			return true;
		} else {
			document.getElementById("prenomverif").innerHTML = "";
			var DOM_img = document.createElement("img");
			DOM_img.src = "resources/icons/glyphicons-200-ban-circle.png";
			document.getElementById("prenomverif").appendChild(DOM_img);
			return false;
		}
	}

	function verifbouton() {
		console.log("verifprenom :" + verifprenom());
		console.log("verifnom :" + verifnom());
		console.log("verifmail :" + verifmail());
		console.log("verifmdp :" + verifmdp());
		if (verifprenom() & verifnom() & verifmail() & verifmdp()) {
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
				<h1>Inscription</h1>
				<hr>
				<br>
				<form method="POST" action="Inscription"
					commandName="formulaireInscription">
					<div class="row">
						<div class="col-sm-6 text-right">
							<label for="mail" class="col-form-label"><img
								src="resources/icons/glyphicons-4-user.png" alt="User">
								Adresse mail :</label>
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
							<br><br>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 text-right">
							<label for="mdp" class="col-form-label"><img
								src="resources/icons/glyphicons-45-keys.png" alt="Key">
								Mot de passe :</label>
						</div>
						<div class="col-sm-6 text-left">
							<div class="row">
								<div class="col-sm-5">
									<input type="password" id="mdp" name="mdp" class="form-control"
										placeholder="Mot de passe" required
										onkeyup="verifmdp();verifbouton();" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6"></div>
						<div class="col-sm-6 text-left">
							<div class="row">
								<div class="col-sm-5">
									<input type="password" id="repassword" class="form-control"
										placeholder="Confirmer mot de passe" required
										onkeyup="verifmdp();verifbouton();" />
								</div>
								<label id="mdpverif" class="col-form-label"></label>
							</div>
						</div>
						<br> <br><br>
					</div>
					<div class="row">
						<div class="col-sm-6 text-right">
							<label for="nom" class="col-form-label"> Nom :</label>
						</div>
						<div class="col-sm-6 text-left">
							<div class="row">
								<div class="col-sm-5">
									<input type="text" id="nom" name="nom" placeholder="Nom"
										class="form-control" required
										onkeyup="verifnom();verifbouton();" />
								</div>
								<label id="nomverif" class="col-form-label"></label>
							</div>
						</div>
						<br> <br> <br>
					</div>
					<div class="row">
						<div class="col-sm-6 text-right">
							<label for="prenom" class="col-form-label"> Prénom :</label>
						</div>
						<div class="col-sm-6 text-left">
							<div class="row">
								<div class="col-sm-5">
									<input type="text" id="prenom" name="prenom"
										placeholder="Prénom" class="form-control" required
										onkeyup="verifnom();verifbouton();" />
								</div>
								<label id="prenomverif" class="col-form-label"></label>
							</div>
						</div>
						<br> <br> <br>
					</div>
					<div class="row">
						<div class="col-sm-12 text-center">
							<p>
								<input id="submitbutton" type="submit" class="btn btn-primary"
									value="Inscription" disabled /> ou <a href="index"> <input
									type="button" class="btn btn-primary" value="Annuler" />
								</a>
							</p>
						</div>
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