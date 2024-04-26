<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="Domain.Product"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet" href="./resources/css/style.css">
</head>
<body>
  <nav>
    <div id="nav_sec_left">
      <img src="./resources/images/logo.svg" alt="logo" id="logo" />
      <ul id="nav_item">
        <li><a href="#" style="color: rgb(5, 158, 35) !important;">Home</a></li>
        <span>/</span>
        <li><a href="#" style="color: rgb(5, 158, 35) !important;">Products</a></li>
        <span id="editSpan" style="display:none;">/</span>
          <li id="editText" style="display:none; color: green;">Edit</li>
      </ul>
    </div>
    <div id="nav_sec_right">
      <button id="log_btn">Logout</button>
    </div>
  </nav>
  <section id="main">
    <div id="left_section">
      <ul id="aside_items">
        <li><a href="viewProduct.jsp" >Dashboard</a></li>
        <li><a href="listProducts.jsp" class="active">Products</a></li>
        <li><a href="listPackages.jsp">Packages</a></li>
        <li><a href="rentals.jsp">My Rentals</a></li>
        <li><a href="myCart.jsp">My Orders</a></li>
        <li><a href="setting.jsp">Settings</a></li>
      </ul>
    </div>
    <div id="right_section">
      <div id="right_upper"><a href="#" id="category">Products</a></div>
      <div id="right_lower">
        <div class="items">
          <div class="searchbar">
            <input type="text" name="" id="" placeholder="city">
            <button>FILTER</button>
          </div>
          
          
          
          <div class="items-list">
            <div class="item">
                <img src="./resources/images/products/camera.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
            <div class="item">
                <img src="./resources/images/products/chair.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
            <div class="item">
                <img src="./resources/images/products/p1.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
            <div class="item">
                <img src="./resources/images/products/p2.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
            <div class="item">
                <img src="./resources/images/products/p3.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
            <div class="item">
                <img src="./resources/images/products/p4.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
        <div class="item">
                <img src="./resources/images/products/p5.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
             <div class="item">
                <img src="./resources/images/products/p6.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
             <div class="item">
                <img src="./resources/images/products/p7.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
             <div class="item">
                <img src="./resources/images/products/p8.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
             <div class="item">
                <img src="./resources/images/products/p9.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
             <div class="item">
                <img src="./resources/images/products/p10.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
             <div class="item">
                <img src="./resources/images/products/sofa-1.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div> <div class="item">
                <img src="./resources/images/products/sofa-2.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div> <div class="item">
                <img src="./resources/images/products/sofa-3.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div> <div class="item">
                <img src="./resources/images/products/washing.png" alt="">
                <h4>Living Room: Ferniture</h4>

                <button class="details-btn">DETAILS</button>
            </div>
        </div>
        </div>
      </div>
    </div>
  </section>
  <!-- Hidden details content -->
  <div id="details_content" style="display: none;">
    <div class="products-detail">
      <div class="detail">
        <img src="./resources/images/products/p1.png" alt="Chair-image">
        <div class="info">
          <p class="product-name">Designer Chair</p>
          <p class="price">₹ 1500 / month</p>
          <div class="sub-info">
            <table>
              <tbody>
                <tr>
                  <td style="font-weight: bold; color: black;">Material: </td>
                  <td>Wood</td>
                </tr>
                <tr>
                  <td style="font-weight: bold; color: black;">Brand: </td>
                  <td>Bosch</td>
                </tr>
                <tr>
                  <td style="font-weight: bold; color: black;">Dimensions: </td>
                  <td>121 X 121</td>
                </tr>
                <tr>
                  <td style="font-weight: bold; color: black;">Product Category: </td>
                  <td>Furniture</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div class="payment-plan">
        <p>Make your RMI(Rental Monthly Installment plan)</p>
        <div class="cards">
          <div class="card">
            <p style="background-color: white;"><span style="font-size: 22px; background-color: white; font-weight: bold;">6</span> month plan</p>
            <div style="background-color: white;">
              <h3 style="margin: none; background-color: white;"><span style="color: black; font-size: 32px; background-color: white;">₹ 1440.0/</span> month</h3>
              <p style="background-color: white; font-size: 12px;">₹ 6723 for</p>
              <button>ADD TO CART</button>
            </div>
          </div>
          <!-- Add more payment plans as needed -->
          <div class="card" style="margin-top: 0;">
            <p style="background-color: white;"><span style="font-size: 22px; background-color: white; font-weight: bold;">9</span> month plan</p>
            <div style=" background-color: white;">
                <h3 style="margin: none; background-color: white;"><span style="color: black; font-size: 32px; background-color: white;">₹ 1440.0/</span> month
            </h3>
            <p style="background-color: white; font-size: 12px;">₹ 6723 for</p>
            <button>ADD TO CART</button>
            </div>
        </div>
        <div class="card">
            <p style="background-color: white;"><span style="font-size: 22px; background-color: white; font-weight: bold;">12   </span> month plan</p>
            <div style=" background-color: white;">
                <h3 style="margin: none; background-color: white;"><span style="color: black; font-size: 32px; background-color: white;">₹ 1440.0/</span> month
            </h3>
            <p style="background-color: white; font-size: 12px;">₹ 6723 for</p>
            <button>ADD TO CART</button>
            </div>
        </div>
        </div>
      </div>
    </div>
  </div>

  <script>
    // Function to change content on button click
    function showDetails() {
      var detailsContent = document.getElementById('details_content').innerHTML;
      document.getElementById('right_lower').innerHTML = detailsContent;
       // Show the "Edit" text in the navigation bar
       document.getElementById('editSpan').style.display = "inline";
       document.getElementById('editText').style.display = "inline";
   
       document.getElementById('details_content').style.display = "block";
    }

    // Add event listener to all detail buttons
    var detailButtons = document.querySelectorAll('.details-btn');
    detailButtons.forEach(function (button) {
      button.addEventListener('click', showDetails);
      
      document.getElementById('nav_item').classList.add('showDetails');
    });
  </script>
</body>
</html>