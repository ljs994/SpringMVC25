package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component 	// 스프링이 의존성 처리해줘
@Data		// import lombok.Data; (게터 세터, tostring, equals 같은걸 만들어준다)

public class Chef {
	
	private String name;
	private int age;

}
