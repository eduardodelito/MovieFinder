# MovieFinder - Demo App

MovieFinder is using Model-View-ViewModel (MVVM) template client application architecture with modularised dependencies. Used LiveData to ensures UI matches on data state and Data Binding to display the details.
This is based on the Guide to app architecture article with the androidx package, Kotlin and production ready coroutine. I use several android architecture components like LiveData, ViewModel ,Room. Here are several libraries that i use:

# Features
* Display list with (Title, Release)
* Display message in the below search view if the list of movies is empty.
* Display message in the center to search movies.
* Details with  (Poster, Title, Plot, Language, Actors, Duration)
* Used loader in the placeholder image.

# Major libraries
* Navigation Component - To display and navigate screen
* Material - For Android-oriented design
* LiveData - For lifecycle-aware
* ViewModel - To outlive specific instantiations of views or LifecycleOwners
* Retrofit - Networking
* Fresco - Image Loader
* Dagger - For injection
* Coroutine - For asynchronous
* Mockito - Unit Test(To Do)
* Espresso - Unit Test(To Do)

Used MVVM because it is an alternative to MVC and MVP patterns when using Data Binding technology. The ViewModel has Built in LifeCycleOwner and doesn't have a reference for View.

<b>Mobile Phone: List Screen and Details Screen:</b><br />
<img src="https://github.com/eduardodelito/MovieFinder/blob/main/screens/Screen%20Shot%202022-05-28%20at%209.52.06%20AM.png" width="20%" />
&nbsp;&nbsp;
<img src="https://github.com/eduardodelito/MovieFinder/blob/main/screens/Screen%20Shot%202022-05-28%20at%209.52.15%20AM.png" width="20%" />
<br /><br />
