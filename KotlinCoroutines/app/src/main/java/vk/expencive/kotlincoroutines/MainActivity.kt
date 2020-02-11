package vk.expencive.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.system.measureTimeMillis

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
//            CoroutineScope(IO).launch {
//                fakeApiRequest()
//            }

            fakeApiRequest()

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

    private fun fakeApiRequest(){
        //вариант для последовательного запуска одного запроса, который зависит от выполнения другого

        CoroutineScope(IO).launch {

            val executionTime = measureTimeMillis {
                val result1 = async {
                    println("Debug: launching job1 ${Thread.currentThread().name}")
                    getResult1FromApi()
                }.await()

                val result2 = async {
                    println("Debug: launching job2 ${Thread.currentThread().name}")
                    getResult2FromApi(result1)
                }.await()

                println("Debug: got result 2: $result2")
            }

            println("Debug: total elapsed time $executionTime ms.")
        }



    }

//    private suspend fun fakeApiRequest() {
//первый уровень, самый обычный варианта использования коротины
//        withContext(IO){
//            val job = withTimeoutOrNull(TIMEOUT) {
//                val result1 = getResult1FromApi()
//
//                println("debug: ${result1}")
//                setTextOnMainThread("Got $result1")
//                val result2 = getResult2FromApi()
//                setTextOnMainThread("Got $result2")
//
//            }
//
//            if (job==null){
//                val cancelMessage = "Cancell job ... job tooks longer than $TIMEOUT"
//                println("debug: ${cancelMessage}")
//                setTextOnMainThread(cancelMessage)
//            }
//        }
//
//
//
//
//
//
//    }

    private suspend fun getResult1FromApi(): String{
        logThread("getResult1FromApi")
        delay(3000)
        return RESULT_1

    }

    private suspend fun getResult2FromApi(result1: String): String {
        logThread("getResult2FromApi")
        delay(3000)
        if (result1.equals(RESULT_1)){
        return RESULT_2}
        throw CancellationException("Result #1 was incorrect")


    }

    private fun logThread(methodName: String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }
}
