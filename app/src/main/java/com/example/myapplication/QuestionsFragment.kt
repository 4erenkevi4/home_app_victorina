package com.example.myapplication
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val TEXT = "Вопрос"
private const val ANSWER = "Ответ"
private var i = 0
private var b = 1

open class QuestionsFragment : Fragment(){
    private var text: String? = null
    private var answ: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let{
            text = it.getString(TEXT)
            answ= it.getBoolean(ANSWER,true)}}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val root = inflater.inflate(
            R.layout.fragment_questions, container,
            false)
            root.findViewById<TextView>(R.id.question1).text = text
        return root}

    override fun onStart(){
        super.onStart()
        for (n in 0..8){
            view?.findViewById<Button>(R.id.button_yes)?.setOnClickListener{
                (requireActivity() as MyInterface).answerQuestion(i + b, true)
                i++}}
            view?.findViewById<Button>(R.id.button_no)?.setOnClickListener{
                (requireActivity() as MyInterface).answerQuestion(i + b, false)
                i++}}

    companion object{
        @JvmStatic
        fun newInstance(text: String, answer: Boolean) =
            QuestionsFragment().apply {
                arguments = Bundle().apply {
                    putString(TEXT, text)
                    putBoolean(ANSWER,answer)}}}
}
