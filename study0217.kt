fun main() {
    //확장 함수
    val source = "Hello World!"
    val target = "Kotlin"
    println(source.LongString (target)) //source <= 확장대상(LongString함수의 this가 된다.)


    //중위 함수
    val multi = 3 multiply 10 //일반적인 표현법: val multi = 3.multiply(10) => 중위 표현법: .과 () 생략
    println("multi: $multi")


    //forEach문 ????
    val numList = arrayListOf(1,2,3,4,5,6) //실행결과: 1 2 3 4 5 6
    numList.forEach {i -> println(i)} //변수 i에 값을 지정
    numList.forEach{println(it)} //암묵적인 방법: it키워드 변수 사용
    //forEach의 정의: 반복을 돌리면서 각 원소에 대해 입력값으로 받은 action을 수행하도록 만드는 확장함수. Unit을 return
    //forEach는 continue와 break문을 사용할 수 없다. break를 하려면 return@run을 사용하고 continue를 하려면 return@forEach


    //Bclass
    val B = Bclass("한석봉", "광주", 20)
    println(B.name)
}


//String 클래스에 확장 함수를 추가해 보자
fun String.LongString(target: String): String = if(this.length > target.length) this else target
//this와 target의 문자 길이를 비교해서 더 긴 길이를 가진 값을 출력하는 "확장 함수"
// *확장하려는 대상에 동일한 이름의 멤버 함수나 메서드가 존재한다면 멤버 메서드가 우선으로 호출된다.


/*중위 함수의 조건: 1. 멤버 메서드 또는 확장 함수여야 한다. 2. 하나의 매개변수를 가져야한다. 3. infix 키워드로 정의한다.
클래스 멤버 호출 시 사용하는 점(.)을 생략, 함수 뒤에 소괄호x*/
infix fun Int.multiply (vararg x: Int) : Int { //가변인자 vararg: 매개변수의 개수가 고정되지 않음
    return this * x
}


//Kotlin으로 클래스 선언하기: 먼저, 멤버 프로퍼티(변수)와 생성자를 동시에 선언한다.
//var이나 val을 붙여 생성자 매개변수 서언과 동시에 변수를 선언한 것과 같다.
class Aclass(val name: String, var address: String, var age: Int = 22)

class Bclass (name: String, address: String, age: Int) { //var이나 val을 붙이지 않으면 생성자 매개변수만 선언한 것이다.
    var name: String = name//name 프로퍼티는 선언과 동시에 초기화 구문까지 함께 기술하였다. init에서 해주거나 여기서 해주거나(안하면 오류남)
    var address1: String //꼭 생성자 매개변수랑 변수명이 같을 필요는 없다!!
    var age: Int //따로 멤버 프로퍼티(변수)를 선언해준다.
    
    init { //init(뜻: 초기화)블럭을 통해 멤버 프로퍼티(변수)를 초기화 해주어야 한다.
        this.address1 = address
        this.age = age
    }
}

// *Kotlin에서 프로퍼티란? 멤버 변수를 말하지만 setter/getter를 따로 선언하지 않아도 기본적으로 생성 된다.
class Cclass(name: String, address: String, age: Int) {
    var name: String
    var address: String
    get() = "$field 특별시"
    set (address) {
        field = "$address 특별시"
    }
    var age: Int
    
    init{
        this.name = name
        this.address = address
        this.age = age
    }
}