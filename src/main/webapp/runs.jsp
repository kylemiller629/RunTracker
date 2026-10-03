
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MileMarker - Runs</title>
</head>
<body>

    <h1>My Runs</h1>
        <table>
            <tr>
                <th>Date</th>
                <th>Distance</th>
                <th>Duration</th>
                <th>Notes</th>
            </tr>

            <c:forEach var="run" items="${runs}">
                <tr>
                    <td>${run.runDate}</td>
                    <td>${run.distance}</td>
                    <td>${run.duration}</td>
                    <td>${run.notes}</td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
