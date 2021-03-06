package com.example.fragment_demo_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class LabelFragment: Fragment() {

    private var counter = 0
    private lateinit var counterLabel : TextView

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        counter = savedInstanceState?.getInt("counter")
            ?:arguments?.getInt("counter")
                    ?: 0

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.label_fragment,container,false)
        counterLabel = view.findViewById(R.id.textView)
        counterLabel.text = counter.toString()
        return view
    }

    //カウンターを保存
    override fun onSaveInstanceState(outState:Bundle) {
        outState.putInt("counter",counter)
    }

    fun update() {
        counter++
        counterLabel.text = counter.toString()
    }
}

//カウンターの値を保持
fun newLabelFragment(value : Int):LabelFragment {
    val fragment = LabelFragment()

    val args = Bundle()
    args.putInt("counter",value)

    fragment.arguments = args
    return fragment
}
