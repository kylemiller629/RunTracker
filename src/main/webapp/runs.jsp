<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Runs" scope="request" />

<html>

<c:import url="head.jsp" />

<body data-bs-theme="dark">

    <c:import url="header.jsp" />

    <main class="container my-4">

        <h1 class="fw-bold mb-2">My Runs</h1>
        <p class="text-muted mb-4">Every mile counts. Keep pushing forward.</p>


        <h2 class="mb-3">Running Summary</h2>

        <div class="row g-3 mb-5">

            <div class="col-md-6">
                <div class="card shadow-sm h-100">
                    <div class="card-body p-4">

                        <h5 class="text-muted">Total Runs</h5>
                        <h2 class="fw-bold text-primary">${user.runs.size()}</h2>

                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card shadow-sm h-100">
                    <div class="card-body p-4">
                        <h5 class="text-muted">Total Distance</h5>
                        <h2 class="fw-bold text-primary">${user.totalDistance}<small class="fs-6 text-muted">miles</small></h2>
                    </div>
                </div>
            </div>

        </div>

        <div class="card shadow-sm mb-4">
            <div class="card-body p-4">

                <div class="d-flex justify-content-between align-items-center mb-3">

                    <h2 class="mb-0">Running History</h2>
                    <a href="addRun.jsp" class="btn btn-primary">Add Run</a>

                </div>

                <div class="table-responsive">
                    <table class="table table-striped table-hover align-middle">

                        <thead>
                        <tr>
                            <th>Date</th>
                            <th>Distance</th>
                            <th>Duration</th>
                            <th>Pace</th>
                            <th>Notes</th>
                            <th>Actions</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="run" items="${user.runs}">
                            <tr>
                                <td>${run.runDate}</td>
                                <td>${run.distance} mi</td>
                                <td>${run.duration} min</td>
                                <td>${run.pace} /mi</td>
                                <td>${run.notes}</td>

                                <td>
                                    <div class="d-flex gap-2">

                                        <a href="runDetails?id=${run.id}" class="btn btn-sm btn-outline-info">Details</a>
                                        <a href="editRun?id=${run.id}" class="btn btn-sm btn-outline-light">Edit</a>

                                        <form action="deleteRun" method="post" class="m-0" onsubmit="return confirm('Are you sure you want to delete this run?')">

                                            <input type="hidden" name="id" value="${run.id}">

                                            <button type="submit" class="btn btn-sm btn-outline-danger">Delete</button>

                                        </form>

                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>

            </div>
        </div>

    </main>

</body>
</html>

