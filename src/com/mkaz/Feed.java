package com.mkaz;

import java.util.List;

public interface Feed {
    List<Game> getFeed();
    Game getGame(int number);
}
