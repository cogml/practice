import java.util.*

fun main() {
    var data1 = Data("str1", 1)
    var data2 = Data("str2", 2)
    var data3 = Data("str1", 2)
    var data4 = Data("str2", 1) //n개의 Data클래스 타입의 순서쌍 선언

    var arr : Array<Any> = arrayOf(data1.a, data1.b, data2.a, data2.b, data3.a, data3.b, data4.a, data4.b)
    //처음엔 이차원 배열에 넣으려고 했는데 식이 복잡해져서 일차원배열에 넣고 방법을 생각해봄

    //arr배열이 잘 만들어졌는지 확인하는 단계
    for(i in 0..arr.size-1){
        print("${arr[i]} ")
        if (i%2==1){
            println(" ")
        }
    }

    //lst리스트에 Filter함수로 반환받은 리스트를 넣어주자
    var lst = Filter(arr, 2)
    
    //lst리스트 값을 인쇄하자
    for(i in 0..lst.size-1){
        print(lst[i])
            if (i%2==1){
                println(" ")
            }
    }
}

//데이터 클래스로 변수쌍을 받을 수 있게 만들자
data class Data(var a: String, var b: Int)

fun Filter(arr: Array<Any>, find: Int) : List<Any> { //필터 할 대상 배열, 필터 기준 값(b값)을 매개변수로 받기
    var list = mutableListOf(0)
    for(i in 0..arr.size-1) {
        if(arr[i] == find){
            list.add (arr[i-1])
            list.add (arr[i])
        }
    }
    return list
}