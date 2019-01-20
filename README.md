# GnarlyDialogSampleApp
Fill in description later

### Description ###
description goes here

### Setup ###
 - Maven Central or my Bintray maven for now
 - Gradle implementation...

### Basic Example Usage ###

```java
GnarlyDialog myGnarlyDialog = new GnarlyDialog(MainActivity.this);
myGnarlyDialog.setGnarlyTitleText("Title");
myGnarlyDialog.setGnarlyContentText("Content");
myGnarlyDialog.gnarlyDialogShow();
```

### Optional Functions and Options ###

#### Constructors ####

##### Show #####
To show the GnarlyDialog dialogs, use gnarlyDialog.gnarlyDialogShow().
This will show the dialog with an animation in. Do not use the available Dialog function
gnarlyDialog.show(). This will still show the dialog but it will not animate in.

#### Dismiss ####
Similar to showing the dialog, use gnarlyDialog.gnarlyDialogDismiss() to dismiss it.
Again, the Dislog.dismiss() function is available but it will not animate out the dialog.

#### Type options ####
These are the current GnarlyDialog type options. Each option gives the GnarlyDialog
a different color scheme and the `GNARLY_DIALOG_TYPE_DEFAULT` is currently set to
`GNARLY_DIALOG_TYPE_INFO`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_SUCCESS`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_ERROR`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_INFO`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_WARNING`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_DEFAULT`

#### Color wrap option ####
The color wrap option is enabled by default unless you disable it. This wraps the
entire GnarlyDialog with a thin color edge that matches the primary color for the
dialog type.

To disable the color wrap option, pass false as the `boolean shouldUseColorWrapLayout` arg
to the GnarlyDialog constructor.

#### Button Options ####
GnarlyDialogs will have no buttons by default but you can easily add a primary and secondary button.

Primary buttons accent the primary color of the dialog and secondary buttons are a shade of gray.

To add a primary button, call `gnarlyDialog.setGnarlyPrimaryButtonText(String text)` and pass
a string that you want to set as the primary button text.

To add a secondary button, call `gnarlyDialog.setGnarlySecondaryButtonText(String text)` and pass
a string that you want to set as the secondary button text.

You can also pass a `View.OnClickListener()` to either button to do something on button click.

##### Full Button Example #####
The below button example creates a GnarlyDialog with a title, content, and primary button and
then dismisses the dialog with animation on the primary button click.
```java
GnarlyDialog myGnarlyDialog = new GnarlyDialog(MainActivity.this);
myGnarlyDialog.setGnarlyTitleText("Title");
myGnarlyDialog.setGnarlyContentText("Content");
myGnarlyDialog.setGnarlyPrimaryButtonText("Content");
myGnarlyDialog.setGnarlyPrimaryButtonListener(new View.OnClickListener() {
   @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Primary Button Clicked", Toast.LENGTH_SHORT).show();
        myGnarlyDialog.gnarlyDialogDismiss();
    }
});
myGnarlyDialog.gnarlyDialogShow();
```

### GIFs ###
 - Success with color wrap
 - Warning with color wrap
 - Error with no color wrap
 - Info with no color wrap

![Alt text](/relative/path/to/img.jpg?raw=true "Optional Title")

![Alt text](/ReadmeResources/screenshot_success_colorwrap.png?raw=true "Screenshot Success with Color Wrap")


## TODO Library ##
 - Create a nice fancy Readme here
 - Publish library to AndroidArsenal

## TODO Sample App ##
 - Add auto fill button in sample app to automatically fill in sample data into text fields

#### Useful Info ####
 - Steps to publish library to Bintray
   - https://android.jlelse.eu/publishing-your-android-kotlin-or-java-library-to-jcenter-from-android-studio-1b24977fe450
