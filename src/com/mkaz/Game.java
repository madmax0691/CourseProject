package com.mkaz;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private static final long serialVersionUID = -708177933616049536L;
    private final String title;
    private final String description;
    private final LocalDate releaseYear;
    private final String genre;
    private final String platform;
    private final List<Review> reviews = new ArrayList<>();
    private long favoritesCounter = 0;

    public Game(String title, String description, LocalDate releaseYear, String genre,
                String platform) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.platform = platform;
    }

    public void addReview(Review review) {
        for (Review tempReview : reviews) {
            if (tempReview.getUser().equals(review.getUser())) {
                throw new IllegalArgumentException("You already left a review for this game!");
            }
        }
        reviews.add(review);
    }

    public void removeReview(Review review) {
        for (Review tempReview : reviews) {
            if (tempReview.getUser().equals(review.getUser())) {
                reviews.remove(review);
            } else {
                throw new IllegalArgumentException("Sorry, but this game does not have your review");
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public double getAverageRating() {
        double tempAverageRatingSum = 0.0;
        if (reviews.size() == 0) {
            return 0.0;
        }
        for (Review tempReview : reviews) {
            tempAverageRatingSum += tempReview.getRating();
        }
        return tempAverageRatingSum / reviews.size();
    }

    public long getFavoritesCounter() {
        return favoritesCounter;
    }

    public String getDescription() {
        return description;
    }

    public void showReviews() {
        for (Review tempReview : reviews) {
            System.out.println(tempReview);
        }
    }

    public void setFavoritesCounter(long favoritesCounter) {
        this.favoritesCounter = favoritesCounter;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", platform='" + platform + '\'' +
                ", averageRating=" + getAverageRating() +
                ", favoritesCounter=" + favoritesCounter +
                '}';
    }
}
