<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="My Goals" scope="request" />

<html>

<c:import url="head.jsp" />

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

        <c:forEach var="goalProgress" items="${user.goalProgressList}">
            <tr>
                <td>${goalProgress.goal.goalType}</td>
                <td>${goalProgress.goal.target}</td>
                <td>${goalProgress.goal.startDate}</td>
                <td>${goalProgress.goal.endDate}</td>
                <td>${goalProgress.progress} miles</td>
                <td>
                    <progress value="${goalProgress.percentage}" max="100"></progress>
                    ${goalProgress.percentage}%
                </td>
                <td><a href="editGoal?id=${goalProgress.goal.id}">Edit</a>
                    <form action="deleteGoal" method="post" onsubmit="return confirm('Are you sure you want to delete?');">
                        <input type="hidden" name="id" value="${goalProgress.goal.id}">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="addGoal.jsp">Add Another Goal</a>
    <a href="dashboard">Back to Home</a>
</body>
</html>
