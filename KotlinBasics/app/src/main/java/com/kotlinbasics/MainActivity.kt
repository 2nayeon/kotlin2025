package com.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        // week02Variable()
        // week02Functions()
        week03Classes()
        // week03Collection()
    }
}

private fun week03Collection(){
    Log.d("KotlinWeek03", "== Kotlin Collections ==")

    val fruits = listOf("apple", "banana", "orange")
    // fruits.add("kiwi") -> listOf는 불변리스트라 리스트 수정 불가능
    val mutableFruits = mutableListOf("kiwi", "watermelon")
    mutableFruits.add("banana")
    // mutableFruits -> mutableListOf는 가변리스트라 리스트 수정 가능
    Log.d("KotlinWeek03", "Fruits: $fruits")
    Log.d("KotlinWeek03", "Mutable Fruits: $mutableFruits")

    val scores = mapOf("Kim" to 97, "Park" to 100, "Lee" to 99)
    Log.d("KotlinWeek03", "Scores: $scores")

    for(fruit in mutableFruits){
        Log.d("KotlinWeek03", "Fruits: $fruit")
    }
    scores.forEach{(name, score) -> Log.d("KotlinWeek03", "$name scored $score")}
}

private fun week03Classes() {
    Log.d("KotlinWeek03", "== Kotlin Classes ==")

    class Person(val name: String, var age: Int) {
        fun introduce() {
            Log.d("KotlinWeek03", "안녕하세요, $name ($age 세) 입니다.")
        }
        fun birthday() {
            age++
            Log.d("KotlinWeek03", "$name 의 생일! 이제 $age 세..")
        }
    }
    val person1 = Person("홍길동", 31)
    person1.introduce()
    person1.birthday()

    // class ...() -> 주생성자
    class Animal(var species: String) {
        var weight: Double = 0.0

        // constructor -> 보조생성자
        // // 주생성자가 있기때문에, :this(...)로 주생성자 호출
        constructor(species: String, weight: Double) : this(species) {
            this.weight = weight
            Log.d("KotlinWeek03", "$species 의 무게: $weight kg")
        }
        fun makeSound() {
            Log.d("KotlinWeek03", "$species 가 소리를 냅니다.")
        }
    }
    val puppy = Animal("강아지", 6.5)
    puppy.makeSound()


//    class Student{
//        var name: String = ""
//        var age: Int = 0
//        fun introduce(){
//            println("Hi, I'm $name and I'm $age years old.")
//        }
//    }
//    val student = Student()
//    student.name = "leenayeon"
//    student.age = 26
//    student.introduce()
//
//    // -------------------------------------------------------
//    data class Person(val name: String, val age: Int)
//    val person1 = Person(name="Lee", age=24)
//    val person2 = Person(name="Lee", age=24)
//    println("Person1: $person1")
//    println("Equal?: ${person1 == person2}")
}

private fun week02Variable(){
    println("Week02 Variables")

    val courseName = "Mobile Programming"
    // courseName = "IoT Programming" -> val는 상수선언이라 내용 변경 못함.

    var week = 1
    week = 2
    println("Course: $courseName")
    // $courseName -> 문자열 템플릿
    // 문자열 템플릿: 문자열 안에 변수를 쉽게 넣기 위해 $변수명 형식을 사용함.
    println("Week: $week")

    // --------------------------------------------------------------
    println("== Kotlin Variables ==")
    // val name: String = "Android"
    val name = "Android"
    var version = 8.1
    println("Hello $name $version")

    val age: Int = 22
    val height: Double = 153.7
    val isStudent: Boolean = true
    println("Age: $age, Height: $height, Student: $isStudent")
}

private fun week02Functions(){
//    println("Week02 Functions")
//    fun greet(name: String) = "Hello, $name!"
//    println(greet(name = "Android Developer"))
// ------------------------------------------------------------------
    println("== Kotlin Funtions ==")
    fun greet(name: String): String{
        return "Hello, $name"
    }
    fun add(a: Int, b: Int) = a+b      // 표현식 함수
    fun introduce(name: String, age: Int = 19){
        println("My name is $name and I'm $age years old")
    }
    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")
    introduce("park")
    introduce("Kim", 29)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}