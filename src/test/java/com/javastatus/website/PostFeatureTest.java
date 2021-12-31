package com.javastatus.website;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostFeatureTest {

  @LocalServerPort
  int port;

  WebDriver driver;

  @BeforeEach
  void setup() {
    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
  }

  @AfterEach
  void tearDown() { driver.close(); }

  @Test
  void postsToTwitter() {
    givenUserIsLoggedIn();
    whenTheyPressTweetNow();
    thenTweetAppearsOnTwitter();
  }

  private void thenTweetAppearsOnTwitter() {
    driver.navigate().to(String.format("http://localhost:%d", port));
  }

  private void whenTheyPressTweetNow() {

  }

  private void givenUserIsLoggedIn() {

  }
}
