<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>


	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">NOM</th>
				<th scope="col">DATE DE DEBUT</th>
				<th scope="col">DATE DE FIN</th>
				<th scope="col">TAG</th>
				<th scope="col">TACHE</th>
				<th scope="col">OPERATIONS</th>

			</tr>
		</thead>
		<tbody>

		

			<c:forEach var="tache" items="${ taches }">
				<tr>
					<th scope="row"><c:out value="${ tache.id}" /></th>
					<td><c:out value="${tache.nomcomplet }" /></td>
					<td><c:out value="${ tache.datedebut }" /></td>
					<td><c:out value="${tache.datefin }" /></td>
					<td><c:out value="${tache.tag}" /></td>
					<td><c:out value="${tache.tache }" /></td>
					<td>
						<!--  <a href="app?id=${tache.id}&opr=supprimer">Supprimer La Tache </a> -->
						<button class="btn btn-danger" onclick="onDeleteClick(${tache.id},event)" type="button" >
								Supprimer la tache
						</button> 
						<!-- Button trigger modal -->
						<button class="btn btn-primary" onclick="onEditClick(${tache.id},event)" type="button" >
								Editer la tache
						</button> 
						</td>
				</tr>
			</c:forEach>
			
		</tbody>
		<c:if test="${not empty EditTache.nomcomplet}" >Inconnu
		<div id="modal"   style="position:fixed; z-index:1; left:0; top:0; width:100%;height:100%; overflow:auto; background-color:rgb(0,0,0); background-color:rgb(0,0,0,0.4); "  tabindex="-1"   >
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle">Editer Votre Tache</h5>
										<button type="button" class="close" data-dismiss="modal"aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									<form method="post" action="app?form=Editform&id=${EditTache.id}" >
										<input id="Enom" name="Enom" class="form-control" type="text" value="${EditTache.nomcomplet }">
										<input id="Edatedebut" name="Edatedebut" class="form-control" type="date" value="${EditTache.datedebut}" />
										<input id="Edatefin" name="Edatefin" class="form-control" type="date" value="${EditTache.datefin}" />
										<select name="Etag" id="Etag" class="form-control">
											<option <c:if test="${EditTache.tag == 'Facile'}" >selected</c:if>>Facile</option>
											<option <c:if test="${EditTache.tag == 'Moyen'}" >selected</c:if>>Moyen</option>
											<option <c:if test="${EditTache.tag == 'Difficile'}" >selected</c:if>>Difficile</option>				
										</select>
										<textarea id="Etache" name="Etache" class="form-control"  rows="5" cols="30" >${EditTache.tache}</textarea>
										<div class="modal-footer">
											<button type="reset" class="btn btn-secondary"data-dismiss="modal">Cancel</button>
											<button type="submit" class="btn btn-success">Enregistrer les changements</button>
										</div>
									</form>
									</div>
									
								</div>
							</div>
						</div>
						</c:if>
	</table>
<script>
function onEditClick(id,event){
	window.location.href = "app?id="+id+"&opr=chercher";
	event.preventDefault();     
}
function onDeleteClick(id,event){
	window.location.href = "app?id="+id+"&opr=supprimer";
	event.preventDefault();     
}

</script>

</body>
</html>
