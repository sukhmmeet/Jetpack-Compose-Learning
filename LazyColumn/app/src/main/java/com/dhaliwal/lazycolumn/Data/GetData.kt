package com.dhaliwal.lazycolumn.Data

import com.dhaliwal.lazycolumn.Person
import kotlin.random.Random

class GetData {

    private val firstNames = listOf(
        "Sam", "Alex", "John", "Emma", "Liam", "Olivia",
        "Noah", "Ava", "Mason", "Sophia", "Ethan", "Mia"
    )

    private val lastNames = listOf(
        "Daniel", "Smith", "Brown", "Johnson",
        "Taylor", "Anderson", "Thomas", "Jackson"
    )

    fun getAllData(): List<Person> {
        return List(100) { index ->
            Person(
                id = index,
                firstName = firstNames.random(),
                lastName = lastNames.random(),
                age = Random.nextInt(10, 60)
            )
        }
    }
}
