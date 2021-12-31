package com.javastatus.website;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("javastatus.twitter.oauth")
@Data
public class TwitterConfig {
  private String consumerKey;
  private String consumerSecret;
  private String accessToken;
  private String accessTokenSecret;
}
