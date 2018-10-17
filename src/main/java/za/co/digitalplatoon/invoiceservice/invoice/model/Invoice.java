package za.co.digitalplatoon.invoiceservice.invoice.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZWAKELE2
 **/

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String client;

    private Long vatRate;

    private Date invoiceDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id")
    private List<LineItem> lineItems = new ArrayList<>();

    public Invoice() {
        // no-arg constructor
    }

    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
        lineItem.setInvoice(this);
    }

    public void removeLineItem(LineItem lineItem) {
        this.lineItems.remove(lineItem);
        lineItem.setInvoice(null);
    }

    public Long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setVatRate(Long vatRate) {

        this.vatRate = vatRate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getSubTotal() {

        return lineItems.stream()
                .map(itm -> itm.getLineItemTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getVat() {
        return BigDecimal.valueOf(getVatRate() / 100d).multiply(getSubTotal()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal() {
        return getSubTotal().add(getVat()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;

        Invoice invoice = (Invoice) o;

        if (!getId().equals(invoice.getId())) return false;
        if (!getClient().equals(invoice.getClient())) return false;
        if (!getVatRate().equals(invoice.getVatRate())) return false;
        return getInvoiceDate().equals(invoice.getInvoiceDate());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getClient().hashCode();
        result = 31 * result + getVatRate().hashCode();
        result = 31 * result + getInvoiceDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invoice{");
        sb.append("id=").append(id);
        sb.append(", client='").append(client).append('\'');
        sb.append(", vatRate=").append(vatRate);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append('}');
        return sb.toString();
    }
}
