package vk.expencive.kotlinsingletonexample

import vk.expencive.kotlinsingletonexample.models.User

object ExampleSingleton {

    val singletonUser: User by lazy{
        User("mitchelltabian@gmail.com", "mitch", "some_image_url.png")
    }
}