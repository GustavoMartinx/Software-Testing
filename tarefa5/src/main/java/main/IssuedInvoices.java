package main;

import java.util.ArrayList;
import java.util.List;

public class IssuedInvoices {

    private final List<Invoice> invoices;

    public IssuedInvoices() {
        this.invoices = new ArrayList<>();
    }

    // Adiciona uma fatura à lista
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> all() {
        return new ArrayList<>(invoices);
    }
}
