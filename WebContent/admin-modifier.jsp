<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="UTF-8">
<title>admin-modifier</title>
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


<!-- ajouter un livre -->

<section class="vh-100" style="background-color: #eee;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-8 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">entrez les informations du livre</p>
                
				<%String id_livre = request.getParameter("id_livre");
				request.setAttribute("id_livre", id_livre);%>
				
				
                <form class="mx-1 mx-md-4" action="/e-book/adminmodifierInfoLivre.do?id_livre=${id_livre }" method="post">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example3c">le titre du livre :</label>
                      <input type="text" id="form3Example3c" class="form-control"  name="titre"/>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">description :</label>
                      <textarea type="text" id="form3Example4c" class="form-control" name="description"></textarea>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">quantité :</label>
                      <input type="text" id="form3Example4c" class="form-control" name="quantite"/>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">La date de publication (l'année d'apparition du livre) :</label>
                      <input type="input" id="form3Example4c" class="form-control" name="year"/>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">édition :</label>
                      <input type="input" id="form3Example4c" class="form-control" name="edition"/>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">language :</label>
                      <input type="text" id="form3Example4c" class="form-control" name="langue"/>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">nombre de pages :</label>
                      <input type="number" id="form3Example4c" class="form-control" name="pages"/>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">ISBN :</label>
                      <input type="text" id="form3Example4c" class="form-control" name="isbn"/>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">catégorie :</label>
                      <input type="text" id="form3Example4c" class="form-control" name="categorie"/>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">auteur :</label>
                      <input type="text" id="form3Example4c" class="form-control" name="auteur"/>
                    </div>
                  </div>                  
				
                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-lg">ajouter</button>
                  </div>
                  

                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>