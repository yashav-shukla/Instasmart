<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<style>
  * {
    margin: 0px;
    padding: 0px;
    box-sizing: border-box;
    font-family :sans-serif;
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
    	background-color: white;
	padding: 2px 4px 2px 4px;
}

#nav_item {
    display: flex;
    justify-content: space-between;
    width:150px;
    color:green;
}
#nav_item.editing-enabled {
    width: 180px;
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
#setting_form {
    margin-top: 20px;
}

#setting_form label {
    font-weight: bold;
}
.input-field {
            width: calc(100% - 20px);
            padding: 8px 10px;
            margin-bottom: 20px;
            border: none;
            border-bottom: 1px solid #ccc;
            box-sizing: border-box;
            transition: border-color 0.3s;
            font-family: Arial, sans-serif;
            font-size: 16px;
        }

        /* Style input fields on focus */
        .input-field:focus {
            outline: none;
            border-bottom-color: darkgreen;
        }

</style>
<body>
    <nav>
      <div id="nav_sec_left">
        <img src="./resources/images/logo.svg" alt="logo" id="logo" />
        <ul id="nav_item">
          <li><a href="#" >Home</a></li>
          <span>/</span>
          <li><a href="#" >Settings</a></li>
           <span id="editSpan" style="display:none;">/</span>
          <li id="editText" style="display:none; ">Edit</li>
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
          <li><a href="listProducts.jsp">Products</a></li>
          <li><a href="listPackages.jsp">Packages</a></li>
          <li><a href="rentals.jsp">My Rentals</a></li>
          <li><a href="myCart.jsp">My Orders</a></li>
          <li><a href="settings.jsp" class="active">Settings</a></li>
        </ul>
      </div>
      <div id="right_section">
        <div id="right_lower">
            <h1>Account Settings</h1>
            <form id="setting_form">
                <div class="main_div">
                    <div class="div2">
                        <label for="firstName">First Name:</label><br>
                        <input type="text" id="firstName" name="firstName" value="John" class="input-field" disabled><br>
                        <label for="lastName">Last Name:</label><br>
                        <input type="text" id="lastName" name="lastName" value="Doe" class="input-field"  disabled><br>
                        <label for="username">Username:</label><br>
                        <input type=" name="dob" text" id="username" name="username" value="johndoe" class="input-field"  disabled><br>
                        <label for="email">Email:</label><br>
                        <input type="email" id="email" name="email" value="johndoe@example.com" class="input-field"  disabled><br>
                    </div>
                    <div class="div2">
                        <label for="dob"  > Date of Birth:</label><br>
                        <input type="date"  name="dob"  id="dob" value="1990-01-01" class="input-field"  disabled><br>
                        <label for="password">Password:</label><br>
                        <input type="password" name="password" id="password" value="********" class="input-field"  disabled><br>
                        <label for="contactNo">Contact No:</label><br>
                        <input type="text" id="contactNo" name="contactNo" value="1234567890" class="input-field"  disabled><br>
                        <label for="age">Age:</label><br>
                        <input type="number" id="age"  name="age" value="30" class="input-field"  disabled><br>
                    </div>
                </div>
                <div class="button-container">
                    <button type="button" onclick="enableEditing()" style="background-color:green;">Edit Settings</button>

                </div>
            </form>
        </div>
      </div>
    </section>
    <!-- <footer></footer> -->
    <script>
        function enableEditing() {
            var inputs = document.querySelectorAll('input');
            for (var i = 0; i < inputs.length; i++) {
                inputs[i].removeAttribute('disabled');
            }
         // Show the "Edit" text in the navigation bar
            document.getElementById('editSpan').style.display = "inline";
            document.getElementById('editText').style.display = "inline";
            // Add a class to #nav_item to update its CSS properties
            document.getElementById('nav_item').classList.add('editing-enabled');
        }
    </script>
  </body>

</html>