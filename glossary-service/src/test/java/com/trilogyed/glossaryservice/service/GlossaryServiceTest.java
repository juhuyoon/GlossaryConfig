package com.trilogyed.glossaryservice.service;

import com.trilogyed.glossaryservice.util.feign.DefinitionClient;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlossaryServiceTest {

    @MockBean
    private DefinitionClient client;

    @Before
    public void setUp() throws Exception {

    }
}