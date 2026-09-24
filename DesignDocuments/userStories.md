# User Stories
## MVP User Stories

### User Authentication & Account Management

#### Sign Up *

As a new user, I want to create an account using AWS Cognito so that I can 
log my fishing catches and manage my personal logbook.

#### Sign In *

As a registered user, I want to log in securely so that I can access my 
saved catches and personalized tackle records.

#### Password Reset *

As a registered user, I want to reset my password if I forget it so that 
I don't lose access to my account.

### Catch Logging & Automated Weather
#### Log a New Catch *

As a registered user, I want to log a catch (species, weight, length, 
lure used, location coordinates) so that my backend automatically fetches 
and attaches current local weather conditions (barometric pressure, 
temperature, wind speed) from the OpenWeatherMap API.

#### View Catch Details *

As a registered user, I want to view a full catch entry so that I can 
review both my manual notes and the automatically populated atmospheric data.

#### Edit Catch Log *

As a registered user, I want to edit details of my previously logged catches 
so that I can update or correct any information.

#### Delete Catch Log *

As a registered user, I want to delete a catch log entry so that my logbook 
stays accurate and clutter-free.

### Logbook & Search
#### View Catch History / Dashboard *

As a registered user, I want to view a chronological list of all my logged 
catches in a dashboard so that I can track my overall fishing history.

#### Filter Catches by Lure or Species *

As a registered user, I want to filter my logged catches by fish species or 
lure type so that I can quickly see what tackle has been successful for 
specific fish.