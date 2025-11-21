package com.example.madpractical1

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // Choose which demo to run: "snackbar" or "toast"
    private val demoMode = "snackbar" // change to "toast" to get the toast screenshot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onResume() {
        super.onResume()

        when (demoMode) {
            "snackbar" -> showSnackbarMessage("onResume function called.")
            "toast" -> showCustomToast("onResume function called.")
        }
    }

    private fun showSnackbarMessage(message: String) {
        // Use the root view for the snackbar
        val rootView: View = findViewById(android.R.id.content)
        val snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_LONG)

        // Optional: change background & text (requires material dependency)
        snackbar.setAction("", null) // no action; just to keep default layout
        snackbar.show()
    }

    private fun showCustomToast(message: String) {
        // Inflate custom toast layout to get pill-shaped background like your screenshot
        val inflater = LayoutInflater.from(this)
        val layout: View = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container))

        val text: TextView = layout.findViewById(R.id.toast_text)
        text.text = message

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        // place the toast near the bottom, centered horizontally; adjust yOffset as needed
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 180)
        toast.view = layout
        toast.show()
    }
}
