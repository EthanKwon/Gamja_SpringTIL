package com.example.Spring02;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// JUnit 4.0으로 현재 클래스를 실행 시키기 위해서 
@RunWith(SpringJUnit4ClassRunner.class)

// MyBatis에서 참조하는 설정 파일의 위치를 알려주기 위해서 
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class MyBatisTest {
	//로깅 처리를 위한 코드
	private static final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
	
	@Inject // 의존관계 주입(스프링에서 객체를 생성해서 전달)
	// 즉, root-context.xml 파일안에 SqlSessionFactory 객체를 생성해 놓았음
	//그러므로 @Inject란 개념은 스프링에서 이미 만들어 놓은 객체를 가져다 쓴다는 의미 
	private SqlSessionFactory sqlFactory;

	@Test
	public void testFactory() {
		logger.info("sqlFactory : " + sqlFactory);
	}
	
	@Test
	public void testSession() {
		try(SqlSession sqlSession = sqlFactory.openSession()){
			logger.info("sqlSession : " + sqlSession);
			logger.info("mybatis 연결 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
