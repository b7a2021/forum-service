package telran.b7a.forum.dao;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.b7a.forum.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	Stream<Post> findByAuthor(String author);

}
