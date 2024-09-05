# SwitchView-Compose
<p >
  <a href="https://github.com/jmseb3"><img alt="Author" src="https://img.shields.io/badge/author-jmse3-red.svg"/></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
</p>

SwitchView-Compose For CMP
it replaced [**Switch**](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#switch)


## how to implementation

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
    implementation("com.github.jmseb3:SwitchView-Compose:2.0.0")
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
    val status by rememberSwitchStatus(true)

    CustomSwitch(
        status,
        option = CustomSwitchOption()
    )
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
    val status by rememberSwitchStatus(true)
    SectionSwitchView(
        staus = status,
        option = CustomSwitchOption(),
        section = "test1",
    )
    
    val status2 by rememberSwitchStatus(false)
    SectionSwitchView(
        staus = status2,
        option = CustomSwitchOption(),
        section = "test2",
        description = "description for test2"
    ) 
}
~~~
![img](/screenshots/sectionSwitchView.gif)

### Custom Button
you can use other Option to change
~~~kotlin
data class CustomSwitchOption(
    /**
     * Size of Switch Width
     */
    var width: Dp = 72.dp,

    /**
     * Size of Switch Height
     */
    var height: Dp = 40.dp,

    /**
     * Color of Track
     */
    var trackColor: CustomSwitchColor = CustomSwitchColor(
        Color(0xFF6200EE),
        Color(0xFFe0e0e0)
    ),

    /**
     * Color of Thumb
     */
    var thumbColor: CustomSwitchColor = trackColor,

    /**
     * gap Between Thumb <---> TrackEdge
     */
    var gapBetweenThumbAndTrackEdge: Dp = 8.dp,

    /**
     * border width switch outside
     */
    var borderWidth: Dp = 2.dp,

    /**
     * corner Percent of switch
     */
    var cornerSize: Int = 50,

    /**
     * padding of thumbs icon
     */
    var iconInnerPadding: Dp = 4.dp,

    /**
     * thumb icon size
     */
    var thumbSize: Dp = 24.dp,

    /**
     * Thumb Icon When checked
     */
    val checkedIcon: Any = Icons.Filled.Done,

    /**
     * Thumb Icon When unchecked
     */
    val unCheckedIcon: Any = Icons.Filled.Close,

    /**
     * Thumb Icon Tint Color
     */
    var iconColor : CustomSwitchColor = CustomSwitchColor(
        Color.White,
        Color.White
    )
) {
    fun getIcon(enabled: Boolean) = if (enabled) checkedIcon else unCheckedIcon
}

/**
 * Color Class
 * @param[checkedColor] color when status true
 * @param[unCheckedColor] color when status false
 */
data class CustomSwitchColor(
    val checkedColor: Color,
    val unCheckedColor: Color,
) {
    fun getColor(enabled: Boolean) = if (enabled) checkedColor else unCheckedColor
}
~~~
