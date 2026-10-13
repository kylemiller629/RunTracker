<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>MileMarker - Edit Goal</title>
</head>
<body>
    <c:import url="header.jsp" />
    <h1>Edit Goal</h1>

    <form action="editGoal" method="post">

        <input type="hidden" name="id" value="${goal.id}">




        <button type="submit">Save Changes</button>

    </form>

    <a href="viewGoals">Cancel</a>
</body>
</html>
