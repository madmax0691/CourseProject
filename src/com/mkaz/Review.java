package com.mkaz;

public class Review {
    private final String review;
    private final double rating;
    private final User user;

    public Review(String review, double rating, User user) {
        this.review = review;
        this.rating = rating;
        this.user = user;
    }

    public double getRating() {
        return rating;
    }

    public User getUser() {
        return user;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review='" + review + '\'' +
                ", rating=" + rating +
                ", user=" + user.getNickName() +
                '}';
    }
}
