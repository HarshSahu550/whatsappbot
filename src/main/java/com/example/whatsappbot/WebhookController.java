package com.example.whatsappbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping("/webhook")
    public ResponseEntity<Reply> handleMessage(@RequestBody WhatsAppMessage incoming) {
        // Log the incoming message
        logger.info("Received message from {}: {}", incoming.getFrom(), incoming.getMessage());

        // replies
        String replyText;
        String msg = incoming.getMessage();
        if (msg == null) {
            replyText = "I didn't understand that.";
        } else {
            switch (msg.trim().toLowerCase()) {
                case "hi":
                    replyText = "Hello";
                    break;
                case "bye":
                    replyText = "Goodbye";
                    break;
                default:
                    replyText = "I only respond to Hi or Bye.";
            }
        }

        Reply reply = new Reply(replyText);
        logger.info("Sending reply: {}", replyText);
        return ResponseEntity.ok(reply);
    }
}