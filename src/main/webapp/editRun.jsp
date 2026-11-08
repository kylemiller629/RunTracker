<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Edit Run" scope="request" />

<html>

<c:import url="head.jsp" />

<body data-bs-theme="dark">

<c:import url="header.jsp" />

  <main class="container my-5">

    <div class="mb-4 text-center">
      <h1 class="fw-bold">Edit Run</h1>
      <p class="text-muted">Update your run details. Keep your progress accurate.</p>
    </div>

    <div class="row justify-content-center">
      <div class="col-md-8 col-lg-6">
        <div class="card shadow-sm">
          <div class="card-body p-4">

            <h3 class="mb-4">Run Details</h3>

            <form action="editRun" method="post">

              <input type="hidden" name="id" value="${run.id}">

              <div class="mb-3">
                <label for="runDate" class="form-label">Run Date</label>
                <input type="date" class="form-control" id="runDate" name="runDate" value="${run.runDate}" required>
              </div>

              <div class="mb-3">
                <label for="distance" class="form-label">Distance (miles)</label>
                <input type="number" class="form-control" id="distance" name="distance" value="${run.distance}" step="0.01" required>
              </div>

              <div class="mb-3">
                <label for="duration" class="form-label">Duration (minutes)</label>
                <input type="number" class="form-control" id="duration" name="duration" value="${run.duration}" required>
              </div>

              <div class="mb-4">
                <label for="notes" class="form-label">Notes</label>
                <input type="text" class="form-control" id="notes" name="notes" value="${run.notes}" placeholder="How did your run feel?">
              </div>

              <div class="d-flex justify-content-center gap-2">
                <button type="submit" class="btn btn-primary">Save Changes</button>
                <a href="viewRuns" class="btn btn-outline-light">Cancel</a>
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
