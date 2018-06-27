package CourseProjectOne.IOModule.FileIO;

import CourseProjectOne.Game;
import CourseProjectOne.Review;
import CourseProjectOne.User;

import java.util.ArrayList;
import java.util.List;

public class ReviewsFileIn {
    private final List<Review> reviews = new ArrayList<>();

    public ReviewsFileIn(String fileName, String splitter, int numberOfColumns, List<User> users) {
        List<String> reviewsInput = TextFileIO.read(fileName, splitter);
        remove(reviewsInput, numberOfColumns);
        initialize(reviewsInput, numberOfColumns, users);
    }

    private void remove(List<String> list, int numberOfColumns) {
        for (int i = 0; i < numberOfColumns; i++) { //remove first line with names of columns
            list.remove(0);
        }
    }

    private void initialize(List<String> list, int numberOfColumns, List<User> users) {
        for (int i = 0; i < list.size() / numberOfColumns; i++) {
            reviews.add(new Review(list.get(1 + i * numberOfColumns), Double.parseDouble(list.get(2 + i * numberOfColumns)),
                    users.get(i)));
        }
    }

    public void addReviews(Game game) {
        for (Review review : reviews) {
            game.addReview(review);
        }
    }
}
