<!DOCTYPE html>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Human Resource Application</title>
    <link type="text/css" rel="stylesheet" href="css/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	<script defer type="script" src="css/js/validation.js"></script>
    <link rel="stylesheet" type="text/css" href="css/css/custom_css.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
</head>
<body>
    <div class="row">
        <div class="col-md-3">
            <jsp:include page="admin_sidebar.jsp"/>
        </div>
        <div class="col-md-9">
            <div class="d-flex flex-column">
                <jsp:include page="dashboard_header.jsp"/>
                <div class="d-flex flex-column py-5">
                    <div class="d-flex flex-column justify-content-center mb-5">
                        <h2 class="fw-bold fs-2" style="color:#1e7fcf">ADMISSION FORM</h2>
                    </div>
                    <div class="d-flex flex-column justify-content-center mb-3" style="overflow: scroll; width:800px;">
                        <c:forEach var="form" items="${forms}">
                            <div class="card">
                                <div class="card-body row border-bottom-2">
                                    <div class="col-md-8">
                                        <h5 class="card-title fw-bold">${form.fullName}</h5>
                                        <p class="card-text">${form.department}</p>
                                    </div>
                                    <div class="col-md-3 d-flex justify-content-end">
                                        <a class="btn" style="background-color:rgb(221, 186, 27); color: black;" href="viewForm?id=${form.ID}">Details</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
</body>
