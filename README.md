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

## Creating Messages
Please access the documentation here https://datameshgroup.github.io/fusion/

## Sending Messages
The app uses intents to send and receive messages
### Kotlin Example

    val intent = getPackageManager().getLaunchIntentForPackage("au.com.dmg.axispay")?.apply{
		setAction("au.com.dmg.axispay.SaleToPOIRequest")
		addCategory(Intent.CATEGORY_DEFAULT)
		// this is the message payload, reference the API documents to see how to build these
		putExtra(Message.INTENT_EXTRA_MESSAGE, message.toJson())
		// this is required so the terminal knows which app to return the response to.
		putExtra(Message.INTENT_EXTRA_PARENT, getPackageName)
		// these 2 fields are optional and are used to label the POS.
		putExtra("ApplicationName", "Pos Name")
		putExtra("SoftwareVersion", "1.0.0")
	}


    if(intent == null){
		// AxisPay is not available on the device, this must be run on DMG terminals.
		return
	}
	startActivity(intent)

### Java Example

    Intent intent = getPackageManager().getLaunchIntentForPackage("au.com.dmg.axispay");
    if (intent == null) {
	    Toast.makeText(this, "AxisPay not Available.", Toast.LENGTH_SHORT).show();
	    return;
    }
    // wrapper of request.
    SaleToPOIRequest request // You need to build this yourself first.
    Message message = new Message(request);
    // this is required for the intent filter.
    intent.setAction("au.com.axispay.action.SaleToPOIRequest");
    // this is required for the intent filter.
    intent.addCategory(Intent.CATEGORY_DEFAULT);
    intent.putExtra(Message.INTENT_EXTRA_MESSAGE, message.toJson());
    intent.putExtra(Message.INTENT_EXTRA_PARENT_ID, this.getPackageName());
    // name of this app, that get's treated as the POS label by the terminal.
    intent.putExtra("ApplicationName", "DemoPOS");
    intent.putExtra("SoftwareVersion", "1.0.0");
    startActivity(intent);

## Receiving Messages
In your AndroidManifest.xml you must place an android intent filter to receive the response.

	    <intent-filter>
		    <action android:name="au.com.axispay.action.SaleToPOIResponse" />
		    <category android:name="android.intent.category.DEFAULT" />
	    </intent-filter>

Add this to the activity you wish to receive the response on.
Then on that activity, add the following code.

    onCreate( ... ){
        ...
		// add this code to the onCreate method of your activity.
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra(Message.INTENT_EXTRA_MESSAGE){
			handleResponseIntent(intent)
		}
    }

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		if (isResponseIntent(intent)) {
			handleResponseIntent(intent);
		}
	}

	void handleResponseIntent(Intent intent){
		// The response is sent as a Json and we will need to deserialize it.
		Message message = null;
		try{
			message = Message.fromJson(intent.getStringExtra(Message.INTENT_EXTRA_MESSAGE));
		} catch(Exception e){
			// json errors may occur,
			// if this is occuring, make sure you are using the latest fusion-sdk library
			return;
		}
		SaleToPOIResponse response = message.response;
		// we can now access the data.
	}

## License
All code is released under MIT 2.0
