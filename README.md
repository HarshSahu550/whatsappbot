# 🤖 WhatsApp Bot — Spring Boot

A simple WhatsApp Webhook Bot built with **Spring Boot** that listens for incoming messages and responds with predefined replies.

---

## 📌 Project Overview

This project exposes a REST API endpoint (`/webhook`) that acts as a WhatsApp message handler. When a message is received, the bot processes it and returns an automated reply based on the content.

---

## 🚀 Features

- Receives incoming WhatsApp messages via HTTP POST
- Logs all incoming messages and replies using SLF4J
- Responds intelligently based on message content:
  - `hi` → `Hello`
  - `bye` → `Goodbye`
  - anything else → `I only respond to Hi or Bye.`
- Built on Spring Boot 3.5.14 with Java 20

---

## 🛠️ Tech Stack

| Technology       | Version     |
|------------------|-------------|
| Java             | 20          |
| Spring Boot      | 3.5.14      |
| Spring Web       | Included    |
| Maven            | Build Tool  |
| SLF4J            | Logging     |

---

## 📁 Project Structure

```
whatsappbot/
├── src/
│   └── main/
│       ├── java/com/example/whatsappbot/
│       │   ├── WhatsappbotApplication.java   # Main entry point
│       │   ├── WebhookController.java        # REST Controller (POST /webhook)
│       │   ├── WhatsAppMessage.java          # Request model
│       │   └── Reply.java                    # Response model
│       └── resources/
│           └── application.properties        # App config
├── pom.xml
└── README.md
```

---

## 📡 API Endpoint

### `POST /webhook`

**Request Body:**
```json
{
  "from": "919876543210",
  "message": "hi"
}
```

**Response:**
```json
{
  "reply": "Hello"
}
```

---

## ⚙️ How to Run

### Prerequisites
- Java 20+
- Maven 3.6+

### Steps

```bash
# Clone the repository
git clone https://github.com/HarshSahu550/whatsappbot.git

# Navigate into the project
cd whatsappbot

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The server starts at: `http://localhost:8080`

---

## 🧪 Test the API

Using **curl**:
```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"from": "919999999999", "message": "hi"}'
```

Using **Postman**:
- Method: `POST`
- URL: `http://localhost:8080/webhook`
- Body (JSON): `{ "from": "919999999999", "message": "hi" }`

---

## 👨‍💻 Author

**Harsh Sahu**
- GitHub: [@HarshSahu550](https://github.com/HarshSahu550)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).