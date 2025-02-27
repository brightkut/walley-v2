# Walley V2 - Personal Finance Management Bot

Walley V2 is a personal finance management application designed to interact with users through the LINE messaging platform. It allows users to track their expenses, view their wallet balance, and manage their spending habits.

## Overview

This project uses Spring Boot and is built to be deployed as a serverless application on AWS Lambda. It leverages the LINE Messaging API to provide a conversational interface for managing personal finances.

## Features

*   **Health Check Endpoint:** Provides a `/health` endpoint to verify the application's status.
*   **LINE Webhook Integration:** Handles incoming messages from LINE users via a webhook.
*   **Basic Messaging:** Currently, the bot can receive messages from LINE and reply with a static "originalMessageText".
* **Basic Menu** Able to understand which function the user would like to use from these values `VIEW_WALLET`, `UPDATE_WALLET`, `SUMMARIZE_WALLET`, `UPDATE_WALLET_BY_BILL`

## Architecture

*   **Spring Boot:**  The core of the application, providing dependency injection, web services, and other enterprise features.
*   **AWS Lambda:** The serverless compute platform where the application runs.
*   **LINE Messaging API:** Used for communication with users through the LINE messaging app.
* **Line Webhook** used for receiving information from line.
* **Line Message API** used for sending information back to the user.
*   **Model Classes:**
    *   `LineWebhookDto`: Represents the payload received from LINE's webhook.
    *   `Event`: Represents a single event in the webhook payload (e.g., a user sending a message).
    *   `Message`: Represents the content of a message sent by a user.
    *   `Source`: Information about the source of the event (e.g., user or group).
    *   `DeliveryContext`: Information about redelivery.
*   **Controller Classes:**
    *   `HealthController`: Handles health check requests to `/health`.
    *   `LineWebhookController`: Handles incoming webhook events from LINE at `/webhooks`.
* **Constant Classes:**
    * `LineConstant`: store the constant of line service.

## Setup and Installation

1.  **Prerequisites:**
    *   Java Development Kit (JDK) 11 or higher.
    *   Maven.
    *   AWS Account (for deployment to AWS Lambda).
    *   LINE Developers Account (for LINE Messaging API integration).
    * line bot config that will generate channel secret and channel access token.
    * Configure the `application.yml` file with line channel secret and channel access token.

2.  **Build the Project:**
    ```bash
    mvn clean install
    ```

3.  **Local Testing (Optional):**
    *   You can run the application locally using Spring Boot:
        ```bash
        mvn spring-boot:run
        ```
    *   Note that local testing will not simulate the AWS Lambda environment.
    *   You will not be able to test LINE webhook integration directly without using a tool like ngrok to expose your local port to the internet.

4.  **Deployment to AWS Lambda:**
    *   Package the application as a JAR file (using `mvn clean install`).
    *   Create a new Lambda function in the AWS console.
    *   Set the handler to `com.brightkut.walley_v2.LambdaHandler::handleRequest`.
    *   Upload the JAR file as the function's code.
    *   Configure the necessary environment variables and permissions for your Lambda function.
    *   create api gateway trigger with any method for this line webhook.
    * The api gateway url will be use for webhook url on the line bot configuration.
    * line webhook is using `POST` method.

5.  **Configure LINE Channel:**
    *   In your LINE Developers Console, configure the webhook URL to point to your deployed Lambda function's API Gateway endpoint.
    *   Enable the "Use webhook" setting.

## Usage

1.  **Health Check:**
    *   Send a GET request to `/health` (e.g., `https://<your-api-gateway-endpoint>/health`) to check if the server is running.
    * It will return status code `200` if the server is healthy.
    * Response body will be : `"Server is healthy and running."`

2.  **LINE Webhook:**
    *   Once deployed, users can interact with your bot by messaging it on LINE.
    * The current implementation will echo the static message back to the user.
    * To use `LineWebhookController` you will need to send a `POST` request to `/webhooks`.

## Project Structure

