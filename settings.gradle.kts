import org.gradle.kotlin.dsl.maven

pluginManagement {
	repositories {
		google {
			content {
				includeGroupByRegex("com\\.android.*")
				includeGroupByRegex("com\\.google.*")
				includeGroupByRegex("androidx.*")
			}
		}
		mavenCentral()
		gradlePluginPortal()
		maven { url = uri("https://zendesk.jfrog.io/zendesk/repo") }

	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
		maven { url = uri("https://zendesk.jfrog.io/zendesk/repo") }
	}
}

rootProject.name = "ZendeskChatTest"
include(":app")
 