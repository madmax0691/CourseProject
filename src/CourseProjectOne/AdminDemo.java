package CourseProjectOne;

import java.time.LocalDate;

class AdminDemo {
    private final GamesLibrary gamesLibrary = new GamesLibrary();

    private Game game1 = new Game("GOD OF WAR", "His vengeance against the gods of Olympus" +
            " far behind him, Kratos now lives as a man in the lands of Norse Gods and monsters." +
            " It is in this harsh, unforgiving world that he must fight to survive… and teach his son" +
            " to do the same.", LocalDate.of(2018, 4, 20), "Action Adventure",
            "PS4");

    private Game game2 = new Game("Injustice 2", "Injustice 2 is a worthy sequel to Injustice Gods Among Us." +
            " With improved graphics, a great story and even more features to keep you busy." +
            " Injustice 2 is highly recommended and excels as a fighting game.", LocalDate.of(2018, 3, 27),
            "Action", "PS4");

    private Game game3 = new Game("DARK SOULS REMASTERED", "Embark upon an epic dark fantasy in a universe stricken by" +
            " decline and the Curse. Explore its intricate world design - full of hidden passages," +
            " dungeons and secrets - and uncover its deeply rooted lore.", LocalDate.of(2018, 3, 25),
            "Action RPG", "PS4");

    private Game game4 = new Game("BATMAN: THE ENEMY WITHIN", "Same Stitch is the fifth and final episode of Batman:" +
            " The Enemy Within. The episode will follow Batman as he confronts either Amanda Waller and the Agency or a menace" +
            " he has helped create.", LocalDate.of(2018, 3, 26),
            "Adventure", "PC");

    private Game game5 = new Game("FROSTPUNK", "In a completely frozen world, people develop steam-powered technology to" +
            " oppose the overwhelming cold. Society in its current form becomes ineffective and it has to change" +
            " in order to survive.", LocalDate.of(2018, 4, 24),
            "Action Adventure", "PC");

    private Game game6 = new Game("THE ELDER SCROLLS ONLINE: SUMMERSET", "The Elder Scrolls Online: Summerset is the next" +
            " Chapter of ZeniMax Online Studios' award-winning online RPG.", LocalDate.of(2018, 3, 21),
            "Massively Multiplayer", "PC");

    private Game game7 = new Game("THE FOREST", "As the lone survivor of a passenger jet crash, you find yourself in a mysterious" +
            " forest battling to stay alive against a society of cannibalistic mutants.",
            LocalDate.of(2018, 4, 30),
            "Horror", "PC");

    private Game game8 = new Game("FAR CRY 5", "Welcome to Hope County, Montana. This idyllic location is home" +
            " to a community of freedom-loving people - and a fanatical doomsday cult known by many as The" +
            " Project at Eden's Gate.", LocalDate.of(2018, 3, 27),
            "Action", "PC");

    private Game game9 = new Game("DRAGON'S CROWN PRO", "Dragon's Crown thrusts you into a fantastical medieval" +
            " world packed with labyrinthine dungeons to explore, vile monstrosities to smite, and nearly endless online" +
            " adventure. ", LocalDate.of(2018, 5, 15),
            "Action", "PS4");

    private Game game10 = new Game("FAR: LONE SAILS", "Traverse a dried-out seabed littered with the remains" +
            " of a decaying civilization.", LocalDate.of(2018, 5, 17),
            "Action", "PC");

    private Game game11 = new Game("OUTLAST 2", "Outlast 2 is the sequel to the acclaimed survival horror game Outlast." +
            " Set in the same universe as the first game, but with different characters and a different setting.",
            LocalDate.of(2018, 3, 27),
            "Survival", "Switch");

    private Game game12 = new Game("BATTLETECH", "Assume command of your own mercenary outfit of 'Mechs and" +
            " the MechWarriors that pilot them, struggling to stay afloat as you find yourself drawn into a brutal interstellar" +
            " civil war.",
            LocalDate.of(2018, 4, 24),
            "Strategy", "PC");

    public AdminDemo() {
        gamesLibrary.addGame(game1);
        gamesLibrary.addGame(game2);
        gamesLibrary.addGame(game3);
        gamesLibrary.addGame(game4);
        gamesLibrary.addGame(game5);
        gamesLibrary.addGame(game6);
        gamesLibrary.addGame(game7);
        gamesLibrary.addGame(game8);
        gamesLibrary.addGame(game9);
        gamesLibrary.addGame(game10);
        gamesLibrary.addGame(game11);
        gamesLibrary.addGame(game12);
    }

    public GamesLibrary getGamesLibrary() {
        return gamesLibrary;
    }
}
