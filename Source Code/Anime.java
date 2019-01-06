import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.simple.JSONObject;

public class Anime {
    String link;
    String title;
    String type;
    String episodes;
    String genre;
    float score;
    int votes;
    String rank;
    String popularity;
    int members;
    int favourites;
    String synopsis;

    public Anime(String link, String title, String type, String episodes, String genre, float score,
                 int votes, String rank, String popularity, int members, int favourites, String synopsis) {
        this.link = link;
        this.title = title;
        this.type = type;
        this.episodes = episodes;
        this.genre = genre;
        this.score = score;
        this.votes = votes;
        this.rank = rank;
        this.popularity = popularity;
        this.members = members;
        this.favourites = favourites;
        this.synopsis = synopsis;
    }

    public void printInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Link: " + this.link);
        System.out.println("Type: " + this.type);
        System.out.println("Episodes: " + this.episodes);
        System.out.println("Genres: " + this.genre);
        System.out.println("Score: " + this.score);
        System.out.println("Votes: " + this.votes);
        System.out.println("Ranking: " + this.rank);
        System.out.println("Popularity: " + this.popularity);
        System.out.println("Members: " + this.members);
        System.out.println("Favourites: " + this.favourites);
        System.out.println(" ");
    }

    private String returnInfo() {
        String info =
                "Title: " + this.title + "\nLink: " + this.link + "\nType: " + this.type + "\nEpisodes: "
                + this.episodes + "\nGenres: " + this.genre + "\nScore: " + this.score + "\nVotes: " + this.votes
                + "\nRanking: " + this.rank + "\nPopularity: " + this.popularity + "\nMembers: " + this.members
                + "\nFavourites: " + this.favourites;
        return info;
    }

    public String json() throws IOException {
        JSONObject info = new JSONObject();
        info.put("title", this.title);
        info.put("link", this.link);
        info.put("synopsis", this.synopsis);
        info.put("type", this.type);
        info.put("episodes", this.episodes);
        info.put("genres", this.genre);
        info.put("score", this.score);
        info.put("votes", this.votes);
        info.put("ranking", this.rank);
        info.put("popularity", this.popularity);
        info.put("members", this.members);
        info.put("favourites", this.favourites);

        StringWriter out = new StringWriter();
        info.writeJSONString(out);

        return out.toString();
    }

    public void export(String fileName) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName + ".txt", true));
        out.println("Title: " + this.title);
        out.println("Link: " + this.link);
        out.println("Type: " + this.type);
        out.println("Episodes: " + this.episodes);
        out.println("Genres: " + this.genre);
        out.println("Score: " + this.score);
        out.println("Votes: " + this.votes);
        out.println("Ranking: " + this.rank);
        out.println("Popularity: " + this.popularity);
        out.println("Members: " + this.members);
        out.println("Favourites: " + this.favourites);
        out.println("\n");
        out.close();
    }

}
