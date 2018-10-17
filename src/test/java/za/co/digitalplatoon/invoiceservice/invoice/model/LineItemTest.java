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
public class LineItemTest {

    private LineItem lineItem;

    @Before
    public void init() {

        lineItem = new LineItem();
        lineItem.setId(1l);
        lineItem.setQuantity(2l);
        lineItem.setUnitPrice(BigDecimal.valueOf(2l));

    }

    @Test
    public void givenLineItem_testLineItemTotal() {
        assertThat(lineItem.getLineItemTotal().toPlainString().equals("4.00")).isTrue();
    }
}
