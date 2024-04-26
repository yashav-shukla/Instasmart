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
            margin: 8px 0;
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
            <h2>Fill details to create your profile</h2>
        </div>
        <div>
            <form action="" method=""> 
                <input type="date" placeholder="dob(dd/mm/yyyy)" required />
                <input type="text" placeholder="Age" required />
                <input type="number" min="1"  max="10" placeholder="Contact Number" required />
                <input type="password" placeholder="Street" required />
                <input type="password" placeholder="City" required />
                <input type="password" placeholder="State" required />
                <input type="password" placeholder="Country" required />
                <input type="password" placeholder="Pincode" required />
                <button type="submit">update details</button>
            </form>
        </div>
    </div>
</body>
</html>