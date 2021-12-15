package telran.b7a.forum.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.b7a.forum.dao.PostRepository;
import telran.b7a.forum.dto.NewCommentDto;
import telran.b7a.forum.dto.NewPostDto;
import telran.b7a.forum.dto.PostDto;
import telran.b7a.forum.dto.exceptions.PostNotFoundException;
import telran.b7a.forum.model.Post;

@Service
public class ForumServiceImpl implements ForumService {

	PostRepository postRepository;
	ModelMapper modelMapper;

	@Autowired
	public ForumServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
		this.postRepository = postRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PostDto addNewPost(NewPostDto newPost, String author) {
		Post post = new Post(newPost.getTitle(), newPost.getContent(), author, newPost.getTags());	
		return modelMapper.map(postRepository.save(post), PostDto.class);
	}

	@Override
	public PostDto getPost(String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto removePost(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(NewPostDto postUpdateDto, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLike(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public PostDto addComment(String id, String author, NewCommentDto newCommentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PostDto> findPostsByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
