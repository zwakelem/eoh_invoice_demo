package za.co.digitalplatoon.invoiceservice.invoice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.digitalplatoon.invoiceservice.invoice.model.Invoice;

/**
 * Created by ZWAKELE2
 **/
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
