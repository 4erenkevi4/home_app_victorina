package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

interface MyInterface{
    fun startQuestion ()
    fun answerQuestion(position: Int, result: Boolean)
    fun finishQuestions()}

class MainActivity : AppCompatActivity(), MyInterface {
    var qw1:QuestionsFragment = QuestionsFragment.newInstance("Луна это планета?", false)
    var qw2:QuestionsFragment = QuestionsFragment.newInstance("Галий это металл?", true)
    var qw3:QuestionsFragment = QuestionsFragment.newInstance("Арбуз это ягода?", true)
    var qw4:QuestionsFragment = QuestionsFragment.newInstance("Токио - это самый населенный город мира?",true)
    var qw5:QuestionsFragment = QuestionsFragment.newInstance("Кит это рыба?",false)
    var qw6:QuestionsFragment = QuestionsFragment.newInstance("Австралия это материк?",true)
    var qw7:QuestionsFragment = QuestionsFragment.newInstance("В воздухе преобладает углекислый газ?",false)
    var qw8:QuestionsFragment = QuestionsFragment.newInstance("Плутон это планета Солнечной системы?",true)
    var res:Int = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()}

    private fun initFragment(){
        replaceFragment(FirstFragment())}

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()}

    override fun startQuestion(){
        replaceFragment(qw1)}

    override fun answerQuestion(position: Int, result: Boolean){
        when (position){
            1 -> {replaceFragment(qw2)
                if (!result)
                    ++res}
            2 -> {replaceFragment(qw3)
                if (result)
                    res++}
            3 -> {replaceFragment(qw4)
                if (result)
                    res++}
            4 -> {replaceFragment(qw5)
                if (result)
                    res++}
            5 -> {replaceFragment(qw6)
                if (!result)
                    res++}
            6 -> {replaceFragment(qw7)
                if (result)
                    res++}
            7 -> {replaceFragment(qw8)
                if (!result)
                    res++}
            8 -> {if (!result)
                res++
                finishQuestions()}}}

            override fun finishQuestions(){
        replaceFragment(ResultFragment.newInstance(res))}}
