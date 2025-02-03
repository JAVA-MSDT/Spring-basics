package com.serenity.springioc.bean;

/**
 * @Author Ahmed samy
 * serenitydiver@hotmail.com
 */
public class MoviePlayer {

    private Movie movie;

    public MoviePlayer(Movie movie){
        this.movie = movie;
    }

    public void playMoview(){
        System.out.println(movie.getMovieTitle() + " is Playing now");
    }
}
