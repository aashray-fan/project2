package com.aashray.kotlintesting

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

/**
 * A simple [Activity] that shows a message.
 */
class ShowTextActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)

        // Get the message from the Intent.
        val message = intent.getStringExtra(KEY_EXTRA_MESSAGE)

        // Show message.
        findViewById<TextView>(R.id.show_text_view).text = message
    }

    /**
     * Creates an [Intent] for [ShowTextActivity] with the message to be displayed.
     * @param context the [Context] where the [Intent] will be used
     * @param message a [String] with text to be displayed
     * @return an [Intent] used to start [ShowTextActivity]
     */
    companion object {
        const val KEY_EXTRA_MESSAGE = "Hello Espresso!"
        fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, ShowTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}
