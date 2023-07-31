package me.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.springbootdeveloper.dto.UpdateArticleRequest;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  @Builder
  public Article(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public void update(UpdateArticleRequest updateArticleRequest) {
    this.title = updateArticleRequest.getTitle();
    this.content = updateArticleRequest.getContent();
  }
}
