package lesson26.SpringContext.config;

import com.google.gson.Gson;
import lesson26.SpringContext.CurrencyDownloader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"lesson26"})

public class AppConfig {

    @Bean(name = "downloadService")
    public CurrencyDownloader currencyDownload() {
        return new CurrencyDownloader();
    }

    @Bean(name = "gson")
    Gson gson() {
        return new Gson();
    }
}
