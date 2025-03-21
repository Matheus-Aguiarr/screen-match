import br.com.alura.screenmatch.models.Movie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie avengers = new Movie();
        avengers.setName("Avengers");
        avengers.setYearOfRelease(2010);
        avengers.setDurationInMinutes(200);
        avengers.showTechnicalSheet();

        Movie avatar = new Movie();
        avatar.setName("Avatar");
        avatar.setYearOfRelease(2000);
        avatar.setDurationInMinutes(200);


        ArrayList<Movie> moviesList = new ArrayList<>();
        moviesList.add(avengers);
        moviesList.add(avatar);

        System.out.println("List size: " + moviesList.size());
        System.out.println("Primeiro filme: " + moviesList.getFirst().getName());
    }
}