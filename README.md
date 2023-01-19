# React Native Toggle Loud Speaker

A node modules can open loud speaker for react native.
Support for ios and android.

This package was forked from huutq88/react-native-loud-speaker

I updated the target and compile SDK to 31, and fixed a build error by changing `compile()` to `implementation`

I also edited the Java code so the method `LoudSpeaker.open(true)` can toggle the speaker on/off. Originally, this package was turning it on, but never off. This part of the code was not implemented by the original author.

Since I'm not a Java developper, I wasn't able to improve it more than that. But all contributions are welcome.

NOTA: The update I made are for Android only.

# Installation

```sh
npm install react-native-loud-speaker --save
```
### Installation (iOS)
* Drag LoudSpeaker.xcodeproj to your project on Xcode.
* Click on your main project file (the one that represents the .xcodeproj) select Build Phases and drag libLoudSpeaker.a from the Products folder inside the LoudSpeaker.xcodeproj.

### Installation (Android)
You don't need this for RN >= 60
```gradle
...
include ':react-native-loud-speaker'
project(':react-native-loud-speaker').projectDir = new File(settingsDir, '../node_modules/react-native-loud-speaker/android')
```
You don't need this for RN >= 60
* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-loud-speaker')
}
```

* register module (in MainApplication.java)
You don't need this for RN >= 60
```java
......
import com.loudspeaker.LoudSpeakerPackage;  // <--- import
......

@Override
protected List<ReactPackage> getPackages() {
   ......
   new LoudSpeakerPackage(),            // <------ add here
   ......
}

```

### Usage

```
import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  TouchableOpacity
} from 'react-native';
import LoudSpeaker from 'react-native-loud-speaker'

export default class App extends Component<{}> {
  toggleLoudSpeaker = () => {
    LoudSpeaker.open(true)
  }	
  
  render() {
    return (
      <View style={styles.container}>
        <TouchableOpacity onPress={this.toggleLoudSpeaker} style={styles.button}>
	        <Text>Enable</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  button: {
    height: 45, 
    width: 150, 
    backgroundColor: 'red',
    margin: 10
  },
});
```
