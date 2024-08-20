package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InvoiceFilterTest {
    @Test
    void filterInvoices() {
        // Criação de um Stub
        IssuedInvoices issuedInvoices = mock(IssuedInvoices.class);

        // Criação das faturas
        Invoice mauricio = new Invoice("Mauricio", 20);
        Invoice steve = new Invoice("Steve", 99);
        Invoice frank = new Invoice("Frank", 100);
        List<Invoice> listOfInvoices = Arrays.asList(mauricio, steve, frank);

        // Determina os valores a serem retornados pelo stub
        when(issuedInvoices.all()).thenReturn(listOfInvoices);

        // Passa o Stub como dependência para o método em teste
        InvoiceFilter filter = new InvoiceFilter(issuedInvoices);

        // Assertiva sobre o comportamento esperado
        assertThat(filter.lowValueInvoices()).containsExactlyInAnyOrder(mauricio, steve);
    }
}