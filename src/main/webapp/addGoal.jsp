<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Add Goal" scope="request" />

<html>

<c:import url="head.jsp" />

<body data-bs-theme="dark">

<c:import url="header.jsp" />

  <main class="container my-5">

    <div class="mb-4 text-center">

      <h1 class="fw-bold">Set a Running Goal</h1>
      <p class="text-muted">Set your target. Stay consistent. Track your progress.</p>

    </div>

    <div class="row justify-content-center">
      <div class="col-md-8 col-lg-6">
        <div class="card shadow-sm">
          <div class="card-body p-4">

            <h3 class="mb-4">Goal Details</h3>

            <form action="addGoal" method="post">

              <div class="mb-3">
                <label for="goalType" class="form-label">Goal Type</label>
                <select id="goalType" name="goalType" class="form-select" required>
                  <option value="Weekly Distance">Weekly Distance</option>
                  <option value="Monthly Distance">Monthly Distance</option>
                </select>
              </div>

              <div class="mb-3">
                <label for="target" class="form-label">Target Distance (miles)</label>
                <input type="number" class="form-control" id="target" name="target" step="0.1" min="0.1" required>
              </div>

              <div class="mb-3">
                <label for="startDate" class="form-label">Start Date</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
              </div>

              <div class="mb-4">
                <label for="endDate" class="form-label">End Date</label>
                <input type="date" class="form-control" id="endDate" name="endDate" required>
              </div>

              <div class="d-flex justify-content-center gap-2">
                <button type="submit" class="btn btn-primary">Save Goal</button>
                <a href="home" class="btn btn-outline-light">Back to Home</a>
              </div>

            </form>

          </div>
        </div>
      </div>
    </div>
  </main>
<c:import url="scripts.jsp" />
</body>
</html>
