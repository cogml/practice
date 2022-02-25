fun main() {
    val box: Box<Int> = Box<Int>(1)
    //파라미터의 타입 추론이 가능할 땐 type argument를 생략하여 [ val box = Box(1) ]라고 쓸 수 있다.
    println(box.value)
    println(ConstClass.CONST_VAL)
}

//제네릭 프로그래밍: 데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있는 기술에 중점을 두어 재사용성을 높일 수 있는 프로그래밍 방식

//제네릭 클래스
class Box<T>(t: T) { //T는 type parameter
    var value = t //클래스의 인스턴스를 생성할 때 type argument 를 제공해야 한다.
}

//const val: 특정한 고정된 값을 사용하고 싶을 때
class ConstClass() { //const val은 클래스 생성자로 할당할 수 없다!!!
    companion object{
        const val CONST_VAL = 100 //컴파일시에 결정되는 상수, 특징: 변수 명이 대문자+"_"로 결정
    }
}