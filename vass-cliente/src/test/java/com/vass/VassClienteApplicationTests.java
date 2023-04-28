package com.vass;

import com.vass.controller.ClienteController;
import com.vass.modelo.ResponseDto;
import com.vass.service.ClienteService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VassClienteApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private ClienteService cleinteService;

    @Test
    public void testRest() {

        Mockito.when(cleinteService.findAll()).thenReturn(new ResponseDto<>());
        ResponseEntity<ResponseDto> response = restTemplate.getForEntity("/cliente/", ResponseDto.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
