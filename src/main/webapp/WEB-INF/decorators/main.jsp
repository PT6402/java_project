<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo</title>
    <link rel="stylesheet" href="<c:url value='/lib/bootstrap/css/bootstrap.min.css'/>">
</head>
<body>
    <sitemesh:write property="body"/>
    <script type="text/javascript" src="<c:url value='/lib/jquery/jquery-3.7.1.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/lib/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>

