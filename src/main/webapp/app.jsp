<%@ page pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App</title>
</head>
<body>
	<div >
		<form method="post" action="app?form=Addform" class="d-flex flex-column  ">
			<input class="form-control "  type="text" placeholder="Nom" name="nom" id="nom"/>
			<input class="form-control" type="date" placeholder="Date de debut" name="datedebut" id="datedebut"/>
			<input class="form-control" type="date" placeholder="Date de fin" name="datefin" id="datefin"/>
			<select name="tag" id="tag" class="form-control">
				<option>Facile</option>
				<option>Moyen</option>
				<option>Difficile</option>				
			</select>
			<textarea class="form-control" placeholder="Ecrire une tache" rows="5" cols="30" name="tache" id="tache"></textarea>
			<button class="btn btn-primary bg-danger" type="reset">Annuler</button>
			<button class="btn btn-primary bg-success" type="submit">Ajouter</button>
		</form>
	</div>
	<div>
		<%@ include file="ListeDeTaches.jsp" %>
	</div>
</body>
</html>