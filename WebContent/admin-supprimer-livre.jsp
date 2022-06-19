<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="UTF-8">
<title>admin</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-info">
  <div class="container-fluid">
    <a class="navbar-brand " href="#">E-BOOK</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/e-book/adminAjouterLivre.do">ajouter un livre</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/e-book/admin-supprimer-livre.do">supprimer un livre</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/e-book/admin-supprimer-utilisateur.do">supprimer un compte utilisateur</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/e-book/admin-supprimer-reservation.do">annuler la réservation d'un livre</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<br>
 
<!-- liste des utilisateur -->
<div class="container">
<table class="table">
  <thead>
    <tr>
      <th scope="col">le titre du livre</th>
      <th scope="col">nombre de pages</th>
      <th scope="col">ISBN</th>
      <th scope="col">modifier le livre</th>
      <th scope="col">supprimer le livre</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${livres }" var="livre">
    <tr>
      <th scope="row">${livre.nom }</th>
      <td>${livre.pages }</td>
      <td>${livre.isbn }</td>
      <td><a href="/e-book/modifier-livre.do?id_livre=${livre.id }" type="button" class="btn btn-outline-info">modifier ce livre</a></td>
      <td><a href="/e-book/supprimerLivre.do?id_livre=${livre.id }" type="button" class="btn btn-outline-danger">supprimer ce livre</a></td>
    </tr>
  </c:forEach>

    
  </tbody>
</table>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>