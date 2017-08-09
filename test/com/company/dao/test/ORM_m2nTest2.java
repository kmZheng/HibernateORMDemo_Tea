package com.company.dao.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.pojo.twowaym2n.Course;
import com.company.dao.pojo.twowaym2n.Score;
import com.company.dao.pojo.twowaym2n.Stu;


public class ORM_m2nTest2 {

	private Configuration configuration;
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction trans;

	@Before
	public void setUp() throws Exception {
		configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		trans = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		trans.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void initDB() {
		System.out.println("create the table from pojo--ORM");
	}

	@Test
	public void test(){
		List<Course> courses = session.getNamedQuery("select_course").setParameter("cid", 2).list();
		for(Course course:courses){
			System.out.println(course);
		}
	}
	
	@Test
	public void twoWaym2n_save() {
		Stu zhao = new Stu("zhao");
		Stu qian = new Stu("qian");
		Course java = new Course("java");
		Course oracle = new Course("oracle");
		Course web = new Course("web");
		Course ssh = new Course("ssh");
		
		//����Course.hbm.xml��<set>��������inverse=true�����ԣ���Զ��ϵ��Stu������ά��
		Score s1 = new Score(zhao,java);
		Score s2 = new Score(zhao,oracle);
		Score s3 = new Score(zhao,web);
		Score s4 = new Score(qian,oracle);
		Score s5 = new Score(qian,web);
		Score s6 = new Score(qian,ssh);
		
		session.save(java);
		session.save(oracle);
		session.save(web);
		session.save(ssh);
		session.save(zhao);
		session.save(qian);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		
	}

	@Test
	public void twoWaym2n_update() {
		Stu stu = (Stu) session.get(Stu.class, 1);
		Course web = (Course) session.get(Course.class, 3);
		Set<Score> scores = web.getScores();
		System.out.println("WEB:");
		for(Score score:scores){
			System.out.println(score.getStu().getStuName()+":"+score.getCourseScore());
		}
		
	}

	@Test
	public void twoWaym2n_delete() {
	}//��

	@Test
	public void twoWaym2n_findAll() {

	}

	@Test
	public void twoWaym2n_findById() {
	
	}
}
