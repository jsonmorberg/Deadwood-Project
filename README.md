# Deadwood Project

Deadwood is a fast-paced board game about actors, acting, and
the thrill-filled life of a wandering bit player. It’s perfect for 2 to
6 players, still decent with 7 or 8. Play time is about 60 minutes.

Deadwood.java contains the main function to run the code, and takes a single 
parameter to run (The number of players)!

Example for an Eight Player game of Deadwood: 
java Deadwood 8
"Welcome to DEADWOOD!"

# How to Play

This terminal version of the board game Deadwood uses terminal commands to move
around the board and act! Below is a complete list of the commands a player can 
make on their turn (depending on where they are or if they're working!)

* move - Displays a list of Rooms you can move into if you are not working, chose room by entering corresponding number
* take role - Displays available roles in the room you are currently in if you are not already working
* act - Rolls a dice to see if you can take a shot counter off a room, you can only work once per turn
* rehearse - Gives a +1 to dice rolls on that role, you can only work once per turn
* where - Displays all current players and their positions
* who - Displays current active player and their stats
* end - Ends turn 

NOTE: board.xml & cards.xml are required to run, as the Parser class requires
them to build the appropriate objects
Deadwood is a project worked on by Jayson Morberg & Isaac Simon