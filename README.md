# This is GnarlyDialog!

GnarlyDialog is a fancy little Android Dialog library I built that makes
it easy to create pretty, animated dialog messages in your apps.

Latest Bintray Library Version

[![Latest Version](https://api.bintray.com/packages/sdillon255/GnarlyDialog/me.seandillon.gnarlydialog/images/download.svg?version=1.1) ](https://bintray.com/sdillon255/GnarlyDialog/me.seandillon.gnarlydialog/1.1/link)

*Insert Android Arsenal link here*

Download the GnarlyDialog sample app on Google Play to explore the features.

<a href="https://play.google.com/store/apps/details?id=me.seandillon.gnarlydialogsampleappreal&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1">
	<img border="0" alt="Get it on GooglePlay" src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" width="161" height="62">
</a>

<p align="center">
  <img src="https://github.com/sdillon1/GnarlyDialogSampleApp/blob/master/ReadmeResources/demo_gif_colorwrap_1.gif?raw=true" width="250" />
</p>

<p align="center">
  <img src="https://github.com/sdillon1/GnarlyDialogSampleApp/blob/master/ReadmeResources/screenshot_success_colorwrap.png?raw=true" width="200" />
  <img src="https://github.com/sdillon1/GnarlyDialogSampleApp/blob/master/ReadmeResources/screenshot_error_colorwrap.png?raw=true" width="200"/>
</p>

<p align="center">
    <img src="https://github.com/sdillon1/GnarlyDialogSampleApp/blob/master/ReadmeResources/screenshot_warning_colorwrap.png?raw=true" width="200" />
    <img src="https://github.com/sdillon1/GnarlyDialogSampleApp/blob/master/ReadmeResources/screenshot_info_colorwrap.png?raw=true" width="200" />
</p>

### Setup ###

To use GnarlyDialog, make sure `jcenter()` is included in your project's *build.gradle* file
and then add the following *implementation* line to your app's *build.gradle* file. Note that with
new versions of Android Studio, `jcenter()` is automatically included when you create a new project.

`jcenter()`

`implementation 'me.seandillon.gnarlydialog:gnarlydialog:1.1'`

### Basic Example Usage ###

```java
GnarlyDialog myGnarlyDialog = new GnarlyDialog(MainActivity.this);
myGnarlyDialog.setGnarlyTitleText("Title");
myGnarlyDialog.setGnarlyContentText("Content");
myGnarlyDialog.gnarlyDialogShow();
```

### Additional Functions and Options ###

#### Constructors ####
There are 3 constructor options available for GnarlyDialog.

Create a simple default styled GnarlyDialog by only passing a Context.

`public GnarlyDialog(Context context)`

Create a GnarlyDialog of a specific style type by passing a Context and a type.

`public GnarlyDialog(Context context, int gnarlyDialogType)`

Create a GnarlyDialog of a specific type as well as deciding if you want to
use the color wrap layout which is enabled by default. Simply pass `false` as the
`shouldUseColorWrapLayout` parameter to use the non color wrapping layout.

`public GnarlyDialog(Context context, int gnarlyDialogType, boolean shouldUseColorWrapLayout)`

<hr>

##### Show the GnarlyDialog #####
To show the GnarlyDialog dialogs, use `gnarlyDialog.gnarlyDialogShow()`.
This will show the dialog with an intro animation. Do not use the available Dialog function
`gnarlyDialog.show()`. This will still show the dialog but it will not animate in.

<hr>

#### Dismiss the GnarlyDialog ####
Similar to showing the dialog, use `gnarlyDialog.gnarlyDialogDismiss()` to dismiss it.
Again, the  `gnarlyDialog.dismiss()` function is available and will dismiss the GnarlyDialog
 but it will not animate out.

<hr>

#### Should Cancel On Touch Outside ####

Android Dialogs have an
included function called `setCanceledOnTouchOutside()`. If set to `true`,
the dialog will disappear without animation if the user touches the
screen outside the dialog.

I recommend that you always set this to `false` because who likes a
disappearing GnarlyDialog without its exit animation?

`gnarlyDialog.setGnarlyShouldDismisOnOutsideTouch(false)`

<hr>

#### Style Type Options ####
These are the current GnarlyDialog type options. Each option gives the GnarlyDialog
a different color scheme and the `GNARLY_DIALOG_TYPE_DEFAULT` is currently set to
`GNARLY_DIALOG_TYPE_INFO`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_SUCCESS`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_ERROR`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_INFO`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_WARNING`
 - `GnarlyDialog.GNARLY_DIALOG_TYPE_DEFAULT`

<hr>

#### Color Wrap Option ####
The color wrap option is enabled by default unless you disable it with
the appropriate constructor. The color wrap wraps the entire GnarlyDialog
with a thin edge of color that matches the primary color for the
dialog type.

To disable the color wrap option, pass `false` as the `boolean shouldUseColorWrapLayout` argument
to the GnarlyDialog constructor.

<hr>

#### Button Options ####
GnarlyDialogs will have no buttons by default but you can easily add a
primary and secondary button.

The color of the primary button correlates to the primary color of the
dialog type while the secondary button is a shade of gray.

To add a primary button, call `gnarlyDialog.setGnarlyPrimaryButtonText(String text)`
and pass a string that you want to set as the primary button text.

To add a secondary button, call `gnarlyDialog.setGnarlySecondaryButtonText(String text)` and pass
a string that you want to set as the secondary button text.

You can also pass a `View.OnClickListener()` to either button to do something on button click.

<hr>

##### Full Button Example #####
The below button example creates a basic GnarlyDialog with a title,
content, and primary button and then dismisses the dialog with
animation on the primary button click.
```java
final GnarlyDialog myGnarlyDialog = new GnarlyDialog(MainActivity.this);
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
myGnarlyDialog.setGnarlyShouldDismisOnOutsideTouch(false);
myGnarlyDialog.gnarlyDialogShow();
```

<hr>

## Author ##
[Sean Dillon (Android Developer)](http://seandillon.me/readme-gnarlydialog  "Sean Dillon (Android Developer)")



## Apps using GnarlyDialog ##
Below is a list of apps currently using GnarlyDialog.

If you use GnarlyDialog and would like to have your app listed here, send me a message
or shoot me an email at seandillonapps@gmail.com.

 - [GnarlyDialog Sample App](https://play.google.com/store/apps/details?id=me.seandillon.gnarlydialogsampleappreal "GnarlyDialog Sample App")
 - [Anti Surge (Update with GnarlyDialog coming soon)](https://play.google.com/store/apps/details?id=me.seandillon.antisurge "Anti Surge")