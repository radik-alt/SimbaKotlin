package com.example.simbakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.simbakotlin.KotlinFirst.Book
import com.example.simbakotlin.KotlinFirst.Magazine
import com.example.simbakotlin.KotlinFirst.Publication



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    /* 2
    * Необходимо создать интерфейс Publication, у которого должно быть свойства – price и wordCount,
    * а также метод getType, возвращающий строку.
    * Создать два класса, реализующих данный интерфейс – Book и Magazine.
    *  В методе getType для класса Book возвращаем строку с зависимости от количества слов.
    * Если количество слов не превышает 1000, то вывести “Flash Fiction”, 7,500 –“Short Story”, всё, что выше – “Novel”.
    * Для класса Magazine возвращаем строку “Magazine”.

    3.
    Создать два объекта класса Book и один объект Magazine.
    Вывести в лог для каждого объекта тип, количество строк и цену в евро в отформатированном виде.
    У класса Book переопределить метод equals и произвести сравнение сначала по ссылке, затем используя метод equals.
     Результаты сравнений вывести в лог.

    4.
    Создать метод buy, который в качестве параметра принимает Publication (notnull - значения) и
    выводит в лог “The purchase is complete. The purchase amount was [цена издания]”.
    Создать две переменных класса Book, в которых могут находиться null значения. Присвоить одной null,
    а второй любое notnull значение. Используя функцию let, попробуйте вызвать метод buy с каждой из переменных.

    5.
    Создать переменную sum и присвоить ей лямбда-выражение, которое будет складывать два переданных ей числа
    и выводить результат в лог.
     Вызвать данное лямбда-выражение с произвольными параметрами.
     */
    private fun first(){
        var publication:Publication = Magazine(100, 1000)
        println("Magazine: кол-во строк = ${publication.wordCount}, цена в евро = ${covertRubleToEuro(publication.price)}, type = ${publication.getType()}")

        val equalFirst = publication == Magazine(100, 1000)

        publication = Book(100, 1000)
        println("Book: кол-во строк = ${publication.wordCount}, цена в евро = ${covertRubleToEuro(publication.price)}, type = ${publication.getType()}")

        val equalSecond = publication == Book(100, 1000)

        println(equalFirst)
        println(equalSecond)

        val sum = {a:Int, b:Int -> a + b}

        buy(Magazine(300, 2000))
        buy(null)

        log(sum(1, 2).toString())
    }


    private fun covertRubleToEuro(price: Int): Double {
        val courseEuro = 76.64
        return price / courseEuro
    }

    private fun log(message:String){
        Log.d("MainLog", message)
    }

    private fun buy (publication: Publication?){
        publication?.let {
            println("The purchase is complete. The purchase amount was ${it.price}")
        }
    }
}