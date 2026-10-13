<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>MileMarker - Run Details</title>
</head>
<body>
    <c:import url="header.jsp" />
    <h1>Run Details</h1>

    <p>Date: ${run.runDate}</p>
    <p>Distance: ${run.distance} miles</p>
    <p>Duration: ${run.duration} seconds</p>
    <p>Average Pace: ${run.pace} /mi</p>
    <p>Notes: ${run.notes}</p>

    <a href="editRun?id=${run.id}">Edit Run</a>
    <a href="viewRuns">Back to Runs</a>
</body>
</html>
