package com.serenity.springioc.runner;

import com.serenity.springioc.bean.Movie;
import com.serenity.springioc.bean.MoviePlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Ahmed samy
 * serenitydiver@hotmail.com
 */
public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

      // Commenting these lines because we are using dependency injection from applicationContext xml
       /* Movie movie = context.getBean("movieType", Movie.class); /
        MoviePlayer moviePlayer = new MoviePlayer(movie);*/

       MoviePlayer moviePlayer = context.getBean("moviePlayer", MoviePlayer.class);
        moviePlayer.playMoview();

    }
}
