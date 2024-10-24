package com.eco_awareness.ecoai.exception;
/**
 * EcoAIException is a custom exception class for handling errors
 * specific to the EcoAI application.
 */
public class EcoAIException extends RuntimeException {
    public EcoAIException(String message) {
        super(message);
    }
    public EcoAIException(String message, Throwable cause) {
        super(message, cause);
    }
}