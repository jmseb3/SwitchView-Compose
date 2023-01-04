# SwitchView-Compose
<p >
  <a href="https://github.com/jmseb3"><img alt="Author" src="https://img.shields.io/badge/author-jmse3-red.svg"/></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
</p>

SwitchView-Compose is Android Library  
it replaced [**Switch**](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#switch)


## how to implementation
### compileSdk
use compile version 33
~~~groovy
android {
    compileSdk = 33
}
~~~
### settings.gradle
add repositories **jitpack.io**
~~~groovy
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
~~~

### build.gradle
implementation lastVersion
~~~groovy
dependencies {
    ...
    implementation("com.github.jmseb3:SwitchView-Compose:1.0.0")
}
~~~

## how to use

### use CustomSwitch
~~~kotlin
 Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
) {
    var switchStatus by remember {
        mutableStateOf(false)
    }
    CustomSwitch(switchStatus) { switchOn ->
        switchStatus = switchOn
    }
}
~~~
![img](/screenshots/customSwitch.gif)


### use SectionSwitchView
~~~kotlin
 Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
) {
    var switchStatusOne by remember {
        mutableStateOf(false)
    }
    SectionSwitchView(
        section = "test1",
        switchOn = switchStatusOne
    ) {
        switchStatusOne = it
    }

    var switchStatusTwo by remember {
        mutableStateOf(true)
    }
    SectionSwitchView(
        section = "test2",
        description = "description for test2",
        switchOn = switchStatusTwo
    ) {
        switchStatusTwo = it
    }
}
~~~
![img](/screenshots/sectionSwitchView.gif)

### Custom Button
you can use other Option to change
~~~kotlin
fun CustomSwitch(
    switchOn: Boolean = false,
    width: Dp = 72.dp,
    height: Dp = 40.dp,
    checkedTrackColor: Color = DefaultCheckColor,
    uncheckedTrackColor: Color = DefaultUnCheckColor,
    gapBetweenThumbAndTrackEdge: Dp = 8.dp,
    borderWidth: Dp = 2.dp,
    cornerSize: Int = 50,
    iconInnerPadding: Dp = 4.dp,
    thumbSize: Dp = 24.dp,
    updateAction: (switchOn: Boolean) -> Unit = {},
) 
~~~