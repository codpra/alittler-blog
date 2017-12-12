package cn.alittler.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.alittler.blog.domain.User;
import cn.alittler.blog.repository.UserRepository;
import cn.alittler.blog.service.UserService;

/**
 * @description User Service Implementation
 * @author LiuDecai
 * @date 2017-12-12 16:53:35
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User entity) {
		userRepository.save(entity);
		return entity;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.delete(id);
	}

	@Override
	public void updateUser(User entity) {
		userRepository.saveAndFlush(entity);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> getUserPage(int pageNo, int pageSize, String name, Pageable pageable) {
		PageRequest pageRequest = new PageRequest(pageNo, pageSize);
		Page<User> page = userRepository.findByNameLike(name, pageRequest);
		return page;
	}

}
