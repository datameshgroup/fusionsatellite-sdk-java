# Java Fusion SDK

Fusion SDK allows for the creation of payment requests for terminals running Satellite.
This library is designed for both Java 8+ and Android.

## How to include

    implementation "com.datameshgroup.fusion:fusion-sdk:1.2.2"

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
You should use the fusion reference API when creating Request objects  
Please access the documentation here https://datameshgroup.github.io/fusion/

# Android Implemetation Details
The terminal uses startActivityForResult to create payment requests.
### Kotlin Example
    val intent = Intent(Message.INTENT_ACTION_SALETOPOI_REQUEST).apply {
		// this is the message payload, reference the API documents to see how to build these
		putExtra(Message.INTENT_EXTRA_MESSAGE, message.toJson())
		// these 2 fields are optional and are used to label the POS.
		putExtra(Message.INTENT_EXTRA_APPLICATION_NAME, "Pos Name")
		putExtra(Message.INTENT_EXTRA_APPLICATION_VERSION, "1.0.0")
	}
	startActivityForResult(intent, 100)

### Java Example


        Intent intent = new Intent(Message.INTENT_ACTION_SALETOPOI_REQUEST);

        // wrapper of request.
        Message message = new Message(request);

        intent.putExtra(Message.INTENT_EXTRA_MESSAGE, message.toJson());
        // name of this app, that get's treated as the POS label by the terminal.
        intent.putExtra(Message.INTENT_EXTRA_APPLICATION_NAME, "DemoPOS");
        intent.putExtra(Message.INTENT_EXTRA_APPLICATION_VERSION, "1.0.0");

        startActivityForResult(intent, 100);

Note, message object is of type Message, you cannot use SaleToPOIRequest here, you must wrap the SaleToPOIRequest
in the message object.

## Receiving Response
In the same activity add the following  

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
        super.onActivityResult(requestCode, responseCode, data);
        if(data != null && data.hasExtra(Message.INTENT_EXTRA_MESSAGE)) {
            this.handleResponseIntent(data);
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
