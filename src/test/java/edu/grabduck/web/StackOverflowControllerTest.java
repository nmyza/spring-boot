package edu.grabduck.web;

import com.google.common.collect.ImmutableList;
import edu.grabduck.service.ProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Run test with Mockito runner
@RunWith(MockitoJUnitRunner.class)
public class StackOverflowControllerTest {
    // Create service for Controller
    @Mock
    private ProviderService service;
    // Inject service to controller
    @InjectMocks
    private StackOverflowController controller;

    @Test
    public void getProviders() throws Exception {
        //prepare
        when(service.getAll()).thenReturn(ImmutableList.of());
        //testing
        controller.getProviders();
        //validate
        verify(service).getAll();
    }

}