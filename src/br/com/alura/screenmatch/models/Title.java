package br.com.alura.screenmatch.models;

import com.google.gson.annotations.SerializedName;
import exception.invalidYearException;

public class Title implements Comparable<Title> {

    private String name;
    private int yearOfRelease;
    private boolean includedOnThePlan;
    private double sumOfReviews;
    private int totalReviews;
    private int durationInMinutes;

    public Title(String name, int yearOfRelease) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
    }

    public Title(TitleOmdb myTitleOmdb) {

        if(myTitleOmdb.year().length() > 4) { //Feito para tratar o erro que da quando vem um ano errado (por exemplo: 2018-);
            throw new invalidYearException("Não foi possível converter o ano por que tem mais de 04 caracteres."); //Criando uma nova exception;
        }

        this.name = myTitleOmdb.title();
        this.yearOfRelease = Integer.valueOf(myTitleOmdb.year());
        this.durationInMinutes = Integer.valueOf(myTitleOmdb.runtime().substring(0,3));

    }

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

    @Override
    public int compareTo(Title o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nYear of release: " + this.yearOfRelease + "\nDuration in minutes: " + this.durationInMinutes;
    }
}
