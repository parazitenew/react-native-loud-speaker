package com.loudspeaker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.react.bridge.*;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import android.media.AudioManager;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoudSpeakerModules extends ReactContextBaseJavaModule {
	private ReactApplicationContext reactContext;
	public LoudSpeakerModules(ReactApplicationContext reactContext) {
		super(reactContext);
		this.reactContext = reactContext;
	}

	@Override
	public String getName() {
        return "LoudSpeaker";
    }

  	@ReactMethod
	public void open(Boolean voice){
		AudioManager audioManager = (AudioManager) reactContext.getSystemService(Context.AUDIO_SERVICE);

				if (voice == true){
					audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
					audioManager.setSpeakerphoneOn(true);
				}
				else if (voice == false){
                	audioManager.setMode(AudioManager.MODE_NORMAL);
					audioManager.setSpeakerphoneOn(false);
				}
	}
	@ReactMethod
	public void about(final Promise promise)
	{
        try{
			promise.resolve("");
		} catch (Exception e) {
			promise.reject("error","this is a error message");
		}
	}
}
