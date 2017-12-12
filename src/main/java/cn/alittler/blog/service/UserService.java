package cn.alittler.blog.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.alittler.blog.domain.User;

/**
 * @description User Service
 * @author LiuDecai
 * @date 2017-12-12 16:49:55
 */
public interface UserService {

	/**
	 * 新增用户
	 * 
	 * @param entity
	 *            用户实体
	 * @return
	 */
	User createUser(User entity);

	/**
	 * 删除用户
	 * 
	 * @param id
	 *            用户ID
	 */
	void deleteUser(Integer id);

	/**
	 * 更新用户
	 * 
	 * @param entity
	 *            用户实体
	 */
	void updateUser(User entity);

	/**
	 * 查询所有用户
	 * 
	 * @return 返回所有用户
	 */
	List<User> getUsers();

	/**
	 * 根据条件分页查询
	 * 
	 * @param pageNo
	 *            当前页号
	 * @param pageSize
	 *            每页有多少条信息
	 * @param name
	 *            查询条件
	 * @param pageable
	 *            分页信息
	 * @return 返回分页结果
	 */
	Page<User> getUserPage(int pageNo, int pageSize, String name, Pageable pageable);

}
