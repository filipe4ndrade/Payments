package br.com.payments.services;

import br.com.payments.models.dto.PurchaseDTO;
import br.com.payments.repositories.ClientRepository;
import br.com.payments.repositories.InvoiceRepository;
import br.com.payments.repositories.PurchaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class PurchaseServiceTest {

    @InjectMocks
    PurchaseService purchaseService;

    @Mock
    PurchaseRepository purchaseRepository;
    @Mock
    ClientRepository clientRepository;
    @Mock
    InvoiceRepository invoiceRepository;

    PurchaseDTO purchaseDTO;

    @BeforeEach
    public void setUp(){
        purchaseDTO = new PurchaseDTO(1L, 100L, 120L, 1.5, 1001L, List.of(2001L, 2002L));
    }

    @Test
    void deveCadastrarPurchaseComSucesso(){

    }

}
