fun main() {
    //[1, 2, [3, 4, [5, 6, 7], 8, 9 ], [10, 11,  [12, 13, [14, 15], 16], 17, [18, 19, 20]]]
    val lst = mutableListOf(1, 2, listOf(3, 4, listOf(5, 6, 7), 8, 9), listOf(10, 11, listOf(12, 13, listOf(14, 15), 16), 17, listOf(18, 19, 20)))

    val result = Flatten(lst)
    println(result)
}

fun Flatten(lst: MutableList<Any>) : MutableList<Any> { //재귀함수로 구현
    var result_lst : MutableList<Any> = mutableListOf()
    var count  = 1
    var size = lst.size
    return if(count <= 0){ //count = 0일 때 까지(count는 정수형이아닌 원소(즉, 배열 형태인 원소)의 개수)
        result_lst
    } 
    else{ 
        count = 0
        for(i in 0..size-1){
            if(lst[i] is Int){ //lst[i]가 정수라면 
                result_lst.add(lst[i]) 
            }
            else{
                count++
                var sub_lst : MutableList<Any> = mutableListOf()
                sub_lst.add(lst[i])
                Flatten(sub_lst)
            }
        count = 0
        }
    }
}

