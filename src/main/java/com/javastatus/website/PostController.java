package com.javastatus.website;

import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.dto.tweet.Tweet;
import io.github.redouane59.twitter.signature.TwitterCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

  TwitterConfig twitterConfig;

  @Autowired
  public PostController(TwitterConfig twitterConfig) {
    this.twitterConfig = twitterConfig;
  }

  @GetMapping("/post")
  void post() {
    final TwitterClient client = new TwitterClient(
            TwitterCredentials.builder()
                    .apiKey(twitterConfig.getConsumerKey())
                    .apiSecretKey(twitterConfig.getConsumerSecret())
                    .accessToken(twitterConfig.getAccessToken())
                    .accessTokenSecret(twitterConfig.getAccessTokenSecret())
                    .build()
            );

    try {
      final Tweet tweet = client.postTweet("Another random tweet.");

      System.out.println("Text: " + tweet.getText());
    } catch (RuntimeException e) {
      System.out.println("ERROR " + e.getMessage());
    }
  }
}
