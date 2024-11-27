import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    private int amount;

    CurrencyFormatter(int amount) {
        this.amount = amount;
    }

    public String formatCurrency() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormatter.format(this.amount);
    }
}