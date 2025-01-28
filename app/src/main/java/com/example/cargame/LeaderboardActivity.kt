package com.example.cargame

// LeaderboardActivity.kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class LeaderboardActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)

        // Retrieve top scores from Firestore
        db.collection("scores")
            .orderBy("score", Query.Direction.DESCENDING)
            .limit(10)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    // Handle each document (score)
                    val userId = document.getString("userId")
                    val score = document.getLong("score")
                    // Display or process the score data as needed
                }
            }
            .addOnFailureListener { exception ->
                // Handle errors
            }
    }
}
