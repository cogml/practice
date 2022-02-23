fun main(){
    //Override
    println("------오버라이드------")
    val child = Child()
    child.walking()
    val boy = Boy()
    boy.walking()

    //Abstract
    println("------추상화------")
    var rabbit = Rabbit()
    rabbit.eat()
    rabbit.sniff() //sniff는 Animal클래스에서만 정의돈 함수

    //interface
    println("------인터페이스------")
    var outside = Outside()
    outside.run()
    outside.ride()

    //중첩클래스, 내부클래스
    println("------중첩클래스, 내부클래스------")
    Outer.Nested().introduce()//중첩 클래스의 객체를 만들어 함수 호출

    //Outer.Inner().introduceInner() : 내부 클래스는 이렇게 쓰면 오류남
    val outer = Outer()
    val inner = outer.Inner()
    
    //val nested = outer.Nested() : 마찬가지로 중첩 클래스를 이렇게 쓰면 오류남
    //nested.introduce()

    inner.introduceInner()
    inner.introduceOuter()

    outer.text = "Changed Outer Class"
    inner.introduceOuter()

    //set: 정렬되지 않고 중복이 허용되지 않은 컬렉션 => 인덱스로 객체 참조x, mutableSet이 존재
    println("------Set------")
    val a = mutableSetOf("귤", "바나나", "키위")
    for(item in a){ //a set의 모든 객체를 출력
        println("${item}")
    }
    a.add("사과")
    println(a) //list를 출력한 것 처럼 나옴 [귤, 바나나, 키위, 사과]
    
    a.remove("바나나")
    println(a)

    println(a.contains("귤")) //"귤"이 하나라도 들어있으면 true

    //map: 객체를 넣을 때 객체를 찾을 키를 쌍으로 넣어주는 컬렉션, MutableMap이 존재
    //※주의: 같은 Key에 다른 객체를 넣으면 기존의 객체가 대체가 된다.
    println("------Map------")
    val family = mutableMapOf(1 to "엄마", 2 to "아빠", 3 to "언니") //key to value로 입력
    for(entry in family){ 
        println("${entry.key}: ${entry.value}")
    }
    family.put(4, "오빠") //Map에서는 add대신 put을 사용! (remove는 똑같이 씀)
    println(family)

    println(family[3]) //키값으로 객체 출력하기
    //key는 key끼리, value는 value끼리 타입을 맞춰주어야 한다.
}

//override: 상위 클래스의 메소드 재정의
open class Parent { //open키워드로 상속이 가능해졌다.
    open fun walking(){ //walking이라는 함수도 상속이 가능하다! 
        println("walking")
    }
}

class Child : Parent() { //Parent 클래스를 상속한다.
    override fun walking() { //Parent 내부의 함수와 같은 이름의 함수 재정의
        println("child walking") //상위 클래스의 동작을 상속받아 메소드의 동작을 변경
    } 
}

class Boy : Parent() {
    final override fun walking(){ //final 더 이상 overriding을 하지 못한다.
        println("boy walking")
    }
}
//*상위 클래스에서 open이 붙은 함수는 서브 클래스에서 oveeride를 붙여 재정의 가능하다.


//abstract 추상 클래스, 추상 함수
abstract class Animal { //추상 함수가 있는 추상 클래스는 무조건 상속되어야 한다!
    abstract fun eat() 
    fun sniff() {
        println("냄새를 맡습니다")
    }
}

class Rabbit : Animal() { //상위 클래스 명 뒤에 () 붙여주기!!!
    override fun eat() { //상위(Animal) 클래스에는 eat이 전혀 정의되지 않음 (껍데기 상태)
        println("당근을 먹습니다")
    }
}


/*interface : 클래스가 구현해야하는 동작을 지정하는 [추상적인] 자료형이다.
구현된 함수는 open으로, 구현이 없으면 abstract로 간주 => 따로 키워드를 붙일 필요가 없다.
하나의 서브 클래스는 한번에 여러 인터페이스를 상속받을 수 있다.*/
interface Runner {
    fun run()
}

interface Rider {
    fun ride() {
        println("스쿠터를 타다")
    }
}

class Outside: Runner, Rider {
    override fun run() {
        println("달리기를 하다")
    }
    override fun ride() { //인터페이스의 함수를 쓰려면 무조건 override를 붙이고 재정의 해야한다.
        println("자전거를 타다") 
    }
}

/*중첩클래스(Nested Class): 클래스안에 클래스를 넣을 수 있다. 
중첩클래스는 외부 클래스의 내용을 공유할 수 없다
내부클래스(Inner Class): 혼자서 객체를 만들 수 없고 외부 클래스의 객체가 있어야 한다
외부 클래스의 속성과 함수의 이용이 가능하다.*/
class Outer {
    var text = "Outer Class"
    class Nested { //중첩 클래스
        fun introduce() {
            println("Nested Class")
        }
    }

    inner class Inner { //내부 클래스
        var text = "Inner Class" //Outer클래스와 같은 속성 text
        fun introduceInner(){
            println(text)
        }

        fun introduceOuter() {
            println(this@Outer.text) //Outer클래스와 Inner클래스에 같은 이름의 속성이나 클래스가 있을때 this@Outer클래스명 으로 참조
        }
    }
}