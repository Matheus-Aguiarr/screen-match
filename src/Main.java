import br.com.alura.screenmatch.models.Movie;

public class Main {
    public static void main(String[] args) {
        Movie avengers = new Movie();
        avengers.setName("Avengers");
        avengers.setYearOfRelease(2010);
        avengers.setDurationInMinutes(200);
        avengers.showTechnicalSheet();
    }
}