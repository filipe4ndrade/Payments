package br.com.payments.services;

import br.com.payments.models.dto.TransactionDTO;
import br.com.payments.models.purchase.Purchase;
import br.com.payments.models.transaction.Transaction;
import br.com.payments.repositories.PurchaseRepository;
import br.com.payments.repositories.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final PurchaseRepository purchaseRepository;

    //Cadastrar Transaction
    public TransactionDTO cadastrarTransaction(TransactionDTO transactionDTO){
        Purchase purchase = purchaseRepository.findById(transactionDTO.purchase_id())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));

        Transaction transaction = transactionRepository.save(new Transaction(transactionDTO, purchase));
        return new TransactionDTO(transaction);
    }
}
