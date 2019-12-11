package vk.expencive.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    private val TIMEOUT: Long = 6900

    private val RESULT_2: String  = "Result #2"
    private val RESULT_1 = "Result #1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            setNewText("Click")



            //Может быть IO (Для интернет запросов, БД), Main(в главном потоке), Default(для тяжелых операций)
            CoroutineScope(IO).launch {
                fakeApiRequest()
            }

        }
    }

    private fun  setNewText(input: String){
        val newText = text.text.toString() + "\n${input}"
        text.text = newText

    }

    private suspend fun setTextOnMainThread(input: String){
        withContext(Main){
            setNewText(input)
        }

    }

    private suspend fun fakeApiRequest() {

        withContext(IO){
            val job = withTimeoutOrNull(TIMEOUT) {
                val result1 = getResult1FromApi()

                println("debug: ${result1}")
                setTextOnMainThread("Got $result1")
                val result2 = getResult2FromApi()
                setTextOnMainThread("Got $result2")

            }

            if (job==null){
                val cancelMessage = "Cancell job ... job tooks longer than $TIMEOUT"
                println("debug: ${cancelMessage}")
                setTextOnMainThread(cancelMessage)
            }
        }






    }

    private suspend fun getResult1FromApi(): String{
        logThread("getResult1FromApi")
        delay(3000)
        return RESULT_1

    }

    private suspend fun getResult2FromApi(): String {
        logThread("getResult2FromApi")
        delay(3000)
        return RESULT_2

    }

    private fun logThread(methodName: String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }
}
