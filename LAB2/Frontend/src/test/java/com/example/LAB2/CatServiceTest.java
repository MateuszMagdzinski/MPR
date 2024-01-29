package com.example.LAB2;

import com.example.LAB2.Backend.Cat;
import com.example.LAB2.Backend.CatService;
import com.example.LAB2.Backend.CatsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.web.client.MockServerRestClientCustomizer;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestClient;

import java.util.List;

import static com.example.LAB2.CatService.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RestClientTest
public class MyRestServiceUnitTest {
    @InjectMocks
    private MyRestService service;
    private MockServerRestClientCustomizer customizer = new MockServerRestClientCustomizer();
    private RestClient.Builder builder = RestClient.builder();

    @BeforeEach
    public void setUp() {
        customizer.customize(builder);
        service = new MyRestService(builder.build());
    }

    @Test
    public void findCatByNameWhenCatExist() {
        customizer.getServer().expect(MockRestRequestMatchers.requestTo(
                        BASE_URL + "/cat/Dan"))
                .andRespond(MockRestResponseCreators
                        .withSuccess(""" 
                                {"name":"Dan", "age":12}
                                """, MediaType.APPLICATION_JSON));
        Cat cat = service.getCatByName("Dan");
        assertEquals("Dan", cat.getName());
    }

}
