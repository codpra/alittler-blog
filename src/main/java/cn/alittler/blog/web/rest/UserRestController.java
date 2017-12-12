package cn.alittler.blog.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.alittler.blog.domain.User;
import cn.alittler.blog.repository.UserRepository;

/**
 * @description UserRestController
 * @author LiuDecai
 * @date 2017-12-12 16:59:25
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 初始化数据
	 */
	@GetMapping("/initial")
	public void initialData() {
		List<User> entities = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			User user = new User();
			user.setName("AA" + i + "ldc");
			entities.add(user);
		}
		userRepository.save(entities);
	}

	@GetMapping("/list")
	public List<User> list(@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<User> page = userRepository.findByNameLike(name, pageable);

		return page.getContent();
	}

}
