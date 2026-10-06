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


### Week 6 - Run Web Functionality
#### This week's focus is completing the Run user story from the database to the web application

- [X] Create ViewRuns controller
- [X] Create JSP for viewing runs
- [X] Display runs from the database on the Runs page
- [X] Create AddRun controller
- [X] Create JSP form for adding a run
- [X] Insert runs submitted from the form into the database
- [X] Redirect to View Runs after adding a run
- [X] Create basic MileMarker homepage
- [X] Create reusable header/navigation JSP
- [ ] Add edit run functionality
- [ ] Add delete run functionality
- [ ] Add run details page
- [ ] Add run search functionality
- [ ] Update weekly reflection


### Week 7 - Goals and Running Statistics
#### This week's focus is adding goal functionality and running statistics

- [ ] Create JSP for adding a running goal
- [ ] Create controller for adding a running goal
- [ ] Create JSP for viewing running goals
- [ ] Create controller for viewing running goals
- [ ] Display progress toward running goals
- [ ] Calculate pace for a run
- [ ] Display calculated pace
- [ ] Calculate total number of runs
- [ ] Calculate total running distance
- [ ] Display running summary on the homepage/dashboard
- [ ] Update weekly reflection


### Week 8 - Web Services/API
#### This week's focus is selecting and implementing a weather API

- [ ] Research at least two possible weather APIs
- [ ] Compare weather APIs and determine which best fits MileMarker
- [ ] Select weather API
- [ ] Complete class web service/API exercise
- [ ] Connect MileMarker to selected weather API
- [ ] Retrieve weather data for runs
- [ ] Display weather information for a run
- [ ] Add logging and error handling for API requests
- [ ] Test weather API functionality
- [ ] Update weekly reflection


### Week 9 - Authentication and AWS
#### This week's focus is authentication and preparing the application for deployment

- [ ] Configure AWS Cognito
- [ ] Add user sign-up functionality using Cognito
- [ ] Add user sign-in functionality using Cognito
- [ ] Add password reset functionality using Cognito
- [ ] Protect pages that require authentication
- [ ] Connect authenticated users to their MileMarker data
- [ ] Create production MySQL database using Amazon RDS
- [ ] Configure production database connection
- [ ] Create AWS Elastic Beanstalk environment
- [ ] Deploy MileMarker to AWS Elastic Beanstalk
- [ ] Test application with production database
- [ ] Test authentication in deployed application
- [ ] Update weekly reflection


### Week 10 - Complete MVP and User Interface
#### This week's focus is completing remaining MVP functionality

- [ ] Review all MVP user stories
- [ ] Complete any unfinished MVP functionality
- [ ] Add Bootstrap styling
- [ ] Improve homepage/dashboard layout
- [ ] Improve Runs page
- [ ] Improve Goals page
- [ ] Add navigation between application pages
- [ ] Add form validation where needed
- [ ] Test application workflow from sign-in through run and goal management
- [ ] Fix bugs discovered during testing
- [ ] Update weekly reflection


### Week 11 - Testing and Final Improvements
#### This week's focus is testing and preparing MileMarker for final delivery

- [ ] Review JUnit test coverage
- [ ] Add missing unit tests
- [ ] Verify Log4J2 logging
- [ ] Remove any System.out statements
- [ ] Test CRUD functionality
- [ ] Test one-to-many relationships
- [ ] Test weather API functionality
- [ ] Test authentication
- [ ] Test deployed AWS application
- [ ] Review application for usability issues
- [ ] Fix remaining bugs
- [ ] Update project documentation
- [ ] Update weekly reflection


### Week 12 - Final Project Preparation
#### This week's focus is final project review and presentation

- [ ] Verify all required Enterprise Java project objectives are met
- [ ] Verify all MVP user stories are complete
- [ ] Verify MileMarker is deployed and working on AWS
- [ ] Complete final README/documentation
- [ ] Prepare final project presentation
- [ ] Record project demonstration if required
- [ ] Practice demonstrating MileMarker
- [ ] Complete final testing
- [ ] Submit final project
- [ ] Complete final reflection/time log