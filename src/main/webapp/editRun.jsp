
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MileMarker - Edit Run</title>
</head>
<body>

  <h1>Edit Run</h1>

  <form action="editRun" method="post">

    <input type="hidden" name="id" value="${run.id}">

    <label for="runDate">Date:</label>
    <input type="date" id="runDate" name="runDate" value="${run.runDate}" required>
    <br>

    <label for="distance">Distance:</label>
    <input type="number" id="distance" name="distance" value="${run.distance}" step="0.01" required>
    <br>

    <label for="duration">Duration</label>
    <input type="number" id="duration" name="duration" value="${run.duration}" required>
    <br>

    <label for="notes">Notes</label>
    <input type="text" id="notes" name="notes" value="${run.notes}">
    <br>

    <button type="submit">Save Changes</button>

  </form>

  <a href="viewRuns">Cancel</a>
</body>
</html>
