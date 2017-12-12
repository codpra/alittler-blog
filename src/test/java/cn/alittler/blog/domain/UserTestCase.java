package cn.alittler.blog.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import cn.alittler.blog.repository.UserRepository;

/**
 * @description UserTestCase
 * @author LiuDecai
 * @date 2017-12-12 17:10:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestCase {

	@Autowired
	UserRepository userRepository;

	/**
	 * 测试插入数据
	 */
	@Test
	public void testUserRepositorySaveAndFind() {
		List<User> entities = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			User user = new User();
			user.setName("AA" + i + "ldc");
			entities.add(user);
		}
		userRepository.save(entities);

		Assert.assertEquals(50, userRepository.findAll().size());
	}

	/**
	 * 测试查询数据
	 */
	@Test
	public void testUserRepositoryFindBy() {
		System.out.println(userRepository.findAll());
		Pageable pageable = new PageRequest(1, 20);
		Page<User> page = userRepository.findByNameLike("%9%", pageable); // 9、19、29、39、49
		assertThat(page.getTotalElements()).isEqualTo(5);
	}

}
