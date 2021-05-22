# Safety
Mobile Applications final project

# How to use
If you see the page below you are on the main page 

<img src="homepgSafet.png" height=500/> 

Next, you will want to navigate over to the guardian page and enter the name, phone number and email of a person that you completely trust

<img src="addGuardian2.png" height=500/>

When you feel that you are in trouble you can tap on send location to instantly send you location to your guardian

<img src="sendSafety.png" height=500/>

You can view your exact location if you tap the location icon

<img src="safetylocation.png" height=500/>


# Project Statement

This application that I wanted to develop was an all purpose application that can help you with daily life. It quickly turned into a much simpler app because I found it to be very challenging. The purpose of my project was to build an app where someone who is in danger or in a scary situation could alert a trusted friend that they were in trouble. For example if an attractive woman is walking home alone in the dark through a dangerous neighbor, she could hit the alert button which would text a preset contact her exact location.

# Application Design

This application target mobile phones and tablets, preferably devices that people can carry around on them (Devices people would likely have on them in an emergency). This application uses google maps api to track your exact location.

<b>MainActivity</b> - The main activity defines the title and vector assets for the recycler view, it then set the recyclerviewadapter. I went with the recycler view because I was not sure how many features I wanted to add at the start. The recycler view allows you to be dynamic.

<b>RecyclerViewAdapter</b> -  The recycler view adapter is the controller for th allows the home page to be dynamic and show the tile navigation. In this page we can set onclick listeners for each tile. We check for matching titles and if the title matches we can spark a new activity or send a message.

<b>MapsActivity</b> - This activity uses the google maps api. In this activity we check if the user has trhe correct permissions. Something that is relatively new is the  onRequestPermissionsResult. We need to override this method, if the app needs to prompt the user for permission it will run the following code as a result. The code is essentially the same as in the onCreate method but this is executed if the user has to grant permission. Next, it uses location listener to recieve our current location and will display it on the map. The maps activity uses geocoder, which allows the developer to get the users address and zipcode should he/she want to add this information in another feature later on down the line.

<b>AddGuardian</b> - The add guardian activity uses textview and edittext texts to recieve the users name and phone number. I then save this information in shared preferences and will call it later to send and instant text message when the client taps on the send location icon.

<b>Vector Assets</b> - I was able to design and color some vector assets for the recycler view.

