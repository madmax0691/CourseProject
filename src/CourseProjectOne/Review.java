package CourseProjectOne;

public class Review {
    private final String review;
    private final double rating;
    private final User user;

    public Review(String review, double rating, User user) {
        this.review = review;
        this.rating = rating;
        this.user = user;
    }

    double getRating() {
        return rating;
    }

    User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review='" + review + '\'' +
                ", rating=" + rating +
                ", user=" + user +
                '}';
    }
}
