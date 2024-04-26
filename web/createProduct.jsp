<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



  <style>
  
  * {
    margin: 0px;
    padding: 0px;
    box-sizing: border-box;
}

html,
body {
    height: 100%;
    width: 100%;
    background-color: rgba(216, 216, 216, 0.865);
}


/* ~~~~~~~~~~~ Navigation section CSS ~~~~~~~~~~~~~~~ */

nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 60px;
}

#nav_sec_left {
    display: flex;
    align-items: center;
    width: fit-content;
    margin-left: 12px;
}

#logo {
    height: 30px;
    margin-right: 12px;
    width: auto;
}

#nav_item {
    display: flex;
    justify-content: space-between;
    width: 200px;
}

#nav_item li {
    list-style: none;
}

#nav_item li a {
    text-decoration: none;
    color: green;
    
}

#log_btn {
    margin-right: 12px;
    padding: 5px 10px;
    border-radius: 5px;
    border: none;
    background-color: white;
}

/* ~~~~~~~~~~~ main section CSS ~~~~~~~~~~~~~~~ */
#main {
    display: flex;
    height: 100%;
    width: 100%;
}

#left_section {
    height: 100%;
    width: 22%;
}


#aside_items {

    padding: 28px 0px;
    display: flex;
    flex-direction: column;
    gap: 10px;
    width: 80%;
    height: 100%;

}

#aside_items li {

    list-style: none;
    width: 100%;
}

#aside_items li a {
    text-decoration: none;
    color: black;
    display: block;
    padding: 3px;
    padding-left: 18px;
}

#aside_items li:hover,
.active {
    background-color: white ;
    border-radius: 0px 10px 10px 0px ;
}
#aside_items li:hover a {
    background-color: white;
    border-radius: 0px 10px 10px 0px ;
}


#right_section {
    height: 100%;
    width: 75%;
    padding: 28px 0px;
}

#right_upper {
    height: 25px;
    display: flex;
    align-items: center;

}

#category {
    text-decoration: none;
    color: black;
    /* padding: 3px; */
}

#right_lower {
    background-color: white !important;
    height: auto;
    width: 100%;
    padding: 20px;

}
.navbar {
    padding: 2px;
    display: flex;
    align-items: center;
    color: gray;
    justify-content: space-between;
}

.logo {
    display: flex;
    align-items: center;
    background-color: white;
    padding-left: 10px;
    padding-right: 10px;

}

.logo>p {
    background-color: white;
    margin-left: 10px;
}

.nav-page-url {
    padding-left: 50px;
    padding-right: 10px;
    font-weight: 400;
    color: rgb(22, 189, 145);
    font-size: 18px;
}
.sidebar {
    width: 15vw;
    display: flex;
    padding-left: 10px;
    padding-right: 20px;
    padding-top: 15px;
    flex-direction: column;

}
*{
font-family: sans-serif;
}
.sidebar>a {
    text-decoration: none;
    margin-bottom: 10px;
    color: gray;
    /* width: 100%; */
    display: inline;
    padding: 10px;
}
.main_div{
  display: grid;
  grid-template-columns: auto auto auto;

}



/* Style form inputs */
input[type="text"],
select {
  width: calc(100% - 20px);
  padding: 8px 10px;
  margin-bottom: 20px;
  border: none;
  border-bottom: 1px solid #ccc;
  box-sizing: border-box;
  transition: border-color 0.3s;
}

/* Style form inputs on focus */
input[type="text"]:focus,
select:focus {
  outline: none;
  border-bottom-color: darkgreen;
}

/* Style form container */
.main_div {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

/* Style form sections */
.div2 {
  flex: 1;
  padding: 10px;
}

/* Style form buttons container */
.button-container {
  text-align: center;
  margin-top: 20px;
}

/* Style form buttons */
button {
  padding: 10px 20px;
  margin: 0 10px; /* Adjust margin between buttons */
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* Style Create button */
button.create-button {
  background-color: darkgreen;
  color: white;
}

#id{
  font-weight: 900;
}

</style>
  
  </head>
  <body>
    <nav>
      <div id="nav_sec_left">
        <img src="./resources/images/logo.svg" alt="logo" id="logo" />
        <ul id="nav_item">
          <li><a href="#">Home</a></li>
          <span>/</span>
          <li><a href="#" >Categories</a></li>
          <span>/</span>
           <li><a href="#" >Create</a></li>
        </ul>
      </div>
      <div id="nav_sec_right">
        <button id="log_btn">Logout</button>
      </div>
    </nav>
    <section id="main">
      <div id="left_section">
        <ul id="aside_items">
          <li><a href="viewProduct.jsp">Dashboard</a></li>
          <li><a href="listProducts.jsp" class="active">Products</a></li>
          <li><a href="listPackages.jsp">Packages</a></li>
          <li><a href="#">Locations</a></li>
          <li><a href="#">Brands</a></li>
          <li><a href="#">Catalogs</a></li>
        </ul>
      </div>
      <div id="right_section">
        <div id="right_lower">
          <form id="create_product_form" >
            <center id="bold"><h2 >Create Product</h2></center>
            <div class="main_div"> <div class="div2">
              <div>
              <label for="name">Name:</label>
              <input type="text" id="name" name="name">
            </div>
            <div>
              <label for="catalogServiceSector">Catalog Service Sector:</label>
              <select id="catalogServiceSector" name="catalogServiceSector">
                <option value="sector1"></option>
                <option value="sector2"></option>
                <option value="sector3"></option>
              </select>
            </div>
            <div>
              <label for="productCategory">Product Category:</label>
              <select id="productCategory" name="productCategory">
                <option value="category1"></option>
                <option value="category2"></option>
                <option value="category3"></option>
              </select>
            </div>
            <div>
              <label for="dimensions">Dimensions:</label>
              <input type="text" id="dimensions" name="dimensions">
            </div>
            <div>
              <label for="material">Material:</label>
              <input type="text" id="material" name="material">
            </div>
            <div>
              <label for="imageUrl">Image URL:</label>
              <input type="text" id="imageUrl" name="imageUrl">
            </div>
            <div>
              <label for="costPerMonth">Cost/Month:</label>
              <input type="text" id="costPerMonth" name="costPerMonth">
            </div>
          </div>
      
          <div class="div2">
            <div>
              <label for="bread">Bread:</label>
              <input type="text" id="bread" name="bread">
            </div>
            <div>
              <label for="catalogServiceArea">Catalog Service Area:</label>
              <input type="text" id="catalogServiceArea" name="catalogServiceArea">
            </div>
            <div>
              <label for="productType">Product Type:</label>
              <input type="text" id="productType" name="productType">
            </div>
            <div>
              <label for="weightKg">Weight (kg):</label>
              <input type="text" id="weightKg" name="weightKg">
            </div>
            <div>
              <label for="colors">Colors:</label>
              <input type="text" id="colors" name="colors">
            </div>
            <div>
              <label for="location">Location:</label>
              <input type="text" id="location" name="location">
            </div>
        
            <div>
              <button type="button">Cancel</button>
              <button type="button" style="background-color: darkgreen; color: white;">Create</button>
            
            </div>
          </div>
        </div>
          </form>
        </div>
      </div>
    </section>
    <!-- <footer></footer> -->
  </body>


<html lang="en">

