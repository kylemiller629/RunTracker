<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>MileMarker- Goals</title>
</head>
<body>
    <c:import url="header.jsp" />
    <h1>My Running Goals</h1>

    <table>
        <tr>
            <th>Goal Type</th>
            <th>Target</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Miles Completed</th>
            <th>Progress</th>
            <th>Action</th>
        </tr>

        <c:forEach var="goal" items="${goals}">
            <tr>
                <td>${goal.goalType}</td>
                <td>${goal.target}</td>
                <td>${goal.startDate}</td>
                <td>${goal.endDate}</td>
                <td>${progressMap[goal.id]} miles</td>
                <td>
                    <progress value="${percentMap[goal.id]}" max="100"></progress>
                    ${percentMap[goal.id]}%
                </td>
                <td><a href="editGoal?id=${goal.id}">Edit</a>
                    <form action="deleteGoal" method="post" onsubmit="return confirm('Are you sure you want to delete?');">
                        <input type="hidden" name="id" value="${goal.id}">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="addGoal.jsp">Add Another Goal</a>
    <a href="home">Back to Home</a>
</body>
</html>
