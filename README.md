# MAL-Data-Scraper
Scraps Anime information from the site [MyAnimeList](https://myanimelist.net/).

## Dependencies 

* Java SDK (version 1.8 or newer)
* [jsoup library](https://jsoup.org/)
* [json-simple library](https://github.com/fangyidong/json-simple)

## Installing

The class `.java` files are in the "Source Code" folder, the `.jar` file is in the "searchMAL_jar" folder. 

Note that neither Maven or Gradle are supported at the moment.

## Documentation

The main class is the `Anime` class, which will contain all the information of said anime.

To create an `Anime` object, you call `AnimeSearch.animeSearch("anime name")`, where `"anime name"` is the title of the anime which you want to search up. For example,
```java
Anime ani = AnimeSearch.animeSearch("fma"); // returns an Anime object for the anime "fma"
```
An `Anime` object has the following properties:
```java
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
```
An `Anime` object has the following functions:
```java
printInfo() // prints out all the properties of an Anime object

json() // returns all the properties of an Anime object in json format as a String

export("file name") // exports all the properties of Anime object into a .txt file called "file name"
```

## Examples

```java
Anime ani = AnimeSearch.animeSearch("one piece");
System.out.println("Title: " + ani.title);
System.out.println("Rank: " + ani.rank);
System.out.println("Genres: " + ani.genre);
System.out.println(ani.json());

// Console Output
Title: One Piece
Rank: #93
Genres: Action, Adventure, Comedy, Super Power, Drama, Fantasy, Shounen
{
  "score": 8.53,
  "favourites": 76170,
  "genres": "Action, Adventure, Comedy, Super Power, Drama, Fantasy, Shounen",
  "popularity": "#36",
  "members": 795306,
  "link": "https://myanimelist.net/anime/21/One_Piece",
  "votes": 461244,
  "ranking": "#93",
  "synopsis": "Gol D. Roger was known as the \"Pirate King,\" the strongest and most infamous being to have sailed the Grand Line. The
  capture and execution of Roger by the World Government brought a change throughout the world. His last words before his death revealed
  the existence of the greatest treasure in the world, One Piece. It was this revelation that brought about the Grand Age of Pirates,
  men who dreamed of finding One Piece—which promises an unlimited amount of riches and fame—and quite possibly the pinnacle of glory
  and the title of the Pirate King. Enter Monkey D. Luffy, a 17-year-old boy who defies your standard definition of a pirate. Rather
  than the popular persona of a wicked, hardened, toothless pirate ransacking villages for fun, Luffy’s reason for being a pirate is one
  of pure wonder: the thought of an exciting adventure that leads him to intriguing people and ultimately, the promised treasure.
  Following in the footsteps of his childhood hero, Luffy and his crew travel across the Grand Line, experiencing crazy adventures,
  unveiling dark mysteries and battling strong enemies, all in order to reach the most coveted of all fortunes—One Piece.",
  "title": "One Piece",
  "type": "TV",
  "episodes": "Unknown"
}
```

## Built With

* Java

## Author(s)

* Bob Huang
