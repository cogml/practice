import java.util.*

fun main() {
    val input = Scanner(System.`in`) //import java.util.*필요
    val size = input.nextInt() //Scanner로 배열의 행의 개수(Int)를 입력 받는다
    var arr = Array(size,{arrayOf(0,"a")}) //행의 개수의 크기에 맞는 빈 이차원 배열을 선언한다
    for(i in 0..size-1){
        var stri : String = input.nextLine()
        var inte : Int = input.nextInt()
        var pair = Data(stri, inte)
        arr[i][0] = pair.a
        arr[i][1]= pair.b
        println("( ${arr[i][0]}, ${arr[i][1]} )")
    }
    //행의 개수만큼 Data 클래스 타입의 변수를 생성한다.
    //빈 배열에 생성한 변수들을 원소로 넣는다 (forEach문 사용)

    //Filter함수로 원하는 값 필터링 하기
}

//데이터 클래스로 변수쌍을 받을 수 있게 만들자
data class Data(var a: String, var b: Int)

fun Filter(arr: Array<Any>{Array<String>, Array<Int>}, find: Int){ 
    //이차원 배열을 받으려 하기보다는 일차원 배열 두개 받아서 이중for문으로 쓰기
    var list = mutableListOf(mutableListOf(0))
    (0..arr.size-1).forEach {
        if(arr[i][1] = find){
            list.add (mutableListOf(arr[i][0], arr[i][1]))
        }
    }
}

["Str1", 1]
["Str2", 4]

