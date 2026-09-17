Binary Calculator Web Application

A containerized Java web application that performs binary arithmetic and uses MySQL for relational data storage. This project gave me hands-on experience taking a web application from development through containerization and deployment on Google Cloud.

Tech Stack

* Java & Maven — application development and build management
* MySQL — relational database
* Docker — application containerization
* Kubernetes — container orchestration and deployment
* Google Kubernetes Engine (GKE) — cloud deployment
* Google Cloud Artifact Registry — Docker image storage
* Git & GitHub — version control

What I Built

I developed and deployed the Binary Calculator web application as part of my Software Engineering coursework at Ontario Tech University. My work included:

* Building and packaging the Java web application with Maven.
* Connecting the application to a MySQL database.
* Containerizing the application with Docker.
* Creating Kubernetes deployment and service configurations for the application and database.
* Publishing the application image to Google Cloud Artifact Registry.
* Deploying the application and MySQL service to Google Kubernetes Engine.
* Troubleshooting deployment and configuration issues using Kubernetes commands and container logs.

Deployment Architecture

The application is packaged as a Docker image and deployed to a Kubernetes cluster on GKE. A Kubernetes service exposes the web application, while MySQL runs as a separate deployment and service for relational data storage.

User
  |
  v
LoadBalancer Service
  |
  v
Binary Calculator Application
(Java / Docker / Kubernetes)
  |
  v
MySQL Service
  |
  v
MySQL Database
Docker Image -> Google Cloud Artifact Registry -> GKE

What I Learned

This project helped me understand the full path from application code to a running cloud deployment. In particular, I gained practical experience with containerization, Kubernetes deployments and services, relational databases, cloud infrastructure, application logs, and debugging configuration problems.

It also reinforced the importance of making deployment steps repeatable rather than relying on manual configuration.

Repository Structure

* BinaryCalculatorWebapp/ — Java/Maven web application and container configuration
* MySQL/ — Kubernetes configuration for the MySQL deployment and service
* figures/ — screenshots and supporting project material

About

Academic software engineering project completed at Ontario Tech University. This repository documents my implementation and cloud deployment work for the Binary Calculator application.
