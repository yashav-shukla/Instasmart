<!DOCTYPE html>
<html lang="en">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
    height: 40px;
    margin-right: 12px;
    width: auto;
    background-color:white;
    padding:2px 4px 2px 4px;
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
    background-color: rgb(216, 216, 216) !important;
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

.sidebar>a {
    text-decoration: none;
    margin-bottom: 10px;
    color: gray;
    /* width: 100%; */
    display: inline;
    padding: 10px;
}
*{
    font-family: sans-serif;
    font-weight: 1150;
}
/* cart css*/
.cart {
    display: flex;
    flex-direction: column;
    width: 90%;
    padding: 1rem;

}

.cart>.cart-header {
    background-color: white;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 4vh;
    padding-left: 10px;
    padding-right: 10px;}

.cart>.cart-header>* {
    background-color: white;
}

.cart>.cart-header>div {
    display: flex;
    align-items: center;
}

.cart>.cart-header>div>* {
    background-color: white;
}

.cart>.cart-header>div>img {
    height: 40px;
}

.addresses {
    display: flex;
    flex-wrap: wrap;
}

.address {
    width: 25vw;
    margin-right: 2vw;
    margin-bottom: 2vh;
    display: flex;
    flex-direction: column;
    padding: 10px;
    padding-top: 0;
    background-color: white;
}

.address > span{
    color: gray;
    font-size: 12px;
}
.address>* {
    background-color: white;
}
.address>button {
    width: 10vw;
    background-color: rgb(5, 158, 107);
    padding: 5px;
    padding-right: 15px;
    padding-left: 15px;
    color: white;
    outline: none;
    border: none;
    margin-top: 2vh;
    border-radius: 2px;
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
          <li><a href="#" >MyCart</a></li>
        </ul>
      </div>
      <div id="nav_sec_right">
        <button id="log_btn">MyCart <span style="background-color: green;  border-radius: 50%; padding:0px 4px 0px 4px;font-size: 14px;color: white;" >6</span></button>
        <button id="log_btn">Logout</button>
      </div>
    </nav>
    <section id="main">
      <div id="left_section">
        <ul id="aside_items">
          <li><a href="#" class="active">Dashboard</a></li>
          <li><a href="#">Products</a></li>
          <li><a href="#">Packages</a></li>
          <li><a href="#">My Rentals</a></li>
          <li><a href="#">My Orders</a></li>
          <li><a href="#">Settings</a></li>
        </ul>
      </div>
      <div id="right_section">
        <div id="right_lower" >
            <div class="cart">
                <div class="cart-header" >
                    <div>
                        <img src="./resources/images/icons/large-cart.png" alt="cart icon" height="50px">
                        <h4>My Cart</h4>
                    </div>
                    <h4 style="color: rgb(5, 158, 107);">&#8377; 12690.0</h4>
                </div>
                <div class="" style="display: flex ; align-items: center; margin-bottom:1rem">
                    <img  src="./resources/images/icons/icon_location.png" alt="location"> 
                    <h4 style="color: gray;">Choose a delivery address</h4>
                </div>
                <div class="addresses">
                    <div class="address">
                        <h4>Address - 1</h4>
                        <span>2nd man</span>
                        <span>Chennai</span>
                        <span>Tamilnadu</span>
                        <span>India 577001</span>
                        <button>DELIVER HERE</button>
                    </div>
                    <div class="address">
                        <h4>Address - 2</h4>
                        <span>2nd man</span>
                        <span>Chennai</span>
                        <span>Tamilnadu</span>
                        <span>India 577001</span>
                        <button>DELIVER HERE</button>
                    </div>
                    <div class="address">
                        <h4>Add new address</h4>
                        <img src="./resources/images/new-address.png" style="height: 8vh; width: 8vw;" alt="new-address">
                     
                        <button style="background-color: white; color: rgb(5, 158, 107); padding: none; font-weight: bold;  width: 8vw;">ADD NEW</button>
                    </div>
    
                </div>
            </div>
        </div>
      </div>
    </section>
    <!-- <footer></footer> -->
  </body>
</html>