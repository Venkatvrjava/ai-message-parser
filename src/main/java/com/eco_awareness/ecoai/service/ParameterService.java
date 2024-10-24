package com.eco_awareness.ecoai.service;

import com.eco_awareness.ecoai.entity.Parameter;
import com.eco_awareness.ecoai.exception.EcoAIException;
import com.eco_awareness.ecoai.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ParameterService handles the business logic for processing parameters
 * and generating EcoAI messages.
 */
@Service
public class ParameterService {
    @Autowired
    private ParameterRepository paramRepository;

    /**
     * Generates an EcoAI message based on the provided parameter.
     *
     * @param param The input parameter.
     * @return The generated message.
     * @throws EcoAIException if there is a database error while saving the parameter.
     */
    public String generateEcoAIMessage(String param) throws EcoAIException {
        try {
            // Store parameter in the database
            Parameter parameter = new Parameter(param);
            paramRepository.save(parameter);
            return "This AI is super green eco-powered and sustainable. The meaning of the universe is " + param + ".";
        } catch (Exception e) {
            throw new EcoAIException("Error saving the parameter: " + param, e);
        }
    }
}
