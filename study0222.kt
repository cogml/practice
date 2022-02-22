fun main() {
    //-----람다함수 : 여러 구문의 사용-----
    val c: (String) -> Int = {str ->
        println("$str 람다함수")
        println("여러구문 사용")
        3 //마지막 구문에 결과값이 반환된다.
        }
    //파라미터가 하나인 람다함수 : it 사용
    val d: (String) ->Unit = {println("$it 람다함수")}


    //-----Kotlin scope 함수-----
    //(1) let : 지정된 값이 null이 아닌 경우, nullable객체를 다른 nullable로 변환
    println("<<let>>")
    var w1: WHAT? = null //WHAT은 데이터 클래스
    val v1 = w1?.let { //w1이 null일 경우 람다식 수행x
        println(it)
    } ?: "Known"
    println(v1)

    var ww1: WHAT? = WHAT("Let", 20)
    val vv1 =ww1?.let {
        println(it) //<it>사용
    } ?: "Known"

    //(2) also
    println("<<also>>")
    var w2 : WHAT? = null
    val v2 = w2?.also {
        println(it) //null이므로
    }?: "Known" //?:뒤의 값인 Known이 출력
    println(v2) //반환값은 null

    var ww2: WHAT? = WHAT("Also", 20)
    val vv2 = ww2?.also { //also는 받은 객체를 <it>으로 받아 사용
        println(it) //받은 객체를 그대로 반환
    } ?: "Known"
    println(vv2)

    //(3) apply //받은 객체를 람다 함수 내부에서 it이 아닌 this로 처리, 받은 객체 그대로 반환
    println("<<apply>>")
    val w3 = What("Apply", 10) //w3 = (Apply, 10)
    val r3 = w3.apply { //apply에 의해 r3 = w3 = (A, 20)
        name = "A"
        age = 20
    }
    println(w3)
    println(r3)

    //(4) with
    println("<<with>>")
    val w4 = What("With", 10)
    val r4 = w4?.let{
        with(it) {
            name = "W"
            age = 20
            "Hello"
        }
    }
    println(w4)
    println(r4)

    //(5) run
    println("<<run>>")
    val v5 = run {
        val w5 = What("Run", 10)
        w5 //마지막 구문에 결과값을 반환
    }
    println(v5)

    val vv5 = v5.run {
        name = "R"
        age = 20
        "Hello!"
    }
    println(v5)
    println(vv5)


    var price =4000 //Book클래스의 속성이름과 같은 변수를 하나 생성 => 지우고 돌려보기!
    //apply : 인스턴스 자신을 다시 반환함 => 생성되자마자 변수에 바로 넣음
    var book = Book("KotlinBook", 9000).apply {
        name = "[초특가]" + name
        discount()
    }

    //run : apply와 달리 마지막 구문에 결과값을 반환
    println("-----run-----")
    book.run{
        println("상품명: ${name}, 가격: ${price}원") //discount(할인)된 가격으로 출력됨
    } //※ price변수: Book클래스보다 main의 변수를 우선시함!!! => also, let사용

    //also: apply와 같은 기능, it을 통해 인스턴스를 사용
    //let: run과 같은 기능(with랑도 같은 기능), it을 통해 인스턴스를 사용
    //also와 let을 사용하는 이유: 같은 이름의 변수나 함수가 'scope 바깥에 중복'된 경우에 혼란을 방지
    println("-----let-----")
    book.let{
        println("상품명: ${it.name}, 가격: ${it.price}원")
    }

    //with : run과 동일한 기능, 인스턴스를 참조연산자 대신 파라미터로 받는다. 그게 뭔말이냐..=> a.run{ ... }이었다면, with(a){ ... }로 사용한다.


    //------컬렉션 함수------
    val namelist = listOf("박수영", "김지수", "김다현", "신유나", "김지우")
    println(namelist.filter{ it.startsWith("김")}) //filter와 startWith로 김씨인 사람만 출력
    println(namelist.map{"이름: " + it}) //map으로 모든 원소 앞에 "이름: "을 붙여 출력
    
    println(namelist.any{it == "김지현"}) //"김지현"이 <한명이라도> 있는지 Boolean(true/false)
    println(namelist.all{it.length == 3}) //<모든> 이름이 세글자인지
    println(namelist.none{it.startsWith("이")})//"이"로 시작하는 사람이 아무도 없는지

    println(namelist.first{it.startsWith("김")}) //first로 "김"으로 시작하는 <첫번째> 사람 출력
    println(namelist.last{it.startsWith("김")}) //last로 "김"으로 시작하는 <마지막> 사람 출력
    println(namelist.count{it.contains("지")}) //count와 contains로 "지"가 들어간 사람 <몇명>인지 출력

    //------컬렉션 함수2------
    data class Person(val name: String, val birth: Int)
    val personlist = listOf(Person("유나", 1992), 
                            Person("조이", 1996), 
                            Person("츄", 1999),
                            Person("유나", 2003))

    println(personlist.associateBy {it.birth}) //person객체의 birth를 기준으로 map을 만들어 출력
    println(personlist.groupBy {it.name}) //person객체의 이름을 기준으로 묶어 map을 만들어 출력
    
    val(over98, under98) = personlist.partition {it.birth > 1998} //partion을 통해 birth가 98년도 이전, 이후로 나눈다
    println(over98)
    println(under98)
}

data class WHAT(val name: String, val age: Int)
data class What(var name: String, var age : Int)
class Book(var name: String, var price: Int){
    fun discount(){
        price -= 2000
    }
}