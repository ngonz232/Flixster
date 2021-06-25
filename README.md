# Project 2 - *Flixster*

**Flixster** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **12** hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **scroll through current movies** from the Movie Database API
* [X] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
* [X] For each movie displayed, user can see the following details:
  * [X] Title, Poster Image, Overview (Portrait mode)
  * [X] Title, Backdrop Image, Overview (Landscape mode)
* [X] Allow user to view details of the movie including ratings within a separate activity

The following **stretch** features are implemented:

* [X] Improved the user interface by experimenting with styling and coloring.
* [X] Apply rounded corners for the poster or background images using [Glide transformations](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#transformations)
* [X] Apply the popular [View Binding annotation library](http://guides.codepath.org/android/Reducing-View-Boilerplate-with-ViewBinding) to reduce boilerplate code.
* [X] Allow video trailers to be played in full-screen using the YouTubePlayerView from the details screen.

The following **additional** features are implemented:

* [X] List anything else that you can get done to improve the app functionality!
I improved the UI by making the titles bold and italic. I changed the font and coloring of all the text as well as the color of the backgrounds and added proper padding
between the rows and images since they were too close together. 

Also, I noticed that there were no back buttons to switch between activities. I created working back buttons for each activity. Another feature I added was to automatically play 
the movie trailers when the play button overlay on the movie poster is clicked. This makes the UI a smoother experience for the user as they do not need to do multiple clicks. 


## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [Kap](https://getkap.co/).

## Notes

The challenges were most of the bonus stories as there were no videos or much guidance for them, but they helped me immensely in improving my abilities to research
outside sources for help and further my critical thinking as a developer. I also became creative with the UI and identified several faults which I improved outside of 
the bonus stories as mentioned above.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [2021] [Nicholas Gonzalez]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
