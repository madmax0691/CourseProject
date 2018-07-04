package com.mkaz.io.fileio;

import com.mkaz.Game;
import com.mkaz.Review;
import com.mkaz.User;

import java.util.ArrayList;
import java.util.List;

public class ReviewsFileIn {
    private static final int NUMBER_OF_COLUMNS = 3;
    private final List<Review> reviews = new ArrayList<>();
    private final List<String> reviewsInfo;

    public ReviewsFileIn(List<String> reviewsInfo) {
        this.reviewsInfo = reviewsInfo;
        remove();
    }

    private void remove() {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            reviewsInfo.remove(0);
        }
    }

    public void initialize(List<User> users) {
        for (int i = 0; i < reviewsInfo.size() / NUMBER_OF_COLUMNS; i++) {
            reviews.add(new Review(reviewsInfo.get(1 + i * NUMBER_OF_COLUMNS),
                    Double.parseDouble(reviewsInfo.get(2 + i * NUMBER_OF_COLUMNS)),
                    users.get(i)));
        }
    }

    public void addReviews(Game game) {
        for (Review review : reviews) {
            game.addReview(review);
        }
    }
}
