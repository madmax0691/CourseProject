package com.mkaz.io.fileio;

import com.mkaz.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewsFileOut {
    private final List<Review> reviews;
    private final List<String> reviewsInfo = new ArrayList<>();

    public ReviewsFileOut(List<Review> reviews) {
        this.reviews = reviews;
        initialize();
    }

    private void addFirstLine() {
        reviewsInfo.add("\"" + "NickName:" + "\"" + "\t" + "\"" + "Review:" + "\"" + "\t" + "\"" + "Rating:"
                + "\"");
    }

    private void initialize() {
        addFirstLine();
        StringBuilder stringBuilder;
        for (Review review : reviews) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("\"");
            stringBuilder.append(review.getUser().getNickName());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(review.getReview());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(review.getRating());
            stringBuilder.append("\"");
            reviewsInfo.add(stringBuilder.toString());
        }
    }

    public void write(String fileName) {
        TextFileIO.write(fileName, reviewsInfo);
    }
}
