package br.com.payments.services;

import br.com.payments.models.client.Client;
import br.com.payments.models.dto.PurchaseDTO;
import br.com.payments.models.invoice.Invoice;
import br.com.payments.models.purchase.Purchase;
import br.com.payments.repositories.ClientRepository;
import br.com.payments.repositories.InvoiceRepository;
import br.com.payments.repositories.PurchaseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ClientRepository clientRepository;
    private final InvoiceRepository invoiceRepository;

    //Cadastrar Purchase
    public PurchaseDTO cadastrarPurchase(PurchaseDTO purchaseDTO) {
        Client client = clientRepository.findById(purchaseDTO.clientId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));

        List<Invoice> invoice = invoiceRepository.findAllById(purchaseDTO.invoiceId());

        Purchase purchase = purchaseRepository.save(new Purchase(purchaseDTO, client, invoice));

        return new PurchaseDTO(purchase);
    }
}
