<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Admissions</title>
    <link type="text/css" rel="stylesheet" href="css/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" type="text/css" href="css/css/custom_css.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
    <div class="row custom-shadow" style="margin: 100px 70px; height:500px; width:1100px; border-radius: 20px;">
        <div class="col-md-6 d-flex flex-column justify-content-center " style="background-color: rgb(40, 95, 156); color:white; padding: 0px 90px; border-top-left-radius: 20px; border-bottom-left-radius: 20px;">
            <h3 class="fw-bold">Login</h3>
            <p>Enter you account details</p>
            <form class="form" id="form" method="post" action="login" novalidate>
                <div>
                    <% 
                    String emailMessage = (String) request.getAttribute("email_message");
                    if (emailMessage != null && !emailMessage.isEmpty()) {
                    %>
                    <input type="email" id="email" name="email" class="form-control is-invalid transparent-input" placeholder ="Email" required/>
                    <span class ="error" style="color: #ff1a1a;"><%=request.getAttribute("email_message")%></span>
                    <%
                    } else {
                    %>
                    <input type="email" id="email" name="email" class="form-control transparent-input" placeholder ="Email" required/>
                    <span class ="error" style="color: #ff1a1a;"></span>
                    <%
                        }
                    %>
                </div>
                <div>
                    <% 
                    String passMessage = (String) request.getAttribute("pass_message");
                    if (passMessage != null && !passMessage.isEmpty()) {
                    %>
                    <input type="password" id="password" name="password" class="form-control transparent-input mt-4 is-invalid" placeholder="Password" required />
                    <span class ="error" style="color: #ff1a1a;"><%=request.getAttribute("pass_message")%></span>
                    <%
                    } else {
                    %>
                    <input type="password" id="password" name="password" class="form-control transparent-input mt-4 mb-4" placeholder="Password" required />
                    <span class ="error" style="color: #ff1a1a;"></span>
                    <%
                        }
                    %>
                </div>
                <div class="d-flex justify-content-center">
                    <input type="submit" class="px-4 mt-2 btn button" style="border-radius: 10px;" value="Login"/>
                </div>
                <div class="d-flex justify-content-center mt-3">
                    <a href="index.jsp" class="" style="color:rgb(221, 186, 27)">Sign Up, if you haven't</a>
                </div>
            </form>
        </div>
        
        <div class="col-md-6 d-flex flex-column justify-content-center align-items-center" style="color: white; background-color: rgb(221, 186, 27); border-top-right-radius: 20px; border-bottom-right-radius: 20px;">
            <div class="d-flex flex-column">
                <h2>Welcome to Student Portal</h2>
            </div>
            <img style="width:400px;height:400px" src="css/images/signup1.png">
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.js"></script>
</body>
</html>