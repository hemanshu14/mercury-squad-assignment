package com.assignment.usermanagement.feign.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assignment.usermanagement.model.User;

/**
 * @author hemanshu.banga
 *
 */

@FeignClient(name = "${feign.name}", url = "${userdata.api}")
public interface UserDataClient {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	List<User> getUsersData();

}
