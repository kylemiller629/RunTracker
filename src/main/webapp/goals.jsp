<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MileMarker- Goals</title>
</head>
<body>

    <h1>My Running Goals</h1>

    <table>
        <tr>
            <th>Goal Type</th>
            <th>Target</th>
            <th>Start Date</th>
            <th>End Date</th>
        </tr>

        <c:forEach var="goal" items="${goals}">
            <tr>
                <td>${goal.goalType}</td>
                <td>${goal.target}</td>
                <td>${goal.startDate}</td>
                <td>${goal.endDate}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="addGoal.jsp">Add Another Goal</a>
    <a href="home">Back to Home</a>
</body>
</html>
