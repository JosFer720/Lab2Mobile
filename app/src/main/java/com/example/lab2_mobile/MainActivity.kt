//FERNANDO RUIZ 23065
//PROGRAMACIÓN DE PLATAFORMAS MÓVILES

package com.example.lab2_mobile

//TASK 1
fun calcularPromedio(notas: List<Int>): Double {
    if (notas.isEmpty()) return 0.0
    val sumaNotas = notas.reduce { acumulador, valor -> acumulador + valor }
    val promedio = sumaNotas.toDouble() / notas.size
    return promedio
}

//TASK 2
fun notasFiltradas(notas: List<Int>): List<Int> {
    return notas.filter { it % 2 != 0 }
}

//TASK 3
fun isPalindrome(palabra: String): Boolean {
    return palabra == palabra.reversed()
}

//TASK 4
fun saludos(nombres: List<String>): List<String> {
    return nombres.map { "¡Hola, $it!" }
}

//TASK 5
fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

//TASK 6

data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

fun mapPersonToStudent(person: Person, studentId: String): Student {
    return Student(person.name, person.age, person.gender, studentId)
}

//MAIN FUNCTION
fun main() {
    val notas = listOf(10, 5, 8, 7, 9)
    val promedio = calcularPromedio(notas)
    println("El promedio es: $promedio")
    println()

    val notasImpares = notasFiltradas(notas)
    println("Notas impares: $notasImpares")
    println()

    val palabra1 = "oso"
    val palabra2 = "hola"
    val esPalindromo = isPalindrome(palabra1)
    println("Es palíndromo: $esPalindromo")
    println()
    val esPalindromo2 = isPalindrome(palabra2)
    println("Es palíndromo: $esPalindromo2")
    println()

    val nombres = listOf("Lucia", "Alejandro", "Raul", "Juan", "Maria")
    val listaSaludos = saludos(nombres)
    listaSaludos.forEach { println(it) }
    println()

    val suma = performOperation(5, 3) { x, y -> x + y }
    val division = performOperation(6, 3) { x, y -> x / y }

    println("Suma: $suma")
    println("División: $division")
    println()

    val people = listOf(
        Person("Alejandro", 22, "Female"),
        Person("Mario", 20, "Male"),
        Person("Luciano", 23, "Male")
    )

    val students = people.mapIndexed { index, person ->
        mapPersonToStudent(person, "ID${index + 1}")
    }

    students.forEach { student ->
        println("El Estudiante ${student.name} tiene edad ${student.age}")
    }
}
