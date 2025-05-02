package com.android.chefshare.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.android.chefshare.R
import com.android.chefshare.databinding.ActivityLoginBinding
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    private lateinit var gifView1: ImageView
    private lateinit var gifView2: ImageView
    private var currentGifIndex = 0
    private var isGifView1Visible = true
    private val gifResList = listOf(
        R.drawable.gif2,
        R.drawable.gif3,
        R.drawable.gif1
    )

    private var isGifLooping = false
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gifView1 = findViewById(R.id.gifView1)
        gifView2 = findViewById(R.id.gifView2)

        startGifLoop()

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            stopGifLoop()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val btnGoogleLogin = findViewById<LinearLayout>(R.id.btnGoogleLogin)
        btnGoogleLogin.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            googleSignInLauncher.launch(signInIntent)
        }
    }

    private val googleSignInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
            auth.signInWithCredential(credential)
                .addOnCompleteListener { firebaseTask ->
                    if (firebaseTask.isSuccessful) {
                        val user = auth.currentUser
                        val accountName = account?.displayName
                        val profileUpdates = UserProfileChangeRequest.Builder()
                            .setDisplayName(accountName)
                            .setPhotoUri(account?.photoUrl)
                            .build()
                        user?.updateProfile(profileUpdates)

                        stopGifLoop()

                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Đăng nhập Google thất bại", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Google Sign-In thất bại: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            Log.e("LoginActivity", "Google Sign-In error", task.exception)
        }
    }

    private fun startGifLoop() {
        isGifLooping = true

        fun loopNextGif() {
            if (!isGifLooping || isFinishing || isDestroyed) return

            val nextGifIndex = (currentGifIndex + 1) % gifResList.size
            val currentImageView = if (isGifView1Visible) gifView1 else gifView2
            val nextImageView = if (isGifView1Visible) gifView2 else gifView1

            try {
                Glide.with(this)
                    .asGif()
                    .load(gifResList[nextGifIndex])
                    .into(nextImageView)
            } catch (e: IllegalArgumentException) {
                Log.e("LoginActivity", "Glide load failed", e)
                return
            }

            nextImageView.alpha = 0f
            nextImageView.visibility = View.VISIBLE

            nextImageView.animate().alpha(1f).setDuration(1000).start()
            currentImageView.animate().alpha(0f).setDuration(1000).withEndAction {
                currentImageView.visibility = View.GONE
                isGifView1Visible = !isGifView1Visible
                currentGifIndex = nextGifIndex
                handler.postDelayed({ loopNextGif() }, 4000)
            }.start()
        }

        // Load GIF đầu tiên
        try {
            Glide.with(this)
                .asGif()
                .load(gifResList[currentGifIndex])
                .into(gifView1)
        } catch (e: IllegalArgumentException) {
            Log.e("LoginActivity", "Initial GIF load failed", e)
        }

        gifView1.alpha = 1f
        gifView1.visibility = View.VISIBLE

        handler.postDelayed({ loopNextGif() }, 4000)
    }

    private fun stopGifLoop() {
        isGifLooping = false
        handler.removeCallbacksAndMessages(null)
    }

    override fun onDestroy() {
        stopGifLoop()
        super.onDestroy()
    }
}
