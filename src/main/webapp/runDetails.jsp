<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Run Details" scope="request" />

<html>

<c:import url="head.jsp" />

<body data-bs-theme="dark">

<c:import url="header.jsp" />

    <main class="container my-5">

        <div class="mb-4 text-center">
            <h1 class="fw-bold">Run Details</h1>
            <p class="text-muted">Every mile tells a story. Here's yours.</p>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card shadow-sm">
                    <div class="card-body p-4">

                        <h3 class="mb-4">Run Summary</h3>

                        <div class="row g-3 mb-4">

                            <div class="col-6">
                                <div class="card h-100">
                                    <div class="card-body text-center">
                                        <h6 class="text-muted">Distance</h6>
                                        <h2 class="fw-bold text-primary">${run.distance}</h2>
                                        <small class="text-muted">miles</small>
                                    </div>
                                </div>
                            </div>

                            <div class="col-6">
                                <div class="card h-100">
                                    <div class="card-body text-center">
                                        <h6 class="text-muted">Duration</h6>
                                        <h2 class="fw-bold text-primary">${run.duration}</h2>
                                        <small class="text-muted">seconds</small>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="mb-3">
                            <h6 class="text-muted">Run Date</h6>
                            <p>${run.runDate}</p>
                        </div>

                        <div class="mb-3">
                            <h6 class="text-muted">Average Pace</h6>
                            <p>${run.pace} /mi</p>
                        </div>

                        <div class="mb-4">
                            <h6 class="text-muted">Notes</h6>
                            <p>${run.notes}</p>
                        </div>

                        <div class="d-flex justify-content-center gap-2">
                            <a href="editRun?id=${run.id}" class="btn btn-primary">Edit Run</a>
                            <a href="viewRuns" class="btn btn-outline-light">Back to Runs</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </main>

<c:import url="scripts.jsp" />

</body>
</html>
