package vk.expencive.kotlinsingletonexample

import vk.expencive.kotlinsingletonexample.models.User

object ExampleSingleton {

    val singletonUser: User by lazy {
        User("expencive@bk.ru", "anton", "wrgregh.png")
    }
}