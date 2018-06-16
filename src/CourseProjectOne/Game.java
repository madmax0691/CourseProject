package CourseProjectOne;

import java.time.LocalDate;
import java.util.ArrayList;

public class Game {
    private final String title;
    private final String description;
    private final LocalDate releaseYear;
    private final String genre;
    private final String platform;
    private double averageRating;
    private final ArrayList<Review> reviews = new ArrayList<>();
    private long favoritesCounter;

    public Game(String title, String description, LocalDate releaseYear, String genre,
                String platform, double averageRating, long favoritesCounter) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.platform = platform;
        this.averageRating = averageRating;
        this.favoritesCounter = favoritesCounter;
    }

    private void setAverageRating() {
        double tempAverageRatingSum = 0;
        for (Review tempReview : reviews) {
            tempAverageRatingSum += tempReview.getRating();
        }
        averageRating = tempAverageRatingSum / reviews.size();
    }

    public void addReview(Review review) {
        for (Review tempReview : reviews) {
            if (tempReview.getUser().equals(review.getUser())) {
                throw new IllegalArgumentException("You already left a review for this game!");
            }
        }
        reviews.add(review);
        setAverageRating();
    }

    public void removeReview(Review review) {
        for (Review tempReview : reviews) {
            if (tempReview.getUser().equals(review.getUser())) {
                reviews.remove(review);
                setAverageRating();
            } else {
                throw new IllegalArgumentException("Sorry, but this game does not have your review");
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public long getFavoritesCounter() {
        return favoritesCounter;
    }

    public String getDescription() {
        return description;
    }

    public void showReviews(){
        for (Review tempReview : reviews) {
            System.out.println(tempReview);
        }
    }

    public void setFavoritesCounter(long favoritesCounter) {
        this.favoritesCounter = favoritesCounter;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", platform='" + platform + '\'' +
                ", averageRating=" + averageRating +
                ", favoritesCounter=" + favoritesCounter +
                '}';
    }
}
