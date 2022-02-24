fun main(){
    //Data class의 기능
    println("------Data Class-------")
    val a = General("홍길동", 123) //일반클래스로 객체 생성
    val b = Data("전우치", 456) //Data클래스로 객체 생성
    val b1 = Data("전우치", 456)
    
    println(a == General("홍길동", 123)) //equals()함수 기능을 하는지 테스트
    //위의 equals()값이 false가 나오는 이유는 hashCode()값이 다르기 때문이다
    println("hashCode: ${a.hashCode()}") //hashCode()함수값 출력
    println("hashCode: ${General("홍길동", 123).hashCode()}")
    println(a) //toString()의 결과값을 확인하기 위해 값 그대로 출력
    //a에 객체에 대한 출력값은 제대로 동작하지 않음..

    println(b == Data("전우치", 456))
    println("hashCode: ${b.hashCode()}") //값이 같으면 hashCode()값도 같아진다??
    println("hashCode: ${Data("전우치", 456).hashCode()}")
    println("hashCode: ${b1.hashCode()}")
    println(b)
    println("b_toString: ${b.toString()}")
    println("tostring한 hashcode: ${b.toString().hashCode()}")

    println(b.copy()) //b를 copy()한 결과 출력
    println("hashCode: ${b.copy().hashCode()}") //copy후 hashcode
    println(b.copy("심청이")) //b를 copy()하여 이름을 수정한 결과 출력
    println("hashCode: ${b.copy("심청이").hashCode()}")
    println(b.copy(id = 789)) //named argument를 통해 id만 바꾼 결과 출력

    val list = listOf(Data("엄마",69), Data("아빠", 66), Data("언니", 95))
    for((x,y) in list) { //for문으로 순회하기 위해 두 속성을 받을 이름을 지정한다
        println("$x : $y") //내부적으로 component1(), component2()함수로 값을 불러온다.
    }

    //Enum class
    println("------Enum Class-------")
    var state = State.SING //선언시에 만든 객체를 이름으로 참조하여 그대로 사용한다.
    println(state)

    state = State.SLEEP
    println(state.isSleeping())

    state = State.EAT
    println(state.msg)

    //vararg(Variable number of arguments: 가변인자-변하기 쉬운 인수의 개수)
    println("------Vararg-------")
    fun sum(vararg numbs : Int) : Int {
        var result = 0
        for(num in numbs) {
            result += num
        }
        return result
    }
    println(sum(2,4,6)) //매개변수의 개수: 3
    println(sum(1,3,5,7,9)) //매개변수의 개수: 5

    //vararg(Variable number of arguments: 가변인자-변하기 쉬운 인수의 개수)
    println("------isInitialized-------")
    Test_Initialized().init() //클래스().함수()를 실행

    //Infix함수
    println("------Infix-------")
    //아래 함수의 dispatcher은 String타입, receiver은 String타입의 other라는 변수이다.
    infix fun String.add(other: String): String { //함수명은 add
        return this + other //this는 dispatcher객체를 의미한다.
    }
    val string = "Hello" add " World!" //Hello는 this가 되고, World는 other가 된다.
    println(string)

    val stri = MyString()
    stri add "Hello"
    stri add " World"
    println(stri.string) //string은 MyString클래스의 함수
}

//Data class에 대한 설명 정리 on Notion

//일반클래스와 데이터 클래스를 만들어 비교해보자!
class General(val name: String, val id: Int)
data class Data(val name: String, val id : Int)

//Enum class에 대한 설명 정리 on Notion: 상태를 구분하기 위한 여러 객체를 포함하는 클래스
enum class State(val msg: String) {
    SING("노래를 부르다"),
    EAT("밥을 먹는다"),
    SLEEP("잠을 잔다"); //세미콜론(;)으로 마무리해주기!!!
    fun isSleeping() = this == State.SLEEP
}

//isInitialized를 사용해보자!
class Test_Initialized {
    lateinit var lateTest : String //문자형으로 주어진 lateTest변수
    fun init() { //init라는 함수는 init(초기화=값을 주기)전과 후에 초기화 여부 출력
        println("init전: ${this::lateTest.isInitialized}") //변수명.isInitialized 앞에 ::을 붙여준다.
        lateTest = "값을 넣어주자"
        println("init후: ${this::lateTest.isInitialized}")
    }
}

//클래스 내에 Infix함수 정의 : dispatcher가 클래스 자신이 되므로 생략 가능
class MyString {
    var string = ""
    infix fun add(other: String) {
        this.string = this.string + other //이 클래스의 string뒤에 other을 붙이자
    }
}