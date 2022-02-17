fun main() {
    //Ȯ�� �Լ�
    val source = "Hello World!"
    val target = "Kotlin"
    println(source.LongString (target)) //source <= Ȯ����(LongString�Լ��� this�� �ȴ�.)


    //���� �Լ�
    val multi = 3 multiply 10 //�Ϲ����� ǥ����: val multi = 3.multiply(10) => ���� ǥ����: .�� () ����
    println("multi: $multi")


    //forEach�� ????
    val numList = arrayListOf(1,2,3,4,5,6) //������: 1 2 3 4 5 6
    numList.forEach {i -> println(i)} //���� i�� ���� ����
    numList.forEach{println(it)} //�Ϲ����� ���: itŰ���� ���� ���
    //forEach�� ����: �ݺ��� �����鼭 �� ���ҿ� ���� �Է°����� ���� action�� �����ϵ��� ����� Ȯ���Լ�. Unit�� return
    //forEach�� continue�� break���� ����� �� ����. break�� �Ϸ��� return@run�� ����ϰ� continue�� �Ϸ��� return@forEach


    //Bclass
    val B = Bclass("�Ѽ���", "����", 20)
    println(B.name)
}


//String Ŭ������ Ȯ�� �Լ��� �߰��� ����
fun String.LongString(target: String): String = if(this.length > target.length) this else target
//this�� target�� ���� ���̸� ���ؼ� �� �� ���̸� ���� ���� ����ϴ� "Ȯ�� �Լ�"
// *Ȯ���Ϸ��� ��� ������ �̸��� ��� �Լ��� �޼��尡 �����Ѵٸ� ��� �޼��尡 �켱���� ȣ��ȴ�.


/*���� �Լ��� ����: 1. ��� �޼��� �Ǵ� Ȯ�� �Լ����� �Ѵ�. 2. �ϳ��� �Ű������� �������Ѵ�. 3. infix Ű����� �����Ѵ�.
Ŭ���� ��� ȣ�� �� ����ϴ� ��(.)�� ����, �Լ� �ڿ� �Ұ�ȣx*/
infix fun Int.multiply (vararg x: Int) : Int { //�������� vararg: �Ű������� ������ �������� ����
    return this * x
}


//Kotlin���� Ŭ���� �����ϱ�: ����, ��� ������Ƽ(����)�� �����ڸ� ���ÿ� �����Ѵ�.
//var�̳� val�� �ٿ� ������ �Ű����� ����� ���ÿ� ������ ������ �Ͱ� ����.
class Aclass(val name: String, var address: String, var age: Int = 22)

class Bclass (name: String, address: String, age: Int) { //var�̳� val�� ������ ������ ������ �Ű������� ������ ���̴�.
    var name: String = name//name ������Ƽ�� ����� ���ÿ� �ʱ�ȭ �������� �Բ� ����Ͽ���. init���� ���ְų� ���⼭ ���ְų�(���ϸ� ������)
    var address1: String //�� ������ �Ű������� �������� ���� �ʿ�� ����!!
    var age: Int //���� ��� ������Ƽ(����)�� �������ش�.
    
    init { //init(��: �ʱ�ȭ)���� ���� ��� ������Ƽ(����)�� �ʱ�ȭ ���־�� �Ѵ�.
        this.address1 = address
        this.age = age
    }
}

// *Kotlin���� ������Ƽ��? ��� ������ �������� setter/getter�� ���� �������� �ʾƵ� �⺻������ ���� �ȴ�.
class Cclass(name: String, address: String, age: Int) {
    var name: String
    var address: String
    get() = "$field Ư����"
    set (address) {
        field = "$address Ư����"
    }
    var age: Int
    
    init{
        this.name = name
        this.address = address
        this.age = age
    }
}