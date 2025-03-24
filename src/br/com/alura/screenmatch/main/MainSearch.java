package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Title;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var search = sc.nextLine();
        String address = "https://www.omdbapi.com/?t=" + search + "&apikey=c8ba3d41";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
        Gson gson = new Gson();
        Title myTitle = gson.fromJson(json, Title.class);
        System.out.println(myTitle);
    }
}
