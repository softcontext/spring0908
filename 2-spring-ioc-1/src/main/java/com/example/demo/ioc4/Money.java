package com.example.demo.ioc4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Value Object: 값을 보관하는 용도의 객체는 
// 일반적으로 빈 컨테이너에 등록하지 않는다. 
// 왜냐하면 컨테이너에 등록하는 객체는 Singleton 써도 되는 객체들만 
// 사용하기 때문입니다. 개발자가 필요할 때 직접 new 해서 사용합니다.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Money {
	private int amount;
}
