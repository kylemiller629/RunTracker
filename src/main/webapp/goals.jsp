<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="My Goals" scope="request" />

<html>

<c:import url="head.jsp" />

<body data-bs-theme="dark">

<c:import url="header.jsp" />

    <main class="container my-4">

        <h1 class="fw-bold mb-2">My Running Goals</h1>
        <p class="text-muted mb-4">Set your goals. Track your progress. Keep moving forward.</p>

        <div class="card shadow-sm mb-4">
            <div class="card-body p-4">

                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h2 class="mb-0">Goal Progress</h2>
                    <a href="addGoal.jsp" class="btn btn-primary">Add Goal</a>
                </div>

                <div class="table-responsive">
                    <table class="table table-striped table-hover align-middle">

                        <thead>
                        <tr>
                            <th>Goal Type</th>
                            <th>Target</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Miles Completed</th>
                            <th>Progress</th>
                            <th>Actions</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="goalProgress" items="${user.goalProgressList}">
                            <tr>
                                <td>${goalProgress.goal.goalType}</td>
                                <td>${goalProgress.goal.target} miles</td>
                                <td>${goalProgress.goal.startDate}</td>
                                <td>${goalProgress.goal.endDate}</td>
                                <td>${goalProgress.progress} miles</td>

                                <td>
                                    <div class="progress mb-2" role="progressbar"
                                         aria-label="Goal progress"
                                         aria-valuenow="${goalProgress.percentage}"
                                         aria-valuemin="0"
                                         aria-valuemax="100">
                                        <div class="progress-bar" style="width: ${goalProgress.percentage}%"></div>
                                    </div>
                                        ${goalProgress.percentage}%
                                </td>

                                <td>
                                    <div class="d-flex gap-2">

                                        <a href="editGoal?id=${goalProgress.goal.id}" class="btn btn-sm btn-outline-light">Edit</a>

                                        <form action="deleteGoal" method="post" class="m-0"
                                              onsubmit="return confirm('Are you sure you want to delete?');">
                                            <input type="hidden" name="id" value="${goalProgress.goal.id}">
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

        <a href="dashboard" class="btn btn-outline-light">Back to Home</a>

    </main>

</body>
</html>

