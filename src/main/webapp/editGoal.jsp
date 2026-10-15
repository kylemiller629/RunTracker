<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Edit Goal" scope="request" />

<html>

<c:import url="head.jsp" />

<body>
    <c:import url="header.jsp" />
    <h1>Edit Goal</h1>

    <form action="editGoal" method="post">

        <input type="hidden" name="id" value="${goal.id}">

        <label for="goalType">Goal Type:</label>
        <select id="goalType" name="goalType" required>
            <option value="Weekly Distance" ${goal.goalType == 'Weekly Distance' ? 'selected' : ''}>Weekly Distance</option>

            <option value="Monthly Distance" ${goal.goalType == 'Monthly Distance' ? 'selected' : ''}>Monthly Distance</option>

        </select>
        <br>

        <label for="target">Target Distance (miles):</label>
        <input type="number" id="target" name="target" value="${goal.target}" step="0.1" min="0.1" required>
        <br>

        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" value="${goal.startDate}" required>
        <br>

        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" value="${goal.endDate}" required>
        <br>

        <button type="submit">Save Changes</button>

    </form>

    <a href="viewGoals">Cancel</a>
</body>
</html>
