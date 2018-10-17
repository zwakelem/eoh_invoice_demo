package za.co.digitalplatoon.invoiceservice.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.digitalplatoon.invoiceservice.invoice.dao.InvoiceRepository;
import za.co.digitalplatoon.invoiceservice.invoice.model.Invoice;

import java.util.List;

/**
 * Created by ZWAKELE2
 **/
@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> findAllInvoices() {
        return (List<Invoice>) invoiceRepository.findAll();
    }

    public Invoice findInvoice(Long invoiceId) {

        return invoiceRepository.findById(invoiceId).orElse(null);

    }

}
