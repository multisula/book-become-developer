package me.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.springbootdeveloper.domain.Article;
import me.springbootdeveloper.dto.AddArticleRequest;
import me.springbootdeveloper.dto.UpdateArticleRequest;
import me.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
  private final BlogRepository blogRepository;

  public Article save(AddArticleRequest request) {
    return blogRepository.save(request.toEntity());
  }

  public List<Article> findAll() {
    return blogRepository.findAll();
  }

  public Article findById(long id) {
    return blogRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
  }

  public void delete(long id) {
    blogRepository.deleteById(id);
  }

  @Transactional
  public Article update(long id, UpdateArticleRequest updateArticleRequest){
    Article article = blogRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

    article.update(updateArticleRequest);

    return article;
  }
}
