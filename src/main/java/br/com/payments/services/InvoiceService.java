package br.com.payments.services;

import br.com.payments.models.client.Client;
import br.com.payments.models.dto.InvoiceDTO;
import br.com.payments.models.invoice.Invoice;
import br.com.payments.repositories.ClientRepository;
import br.com.payments.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ClientRepository clientRepository;

    //Consultar Invoices pelos contract numbers
    public List<InvoiceDTO> consultarInvoice(Long id){
        Client client = clientRepository.getReferenceById(id);

        List<Invoice> invoices = invoiceRepository.findAllByContractNumberAndPaidFalse(client.getContractNumber());
        return invoices.stream().map((i)-> new InvoiceDTO(i)).toList();
    }

    //Cadastar Invoices
    public InvoiceDTO cadastrarInvoice(InvoiceDTO invoiceDTO){
        Invoice invoice = invoiceRepository.save(new Invoice(invoiceDTO));
        return new InvoiceDTO(invoice);
    }
}
