package com.example.myapplication
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
private const val BALL = "количество верных ответов"

class ResultFragment : Fragment(){
    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(BALL)}}

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val root = inflater.inflate(R.layout.fragment_result, container, false)
        root.findViewById<TextView>(R.id.result1).text = param1.toString()+" из 8"
        return root}

    companion object{
        @JvmStatic
        fun newInstance(param1: Int) =
            ResultFragment().apply{
                arguments = Bundle().apply{
                    putInt(BALL,param1)}}}
}