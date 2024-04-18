<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Make Reservation</title>
</head>
<body>
    <h1>Make Reservation</h1>
    <form action="ReservationServlet" method="post">
        <label for="checkInDate">Check-in Date:</label>
        <input type="date" id="checkInDate" name="checkInDate" required><br><br>
        
        <label for="checkOutDate">Check-out Date:</label>
        <input type="date" id="checkOutDate" name="checkOutDate" required><br><br>
        
        <label for="roomId">Room ID:</label>
        <input type="number" id="roomId" name="roomId" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
