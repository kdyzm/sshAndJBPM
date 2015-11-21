package com.kdyzm.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdyzm.domain.Post;
import com.kdyzm.domain.User;
import com.kdyzm.service.PostService;
import com.kdyzm.service.UserService;

public class Init {
	private static ApplicationContext context;
	static{
		context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
	public static void main(String[] args) {
		initPostData();
		initUserData();
	}
	private static void initPostData(){
		PostService postService=(PostService) context.getBean("postService");
		Post post1=new Post();
		post1.setPname("项目组长");
		Post post2=new Post();
		post2.setPname("总经理");
		Post post3=new Post();
		post3.setPname("总裁");
		Post post4=new Post();
		post4.setPname("会计");
		
		postService.savePost(post1);
		postService.savePost(post2);
		postService.savePost(post3);
		postService.savePost(post4);
	}
	private static void initUserData(){
		UserService userService=(UserService) context.getBean("userService");
		PostService postService=(PostService) context.getBean("postService");
		Post post1=postService.getPostByName("项目组长");
		Post post2=postService.getPostByName("总经理");
		Post post3=postService.getPostByName("总裁");
		Post post4=postService.getPostByName("会计");
		
		User user1=new User();
		user1.setUserName("张三");
		user1.setPassword("xiaozhang");
		user1.setPost(post1);
		
		User user2=new User();
		user2.setUserName("李四");
		user2.setPassword("xiaozhang");
		user2.setPost(post2);
		
		User user3=new User();
		user3.setUserName("王五");
		user3.setPassword("xiaozhang");
		user3.setPost(post3);
		
		User user4=new User();
		user4.setUserName("赵六");
		user4.setPassword("xiaozhang");
		user4.setPost(post4);
		
		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);
	}
}
