package lesson22.Url;

/*
1. Изучить стороннее API. В качестве примера можно взять https://api.openweathermap.org/;
2. Разработать консольное приложение, где пользователь передает информацию и получает ответ от удаленного сервиса.
Например, при использовании погодного сервиса ожидается, что пользователь будет вводить название городов,
информацию о погоде которых он захочет получить. Для получения требуемых данных в программе потребуется подключиться
к данному API, используя возможности URLConnection или любого понравившегося Httpклиента.
Запрос данных о погоде осуществляется посредством обращения по адресу:
https://api.openweathermap.org/data/2.5/weather?q=Samara&appid=<api_key>&units=metric.
Используя параметр mode можно выбрать подходящий формат (json/xml), в качестве параметра appid следует
передать API Key пользователя, которого следует зарегистрировать
(либо использовать 886705b4c1182eb1c69f28eb8c520e20 – не рекомендуется).
3*. API Key следует вынести во внешний ресурсный файл или использовать как переменные окружения/системные свойства
4*. Для транслитерации текста рекомендую воспользоваться библиотекой icu4j или справочник городов
 */

import com.google.gson.*;
import lesson22.Url.dto.Data;
import lesson22.Url.dto.SearchReferences;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class UrlRunner {
    public static void main(String[] args) throws IOException {

        /* Доступ к сайту со справочником товаров UK и поиск соответствующей номенклатуры по ключевому слову
        Описание API доступно на следующей странице
        https://api.trade-tariff.service.gov.uk/reference.html#trade-tariff-public-api-v2
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите наименование товара на английском (например - pipe или coffee):");
        String tradeName = scanner.next();

        URL trade = new URL("https://www.trade-tariff.service.gov.uk/api/v2/search_references.json?query[letter]=" + tradeName);

        URLConnection tradeConnection = trade.openConnection();
        tradeConnection.connect();
        Scanner tradeScanner = new Scanner(tradeConnection.getInputStream());
        String json = "";
        while (tradeScanner.hasNextLine()) {
            json += tradeScanner.nextLine();
        }

        System.out.println("По номенклатуре найдены следующие соответствия: ");
        System.out.println(" ");
        Gson gson = new Gson();
        Data data = gson.fromJson(json, Data.class);

        for (SearchReferences i : data.data) {
            System.out.println(i.attributes.title);
        }
    }
}



