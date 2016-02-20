package tw.com.webservice;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tw.com.view.bean.UserBean;

@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}
	
	@POST
	@Path("/userpost")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<User> getUserpost(@Valid UserBean bean) {
		List<User> list = userDao.getAllUsers();
		
		list.add(new User(bean.getId(), bean.getName(), bean.getProfession()));
		
		return list;
	}
}