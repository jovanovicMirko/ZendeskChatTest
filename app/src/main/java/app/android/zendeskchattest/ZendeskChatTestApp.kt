package app.android.zendeskchattest

import android.app.Application
import zendesk.chat.Chat


class ZendeskChatTestApp: Application() {

	override fun onCreate() {
		super.onCreate()
		Chat.INSTANCE.init(this, "YOUR_ACCOUNT_KEY")
	}
}