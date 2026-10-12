package com.example.labex3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labex3.ui.theme.LabEx3Theme

// Data class representing each message item
data class Message(
    val author: String,
    val body: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabEx3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Conversation(
                        messages = sampleMessages,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Custom composable for an individual Message item
 * Displays a circular image avatar
 */
@Composable
fun MessageCard(msg: Message, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(all = 8.dp)
    ) {
        // Circular Avatar with a red border matching the screenshot design
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.Red, CircleShape)
        )

        // Space between avatar and text column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            // Author Name
            Text(
                text = msg.author,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Message Bubble container
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFF2F2F7), // Light bubble background color
                shadowElevation = 1.dp
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

/**
 * Composable  renders a scrollable list of messages using LazyColumn.
 */
@Composable
fun Conversation(messages: List<Message>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}

val sampleMessages = listOf(
    Message("Ricardo", "Hi!"),
    Message("Leticia", "How are you?"),
    Message("Stefany", "Hey everyone!"),
    Message("Ricardo", "Test: 1..2...3"),
    Message("Leticia", "I love coding!"),
    Message("Stefany", "What are you all working on?"),
    Message("Ricardo", "Hi!"),
    Message("Leticia", "How are you?"),
    Message("Stefany", "All good here!"),
    Message("Ricardo", "Test: 1..2...3"),
    Message("Leticia", "I love coding!"),
    Message("Stefany", "See you soon!")
)

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    LabEx3Theme {
        MessageCard(
            msg = Message("Ricardo", "Hello from Compose!")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversation() {
    LabEx3Theme {
        Conversation(messages = sampleMessages)
    }
}
