
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mile Marker - Add Run</title>
</head>

<body>

    <h1>Add Run</h1>

    <form action="addRun" method="post">

        <label for="runDate">Date:</label>
        <input type="date" id="runDate" name="runDate" required>
        <br>

        <label for="distance">Distance:</label>
        <input type="number" id="distance" name="distance" step="0.01" required>
        <br>

        <label for="duration">Duration:</label>
        <input type="number" id="duration" name="duration" required>
        <br>

        <label for="notes">Notes:</label>
        <input type="text" id="notes" name="notes">
        <br>

        <button type="submit">Add Run</button>
    </form>
</body>
</html>
