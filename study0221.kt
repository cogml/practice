import java.util.*

fun main(){
    //Scanner => 문자열 입력받기
    val sc = Scanner(System.`in`) // backtick(`)는 키보드 가장 왼쪽 위에 물결~ 이랑 같이 있음
    val str = sc.nextLine()
    println("입력값은 $str")
    
    //init블럭으로 초기화하기
    val person = InitOrder("chaehee")

    val a =Lazy()
    println(a.lazy) //처음에는 Setting lazy가 출력되지만
    println(a.lazy) 

    val test = LazyTest() //initblock이 출력됨
    test.flow()


    // <<Kotlin 고유 표준함수>>
    //let: 객체(w)를 람다 함수 내부에서 it으로 받아서 사용할 수 있다. 반환값은 가장 마지막 코드의 반환값!
    var w: WHAT? = null //WHAT은 데이터 클래스
    val v = w?.let {
        println(it)
    } ?: "Known"
    println(v)

    //자료형 확인 is 연산자
    fun type(k: Any){
        if(k is Int){
            println("정수")
        }
        else {
            println("정수가 아니다")
        }
    }
    
    type("hello")
    type(4)
    type(listOf(1,2,3))


    //재귀함수 (팩토리얼 구현)
    fun factorial(n: Int, ac: Int): Int {
        return if (n<=0) {
            ac
        } else {
            factorial(n-1, n*ac)
        }
    }

    println("팩토리얼: ${factorial(5, 1)}") //5! = 120
}


//public 프로퍼티(변수)
/*class Aclass(name: String) {
    var name: String //앞에 public이 생략 : getter/setter가 제공된 상태
    private var age: Int //private으로 선언 : getter/setter가 없어 외부에서 접근 불가
}*/

//Constructor: 생성자, lateinit 초기화 지연 (+lazy도 알아보기)
class OverLoadingConstructor(name: String) {
    var name: String //init와 constructor블록이 있으니 초 기화 할 필요 없음
    lateinit var address: String //lateinit 키워드가 없으면 초기값을 할당하지 않으면 에러 발생
     // *lateinit: var에서만 사용할 수 있다! [val]이나 [var 변수: Int]이면 컴파일 에러 발생
     // Non-null 모두 사용 가능
    var age: Int = 0

    init{
        this.name = name
    }

    constructor(name: String, address: String, age: Int): this(name) {
        this.name = name
        this.address = address
        this.age = age
    }

}

//Constructor 제공
val overloading1 = OverLoadingConstructor("홍길동")
val overloading2 = OverLoadingConstructor("홍길동", "서울", 21)


//Lazy initialization
class Lazy() {
    val lazy : Int by lazy { //lazy init는 val프로퍼티만 사용 가능, Int와 Boolean 타입도 가능
        println("Setting lazy")
        100 //반환되는 객체값
    }
}

class LazyTest {
    init{
        println("init block")
    }

    val subject by lazy {
        println("lazy initialized")
        "Kotlin Study" //lazy에 대한 반환값
    }

    fun flow(){
        println("lazy initialized")
        println("subject one: $subject") //최초 초기화 시점
        println("subject two: $subject") //이미 초기화된 값
    }
}

        //Primary Constructor
        //어노테이션이나 접근제한자(public, private)를 갖고 있지 않으면 constructor키워드 생략가능
        //class Bclass constructor(name: String) { ... }

//init블럭으로 초기화하기
class InitOrder(name: String) {
    val property1 = "First property: $name".also(::println) //also: kotlin의 고유 표준
    init {
        println("First init block: ${name}")
    }

    val property2 = "Second property: ${name.length}".also(::println)
    init{
        println("Second init block: ${name.length}")
    }
}

data class WHAT(val name: String, val age: Int)
