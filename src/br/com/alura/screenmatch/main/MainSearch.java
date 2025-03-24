package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Title;
import br.com.alura.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.invalidYearException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var search = sc.nextLine();
        String address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=c8ba3d41"; // Aqui, nos usamos o replace, para tratar o erro de quando o search vem com um filme que possui um espaco em branco, para substituir o espaco em branco por um + (exemplo: Top Gun; Ficaria: Top+Gun)
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
            System.out.println(myTitleOmdb);

            Title myTitle = new Title(myTitleOmdb);

            System.out.println("-----------TITULO JA CONVERTIDO-------");
            System.out.println(myTitle);

        } catch(NumberFormatException e) {

            System.out.println("ERRO: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {

            System.out.println("Algum erro de argumento na busca, verifique o endereco.");
            System.out.println(e.getMessage());
        } catch (invalidYearException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("O programa finalizou corretamente");
    }
}
