# Project Plan

## Week 2
- [x] Create project repository on GitHub
- [x] Create project structure in IntelliJ and push
- [x] Complete Problem Statement
- [x] Weekly reflection/time log

## Week 3
- [x] Research possible Web Services/APIs to use (OpenWeatherMap API)
- [x] List technologies, versions, and how they will be used
- [x] Document user stories and select MVP stories
- [x] Design screens / wireframes for MVP user stories
- [x] Write project plan
- [ ] Triple-check and submit Checkpoint 1
- [ ] Update journal/time log

## Week 4 - Class topic is Hibernate
### Focus: Database Setup & User Entity DAO
- [ ] Create initial database schema (Users, CatchLogs, Tackle) in MySQL/MariaDB
- [ ] Create `User` entity with Hibernate annotations
- [ ] Create `UserDao` to perform CRUD operations
- [ ] Create Hibernate configuration files and database properties
- [ ] Write JUnit tests for `UserDao` to verify CRUD functionality
- [ ] Update time log

## Week 5 - Class topic is Hibernate One-to-Many
### Focus: Catch Log & Tackle Entities (Relationships)
- [ ] Update database schema to support foreign key relationships
- [ ] Create `CatchLog` entity with One-to-Many / Many-to-One mapping to `User`
- [ ] Create `CatchLogDao` for CRUD operations on catches
- [ ] Write JUnit unit tests for `CatchLogDao` testing relationships
- [ ] Update time log

## Week 6 - Class topic is Code Reviews & AWS Setup
### Focus: AWS Infrastructure Setup & Peer Review 1
- [ ] Complete Code Review 1 with assigned peer group
- [ ] Set up AWS Relational Database Service (RDS) instance
- [ ] Connect local environment and application to AWS RDS
- [ ] Update time log

## Week 7 - Class topic is AWS Cognito Authentication
### Focus: User Security & Deployment
- [ ] Set up AWS Cognito User Pool for user authentication
- [ ] Integrate Cognito login/signup into the web application
- [ ] Create secure session handling for logged-in anglers
- [ ] Deploy initial build to AWS Elastic Beanstalk
- [ ] Complete Checkpoint 2 requirements (Database live on AWS, DAOs fully tested)
- [ ] Update time log

## Week 8 - Class topic is Web Services & REST
### Focus: OpenWeatherMap API Integration
- [ ] Register API key for OpenWeatherMap Current Weather API
- [ ] Create Java client/service to consume OpenWeatherMap REST API
- [ ] Map API JSON response to Java POJOs (using Jackson Databind)
- [ ] Write JUnit tests mocking API responses with Mockito
- [ ] Connect weather fetching logic to catch entry creation flow
- [ ] Update time log

## Week 9 - Class topic is Advanced Servlets & JSP
### Focus: Catch Logging UI & Dashboard
- [ ] Build front-end JSP pages using Bootstrap 5 (Catch Form, Dashboard)
- [ ] Create servlets to handle catch submission and weather auto-population
- [ ] Implement validation on catch input fields
- [ ] Complete Checkpoint 3 requirements (Web service consumed, app partially deployed on AWS)
- [ ] Update time log

## Week 10
### Focus: Search & Filtering Features
- [ ] Create servlet and DAO methods to filter catch logs by lure or species
- [ ] Build search results UI view on dashboard
- [ ] Test end-to-end user flow from login -> create catch -> auto weather -> view/filter log
- [ ] Update time log

## Week 11
### Focus: Independent Research Topic Integration
- [ ] Implement independent topic (e.g., Google Maps / Leaflet location picker or Chart.js visual analytics)
- [ ] Connect interactive UI element to the catch log workflow
- [ ] Update time log

## Week 12
### Focus: Code Review 2 & UI Polish
- [ ] Complete Code Review 2 with assigned peer group
- [ ] Refine Bootstrap UI layouts for responsiveness and usability
- [ ] Conduct error handling and user feedback messaging (e.g., invalid coordinates, API failure fallbacks)
- [ ] Update time log

## Week 13 - Class topic is Asynchronous Messaging
### Focus: Logging, Error Handling & Refactoring
- [ ] Verify Log4J 2 logging across all DAOs, Servlets, and API clients
- [ ] Review code against Java Best Practices and clean up technical debt
- [ ] Ensure full JUnit test suite passes
- [ ] Update time log

## Week 14 - Class topic is Code Reviews
### Focus: Final Deployment & Documentation
- [ ] Complete final AWS Elastic Beanstalk deployment and verify production database connection
- [ ] Complete JavaDoc documentation for key classes
- [ ] Finalize `README.md` with application screenshots, features, and tech stack details
- [ ] Update time log

## Week 15 & 16
### Focus: Final Presentation & Project Submission
- [ ] Record application video demonstration and upload link to `README.md`
- [ ] Present completed project to the class
- [ ] Submit final project deliverables