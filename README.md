# Deadwood Project

Deadwood is a project worked on by Jayson Morberg & Isaac Simon

Deadwood.java contains the main function to run the code, and takes a single 
parameter to run (The number of players)!

Example: 
java Deadwood 8
"Welcome to DEADWOOD!"

* move - Displays a list of Rooms you can move into if you are not working, chose room by entering corresponding number
* take role - Displays available roles in the room you are currently in if you are not already working
* act - Rolls a dice to see if you can take a shot counter off a room, you can only work once per turn
* rehearse - Gives a +1 to dice rolls on that role, you can only work once per turn
* where - Displays all current players and their positions
* who - Displays current active player and their stats
* end - Ends turn 

NOTE: board.xml & cards.xml are required to run, as the Parser class requires
them to build the appropriate objects