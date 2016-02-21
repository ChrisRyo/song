package tw.com.service.Impl;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tw.com.entityManager.EntityManagerHelper;
import tw.com.model.vo.Member;
import tw.com.service.MemberService;

/**
 * Session Bean implementation class MemberBean
 */
@Singleton
public class MemberServiceImpl implements MemberService {
	
	@PersistenceContext
	private EntityManager em = EntityManagerHelper.getEntityManager();

    /**
     * Default constructor. 
     */
    public MemberServiceImpl() {
    
    }
    
	/**
	 * 新增用戶
	 * 
	 * @param name
	 *            name
	 * @param pws
	 *            Password
	 * @param email
	 *            Email
	 * @param phone
	 *            Phone
	 * @throws Exception
	 */
	@Override
	public void addUser(String name, String pwd, String email, String phone)
			throws Exception {
		
		EntityTransaction transaction = em.getTransaction();
		try {
			Member member = new Member();
			member.setName(name);
			member.setPwd(pwd);
			member.setEmail(email);
			member.setPhone(phone);

			transaction.begin();
			em.persist(member);
			em.flush();
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error Saving Customer: " + e.getMessage());

			transaction.rollback();
			
			throw new Exception(e.getMessage());
		}
	}
    
    /**
     * 取得所有會員資料
     * 
     * @return
     * @throws Exception
     */
 
	@SuppressWarnings("unchecked")
	@Override
    public List<Member> getMember() throws Exception {
        List<Member> memberList = null;
        Query query = em.createNamedQuery("Member.findAll");
        memberList = (List<Member>) query.getResultList();
        return memberList;
    }

}
