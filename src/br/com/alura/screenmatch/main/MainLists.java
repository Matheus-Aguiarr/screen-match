package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Series;
import br.com.alura.screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainLists {
    public static void main(String[] args) {
        Movie avengers = new Movie("Avengers", 2010);
        avengers.rate(9);
        Movie avatar = new Movie("Avatar", 2000);
        avatar.rate(10);
        Movie sing = new Movie("Sing", 2018);
        avatar.rate(8);
        Series lost = new Series("Lost", 2000);

        ArrayList<Title> list = new ArrayList<>();
        list.add(avengers);
        list.add(avatar);
        list.add(sing);
        list.add(lost);

        for (Title item : list) {
            System.out.println(item.getName());
            if(item instanceof Movie movie && movie.getClassification() > 2) {
                System.out.println(((Movie) item).getClassification());
            }
        }

        ArrayList<String> searchForArtist = new ArrayList<>();
        searchForArtist.add("Adam Sandler");
        searchForArtist.add("Fernanda Torres");
        searchForArtist.add("Zendaya");
        searchForArtist.add("Peter Parker");
        searchForArtist.add("Jimmy");
        System.out.println("Before sort");
        System.out.println(searchForArtist);

        Collections.sort(searchForArtist);
        System.out.println("After sort");
        System.out.println(searchForArtist);

        System.out.println("Title List sorted");
        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.comparing(Title::getYearOfRelease));
        System.out.println("Ordenando por ano");
        System.out.println(list);
    }
}
