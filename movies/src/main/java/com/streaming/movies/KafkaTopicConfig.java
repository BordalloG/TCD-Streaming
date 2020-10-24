package com.streaming.movies;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic moviesMovieWatched () {
        return TopicBuilder.name("movies-movie-watched").build();
    }
    @Bean
    public NewTopic moviesMovieWatchLater () {
        return TopicBuilder.name("movie-watch-later").build();
    }
}