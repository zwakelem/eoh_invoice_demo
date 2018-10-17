package za.co.digitalplatoon.invoiceservice.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.co.digitalplatoon.invoiceservice.invoice.model.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.service.InvoiceService;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ZWAKELE2
 **/

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Invoice addInvoice(@RequestBody @NotNull Invoice invoice) {
        return invoiceService.addInvoice(invoice);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Invoice> viewAllInvoices() {
        return invoiceService.findAllInvoices();
    }

    @GetMapping(value = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Invoice viewInvoice(@PathVariable Long invoiceId) {
        return invoiceService.findInvoice(invoiceId);
    }


}
