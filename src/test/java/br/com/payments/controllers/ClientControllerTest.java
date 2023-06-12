package br.com.payments.controllers;

import br.com.payments.services.ClientService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


//@RunWith(SpringRunner.class) preciasa da dependência do JUnit
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ClientControllerTest {

    @MockBean
    private ClientService clientService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName(value = "Ao buscar um cliente, que não está cadastrado, através do seu id, " +
                         "uma exceção deve ser lançada e o código 404 retornado")
    //Corrigir esse DisplayName
    @WithMockUser
    public void shouldReturnNotFoundWhenFindClient() throws Exception{

        when(clientService.findClientById(1L)).thenReturn(null);

        var response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/payments/client")
                                .param("id", "1L")
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }


}