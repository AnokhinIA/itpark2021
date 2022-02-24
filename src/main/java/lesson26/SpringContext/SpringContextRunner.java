package lesson26.SpringContext;

/*
1.Реализовать приложение с использованием Spring context, создаваемый через XML конфигурацию или аннотации.
2.Приложение представляет собой справочник валют с актуальной информацией о курсах, которая извлекается,
используя API ЦБ РФ в удобном формате (список доступных API - https://www.cbr-xml-daily.ru/).
3.Пользователь запрашивает информацию по интересующей валюте, указывая ее сокращенное наименование (например, USD, EUR, KZT),
в ответ получая актуальный курс в рублях.
4*. Предлагается кэшировать данные в виде справочника Map<String, BigDecimal>,
наполнение которого происходит единожды после создания бина сервиса/компонента.
 Все последующие запросы пользователя должны обрабатываться без обращения за данными по сети.
 */


import com.google.gson.Gson;
import lesson26.SpringContext.config.AppConfig;
import lesson26.SpringContext.dto.CurrenciesData;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class SpringContextRunner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CurrencyDownloader currencyDownloader = (CurrencyDownloader) context.getBean("downloadService");
        String json = "";
        try {
            json = currencyDownloader.download();
        } catch (IOException e) {
            System.out.println("Данные по валюте недоступны: " + e.getMessage());
        }
        Gson gson = (Gson) context.getBean("gson");
        CurrenciesData currenciesData = gson.fromJson(json, CurrenciesData.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сокращенное наименование валюты (например, USD, EUR, KZT):");
        String currencyName = scanner.next();
        currenciesData.searchCurrency(currencyName);
    }
}
