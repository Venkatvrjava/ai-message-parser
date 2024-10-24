package com.eco_awareness.ecoai.controller;

import com.eco_awareness.ecoai.exception.EcoAIException;
import com.eco_awareness.ecoai.service.ParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * EcoAIMessageController is responsible for handling HTTP requests
 * related to EcoAI message generation.
 */
@RestController
@RequestMapping("/universe-meaning")
@Slf4j
public class EcoAIMessageController {
    @Autowired
    private ParameterService parameterService;

    /**
     * Endpoint to retrieve the meaning of the universe based on a given parameter.
     *
     * @param param The input parameter for generating the EcoAI message.
     * @return The generated message.
     * @throws EcoAIException if there is an error while generating the message.
     */
    @GetMapping("/{param}")
    public String getMeaningOfUniverse(@PathVariable String param) throws EcoAIException {
        log.info("Received request to get meaning of universe with param: {}", param);
        return parameterService.generateEcoAIMessage(param);
    }
}
