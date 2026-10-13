<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>MileMarker</title>
</head>
<body>

    <c:import url="header.jsp" />

    <main>
        <h2>Welcome to MileMarker, ${sessionScope.userName}!</h2>
        <p>Track your miles! Reach your goals!</p>

        <c:if test="${not empty sessionScope.userId}">
            <h3>Running Summary</h3>

            <p>Total Runs: ${totalRuns}</p>
            <p>Total Distance: ${totalDistance} miles</p>

            <h3>Recent Runs</h3>

            <table>
                <tr>
                    <th>Date</th>
                    <th>Distance</th>
                    <th>Duration</th>
                    <th>Pace</th>
                    <th>Notes</th>
                </tr>

                <c:forEach var="run" items="${recentRuns}">
                    <tr>
                        <td>${run.runDate}</td>
                        <td>${run.distance}</td>
                        <td>${run.duration}</td>
                        <td>${run.pace}</td>
                        <td>${run.notes}</td>
                    </tr>
                </c:forEach>
            </table>

            <h3>My Running Goals</h3>
                <table>
                    <tr>
                        <th>Goal Type</th>
                        <th>Target</th>
                        <th>Miles Complete</th>
                        <th>Progress</th>
                    </tr>

                    <c:forEach var="goal" items="${goals}">
                        <tr>
                            <td>${goal.goalType}</td>
                            <td>${goal.target} miles</td>
                            <td>${progressMap[goal.id]} miles</td>
                            <td>
                                <progress value="${percentMap[goal.id]}" max="100"></progress>
                                ${percentMap[goal.id]}%
                            </td>
                        </tr>
                    </c:forEach>
                </table>
        </c:if>

    </main>

</body>
</html>
