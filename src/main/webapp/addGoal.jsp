
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MileMarker - Add Goal</title>
</head>
<body>
  <h1>Add Running Goal</h1>
  <form action="addGoal" method="post">

    <label for="goalType">Goal Type:</label>
    <select id="goalType" name="goalType" required>
      <option value="Weekly Distance">Weekly Distance</option>
      <option value="Monthly Distance">Monthly Distance</option>
    </select>
    <br><br>

    <label for="target">Target Distance (miles):</label>
    <input type="number" id="target" name="target" step="0.1" min="0.1" required>
    <br><br>

    <label for="startDate">Start Date:</label>
    <input type="date" id="startDate" name="startDate" required>
    <br><br>

    <label for="endDate">End Date:</label>
    <input type="date" id="endDate" name="endDate" required>
    <br><br>

    <button type="submit">Add Goal</button>
  </form>

  <a href="home">Back to Home</a>

</body>
</html>
