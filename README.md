# Java Fusion SDK

Fusion SDK allows for the creation of payment requests for terminals running Satellite.
This library is designed for both Java 8+ and Android.

## How to include
```
    implementation "com.datameshgroup.fusion:fusion-sdk:3.0.4"
```
If you are using Android you will need to add Java 8 syntax desugaring.
In your app's build.gradle
```
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
```
## Creating Messages
You should use the fusion reference API when creating Request objects  
Please access the documentation here https://datameshgroup.github.io/fusion/

# Android Implementation Details
The terminal uses startActivityForResult to create payment requests.
### Kotlin Example
```kotlin
    val intent = Intent(Message.INTENT_ACTION_SALETOPOI_REQUEST).apply {
		// this is the message payload, reference the API documents to see how to build these
		putExtra(Message.INTENT_EXTRA_MESSAGE, message.toJson())
		// these 2 fields are optional and are used to label the POS.
		putExtra(Message.INTENT_EXTRA_APPLICATION_NAME, "Pos Name")
		putExtra(Message.INTENT_EXTRA_APPLICATION_VERSION, "1.0.0")
	}
	startActivityForResult(intent, 100)
```
### Java Example
```java
    Intent intent = new Intent(Message.INTENT_ACTION_SALETOPOI_REQUEST);

    // wrapper of request.
    Message message = new Message(request);

    intent.putExtra(Message.INTENT_EXTRA_MESSAGE, message.toJson());
    // name of this app, that get's treated as the POS label by the terminal.
    intent.putExtra(Message.INTENT_EXTRA_APPLICATION_NAME, "DemoPOS");
    intent.putExtra(Message.INTENT_EXTRA_APPLICATION_VERSION, "1.0.0");

    startActivityForResult(intent, 100);
```
**_Note, message object is of type Message, you cannot use SaleToPOIRequest here, you must wrap the SaleToPOIRequest
in the message object_**.

## Abort Request
The terminal uses sendBroadcast to send an Abort request during a payment.</br>
<mark style="background: #00ced1!important">*Minimum requirement:Satellite v48D, fusion-sdk 1.3.12*</mark>
### Kotlin Example
```kotlin
    val abortRequest = Intent(Message.INTENT_ACTION_BROADCAST)
    val message = Message(abortRequest)
    abortRequest.putExtra(Message.INTENT_EXTRA_MESSAGE, message.toJson())
    // required intent extra
    abortRequest.putExtra(Message.RETURN_TO_PACKAGE, this.packageName)

    sendBroadcast(abortRequest)
```   

### Java Example
```java
    Intent intentAbort = new Intent(Message.INTENT_ACTION_BROADCAST);
    Message message = new Message(abortRequest);
    intentAbort.putExtra(Message.INTENT_EXTRA_MESSAGE, this.getPackageName());
    // required intent extra
    intentAbort.putExtra(Message.RETURN_TO_PACKAGE, message.toJson());
    
    sendBroadcast(intentAbort);
```
## Receiving startActivity/startActivityForResult Intent Response
In the same activity add the following  
```java
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
```
## Sending Broadcast Intent Request
Requirements:
- Intent action should be: Message.INTENT_ACTION_BROADCAST
- Minimum fusion-sdk version 1.3.13
- Minimum Satellite version: 48D
```kotlin
val intent = Intent(Message.INTENT_ACTION_BROADCAST)
```


## Receiving Broadcast Intent Response
Requirements:
- A class that implements BroadcastReceiver
- An appropriate intent-filter fot the BroadcastReceiver Class and Activity with action: **fusion_broadcast_receiver**
- Minimum fusion-sdk version 1.3.13
- Minimum Satellite version: 48D

Sample AndroidManifest.xml snippet:
```xml
<activity
        android:name=".BroadcastReceiverClass"
        android:exported="true" >
    <intent-filter>
        <action android:name="fusion_broadcast_receiver"/>
        <category android:name="android.intent.category.DEFAULT"/>
    </intent-filter>
</activity>
<activity
android:name=".BroadcastReceiverActivity"
android:exported="true" >
<intent-filter>
    <action android:name="fusion_broadcast_receiver"/>
    <category android:name="android.intent.category.DEFAULT"/>
</intent-filter>
</activity>
```

## Satellite Update Request
If the terminal POS App is on the foreground and user is not able to access the Satellite app directly, the POS App can request for update using intent below.
<mark style="background: #00ced1!important">*Minimum requirement:Satellite v48D, fusion-sdk 1.3.13*</mark>
### Kotlin Example
```kotlin
    val intent = Intent(Message.AXIS_PULL_UPDATE)
    // AXIS_RESULT_ACTIVITY = Activity to go back to after the update
    intent.putExtra(Message::AXIS_RESULT_ACTIVITY, "<POS Activity here>")
    startActivity(intent)
```   

### Java Example
```java
    Intent intent = new Intent(Message.AXIS_PULL_UPDATE);
    // AXIS_RESULT_ACTIVITY = Activity to go back to after the update
    intent.putExtra(Message.AXIS_RESULT_ACTIVITY, "<POS Activity here>");
    startActivity(intent);
```

## Satellite Terminal Diagnosis Request
If the terminal POS App is on the foreground and user is not able to access the Satellite app directly, the POS App can request for terminal diagnosis using intent below.</br>
<mark style="background: #00ced1!important">*Minimum requirement:Satellite v48D, fusion-sdk 1.3.13*</mark>
### Kotlin Example
```kotlin
     val terminalDiagnosisRequest = SaleToPOIRequest.Builder()
    .messageHeader(
        MessageHeader.Builder()
            .messageClass(MessageClass.Service)
            .messageCategory(MessageCategory.Diagnosis)
            .messageType(MessageType.Request)
            .serviceID("")
            .build()
    )
    .build()

    val intent = Intent(Message.INTENT_ACTION_BROADCAST)
    val terminalDiagnosisRequestMessage = Message(terminalDiagnosisRequest)
    intent.putExtra(Message.INTENT_EXTRA_MESSAGE, terminalDiagnosisRequestMessage.toJson())
    sendBroadcast(intent)
```   

### Java Example
```java
        SaleToPOIRequest terminalDiagnosisRequest = new SaleToPOIRequest.Builder()
        .messageHeader(
        new MessageHeader.Builder()
        .messageClass(MessageClass.Service)
        .messageCategory(MessageCategory.Diagnosis)
        .messageType(MessageType.Request)
        .serviceID("")
        .build()
        )
        .build();

        Intent intent = new Intent(Message.INTENT_ACTION_BROADCAST);
        Message terminalDiagnosisRequestMessage = new Message(terminalDiagnosisRequest);
        intent.putExtra(Message.INTENT_EXTRA_MESSAGE, terminalDiagnosisRequestMessage.toJson());
        sendBroadcast(intent);
```

## License
All code is released under MIT 2.0
