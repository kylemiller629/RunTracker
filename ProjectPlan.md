# Project Plan

### Week 2
- [X] Create project repository on GitHub
- [X] Create project structure in IntelliJ and push
- [X] Add link to list of indie projects in student repo
- [X] Weekly reflection/time log


### Week 3 - Project Planning
- [ ] Research possible Web Services/APIs to use
- [ ] List technologies, versions, and how they will be used
- [X] Write project plan
- [X] Document user stories and select MVP stories
- [ ] Confirm MVP stories meet Enterprise Java indie project objectives
- [ ] Design screens and make sure all MVP user stories are covered
- [X] Triple-check for Checkpoint 1
- [X] Update journal/time log/reflection


### Week 4 - Hibernate
#### This week's focus is the Add Run and View Runs user stories

- [X] Create first database design
- [X] Create development version of the database
- [X] Create Run entity
- [X] Create DAO for Run
- [X] Implement CRUD operations in Run DAO
- [X] Create database configuration files for development and testing
- [X] Create test database for unit testing
- [X] Create unit tests for Run DAO
- [X] Update weekly reflection


### Week 5 - One-to-Many Relationships
#### This week's focus is the User entity and connecting users to runs and goals

- [X] Create User table
- [X] Create User entity
- [X] Create UserDao
- [X] Create User-to-Run one-to-many relationship
- [X] Create Goal table
- [X] Create Goal entity
- [X] Create GoalDao
- [X] Create User-to-Goal one-to-many relationship
- [X] Create unit tests for UserDao
- [X] Create unit tests for GoalDao
- [X] Test User-to-Run relationship
- [X] Test User-to-Goal relationship
- [X] Verify deleting a User deletes associated Runs and Goals
- [X] Verify deleting a Run does not delete its User
- [X] Run tests and review test coverage
- [X] Update weekly reflection


### Week 6 - Run Web Management and AWS Setup
#### Focus: Build the run management interface and begin AWS deployment.

- [X] Create ViewRuns controller
- [X] Create JSP for viewing runs
- [X] Display runs from the database on the Runs page
- [X] Create AddRun controller
- [X] Create JSP form for adding a run
- [X] Insert runs submitted from the form into the database
- [X] Redirect to View Runs after adding a run
- [X] Create basic MileMarker homepage
- [X] Create reusable header/navigation JSP
- [X] Calculate and display running pace
- [X] Create AWS Elastic Beanstalk environment
- [X] Update weekly reflection


### Week 7 - Authentication, Goals, and Checkpoint 2
#### Focus: Integrate Cognito, complete goal management, and verify database functionality.
- [X] Configure AWS Cognito authentication
- [X] Implement Cognito sign-in
- [X] Connect authenticated users to MySQL user records
- [X] Implement CRUD for goals
- [X] Calculate running goal progress
- [X] Display goals on dashboard
- [X] Display total runs and total distance on dashboard
- [] Submit Checkpoint 2
- [X] Update weekly reflection


### Week 8 - Web Services/API
#### Focus: Research weather APIs and begin integration

- [ ] Research at least two possible weather APIs
- [ ] Compare weather APIs and determine which best fits MileMarker
- [ ] Select weather API
- [ ] Complete class web service/API exercise
- [ ] Connect MileMarker to selected weather API
- [ ] Retrieve weather data for runs
- [ ] Display weather information for a run
- [ ] Test weather API functionality
- [ ] Sign up for team project
- [ ] Update weekly reflection


### Week 9 - RESTful Web Services and Checkpoint 3
#### Focus: Complete weather API functionality and prepare the deployed application

- [ ] Complete weather API functionality 
- [ ] Display weather information for runs
- [ ] Test functionality 
- [ ] Review authentication
- [ ] Configure production
- [ ] Deploy updated MileMarker application to AWS
- [ ] Test application authentication and database connectivity on AWS
- [ ] Submit Checkpoint 3
- [ ] Update weekly reflection


### Week 10 - Dashboard and User Interface
#### Focus: Improve application appearance and usability

- [ ] Add CSS styling (probably Bootstrap styling)
- [ ] Improve dashboard layout and running summary
- [ ] Display active goals on the dashboard
- [ ] Improve Runs page
- [ ] Improve Goals page
- [ ] Style forms, tables, navigation, and buttons
- [ ] Add form validation where needed
- [ ] Test application workflow from sign-in through run and goal management
- [ ] Fix bugs discovered during testing
- [ ] Update weekly reflection


### Week 11 - Testing and MVP Completion
#### Focus: Complete remaining MVP features and strengthen testing.

- [ ] Review all MVP user stories
- [ ] Review JUnit test coverage
- [ ] Add missing unit tests
- [ ] Verify Log4J2 logging
- [ ] Test CRUD functionality
- [ ] Test one-to-many relationships
- [ ] Test weather API functionality
- [ ] Test authentication
- [ ] Test deployed AWS application
- [ ] Review application for usability issues
- [ ] Fix remaining bugs
- [ ] Update project documentation
- [ ] Update weekly reflection


### Week 12 - Team Project Presentations
#### Focus: Prioritize team project deliverables and maintain MileMarker.

- [ ] Complete team project deliverables
- [ ] Complete professional development presentation
- [ ] Update weekly reflection/time log

### Week 13 - Asynchronous Messaging and Documentation 
#### Focus: Complete course activities and improve project documentation

- [ ] Review asynchronous messaging concepts
- [ ] Update MileMarker README
- [ ] Document application features and technologies
- [ ] Document database relationships
- [ ] Review deployment instructions
- [ ] Update weekly reflection/time log

### Week 14 - Individual Project Code Review 
#### Focus: Review project quality and incorporate peer feedback 

- [ ] Prepare MileMarker for peer code review
- [ ] Participate in individual project code review 
- [ ] Provide peer code review feedback
- [ ] Review feedback
- [ ] Update weekly reflection/time log

### Week 15 - Final Testing and Presentation Preparation
#### Focus: Finalizw the application before presentation week.

- [ ] Verify all project requirements are met
- [ ] Verify all MVP user stories are complete
- [ ] Test full application flow
- [ ] Verify AWS deployment and production database
- [ ] Test Cognito authentication in deployed application
- [ ] Test weather API
- [ ] Complete final UI improvements
- [ ] Prepare presentation
- [ ] Update weekly reflection/time log

### Week 16 - Final Presentation Submission
#### Focus: Present and submit the completed MileMarker application.
- [ ] Run final application tests
- [ ] Verify deployed application is working
- [ ] Verify GitHub repository is up to date
- [ ] Complete final presentation
- [ ] Submit project by December 16 at 9 p.m.
- [ ] Complete final reflection/time log