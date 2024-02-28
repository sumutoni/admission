<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Admissions</title>
    <link type="text/css" rel="stylesheet" href="css/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <style>
        @font-face {
            font-family: 'Comfortaa';
            src: url('css/fonts/Comfortaa-Regular.ttf') format('ttf');
            /* Add additional font formats as needed */
        }

        /* Add your custom CSS styles here */
        body {
            font-family: 'Comfortaa', sans-serif;
            /* Set background size to cover the entire body */
            background-size: cover;
            /* Set background position to center */
            background-position: center;
            /* Set background attachment to fixed to keep the image fixed while scrolling */
            background-attachment: fixed;
        }
    </style>
</head>
<body>
    
    <div class="d-flex justify-content-between">
        <div class="mt-3 ms-2">
            <%
            String name = (String) session.getAttribute("names");
            %>
            <h1 class="fs-3 fw-bold" style="color: #1e7fcf;">Welcome, <%=name%></h1>
        </div>
        <div class="mt-5 me-5">
            <form method="post" action="logout"><button class="fw-bold btn" style="text-decoration: none; background-color:rgb(40, 95, 156); color: white" type="submit">Logout</button></form>
        </div>  
    </div>
</body>