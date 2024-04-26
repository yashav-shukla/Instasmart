<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head> 
<link rel="stylesheet" href="./resources/css/style.css" />
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
        <li><a href="listProducts.jsp" >Products</a></li>
        <li><a href="listPackages.jsp">Packages</a></li>
        <li><a href="rentals.jsp" class="active">My Rentals</a></li>
        <li><a href="myCart.jsp">My Orders</a></li>
        <li><a href="setting.jsp">Settings</a></li>
      </ul>
    </div>
    <div id="right_section">
      <div id="right_upper"><a href="#" id="category">Rental Agreement</a></div>
      <div id="right_lower">
        <div style="width:100%;">
            <div class="agreement">
                <h4>RENTAL AGREEMENT</h4>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, similique alias reprehenderit quo
                    quos sequi rerum necessitatibus nesciunt nulla cum enim aliquid libero. Laboriosam voluptate
                    delectus voluptatibus, dicta quam id ipsum debitis tempora blanditiis soluta beatae perferendis
                    officiis unde? Repellat, perspiciatis eum unde quam iusto ea mollitia amet non cumque aliquam
                    explicabo est accusamus provident nam vel obcaecati fugit veniam, quibusdam at. Praesentium dolores
                    fugit modi expedita nostrum, nihil quod molestias? Dolorum, illo excepturi reprehenderit expedita
                    vitae inventore, ab perferendis voluptatum non, explicabo enim. Molestias necessitatibus quo non
                    quae. Ad ducimus, magnam laudantium expedita at quae blanditiis iusto laborum quam modi natus optio
                    exercitationem a, quas aliquam repellendus? Pariatur sed error blanditiis, atque perspiciatis quis
                    repudiandae quos ipsam dolorum</p>

                <table style="width: 100%;">
                    <thead>
                        <tr>
                            <th>SNo</th>
                            <th>Product Name</th>
                            <th>Product id</th>
                            <th>Quality</th>
                            <th>Rental Rate / month</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Desiner Chair</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1410</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Desiner Table</td>
                            <td>1</td>
                            <td>1</td>
                            <td>2000</td>
                        </tr>
                    </tbody>
                </table>
                <h5 style="text-align: start;">TERMS AND CONDITIONS</h5>
                <ul>
                    <li>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nisi aliquam iusto commodi in sint
                        assumenda, nulla nihil deleniti cum alias tempora natus tempore, ab, porro autem dolor animi
                        facere numquam quas. Dolor, accusantium repudiandae! Ea sunt provident, modi tenetur distinctio
                        blanditiis doloribus reiciendis perspiciatis nisi eveniet velit quo doloremque assumenda?</li>
                    <li>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nisi aliquam iusto commodi in sint
                        assumenda, nulla nihil deleniti cum alias tempora natus tempore, ab, porro autem dolor animi
                        facere numquam quas. Dolor, accusantium repudiandae! Ea sunt provident, modi tenetur distinctio
                        blanditiis doloribus reiciendis perspiciatis nisi eveniet velit quo doloremque assumenda?</li>
                    <li>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nisi aliquam iusto commodi in sint
                        assumenda, nulla nihil deleniti cum alias tempora natus tempore, ab, porro autem dolor animi
                        facere numquam quas. Dolor, accusantium repudiandae! Ea sunt provident, modi tenetur distinctio
                        blanditiis doloribus reiciendis perspiciatis nisi eveniet velit quo doloremque assumenda?</li>

                </ul>

            </div>
        </div>
      </div>
    </div>
  </section>
</body>
</html>
