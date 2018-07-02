package com.mkaz.io.fileio;

import com.mkaz.Review;

import java.util.Arrays;
import java.util.List;

public class ReviewsFileOut {
    private final StringBuilder stringBuilder = new StringBuilder();

    public ReviewsFileOut(String fileName, List<Review> reviews) {
        addFirstLine();
        TextFileIO.write(fileName, initialize(reviews));
    }

    private void addFirstLine() {
        stringBuilder.append("\"" + "NickName:" + "\"" + "\t" + "\"" + "Review:" + "\"" + "\t" + "\"" + "Rating:"
                + "\"" + "\n");
    }

    private List<String> initialize(List<Review> reviews) {
        for (int i = 0; i < reviews.size(); i++) {
            stringBuilder.append("\"");
            stringBuilder.append(reviews.get(i).getUser().getNickName());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(reviews.get(i).getReview());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(reviews.get(i).getRating());
            stringBuilder.append("\"");
            stringBuilder.append("\n");
        }
        List<String> outInfo = Arrays.asList(stringBuilder.toString().split("\n"));
        return outInfo;
    }
}
