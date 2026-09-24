# Dawson Soergel's Individual Project

## Problem Statement
For decades, recreational anglers have relied on personal notebooks, 
mental notes, or basic smartphone logs to track their successful fishing 
trips and lure choices. While keeping track of what bait or lure caught 
a specific species of fish is useful, experienced anglers know that 
environmental conditions, such as barometric pressure trends, water clarity, 
ambient temperature, and wind velocity are often the primary drivers of fish 
feeding behavior.

Currently, anglers who want to analyze their catch history against atmospheric 
data must manually look up past weather records or cross-reference separate 
weather apps at the time of their catch. This process is time-consuming, prone 
to missing data, and makes it difficult to spot subtle meteorological patterns 
over time.

The Angler Catch Log & Weather Sync application solves this problem by 
providing a centralized web platform where fishermen can quickly log details 
about their catches. By integrating directly with a real-time meteorological 
API, the application automatically fetches and attaches localized atmospheric 
conditions to each catch entry, enabling anglers to recognize environmental 
patterns and optimize future fishing outings.

## Project Technologies/Techniques

* Security/Authentication
    * AWS Cognito
* Database
  * MySQL 8.x
* ORM Framework
  * Hibernate Version TBD
* Dependency Management
  * Maven
* Web Services consumed using Java
  * TBD
* CSS
  * Bootstrap
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate Validator?
* Logging
  * Log4J2
* Hosting
  * AWS
* Tech I'd like to explore as part of this work
  * OpenWeatherMap Current Weather API
  * Hibernate Validator
  * Hibernate Search
  * Project Lombok
* Unit Testing
  * JUnit tests to cover all testable logic
* IDE: IntelliJ IDEA

## Design

* [User Stories](DesignDocuments/userStories.md)
* [Screen Design](DesignDocuments/Screens.md)

## Time Log

* [Time Log](timeLog.md)