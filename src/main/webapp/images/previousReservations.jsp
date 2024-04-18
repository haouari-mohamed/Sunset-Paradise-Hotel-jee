<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Previous Reservations</title>
</head>
<body>
    <h1>Previous Reservations</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Reservation ID</th>
                <th>Room ID</th>
                <th>Check-in Date</th>
                <th>Check-out Date</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over the list of reservations -->
            <c:forEach var="reservation" items="${reservationList}">
                <tr>
                    <td>${reservation.id}</td>
                    <td>${reservation.roomId}</td>
                    <td>${reservation.checkInDate}</td>
                    <td>${reservation.checkOutDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
