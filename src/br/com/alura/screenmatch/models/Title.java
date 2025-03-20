package br.com.alura.screenmatch.models;

public class Title {
    private String name;
    private int yearOfRelease;
    private boolean includedOnThePlan;
    private double sumOfReviews;
    private int totalReviews;
    private int durationInMinutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public boolean isIncludedOnThePlan() {
        return includedOnThePlan;
    }

    public void setIncludedOnThePlan(boolean includedOnThePlan) {
        this.includedOnThePlan = includedOnThePlan;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void showTechnicalSheet() {
        System.out.println("Name of the movie/serie: " + this.name);
        System.out.println("Year of release: " + this.yearOfRelease);
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

//    method to give a rate, puting the grade at the parameter and summing the grade plus sumOfReviews
    public void rate(double grade) {
        this.sumOfReviews += grade;
        totalReviews++;
    }

//    method to get the average of the reviews.
    public double getAverageRating() {
        double avg = sumOfReviews / totalReviews;
        return avg;
    }
}
