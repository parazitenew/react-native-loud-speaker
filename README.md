# React Native Toggle Loud Speaker

A node modules can open loud speaker for react native.
Support for ios and android.

This package was forked from huutq88/react-native-toggle-loud-speaker

I updated the target and compile SDK to 31, and fixed a build error by changing `compile()` to `implementation`

I also edited the Java code so the method `LoudSpeaker.open(true)` can toggle the speaker on/off. Originally, this package was turning it on, but never off. This part of the code was not implemented by the original author.

Since I'm not a Java developper, I wasn't able to improve it more than that. But all contributions are welcome.

NOTA: The update I made are for Android only.

[![NPM](https://img.shields.io/npm/v/react-native-toggle-loud-speaker.svg)](https://www.npmjs.com/package/react-native-toggle-loud-speaker) [![NPM](https://img.shields.io/npm/dw/react-native-toggle-loud-speaker.svg)](https://www.npmjs.com/package/react-native-toggle-loud-speaker) [![JavaScript Style Guide](https://img.shields.io/badge/code_style-standard-brightgreen.svg)](https://standardjs.com) [![JavaScript Style Guide](https://img.shields.io/github/stars/parazitenew/react-native-toggle-loud-speaker.svg)](https://github.com/parazitenew/react-native-toggle-loud-speaker)
[![JavaScript Style Guide](https://img.shields.io/github/issues/parazitenew/react-native-toggle-loud-speaker.svg)](https://github.com/parazitenew/react-native-toggle-loud-speaker) [![NPM](https://img.shields.io/npm/types/react-native-toggle-loud-speaker.svg)](https://www.npmjs.com/package/react-native-toggle-loud-speaker) 

# Installation

```sh
npm install react-native-toggle-loud-speaker
```
## Installation (iOS)
* Drag LoudSpeaker.xcodeproj to your project on Xcode.
* Click on your main project file (the one that represents the .xcodeproj) select Build Phases and drag libLoudSpeaker.a from the Products folder inside the LoudSpeaker.xcodeproj.

## Installation (Android)
You don't need this for RN >= 60
```gradle
...
include ':react-native-toggle-loud-speaker'
project(':react-native-toggle-loud-speaker').projectDir = new File(settingsDir, '../node_modules/react-native-toggle-loud-speaker/android')
```
You don't need this for RN >= 60
* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-toggle-loud-speaker')
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

## Usage

```jsx
import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  TouchableOpacity
} from 'react-native';
import LoudSpeaker from 'react-native-toggle-loud-speaker'

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
## Changelog
### 1.1.0
* Updated Compile SDK to 31
* Updated Target SDK to 31
* Updated buildtool to 31.0.0
* Fixed `Could not find method compile()` build error
* Changed Java code for `open()` methode to toggle speaker on/off
