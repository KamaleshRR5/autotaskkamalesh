# Star Wars Test Automation

## Requirements
* Java Development Kit
* Maven

## Running Tests
$ mvn clean install -Dcucumber.filter.tags="@scenarioName"
```

Automationtask
This repo will have automation scripts created for UI and API tasks

To run the tasks, please specify required tag in the runner file

ChromeDriver path is defined as 'C:\Driver\chromedriverexe'

UI - When the Starwars application is available in local host after successful build, use tag '@starwars' in the TestRunner file
API - To execute API task, please use the tag '@api'
Used console to display the results