<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Home" scope="request" />

<html>

<c:import url="head.jsp" />

<body class="dark">

    <c:import url="header.jsp" />

    <main class="container my-5">

        <div class="mb-4">
            <h2 class="fw-bold">Every Mile Counts.</h2>
            <p class="text-muted">Track your progress. Push your limits.</p>
        </div>

        <c:if test="${not empty sessionScope.userId}">

            <h3 class="mb-3">Running Summary</h3>
            <div class="row g-3 mb-5">
                <div class="col-md-6">
                    <div class="card shadow-sm border-0 h-100">
                        <div class="card-body p-4">
                            <h5 class="text-muted">Total Runs</h5>
                            <h2 class="fw-bold text-primary">${user.runs.size()}</h2>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card shadow-sm border-0 h-100">
                        <div class="card-body p-4">

                            <h3 class="text-muted">Total Distance</h3>

                            <h2 class="fw-bold text-primary">${user.totalDistance} <small class="fs-6 text-muted">miles</small></h2>

                        </div>
                    </div>
                </div>
            </div>
            <div class="card shadow-sm border-0 mb-5">
                <div class="card-body p-4">
                    <h3 class="mb-3">Check Weather</h3>

                    <form action="${pageContext.request.contextPath}/dashboard" method="get">

                        <div class="mb-3">
                            <label for="zipCode" class="form-label">Enter ZIP Code:</label>

                            <input type="text"
                                   class="form-control"
                                   id="zipCode"
                                   name="zipCode"
                                   placeholder="Enter ZIP code"
                                   maxlength="5"
                                   pattern="[0-9]{5}"
                                   required>
                        </div>
                        <button type="submit" class="btn btn-primary">Get Weather</button>

                    </form>

                    <c:if test="${not empty weatherError}">
                        <div class="alert alert-warning mt-3">${weatherError}</div>
                    </c:if>

                    <c:if test="${not empty weather}">
                        <div class="mt-4">
                            <h4>Current Weather -${location.placeName}, ${location.adminCode1}</h4>

                            <p class="mb-1">Temperature: ${weather.current.temperature2m} °F</p>

                            <p>Wind Speed: ${weather.current.windSpeed10m} mph</p>
                        </div>
                    </c:if>

                </div>
            </div>

            <div class="card shadow-sm border-0 mb-5">
                <div class="card-body p-4">

                    <h3 class="mb-3">Recent Runs</h3>

                    <div class="table-responsive">
                        <table class="table table-striped table-hover">

                            <thead>
                            <tr>
                                <th>Date</th>
                                <th>Distance</th>
                                <th>Duration</th>
                                <th>Pace</th>
                                <th>Notes</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="run" items="${user.recentRuns}">
                                <tr>
                                    <td>${run.runDate}</td>
                                    <td>${run.distance}</td>
                                    <td>${run.duration}</td>
                                    <td>${run.pace}</td>
                                    <td>${run.notes}</td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>

                </div>
            </div>
            <div class="card shadow-sm border-0 mb-5">
                <div class="card-body p-4">

                    <h3 class="mb-3">My Running Goals</h3>

                    <div class="table-responsive">
                        <table class="table table-striped table-hover">

                            <thead>
                            <tr>
                                <th>Goal Type</th>
                                <th>Target</th>
                                <th>Miles Complete</th>
                                <th>Progress</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="goalProgress" items="${user.goalProgressList}">

                                <tr>
                                    <td>${goalProgress.goal.goalType}</td>

                                    <td>${goalProgress.goal.target} miles</td>

                                    <td>${goalProgress.progress} miles</td>

                                    <td>
                                        <div class="progress mb-2"
                                             role="progressbar"
                                             aria-label="Goal progress"
                                             aria-valuenow="${goalProgress.percentage}"
                                             aria-valuemin="0"
                                             aria-valuemax="100">
                                            <div class="progress-bar" style="width: ${goalProgress.percentage}%"></div>
                                        </div>

                                            ${goalProgress.percentage}%
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:if>
    </main>

</body>
</html>

