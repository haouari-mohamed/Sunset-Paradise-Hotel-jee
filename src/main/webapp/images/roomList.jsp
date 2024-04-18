<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room List</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h1>Room List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Room ID</th>
                <th>Type</th>
                <th>Price</th>
                <th>Amenities</th>
                <th>Availability</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over the list of rooms -->
            <c:forEach var="room" items="${roomList}">
                <tr>
                    <td>${room.id}</td>
                    <td>${room.type}</td>
                    <td>${room.price}</td>
                    <td>${room.amenities}</td>
                    <td>${room.available ? 'Available' : 'Not Available'}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
