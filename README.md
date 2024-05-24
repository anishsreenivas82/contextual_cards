# Contextual Cards Android App
## Overview
This project is an Android application designed to display contextual cards using data fetched from an API. The app demonstrates how to create and manage various types of cards with different layouts and actions. It includes implementation of Retrofit for API calls, Glide for image loading, and custom utility classes for text and background formatting.

## Code Structure
### Main Components
#### Models and interfaces
Defines the data strcutres,API endpoints and response strucutres.

#### Repository
Manages API calls and data fetching using Retrofit.
Provides LiveData to observe changes in the data.

#### Adapters
Handle the linking of all the fragments with the recycler view.

#### Fragments
Define the layout and behavior of different card types.

#### Utils
1. TextUtils.java: Formats text with styles, colors, and fonts.
2. BackgroundUtils.java: Sets background colors, gradients, and images.
