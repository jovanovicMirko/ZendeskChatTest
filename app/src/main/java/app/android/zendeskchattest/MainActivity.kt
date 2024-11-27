package app.android.zendeskchattest

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.android.zendeskchattest.ui.theme.ZendeskChatTestTheme
import zendesk.chat.ChatConfiguration
import zendesk.chat.ChatEngine
import zendesk.classic.messaging.MessagingActivity

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			ZendeskChatTestTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					Greeting(
						modifier = Modifier.padding(innerPadding),
						openChat = ::openZendeskChat
					)
				}
			}
		}
	}

	private fun openZendeskChat() {
		Log.i("POINT", "openZendeskChat: Tu Sam")
		val chatConfiguration = ChatConfiguration.builder()
			.withPreChatFormEnabled(false)
			.build()

		MessagingActivity.builder()
			.withEngines(ChatEngine.engine())
			.show(this, chatConfiguration)
	}
}

@Composable
fun Greeting(
	openChat: () -> Unit,
	modifier: Modifier = Modifier
) {
	Box(
		modifier = modifier
			.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Button(
			onClick = openChat
		) {
			Text("Open Zendesk Chat")
		}
	}
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	ZendeskChatTestTheme {
		Greeting(
			{}
		)
	}
}