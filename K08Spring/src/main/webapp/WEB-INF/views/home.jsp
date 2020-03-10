<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spring Framework Start</title>
</head>
<body>


	<h2>Spring에서 JSON 활용하기</h2>
	<li>
		<a href="jsonUse/jsonView.do" target="_blank">
			@ResponseBody 어노테이션을 이용한 JSON데이터 보기
		</a>
	</li>
	<li>
		<a href="jsonUse/login.do" target="_blank">
			Ajax와 JSON을 활용한 비동기방식 로그인
		</a>
	</li>

	<h2>스프링 MVC 시작하기</h2>
	
	<!-- 
	Spring MVC에서는 이미지와 같은 리소스를 사용하기 위해
	별도로 resources폴더를 제공한다. 해당 폴더의 설정은 
	servlet-context.xml에서 한다.
	
	리소스 사용을 위한 resources폴더의 기본 매핑명은
	resources 이지만 엘리먼트 추가로 별칭을 변경하거나
	추가할 수 있다.
	
	<resources mapping="/images/**" location="/resources/" />
	이와같이 추가하면 경로명에 images를 쓸 수 있다.
	-->
	
	
	<h3>첫번째 컨트롤러 만들기</h3>
	<li>
		<a href="./home/helloSpring" target="_blank">
			First Controller
		</a>
	</li>
	
	<h3>Form값 처리하기</h3>
	<li>
		<a href="./form/servletRequest?id=korea&pw=1234" target="_blank">
			HttpServletRequest로 폼값받기
		</a>
	</li>
	<li>
		<a href="./form/requestParam.do?name=한직전&pw=1234&id=koreavc&email=123@korea.com" target="_blank">
			@RequestParam 어노테이션으로 폼값받기
		</a>
	</li>
	<li>
		<a href="./form/gildong/홍길동/1234/abc@naver.com" target="_blank">
			@PathVariable 어노테이션으로 폼값받기
		</a>
	</li>
	<li>
		<a href="./form/commandObject.do?name=한직전&pw=1234&id=koreavc&email=123@korea.com" target="_blank">
			Command(커맨드객체)로 폼값받기
		</a>
	</li>
	
	
	<h3>@RequestMapping 어노테이션 활용하기</h3>
	<li><a href="./requestMapping/index.do" target="_blank">시작페이지 바로가기</a></li>
	
	<h3>DI(Dependency Injection) : 의존성주입</h3>
	<li><a href="di/myCalculator" target="_blank">
	사칙연산 계산기 만들기</a></li>
	<li><a href="di/myAvengers" target="_blank">
	어벤저스 히어로</a></li>
	
	<h3>Environment 객체를 이용한 외부파일 참조하기</h3>
	<li>
		<a href="environment/main.do" target="_blank">
			외부파일 참조하기
		</a>
	</li>
	
	<h3>파일 업로드</h3>
	
	<li>
		<a href="./fileUpload/uploadPath.do" target="_blank">물리적 경로 확인하기</a>
	</li>	
	<li>
		<a href="./fileUpload/uploadForm.do" target="_blank">파일업로드 폼</a>
	</li>	
	<li>
		<a href="./fileUpload/uploadList.do" target="_blank">파일목록보기</a>
	</li>
	<!-- 컨트롤러 : HomeController -->	
	<h3>오라클 접속 테스트</h3>
	<li>
		<a href="./test/dbConnection.do" target="_blank">DB연결 확인하기</a>
	</li>
	<!--  
	Mybatis 구현절차
	
	1.pom.xml에 의존설정
	
		오라클 JDBC원격 레파지토리(저장소)
		<repositories>
			<repository>
				<id>oracle</id>
				<name>ORACLE JDBC Repository</name>
				<url>https://code.lds.org/nexus/content/groups/main-repo</url>
			</repository>
		</repositories>
		
		ojdbc6(오라클 드라이버) 의존설정  		
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>11.2.0.3</version>			
		</dependency>   
		
		<Spring JDBC 의존설정
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>4.1.4.RELEASE</version>			
		</dependency>   
		   		
		mybatis 의존설정
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.2.8</version>			
		</dependency>      		
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.2.2</version>			
		</dependency>      
		
	2. 스프링 설정파일 servlet-context.xml에서 mybatis를 사용하기 위한
		sqlSession Bean을 생성한다.
	
		Spring-JDBC를 통한 오라클 DB연결정보
		<beans:bean name="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
			<beans:property name="driverClassName" value="오라클 드라이버"/>
			<beans:property name="url" value="커넥션 URL"/>
			<beans:property name="username" value="아이디"/>	
			<beans:property name="password" value="패스워드"/>	
		</beans:bean>
		
		<beans:bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
					
			<beans:property name="dataSource" ref="dataSource"/> 
			1번 속성 -> DB 연결정보
			
			<beans:property name="mapperLocations" value="classpath:mybatis/mapper/*.xml"/> 
			2번 속성 -> Mapper파일의 위치정보
				value="classpath:mybatis/mapper/*.xml" => 
					Mapper패키지 하위의 모든 xml파일을 Mapper로 사용하겠다는 의미
			
		</beans:bean>
		<beans:bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
			<beans:constructor-arg index="0" ref="sqlSessionFactory" />
		</beans:bean>		
		
	3.컨트롤러에서 Bean을 자동주입 받는다.
		
		@Autowired
		private SqlSession sqlSession;
		
	4.컨트롤러와 Mapper파일의 중간 매개체 역할을 하는 Interface를 생성하고
	Mapper를 호출하기 위한 추상메소드를 선언한다.
	
	5. Mapper파일 생성
		-mapperLocations으로 지정된 패키지에 xml파일을 생성
		-<Doctype>을 추가한다.
		-<mapper 엘리먼트의 namespace속성에 연결할 Interface를
		패키지명을 포함한 전체경로로 기술한다.
		
		파라미터를 받는 방법
		1. 순서대로 \#{param1}, \#{param2}...
		2. 인덱스순 \#{0}, \#{1}....
		3. @Param 어노테이션을 이용하는 방법
		
	-->
	<h2>Mybatis를 이용한 방명록(한줄게시판) 제작하기</h2>
	<li>
		<a href="mybatis/list.do" target="_blank">게시판 리스트 바로가기</a>
	</li>
	
	
	<h3>resources 폴더 사용하기</h3>
	
	<img src="./1.png" alt="스폰지밥" />
	<img src="./resources/1.png" width="200" alt="스폰지밥" />
	<img src="./images/2.png" alt="징징이" />
	
</body>
</html>
