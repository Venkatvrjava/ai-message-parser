package com.eco_awareness.ecoai.controller;

import com.eco_awareness.ecoai.exception.EcoAIException;
import com.eco_awareness.ecoai.service.ParameterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
/**
 * EcoAIMessageControllerTest contains unit tests for the EcoAIMessageController class.
 */
public class EcoAIMessageControllerTest {
    @InjectMocks
    private EcoAIMessageController ecoAIMessageController;

    @Mock
    private ParameterService parameterService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(ecoAIMessageController).build();
    }

    @Test
    public void testGetMeaningOfUniverse() throws Exception {
        String param = "42";
        String expectedMessage = "This AI is super green eco-powered and sustainable. The meaning of the universe is " + param + ".";

        when(parameterService.generateEcoAIMessage(param)).thenReturn(expectedMessage);

        mockMvc.perform(get("/universe-meaning/{param}", param)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMessage));
    }

}
