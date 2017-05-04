package com.epam.androidlab.task2.module1

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import de.cketti.mailto.EmailIntentBuilder
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast


class Module1MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_activity)

        val recipient = find<EditText>(R.id.edit_text_recipient).text
        val subject = find<EditText>(R.id.edit_text_subject).text
        val letterText = find<EditText>(R.id.edit_text_letter_text).text
        val fabSend = find<FloatingActionButton>(R.id.fab_send)

        fabSend.setOnClickListener {
            try {
                val emailIntent = EmailIntentBuilder.from(this)
                        .to(recipient.toString())
                        .subject(subject.toString())
                        .body(letterText.toString())
                        .build()

                startActivity(emailIntent)

            } catch (e: java.lang.IllegalArgumentException) {
                if (recipient.toString() == "")
                    longToast("Please enter email address")
                else
                    longToast("Email address: \"$recipient\" is invalid")

            } catch(e: ActivityNotFoundException) {
                longToast("It looks like you don't have email app.")
            }

        }

    }
}
