package dev.chandraji.movies.service;

import dev.chandraji.movies.data.Movie;
import dev.chandraji.movies.data.Review;
import dev.chandraji.movies.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Review> createReview(String reviewBody, String imdbId) {
        List<Review> review = new ArrayList<>();
        Review tempReview = reviewRepository.insert(new Review(reviewBody));
        review.add(tempReview);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
