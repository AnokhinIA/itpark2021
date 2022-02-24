package lesson26.SpringContext;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CurrencyDownloader {

    public String download() throws IOException {
        String json = "";
        URL currencyUrl = new URL("https://www.cbr-xml-daily.ru/daily_json.js");
        URLConnection CurrencyConnection = currencyUrl.openConnection();
        CurrencyConnection.connect();
        Scanner currencyScanner = new Scanner(CurrencyConnection.getInputStream());

        while (currencyScanner.hasNextLine()) {
            json += currencyScanner.nextLine();
        }

        return json;
    }
}
