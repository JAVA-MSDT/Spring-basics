package com.serenity.springioc.bean;

/**
 * @Author Ahmed samy
 * serenitydiver@hotmail.com
 */
public class DocumentaryMovie implements Movie {
    @Override
    public String getMovieTitle() {
        return "Documentary Movie";
    }
}
