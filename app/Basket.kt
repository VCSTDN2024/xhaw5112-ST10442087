package com.example.empowering_the_nation

// Data class for Course
data class Course(
    val name: String,
    val price: Double
)

// Object to manage the basket functionality
object Basket {
    // List to hold courses added to the basket
    val coursesInBasket = mutableListOf<Course>()

    // Function to add a course to the basket
    fun addCourse(course: Course) {
        coursesInBasket.add(course)
    }

    // Function to remove a course from the basket
    fun removeCourse(course: Course) {
        coursesInBasket.remove(course)
    }

    // Function to clear all courses from the basket
    fun clearBasket() {
        coursesInBasket.clear()
    }
}
