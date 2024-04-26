<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <style>
        body {
            margin: 0;
            background-image: url("./resources/images/login_bg.png");
            background-repeat: no-repeat;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        #child {
            background-color: white;
            padding: 2rem;
            border-radius: 10px;
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
           border: 1px solid #e6e6e6;
            border-radius: 5px;
           
            
        }

        button {
            width: 100%;
            background-color: green;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            margin-top: 10px;
            cursor: pointer;
        }

        button:hover {
            background-color: darkgreen;
        }

        a {
            color: green;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Media queries for responsiveness */
        @media (max-width: 480px) {
            #child {
                padding: 1rem;
            }

            button, input {
                padding: 8px;
            }
        }
    </style>
    <body>
    <div id="child">
        <div>
            <img src="./resources/images/logo.svg" alt="logo" width="200">
            <h2>Welcome back, Instasmarter!</h2>
        </div>
        <div>
            <form action="Validation" method="post">  
                <input type="text" placeholder="Username" name="username" required />
                <input type="password" placeholder="Password" name="password" required />
                <button type="submit">SIGN IN</button>
            </form>
            <p>New to INSTASMART? <span><a href="signup.jsp">Sign up</a></span> instead</p>
        </div>
    </div>
</body>
</html>