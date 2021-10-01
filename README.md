# Java Fusion SDK

Fusion SDK allows for the creation of payment requests for Datamesh terminals.
This library is designed for both Java 8 and Android.

## How to include

    implementation "com.datameshgroup.fusion:fusion-sdk:1.0.1"

If you are using Android you will need to add Java 8 syntax desugaring.
In your app's build.gradle

    android {
		compileOptions {
			sourceCompatibility JavaVersion.VERSION_1_8
			targetCompatibility JavaVersion.VERSION_1_8
			coreLibraryDesugaringEnabled true
		}
	}
	dependencies {
		coreLibraryDesugaring 'com.android.tools:desugar_jdk_libs:1.1.5'
	}

## How to use
Please access the documentation here https://datameshgroup.github.io/fusion/

## License
All code is released under MIT 2.0