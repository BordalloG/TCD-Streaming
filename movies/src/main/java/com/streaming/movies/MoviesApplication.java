package com.streaming.movies;

import com.streaming.movies.model.Genre;
import com.streaming.movies.model.Movie;
import com.streaming.movies.repository.GenreRepository;
import com.streaming.movies.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(MoviesApplication.class, args);


	}
	@Bean
	public CommandLineRunner mappingDemo(GenreRepository gr, MovieRepository mr) {
		return  args -> {
			Genre g = new Genre("Comedia");
			Genre g2 = new Genre("Terror");
			Movie m = new Movie("Filme 1","Filme bacana", 2020, g);
			Movie m2 = new Movie("Filme 2","Filme maneiro", 2019, g);
			Movie m3 = new Movie("Filme 3","Filme assustador", 2017, g2);
			Movie m4 = new Movie("Filme 4","Corona", 2020, g2);

			gr.save(g);
			gr.save(g2);
			mr.save(m);
			mr.save(m2);
			mr.save(m3);
			mr.save(m4);
		};
	}

}
