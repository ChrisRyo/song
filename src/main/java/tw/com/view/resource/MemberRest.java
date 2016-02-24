package tw.com.view.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.model.vo.Member;
import tw.com.service.CommonService;


/**
 * 
 * @author chrisryo
 * 
 * 註 : @Consumes接受類型, @Produces返回類型
 *
 */ 
@Path("/member")
public class MemberRest {
	
	@Inject
	private CommonService service;
	
	@GET
	public Viewable init() {
		return new Viewable("/member");
	}
	
	/**
	 * 取所有資料
	 * 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Path("queryAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getAllMember() throws Exception {
		return (List<Member>) service.queryAll(Member.class);
	}
	
	/**
	 *  寫入資料
	 *  
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Member> add(Member member) throws Exception {
		service.insertByEntity(member);
		return (List<Member>) service.queryAll(Member.class);
    }
	
	/**
	 *  更新資料
	 *  
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Member> update(Member member) throws Exception {
		service.updateByEntity(member);
		return (List<Member>) service.queryAll(Member.class);
    }
	
	/**
	 *  寫入資料
	 *  
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@POST
	@Path("remove")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Member> remove(Member member) throws Exception {
		service.deleteByEntity(member);
		return (List<Member>) service.queryAll(Member.class);
    }
	
}