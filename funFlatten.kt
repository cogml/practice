var result_lst = mutableListOf<Any>()
fun main() {
    //[1, 2, [3, 4, [5, 6, 7], 8, 9 ], [10, 11,  [12, 13, [14, 15], 16], 17, [18, 19, 20]]]
    val lst = mutableListOf(1, 2, listOf(3, 4, listOf(5, 6, 7), 8, 9), listOf(10, 11, listOf(12, 13, listOf(14, 15), 16), 17, listOf(18, 19, 20)))
    val result = flatten(lst)
    println(result)
}

fun flatten(lst: MutableList<Any>) : MutableList<Any>{
    for(i in 0..lst.size-1){ 
        if(lst[i] is Int){ //list의 원소가 정수이면
            result_lst.add(lst[i]) //result_lst에 추가하고
        } else { //정수가 아니면, list형태겠지??
            var sub_lst : MutableList<Any> = lst[i] as MutableList<Any> //sub_lst를 만들어서 그 list를 넣자! (as로 타입 확실하게 해주는게 중요!!! 이것 때문에 자꾸 에러뜸...)
            flatten(sub_lst) //재귀함수로 정수로 된 원소들만 추출해내자
        }
    }
    return result_lst //최종적으로 정수형태의 원소들(list형태 없음)이 모인 list를 반환하자
}
