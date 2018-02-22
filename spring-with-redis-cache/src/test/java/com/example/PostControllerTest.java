package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controllers.PostController;
import com.example.model.Author;
import com.example.model.Post;
import com.example.services.PostService;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=RedisCacheApplication.class)
@WebMvcTest(PostController.class)
@Import(EmbeddedRedisTestConfiguration.class)
public class PostControllerTest {
	
	@Autowired
    private MockMvc mvc;
	@MockBean
	private PostService postService;
	
	private List<Post> posts;
	
	
	@Before
	public void setUp() {
		posts = new ArrayList<>();
        posts.add(new Post("IDX001", "Cyberpunk is near", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 555, new Author("Anna")));
        posts.add(new Post("IDX002", "Welcome aboard of the hype train", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Josh")));
        posts.add(new Post("IDX003", "How to improve programming skills ", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 555, new Author("Kobe")));
        posts.add(new Post("IDX004", "Top exercises for IT people", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Leo")));
        posts.add(new Post("IDX005", "Case study of 75 years project", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Tom")));
        posts.add(new Post("IDX006", "Machine Learning", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 255, new Author("Alexa")));
        posts.add(new Post("IDX007", "Memory leaks, how to find them ", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Frank")));
        posts.add(new Post("IDX008", "Robots builds robots", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 155, new Author("Milagros")));
        posts.add(new Post("IDX009", "Quantum algorithms, from the scratch", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 455, new Author("Sarah")));
        posts.add(new Post("IDX010", "Coding, coding, coding", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 255, new Author("Adam")));
        given(postService.getTopPosts()).willReturn(posts);
	}

	@Test
	public void testGetTopPosts() throws Exception{
		mvc.perform(get("/posts/top")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
		  verify(postService, VerificationModeFactory.times(1)).getTopPosts();
	        reset(postService);
		
	}

}
