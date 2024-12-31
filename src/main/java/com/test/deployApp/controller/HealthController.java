package com.test.deployApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    static class SuccessResponse {
        private String message;
        private boolean success;

        public SuccessResponse(String message, boolean success) {
            this.message = message;
            this.success = success;
        }

        // Getters and setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    @GetMapping("/success")
    public SuccessResponse getSuccessResponse() {
        return new SuccessResponse("Operation completed successfully", true);
    }
}
