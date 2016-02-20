package tw.com.service;

import java.util.List;

import tw.com.model.vo.Member;

public interface MemberService {

	/**
	 * 新增用戶
	 * 
	 * @param id
	 *            Id
	 * @param pws
	 *            Password
	 * @param email
	 *            Email
	 * @param phone
	 *            Phone
	 * @throws Exception
	 */
	public void addUser(String id, String pws, String email, String phone)
			throws Exception;
	
	
    /**
     * 取得所有會員資料
     * 
     * @return List<Member>
     * @throws Exception
     */
    public List<Member> getMember() throws Exception;

}
