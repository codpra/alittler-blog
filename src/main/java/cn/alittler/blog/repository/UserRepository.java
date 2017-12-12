package cn.alittler.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.alittler.blog.domain.User;

/**
 * @description UserRepository
 * @author LiuDecai
 * @date 2017-12-12 16:48:16
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	Page<User> findByNameLike(String name, Pageable pageable);

}
