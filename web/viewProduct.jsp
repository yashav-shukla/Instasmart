<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Domain.Product"%>
<%@ page import="java.util.List"%>
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
          <li><a href="#" style="color: rgb(5, 158, 35) !important;">Categories</a></li>
        </ul>
      </div>
      <div id="nav_sec_right">
        <button id="log_btn">Logout</button>
      </div>
    </nav>
    <section id="main">
      <div id="left_section">
        <ul id="aside_items">
          <li><a href="viewProduct.jsp" class="active">Dashboard</a></li>
          <li><a href="listProducts.jsp">Products</a></li>
          <li><a href="listPackages.jsp">Packages</a></li>
          <li><a href="rentals.jsp">My Rentals</a></li>
          <li><a href="MyCart.jsp">My Orders</a></li>
          <li><a href="setting.jsp">Settings</a></li>
        </ul>
      </div>
      
       <%
                    // Assuming the servlet has set an attribute named "productList" containing product data
                    ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
                    if (productList != null) {
                        for (Product product : productList) {
                %>
      
      <div id="right_section">
        <div id="right_upper" ><a href="#" id="category" >Categories</a></div>
        <div id="right_lower"> 
        <div class="items">
            <div class="items-list">

                <div class="item">
                    <img src="./resources/images/products/chair.png" alt="">
                    <h4><%= product.getName() %></h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
                <div class="item">
                    <img src="./resources/images/products/camera.png" alt="">
                    <h4><%= product.getName() %></h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
                <div class="item">
                    <img src="./resources/images/products/chair.png" alt="">
                    <h4><%= product.getName() %>h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
                <div class="item">
                    <img src="./resources/images/products/camera.png" alt="">
                    <h4><%= product.getName() %></h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
                <div class="item">
                    <img src="./resources/images/products/chair.png" alt="">
                    <h4><%= product.getName() %></h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
                <div class="item">
                    <img src="./resources/images/products/camera.png" alt=" ">
                    <h4><%= product.getName() %></h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
                <div class="item">
                    <img src="./resources/images/products/chair.png" alt="">
                    <h4><%= product.getName() %></h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
                <div class="item">
                    <img src="./resources/images/products/camera.png" alt=" ">
                    <h4><%= product.getName() %></h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
                <div class="item">
                    <img src="./resources/images/products/chair.png" alt="">
                    <h4><%=product.getName() %></h4>
                    <img src="./resources/images/icons/eye.png" alt="" class="view-icon" height="10">
                </div>
            </div>
        </div></div>
      </div>
    </section>
    <!-- <footer></footer> -->
  </body>
</html>