<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MileMarker</title>
</head>
<body>

    <c:import url="header.jsp" />

    <main>
        <h2>Welcome to MileMarker</h2>
        <p>Track your miles! Reach your goals!</p>

        <h3>Running Summary</h3>

        <p>Total Runs: ${totalRuns}</p>
        <p>Total Distance: ${totalDistance} miles</p>
    </main>

</body>
</html>
