package com.example.compoundviewsampleproject

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.consent_view.view.*

class ConsentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var onConsentsCheckedChangeListener: (allConsentsChecked: Boolean) -> Unit = {}

    init {
        orientation = LinearLayout.VERTICAL
        gravity = Gravity.CENTER
        LayoutInflater.from(context).inflate(R.layout.consent_view, this, true)

        consent1.setOnCheckedChangeListener { _, _ -> validateConsents() }
        consent2.setOnCheckedChangeListener { _, _ -> validateConsents() }
    }

    private fun validateConsents() {
        onConsentsCheckedChangeListener.invoke(consent1.isChecked && consent2.isChecked)
    }

}