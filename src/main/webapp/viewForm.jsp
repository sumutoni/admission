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
                    <div class="d-flex flex-column justify-content-center mb-3">
                        <h2 class="fw-bold fs-2" style="color:#1e7fcf">FORM DETAILS</h2>
                    </div>
                    <div class="d-flex justify-content-between mb-5" style="width:500px;">
                        <img src="displayPicture?id=${form.ID}" height="100px" width="100px" alt="Passport Picture">
                        <div><p style="color: #1e7fcf; font-size: 20px; font-weight: bold;">Status: </p><span style="font-size: 16px; font-weight: bold;">${form.status}</span></div>
                        
                    </div>
                    <div class="row  mb-3" style="width:800px;">
                        <div class="col-md-12"><h3 class="fw-bold" style="color:rgb(221, 186, 27)">Personal Information</h3></div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Full Name:</label>
                            <span class =""> <%= request.getAttribute("fullName")%></span>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Date of Birth:</label>
                            <span class =""><%= request.getAttribute("dob")%></span>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Gender:</label>
                            <span class =""><%= request.getAttribute("gender")%></span>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Father's Name:</label>
                            <span class =""><%= request.getAttribute("fatherName")%></span>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Mother's Name:</label>
                            <span class =""><%= request.getAttribute("motherName")%></span>
                        </div>
                        <div class="col-md-12"><h3 class="fw-bold" style="color:rgb(221, 186, 27)">Residence</h3></div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Country of Residence:</label>
                            <span class =""><%= request.getAttribute("country")%></span>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">City of Residence:</label>
                            <span class =""><%= request.getAttribute("city")%></span>
                        </div>
                        <div class="col-md-12">
                            <label class="form-label fs-5 fw-bold">Address:</label>
                        <span class =""><%= request.getAttribute("address")%></span>
                        </div>
                        <div class="col-md-12"><h3 class="fw-bold" style="color:rgb(221, 186, 27)">Contact Information</h3></div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Email:</label>
                            <span class =""><%= request.getAttribute("email")%></span>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Phone Number:</label>
                            <span class =""><%= request.getAttribute("phone")%></span>
                        </div>
                        <div class="col-md-12"><h3 class="fw-bold" style="color:rgb(221, 186, 27)">Academic Background</h3></div>
                        <div class="col-md-12">
                            <label class="form-label fs-5 fw-bold">Degree/Certificate:</label>
                            <a href="viewPdf?id=${form.ID}"><%= request.getAttribute("degree")%></a>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Faculty:</label>
                            <span class ="">IT</span>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fs-5 fw-bold">Department:</label>
                            <span class =""><%= request.getAttribute("dept")%></span>
                        </div>
                    </div>
                    <div>
                        <form method="post" action="statusUpdate?id=${form.ID}" class="d-flex justify-content-evenly" style="width: 600px;">
                            <input type="submit" class="status-button" name="update" value="Accept" style="background-color: rgb(26, 148, 52); border: none; border-radius: 10px; padding: 10px 10px; color: white; font-size: 12px; font-weight: bold;"/>
                            <input type="submit" class="status-button" name="update" value="Waitlist" style="background-color: rgb(235, 220, 10); border: none; border-radius: 10px; padding: 10px 10px; color: white; font-size: 12px; font-weight: bold;"/>
                            <input type="submit" class="status-button" name="update" value="Deny" style="background-color: rgb(226, 8, 8); border: none; border-radius: 10px; padding: 10px 10px; color: white; font-size: 12px; font-weight: bold;"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
</body>
