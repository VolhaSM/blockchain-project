package blockchain.project.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

//    public static void main(String[] args) throws IOException, InterruptedException {
//
//        String body = createPostBody();
//        final HttpResponse<String> response = post(body);
//
//        System.out.println(response.statusCode());
//        System.out.println(response.body());
//    }
//
//    private static String createPostBody() {
//        return "{\"userId\":\"Igor\",\"emailAddress\":\"igor@mail.ru\",\"mobilePhone\":\"802922222\"}";
//    }
//
//    private static HttpResponse <String> post(String body) throws IOException, InterruptedException {
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/hello-blockchain/recipients/594b3fda-f425-4b24-876f-fa00bff76a49"))
//                .POST(HttpRequest.BodyPublishers.ofString(body))
//                .header("Content-Type", "application/json")
//                .build();
//
//        HttpResponse <String> response =
//                httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        return  response;
//
//    }
}
