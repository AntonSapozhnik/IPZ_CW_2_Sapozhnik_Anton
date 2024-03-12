package ua.edu.lntu.ipz_cw_2.ui.theme

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ua.edu.lntu.ipz_cw_2.databinding.ActivityMainBinding

// Основний клас
class MainActivity : AppCompatActivity() {

    // Змінні стану авторизації
    private var isLoggedIn = false
    private var userEmail: String? = null
    private lateinit var binding: ActivityMainBinding

    // Метод, для створення активності
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Відображення  інтерфейсу
        if (isLoggedIn) {
            showSignInSuccess()
        } else {
            showSignIn()
        }

        //  натискання кнопки для входу
        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                userEmail = email
                showSignInSuccess()
            }
        }

        // натискання кнопки для виходу
        binding.signOutButton.setOnClickListener {
            isLoggedIn = false
            userEmail = null
            binding.emailEditText.setText("")
            binding.passwordEditText.setText("")
            showSignIn()
        }
    }

    // Метод для відображення інтерфейсу входу
    private fun showSignIn() {
        binding.signInLayout.visibility = View.VISIBLE
        binding.signInSuccessLayout.visibility = View.GONE
    }

    // Метод для відображення інтерфейсу успішного входу
    private fun showSignInSuccess() {
        binding.signInLayout.visibility = View.GONE
        binding.signInSuccessLayout.visibility = View.VISIBLE
        binding.userEmailTextView.text = "Email: $userEmail"
    }
}

//з'явилися нові помилки часу на їх виправлення немає, також про коміти забув повписував в код як коментарі