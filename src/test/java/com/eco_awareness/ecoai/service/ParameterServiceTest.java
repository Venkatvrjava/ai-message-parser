package com.eco_awareness.ecoai.service;

import com.eco_awareness.ecoai.entity.Parameter;
import com.eco_awareness.ecoai.exception.EcoAIException;
import com.eco_awareness.ecoai.repository.ParameterRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@Slf4j
class ParameterServiceTest {

    @InjectMocks
    private ParameterService parameterService;

    @Mock
    private ParameterRepository parameterRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        log.info("Initialized ParameterServiceTest");
    }

    @Test
    public void testProcessParameterSuccess() {
        String param = "42";
        String expectedMessage = "This AI is super green eco-powered and sustainable. The meaning of the universe is " + param + ".";
        String response = parameterService.generateEcoAIMessage(param);
        assert (response.equals(expectedMessage));
        verify(parameterRepository).save(any(Parameter.class));
        log.info("Successfully executed testProcessParameterSuccess");
    }

    @Test
    public void testProcessParameterError() {
        String param = "test-error";
        doThrow(new RuntimeException("Database error")).when(parameterRepository).save(any(Parameter.class));
        try {
            parameterService.generateEcoAIMessage(param);
        } catch (EcoAIException e) {
            log.error("Caught expected DatabaseException: {}", e.getMessage());
        }
    }
}
