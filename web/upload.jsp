<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
/*product upload page */
.product-upload {
    display: flex;
    flex-direction: column;
    background-color: white;
    padding: 10px;
    margin-top: 20px;
    height: 22vh;
    width: 60%;
}

.product-upload>* {
    background-color: white;

}

.product-upload>button {
    width: 10vw;
    background-color: rgb(5, 158, 107);
    padding: 5px;
    padding-right: 15px;
    padding-left: 15px;
    color: white;
    outline: none;
    border: none;
    margin-top: 3vh;
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
          <li><a href="#" >Product</a></li>
          <span>/</span>
          <li><a href="#" >Upload</a></li>
        </ul>
      </div>
      <div id="nav_sec_right">
        <button id="log_btn">Logout</button> 
      </div>
    </nav>
    <section id="main">
      <div id="left_section">
        <ul id="aside_items">
          <li><a href="#" class="active">Product</a></li>
          <li><a href="#">Packages</a></li>
          <li><a href="#">Rentals</a></li>
          <li><a href="#">Orders</a></li>
          <li><a href="#">Settings</a></li>
        </ul>
      </div>
      <div id="right_section">
        <div id="right_lower" >
            <div class="product-upload">
                <h4 style="margin-bottom: 5px;">Product Bulk Upload</h4>
                <input type="file" name="" id="fileInput"  accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel">
                <button id="upload">Upload</button>
            </div>
        </div>
      </div>
    </section>
    <!-- <footer></footer> -->
    <script>
document.getElementById('upload').addEventListener('click', function() {
    var fileInput = document.getElementById('fileInput');
    var file = fileInput.files[0];
    
    if (file) {
        var formData = new FormData();
        formData.append('file', file);
        
        // Send the file to the server using AJAX
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'Upload', true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                console.log('File uploaded successfully');
            } else {
                console.error('Error uploading file');
            }
        };
        xhr.send(formData);
    } else {
        console.error('No file selected');
    }
});
</script>
  </body>
</html>