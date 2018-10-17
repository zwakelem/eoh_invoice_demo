package za.co.digitalplatoon.invoiceservice.invoice.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ZWAKELE2
 **/
@RunWith(SpringRunner.class)
public class InvoiceTest {

    private Invoice invoice;

    @Before
    public void init() {

        invoice = new Invoice();

        invoice.setId(1l);
        invoice.setClient("Zwakele");
        invoice.setVatRate(15l);

        LineItem lineItem1 = new LineItem();
        lineItem1.setId(1l);
        lineItem1.setInvoice(invoice);
        lineItem1.setQuantity(2l);
        lineItem1.setUnitPrice(BigDecimal.valueOf(5l));

        LineItem lineItem2 = new LineItem();
        lineItem2.setId(2l);
        lineItem2.setInvoice(invoice);
        lineItem2.setQuantity(4l);
        lineItem2.setUnitPrice(BigDecimal.valueOf(10l));

        LineItem lineItem3 = new LineItem();
        lineItem3.setId(3l);
        lineItem3.setInvoice(invoice);
        lineItem3.setQuantity(6l);
        lineItem3.setUnitPrice(BigDecimal.valueOf(20l));

        invoice.getLineItems().add(lineItem1);
        invoice.getLineItems().add(lineItem2);
        invoice.getLineItems().add(lineItem3);

    }

    @Test
    public void testAddLineItem() {

        LineItem lineItem = new LineItem();
        lineItem.setId(4l);
        lineItem.setInvoice(invoice);
        lineItem.setQuantity(6l);
        lineItem.setUnitPrice(BigDecimal.valueOf(20l));
        invoice.getLineItems().add(lineItem);

        assertThat(invoice.getLineItems().size() == 4).isTrue();

    }

    @Test
    public void testRemoveLineItem() {

        LineItem lineItem = new LineItem();
        lineItem.setId(4l);
        lineItem.setInvoice(invoice);
        lineItem.setQuantity(6l);
        lineItem.setUnitPrice(BigDecimal.valueOf(20.00));
        invoice.getLineItems().add(lineItem);

        assertThat(invoice.getLineItems().size() == 4).isTrue();

        invoice.removeLineItem(lineItem);

        assertThat(invoice.getLineItems().size() == 3).isTrue();
    }

    @Test
    public void givenInvoice_TestSubTotalAndVatAndTotal() {

        assertThat(invoice.getSubTotal().toPlainString().equals("170.00")).isTrue();
        assertThat(invoice.getVat().toPlainString().equals("25.50")).isTrue();
        assertThat(invoice.getTotal().toPlainString().equals("195.50")).isTrue();

    }

}
