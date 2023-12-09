package hu.gde.food

fun main() {
//    println("gde")

//    var a = "asdf"
//    a = "sdfdsf"
//    println(a)

//    var i: Int
//    println(i)

//    lateinit var e: String
//    e = "sdfds"
//    println(e)

//    var nullable: String? = null
//    if (nullable != null) {
//        println(nullable)
//    }
//    nullable?.let { text ->
//        println(text)
//    }
//    val anotherText = nullable ?: "sdfdsf"
//    println(anotherText)

//    var nullable: String? = null
//    nullable = "sdfd"
//    println(nullable!!.length)

//    val a = Person("a").apply {
//        age = 23
//        height = 123
//    }
//    println(a)
//    println(a.nameLength())

//    val list = mutableListOf(1, 2, 3)
//    println(list)
//    list.swap(0, 2)
//    println(list)

//    val stringList = mutableListOf("as", "dfd")
//    stringList.swap()

//    val iList = listOf(1, 2, 3)
//    iList.add

}

private data class Person(
    val name: String,
) {
    var age: Int = 0
    var height: Int = 0

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

private fun Person.nameLength(): Int = name.length

private fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}