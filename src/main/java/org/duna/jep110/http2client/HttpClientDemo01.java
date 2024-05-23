package org.duna.jep110.http2client;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class HttpClientDemo01 {
  public static void main(String[] args) {
    Logger logger = Logger.getLogger(HttpClientDemo01.class.getName());

    int statusCode = 0;
    String urlApi = "https://dummyapi.online/api/users/1";

    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(urlApi))
      .GET()
      .header("Accept", "text/html")
      .build();

    HttpResponse<String> response = null;
    try {
      response = httpClient.send(request, HttpResponse.BodyHandler.asString());
      statusCode = response.statusCode();
    } catch (IOException | InterruptedException e) {
      logger.warning("Interrupted!\n"+ e);
      Thread.currentThread().interrupt();
    }

    if (statusCode == 200) {
      String body = response.body();
      System.out.println("Response:\n" + body);
    } else {
      System.out.println("Error: Status Code " + statusCode);
    }

  }
}
