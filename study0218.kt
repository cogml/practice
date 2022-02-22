fun main(){
    var a= People()
    a.name = "tom"
    println(a.name)

    val jenny = Age()
    jenny.actualAge = 15
    jenny.age = 15
    println("jenny actual age: ${jenny.actualAge}")
    println("jenny set age: ${jenny.age}")

    //forEachIndex: forEach와 다른 점은 몇 번째 원소를 사용하는지 index를 알 수 있다는 점
    val lst = listOf(1,2,3,4,5,6)
    lst.forEachIndexed {index, value -> println("index[$index]: $value")} //람다식으로 처리

    //return@forEach : forEach문 continue기능
    (1..10).forEach{
        println(it)
        if(it ==5)
            return@forEach //continue기능
    }
    println("done")

    //return@forEach : forEach문 break기능
    run{
        (1..10).forEach{
        println(it)
        if(it ==5)
            return@run //break기능
    }
    println("done")
    }

    //이차원 배열
    var array2 = Array(2, {Array(2, {0})}) //초기값을 0으로 하는 2x2인 2차원 배열
    for(i in 0..1){
        for(j in 0..1){
            println(array2[i][j])
        }
    }

    println("\n")

    //이차원 리스트
    var list2 = mutableListOf(mutableListOf(0))
    list2.add (mutableListOf(6, 2))
    for(i in 0..list2.size-1){
        println(list2.get(i))
    }
}


//Getter와 Setter
class People { //프로퍼티만 존재하여 데이터만 저장하는 용도의 클래스 => 데이터 클래스로 선언해보자
    var name: String = "default"
    get() = field //field: 정의된 실제 값, property의 accessor에서만 접근 가능
    set(value) { //value말고 다른 것을 써도 된다. value는 외부에서 입력받는 값
        field = value
    }
}

class Age() {
    var age: Int = 0
    get() { //get(Value)는 오류남!!!
        println("-실제 나이")
        return field
    }

    set(value) { //value는 입력받는 값: main에서는 age가 value역할을 하게된다.
        field = when {
            value < 18 -> 18
            value in 18..30 -> value
            else -> value -3
        }
        println("-범위에 따른 나이")
    }
    var actualAge = 0
}
