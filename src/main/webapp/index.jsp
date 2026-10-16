<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Home" scope="request" />

<html>

<c:import url="head.jsp" />

<body>

    <c:import url="header.jsp" />

    <main>
        <h2>Welcome to MileMarker, ${sessionScope.userName}!</h2>
        <p>Track your miles! Reach your goals!</p>

        <c:if test="${not empty sessionScope.userId}">
            <h3>Running Summary</h3>

            <p>Total Runs: ${user.runs.size()}</p>
            <p>Total Distance: ${user.totalDistance} miles</p>

            <h3>Recent Runs</h3>

            <table>
                <tr>
                    <th>Date</th>
                    <th>Distance</th>
                    <th>Duration</th>
                    <th>Pace</th>
                    <th>Notes</th>
                </tr>

                <c:forEach var="run" items="${user.recentRuns}">
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

                    <c:forEach var="goalProgress" items="${user.goalProgressList}">
                        <tr>
                            <td>${goalProgress.goal.goalType}</td>
                            <td>${goalProgress.goal.target} miles</td>
                            <td>${goalProgress.progress} miles</td>
                            <td>
                                <progress value="${goalProgress.percentage}" max="100"></progress>
                                ${goalProgress.percentage}%
                            </td>
                        </tr>
                    </c:forEach>
                </table>
        </c:if>

    </main>

</body>
</html>
