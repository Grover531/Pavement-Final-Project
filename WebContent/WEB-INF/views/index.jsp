<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pavement</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v6.1.1/css/all.css"
	integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5"
	crossorigin="anonymous">

<style>
body {
	background-image: url("img/brickwall.jpg");
}
table {
	width: 800px;
	margin: auto;
	text-align: center;
	table-layout: fixed;
}
table, tr, th, td {
	padding: 20px;
	color: black;
	border: 1px solid #080808;
	border-collapse: collapse;
	font-size: 18px;
	font-family: Arial;
	background: linear-gradient(top, #3c3c3c 0%, #222222 100%);
	background: -webkit-gradient(top, #3c3c3c 0%, #222222 100%);
	word-wrap: break-word;
}

</style>

<!-- Navbar Section-->
<nav class="navbar">
	<div class="navbar__container">
		<a href="#home" id="navbar__logo">Pavement</a>
	</div>

	<div class="navbar__toggle" id="mobile-menu">
		<span class="bar"></span> <span class="bar"></span> <span class="bar"></span>
	</div>
	<ul class="navbar__menu">
		<li class="navbar__item"><a href="#home" class="navbar__links"
			id="home-page">Home</a></li>
		<li class="navbar__item"><a href="#about" class="navbar__links"
			id="about-page">About</a></li>
		<li class="navbar__item"><a href="#services"
			class="navbar__links" id="services-page">Services</a></li>
		<li class="navbar__item"><a href="#admin" class="navbar__links"
			id="admin-page">Admin</a></li>
		<li class="navbar__btn"><a href="#sign-up" class="button"
			id="signup">Sign Up</a></li>
	</ul>
</nav>

<!-- Hero Section-->
<div class="hero" id="home">
	<div class="hero__container">
		<h1 class="hero__heading">
			Find a <span>room</span>
		</h1>
		<p class="hero__description">Without the hassle</p>
		<button class="main__btn">
			<a href="#">Explore listings</a>
		</button>
	</div>
</div>

<!--About Section-->
<div class="main" id="about">
	<div class="main__container">
		<div class="main__img--container">
			<div class="main__img--card">
				<i class="fas fa-layer-group"></i>
			</div>
			<div class="main__content">
				<h1>What do we do?</h1>
				<h2>We make finding a room super easy</h2>
				<p>Create account to view listings</p>
				<button class="main__btn">
					<a href="#">Create account</a>
				</button>
			</div>
		</div>
	</div>

	<!-- Services Section -->
	<div class="services" id="services">
		<h1>Our Services</h1>
		<div class="services__wrapper">
			<div class="services__card">
				<h2>Customer Colorways</h2>
				<p>AI Powered technology</p>
				<div class="services__btn">
					<button>Get Started</button>
				</div>
			</div>
			<div class="services__card">
				<h2>Are you ready?</h2>
				<p>Take the leap</p>
				<div class="services__btn">
					<button>Get Started</button>
				</div>
			</div>
			<div class="services__card">
				<h2>Full Gradients</h2>
				<p>100 Combinations</p>
				<div class="services__btn">
					<button>Get Started</button>
				</div>
			</div>
			<div class="services__card">
				<h2>Plenty of rooms to choose from</h2>
				<p>100's of room listings</p>
				<div class="services__btn">
					<button>Get Started</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Features Section -->
	<div class="main" id="sign-up">
		<div class="main__container">
			<div class="main__content">
				<h1>Join Our Team</h1>
				<h2>Sign Up Today</h2>
				<p>See why college students love us</p>
				<button class="main__btn">
					<a href="#">Sign Up</a>
				</button>
			</div>
			<div class="main__img--container">
				<div class="main__img--card" id="card-2">
					<i class="fas fa-users"></i>
				</div>
			</div>
		</div>
	</div>

	<!-- Admin Section -->
	<div class="admin" id="admin" align="center">
		<h3>
			<a href="new">Create New Renter </a>
		</h3>
		<table border="1" cellpadding="5" style="background-color: #FFF;">
			<tr>
				<th>No</th>
				<th>Email</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Contact Number</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listRenter}" var="renter" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${renter.email}</td>
					<td>${renter.firstName}</td>
					<td>${renter.lastName}</td>
					<td>${renter.contactNumber}</td>
					<td><a href="edit?id=${renter.id}">Edit</a> &nbsp;&nbsp; <a
						href="delete?id=${renter.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<!-- Footer Section -->
	<div class="footer__container">
		<div class="footer__links">
			<div class="footer__link--wrapper">
				<div class="footer__link--items">
					<h2>About Us</h2>
					<a href="/sign-up">How it works</a> <a href="/sign-up">Testimonials</a>
					<a href="/sign-up">Careers</a> <a href="/sign-up">Terms of
						Service</a>
				</div>
				<div class="footer__link--items">
					<h2>Videos</h2>
					<a href="/sign-up">Submit Video</a> <a href="/sign-up">Ambassadors</a>
					<a href="/sign-up">Agency</a>
				</div>
			</div>
			<div class="footer__link--wrapper">
				<div class="footer__link--items">
					<h2>Social Media</h2>
					<a href="/sign-up">Instagram</a> <a href="/sign-up">Facebook</a> <a
						href="/sign-up">Youtube</a> <a href="/sign-up">Twitter</a>
				</div>
			</div>
		</div>
		<section class="social__media">
			<div class="social__media--wrap">
				<div class="footer__logo">
					<a href="/" id="footer__logo">Pavement</a>
				</div>
				<p class="website__rights">© PVMT 2020. All rights reserved</p>
				<div class="social__icons">
					<a href="/" class="social__icon--link" target="_blank"> <i
						class="fab fa-facebook"></i>
					</a> <a href="/" class="social__icon--link" target="_blank"> <i
						class="fab fa-instagram"></i>
					</a> <a href="/" class="social__icon--link" target="_blank"> <i
						class="fab fa-youtube"></i>
					</a> <a href="/" class="social__icon--link" target="_blank"> <i
						class="fab fa-linkedin"></i>
					</a> <a href="/" class="social__icon--link" target="_blank"> <i
						class="fab fa-twitter"></i>
					</a>
				</div>
			</div>
		</section>
	</div>

	<script src="app.js"></script>

	</body>
</html>