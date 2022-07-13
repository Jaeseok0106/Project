<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<title>Home</title>
</head>
<style>
#main {
font-size:75px;
}
.carousel-item, .carousel-inner {
height:568px;
}
.nav-item{
list-style-type:none;
float:left;
font-size: 55px;
}
.nav-link {
    font-weight: 600;
    color: #000000;
    padding: 0 0.3125rem;
    font-size: 20px;
    font-size: 1.25rem;
  }
 #detail {
 	font-size: 0.7rem;
 }
</style>
<body>
<div class="container">
<header class="blog-header py-3" style = "height : 230px;">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="text-center">
        <a class="blog-header-logo text-dark" href="#"><p id = main>Gallary name</p></a>
      </div>
    </div>
<br><br><br>
<div class="nav-scroller mb-7" id = "list">
	<ul class="nav justify-content-center" style = "display:block;">
	  <li class="nav-item mx-5">
	    <a class="nav-link active p-7" aria-current="page" href="#" id = "nav1">About us</a>
				<ul class="nav justify-content-end" style = "display : none;" id = "none1">
				  <li class="nav-item">
				    <a class="nav-link" aria-current="page" href="#" id = "detail">Active</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="#" id = "detail">Link</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="#" id = "detail">Link</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" id = "detail">Disabled</a>
				  </li>
				</ul>
	  </li>
	  <li class="nav-item mx-5">
	    <a class="nav-link" href="#" id = "nav2">exhibition</a>
	  </li>
	  <li class="nav-item mx-5">
	    <a class="nav-link" href="#" id = "nav3">artist</a>
	  </li>
	  <li class="nav-item mx-5">
	    <a class="nav-link" id = "nav4">Post</a>
	    	<ul class="nav justify-content-end" style = "display : none;" id = "none2">
			  <li class="nav-item">
			    <a class="nav-link" aria-current="page" href="./review" id = "detail">Review</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="qna" id = "detail">Q&A</a>

			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#" id = "detail">FAQ</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id = "detail">Disabled</a>
			  </li>
			</ul>
	  </li>
	  <li class="nav-item mx-5">
	    <a class="nav-link" aria-current="page" href="#" id = "nav5">Member</a>
	    	<ul class="nav justify-content-end" style = "display : none;" id = "none3">
	    	<c:if test = "${userinfo == null}">
			  <li class="nav-item">
			    <a class="nav-link" aria-current="page" href="./login" id = "detail">Login</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#" id = "detail">Sign in</a>
			  </li>
			</c:if>
			<c:if test = "${userinfo != null }">
			  <li class="nav-item">
			    <a class="nav-link" aria-current="page" href="./logout" id = "detail">Logout</a>
			  </li>
			</c:if>
			  <li class="nav-item">
			    <a class="nav-link" href="#" id = "detail">My page</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id = "detail">Disabled</a>
			  </li>
			</ul>
	  </li>
	  <li class="nav-item mx-5">
	    <a class="nav-link" aria-current="page" href="#" id = "nav6">Notice</a>
	  </li>
	</ul>
  </div>
</header>
</div>
<br><br>


<main class = "container">
	<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
	  <div class="carousel-inner">
	    <div class="carousel-item active" data-bs-interval="2000">
	      <img src="./resources/1.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item" data-bs-interval="2000">
	      <img src="./resources/2.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item" data-bs-interval="2000">
	      <img src="./resources/3.jpeg" class="d-block w-100" alt="...">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>
	
	<div class = "row-mb-2" style = "height:500px;">
		<div class = "col-6">
		
		</div>
	
	</div>
</main>

<!-- 하단 -->
<div class="container-fluid">
  <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <p class="col-md-4 mb-0 text-muted">&copy; 2022 Company, Inc</p>

    <a href="/" class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
    </a>

    <ul class="nav col-md-4 justify-content-end">
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Features</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Pricing</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">FAQs</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
    </ul>
  </footer>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
$(document)
.ready(function () {
	console.log("시작 화면");
	$("#nav1").hover(function() {
		$("#none1").css("display", "block");
		$("#none2").css("display", "none");
		$("#none3").css("display", "none");
	}, function() {
	})
	$("#nav2").hover(function() {
		$("#none1").css("display", "none");
		$("#none2").css("display", "none");
		$("#none3").css("display", "none");
	})
	$("#nav3").hover(function() {
		$("#none1").css("display", "none");
		$("#none2").css("display", "none");
		$("#none3").css("display", "none");
	})
	$("#nav4").hover(function() {
		$("#none1").css("display", "none");
		$("#none2").css("display", "block");
		$("#none3").css("display", "none");
	})
	$("#nav5").hover(function() {
		$("#none1").css("display", "none")
		$("#none2").css("display", "none");
		$("#none3").css("display", "block");
	})
	$("#nav6").hover(function() {
		$("#none1").css("display", "none")
		$("#none2").css("display", "none");
		$("#none3").css("display", "none");
	})	
})
</script>
</html>