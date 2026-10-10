<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MileMarker - Runs</title>
</head>
<body>

    <h1>My Runs</h1>

    <h2>Running Summary</h2>

    <p>Total Runs: ${totalRuns}</p>
    <p>Total Distance: ${totalDistance}</p>

        <table>
            <tr>
                <th>Date</th>
                <th>Distance</th>
                <th>Duration</th>
                <th>Pace</th>
                <th>Notes</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="run" items="${runs}">
                <tr>
                    <td>${run.runDate}</td>
                    <td>${run.distance}</td>
                    <td>${run.duration}</td>
                    <td>${run.pace} /mi</td>
                    <td>${run.notes}</td>
                    <td>
                        <a href="runDetails?id=${run.id}">Details</a>
                        <a href="editRun?id=${run.id}">Edit</a>
                        <form action="deleteRun" method="post" onsubmit="return confirm('Are you sure you want to delete this run?')">
                            <input type="hidden" name="id" value="${run.id}">
                            <button type="submit">Delete</button>

                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>
</body>
</html>
