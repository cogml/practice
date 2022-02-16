fun main() {
    val arr = arrayListOf(1,2,3,4,5)
    reverse(arr)
}

fun reverse(arr: ArrayList<Int>){
    var reverse_arr = arrayListOf(1,2,3,4,5)
    for(i in 0..4){
        reverse_arr[i] = arr[4-i]
        println(reverse_arr[i])
    }
}