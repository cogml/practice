fun main(args: Array<String>) {
    var array = arrayOf(1, 2, 3, 4)
    var re_array = reverse(array)
    re_array.forEach {
        println(it)
    }
}

fun reverse(arr: Array<Int>) : Array<Int?> {
    var reverse_arr = arrayOfNulls<Int>(arr.size)
    for(i in 0..arr.size-1){
        reverse_arr[i] = arr[arr.size-1-i]
    }
    return reverse_arr
}